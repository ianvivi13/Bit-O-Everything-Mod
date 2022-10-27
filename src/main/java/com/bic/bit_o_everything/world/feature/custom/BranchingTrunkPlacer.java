package com.bic.bit_o_everything.world.feature.custom;

import com.bic.bit_o_everything.util.ExtendedCodecs;
import com.bic.bit_o_everything.world.feature.ModTrunkPlacerType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class BranchingTrunkPlacer extends TrunkPlacer {
    public static final Codec<BranchingTrunkPlacer> CODEC = RecordCodecBuilder.create((placerInstance) ->
            trunkPlacerParts(placerInstance).and(placerInstance.group(
                    BranchMovementWeightsProvider.CODEC.fieldOf("branch_movement_weights_provider").forGetter((instance) -> instance.branchMovementWeights),
                    IntProvider.NON_NEGATIVE_CODEC.fieldOf("branch_quantity").forGetter((instance) -> instance.branchQuantity),
                    BranchRangeProvider.CODEC.fieldOf("branch_range_provider").forGetter((instance) -> instance.branchRange),
                    BlockStateProvider.CODEC.fieldOf("branch_block_states").forGetter((instance) -> instance.branchBlockState),
                    ExtendedCodecs.DOUBLE_0_TO_1.fieldOf("trunk_branch_conversion_chance").forGetter((instance) -> instance.trunkBranchConversion)
            )).apply(placerInstance, BranchingTrunkPlacer::new));
    
    protected final BranchMovementWeightsProvider branchMovementWeights;
    protected final BranchRangeProvider branchRange;
    protected final IntProvider branchQuantity;
    protected final BlockStateProvider branchBlockState;
    protected final double trunkBranchConversion;
    
    public BranchingTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, BranchMovementWeightsProvider branchMovementWeights, IntProvider branchQuantity, BranchRangeProvider branchRangeProvider, BlockStateProvider branchBlockState, double trunkBranchConversion) {
        super(baseHeight, heightRandA, heightRandB);
        this.branchMovementWeights = branchMovementWeights;
        this.branchQuantity = branchQuantity;
        this.branchRange = branchRangeProvider;
        this.branchBlockState = branchBlockState;
        this.trunkBranchConversion = trunkBranchConversion;
    }
    
    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerType.BRANCHING_TRUNK_PLACER.get();
    }
    
    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader simulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, int p_226160_, BlockPos treeStartPos, TreeConfiguration treeConfiguration) {
        List<FoliagePlacer.FoliageAttachment> foliageAttachments = new ArrayList<>(); // Determined foliage attachment points
        
        List<BlockPos> trunkPositions = new LinkedList<>(); // Determined trunk positions
        
        int branchesToPlace = this.branchQuantity.sample(randomSource); // The amount of branches left to generate
        boolean convertTrunkToBranch = randomSource.nextDouble() < trunkBranchConversion; // Weather trunk should become branch
        int treeHeight = getTreeHeight(randomSource); // Height of tree - entire, not just trunk
        int min = branchRange.minBranchStart.getMinValue();
        int max = treeHeight - branchRange.minBranchEnd.getMinValue();
        int trunkHeight = convertTrunkToBranch ? randomSource.nextIntBetweenInclusive(Math.min(min, max), Math.max(min, max)) + 1 : treeHeight; // Height of straight trunk
        
        // Place straight part of trunk
        for(int i = 0 ; i <= trunkHeight ; i ++) {
            if (placeLog(simulatedReader, biConsumer, randomSource, treeStartPos.above(i), treeConfiguration)) {
                trunkPositions.add(treeStartPos.above(i));
            } else {
                break;
            }
        }
        
        // Place branch part of trunk if applicable
        if (convertTrunkToBranch) {
            BlockPos branchStart = trunkPositions.get(trunkPositions.size() - 1);
            Branch branch = Branch.branchFromTrunk(branchStart, this.branchRange.getBranchEnd(randomSource, treeStartPos, treeHeight), this.branchMovementWeights, randomSource, Direction.Plane.HORIZONTAL.getRandomDirection(randomSource));
            trunkPositions.addAll(branch.placeBranch(simulatedReader, biConsumer, randomSource, treeConfiguration));
        }
        foliageAttachments.add(new FoliagePlacer.FoliageAttachment(trunkPositions.get(trunkPositions.size() - 1).above(), 1, false));
        
        
        while(branchesToPlace > 0) {
            branchesToPlace --;
            BlockPos start = findBranchOrigin(trunkPositions, randomSource, this.branchRange, treeStartPos, treeHeight);
            if (start == null) break;
            Branch branch = new Branch(start, this.branchRange.getBranchEnd(randomSource, treeStartPos, treeHeight), this.branchMovementWeights, randomSource, Direction.Plane.HORIZONTAL.getRandomDirection(randomSource), this.branchBlockState);
            branch.placeBranch(simulatedReader, biConsumer, randomSource, treeConfiguration);
            foliageAttachments.add(branch.createFoliage());
        }
        
        return foliageAttachments;
    }
    
    private BlockPos findBranchOrigin(List<BlockPos> trunkPositions, RandomSource randomSource, BranchRangeProvider branchRangeProvider, BlockPos treeStart, int treeHeight) {
        int branchYLevel = branchRangeProvider.getBranchStart(randomSource, treeStart, treeHeight);
        List<BlockPos> possibilities = new LinkedList<>();
        
        trunkPositions.forEach(
                (blockPos -> {
                    if (blockPos.getY() == branchYLevel) {
                        possibilities.add(blockPos);
                    }
                })
        );
        
        if (possibilities.size() > 1) {
            return possibilities.get(randomSource.nextInt(possibilities.size()-1));
        } else if (possibilities.size() == 1) {
            return possibilities.get(0);
        }
        return null;
    }
    
    // Moveset - this allows moving in any direction 1 block away
    protected static class Moveset {
        private static final LinkedList<Moveset> ALL_MOVESETS = getAllMoves();
        
        private final BlockPos move;
        public final int moveCount;
        
        private Moveset(int moveCount, BlockPos blockPos) {
            this.moveCount = moveCount;
            this.move = blockPos;
        }
        
        private static LinkedList<Moveset> getAllMoves() {
            LinkedList<Moveset> allMoves = new LinkedList<>();
            
            BlockPos ZERO = BlockPos.ZERO;
            
            allMoves.add(new Moveset(1, ZERO.below()));
            allMoves.add(new Moveset(2, ZERO.below().north()));
            allMoves.add(new Moveset(2, ZERO.below().east()));
            allMoves.add(new Moveset(2, ZERO.below().south()));
            allMoves.add(new Moveset(2, ZERO.below().west()));
            allMoves.add(new Moveset(3, ZERO.below().north().east()));
            allMoves.add(new Moveset(3, ZERO.below().north().west()));
            allMoves.add(new Moveset(3, ZERO.below().south().east()));
            allMoves.add(new Moveset(3, ZERO.below().south().west()));
            allMoves.add(new Moveset(1, ZERO.above()));
            allMoves.add(new Moveset(2, ZERO.above().north()));
            allMoves.add(new Moveset(2, ZERO.above().east()));
            allMoves.add(new Moveset(2, ZERO.above().south()));
            allMoves.add(new Moveset(2, ZERO.above().west()));
            allMoves.add(new Moveset(3, ZERO.above().north().east()));
            allMoves.add(new Moveset(3, ZERO.above().north().west()));
            allMoves.add(new Moveset(3, ZERO.above().south().east()));
            allMoves.add(new Moveset(3, ZERO.above().south().west()));
            allMoves.add(new Moveset(1, ZERO.north()));
            allMoves.add(new Moveset(1, ZERO.east()));
            allMoves.add(new Moveset(1, ZERO.south()));
            allMoves.add(new Moveset(1, ZERO.west()));
            allMoves.add(new Moveset(2, ZERO.north().east()));
            allMoves.add(new Moveset(2, ZERO.north().west()));
            allMoves.add(new Moveset(2, ZERO.south().east()));
            allMoves.add(new Moveset(2, ZERO.south().west()));
            
            return allMoves;
        }
        
        public BlockPos apply(BlockPos start) {
            return start.offset(this.move);
        }
    }
    
    // Branch - this is a branch coming out of the tree, has ability to place itself
    protected static class Branch {
        private final BlockPos origin;
        private final int endHeight;
        private final boolean canPerformDuplicateMoves;
        private final BlockStateProvider branchBlockState;
        private final int maxBranchLength;
        
        private final Set<Map.Entry<Moveset, Integer>> weightedMoves;
        private final Direction branchDirection;
        
        private BlockPos currentPosition;
        private Moveset previousMove;
        //private Direction branchDirection;
        
        public Branch(BlockPos origin, int endHeight, BranchMovementWeightsProvider branchMovementWeightsProvider, RandomSource randomSource, Direction branchDirection, BlockStateProvider branchBlockState) {
            this.origin = origin; // ORIGIN ON TRUNK
            this.endHeight = endHeight; // END HEIGHT TO STOP MOVING AT
            weightedMoves = determineAllMoveWeights( // DETERMINE MOVE WEIGHTS FOR BRANCH
                    branchMovementWeightsProvider.getSingleMoveWeight(randomSource),
                    branchMovementWeightsProvider.getDoubleMoveWeight(randomSource),
                    branchMovementWeightsProvider.getTripleMoveWeight(randomSource),
                    branchMovementWeightsProvider.getMoveUpWeight(randomSource),
                    branchMovementWeightsProvider.getMoveDownWeight(randomSource),
                    branchMovementWeightsProvider.getMoveInWeight(randomSource),
                    branchMovementWeightsProvider.getMoveOutWeight(randomSource),
                    branchMovementWeightsProvider.getMoveSideWeight(randomSource),
                    origin,
                    branchDirection
            ).entrySet();
            this.maxBranchLength = branchMovementWeightsProvider.maxBranchLength();
            this.branchDirection = branchDirection;
            this.canPerformDuplicateMoves = branchMovementWeightsProvider.canPerformDuplicateMoves;
            this.currentPosition = origin; // CURRENT BRANCH POSITION
            this.previousMove = null; // PREVIOUS MOVESET
            //this.branchDirection = branchDirection; // BRANCHES MOVING DIRECTION
            this.branchBlockState = branchBlockState;
        }
        
        public static Branch branchFromTrunk(BlockPos origin, int endHeight, BranchMovementWeightsProvider branchMovementWeightsProvider, RandomSource randomSource, Direction branchDirection) {
            return new Branch(origin, endHeight, branchMovementWeightsProvider, randomSource, branchDirection, null);
        }
        
        // Creates entire branch
        public List<BlockPos> placeBranch(LevelSimulatedReader simulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, TreeConfiguration treeConfiguration) {
            List<BlockPos> branchPositions = new LinkedList<>();
            for(int length = 0 ; length <= maxBranchLength ; length ++) { // runs once per added log
                SimpleWeightedRandomList<Moveset> randomMovesetList;
                if (this.currentPosition.equals(this.origin)) {
                    randomMovesetList = getRandomListOnlyOutMoves(simulatedReader);
                } else {
                    randomMovesetList = getRandomList(simulatedReader); // randomMoves - must be regenerated every success
                }
                
                if (attemptPlaceBranchBlock(simulatedReader, biConsumer, randomSource, treeConfiguration, randomMovesetList)) { // attempt log placement - if success
                    branchPositions.add(this.currentPosition); // append to branch positions
                    if (this.currentPosition.getY() >= this.endHeight) { // if height is within range, quit
                        break;
                    }
                } else {
                    break;
                }
                
            }
            return branchPositions;
        }
        
        // Attempts to place one log - returns boolean if able
        private boolean attemptPlaceBranchBlock(LevelSimulatedReader simulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, TreeConfiguration treeConfiguration, SimpleWeightedRandomList<Moveset> randomMovesetList) {
            for (int tries = 0 ; tries <= 5 ; tries ++) {
                Optional<Moveset> randomMoveset = randomMovesetList.getRandomValue(randomSource); // gets random moveset
                if (randomMoveset.isPresent()) { // if random value exists - if not, return
                    Moveset moveset = randomMoveset.get();
                    BlockPos newPosition = moveset.apply(this.currentPosition);
                    if (this.placeBranchLog(simulatedReader, biConsumer, randomSource, newPosition, treeConfiguration, Function.identity())) { // place log if able
                        this.currentPosition = newPosition; // update current branch position
                        this.previousMove = moveset; // update previous moveset
                        return true;
                    }
                } else {
                    return false;
                }
            }
            return false;
        }
        
        
        
        private FoliagePlacer.FoliageAttachment createFoliage() {
            return new FoliagePlacer.FoliageAttachment(this.currentPosition.above(), 1, false);
        }
        
        private static HashMap<Moveset, Integer> determineAllMoveWeights(int singleMoveWeight, int doubleMoveWeight, int tripleMoveWeight, int moveUpWeight, int moveDownWeight, int moveInWeight, int moveOutWeight, int moveSideWeight, BlockPos origin, Direction branchDirection) {
            HashMap<Moveset, Integer> weightedBranchMoves = new HashMap<>();
            
            for (Moveset move : Moveset.ALL_MOVESETS) {
                int weight = determineMovesetWeight(move, singleMoveWeight, doubleMoveWeight, tripleMoveWeight, moveUpWeight, moveDownWeight, moveInWeight, moveOutWeight, moveSideWeight, origin, branchDirection);
                weightedBranchMoves.put(move, weight);
            }
            //System.err.println(weightedBranchMoves);
            return weightedBranchMoves;
        }
        
        private SimpleWeightedRandomList<Moveset> getRandomList(LevelSimulatedReader simulatedReader) {
            SimpleWeightedRandomList.Builder<Moveset> weightedList = new SimpleWeightedRandomList.Builder<>();
            for (Map.Entry<Moveset, Integer> entry : this.weightedMoves) {
                if (!this.canPerformDuplicateMoves && entry.getKey() == this.previousMove) continue;
                if (TreeFeature.validTreePos(simulatedReader, entry.getKey().apply(this.currentPosition))) {
                    if (entry.getValue() > 0) {
                        weightedList.add(entry.getKey(), entry.getValue());
                    }
                }
            }
            
            return weightedList.build();
        }
        
        private SimpleWeightedRandomList<Moveset> getRandomListOnlyOutMoves(LevelSimulatedReader simulatedReader) {
            SimpleWeightedRandomList.Builder<Moveset> weightedList = new SimpleWeightedRandomList.Builder<>();
            for (Map.Entry<Moveset, Integer> entry : this.weightedMoves) {
                if (!this.canPerformDuplicateMoves && entry.getKey() == this.previousMove) continue;
                if (TreeFeature.validTreePos(simulatedReader, entry.getKey().apply(this.currentPosition))) {
                    if (entry.getValue() > 0 && isPosOut(entry.getKey().apply(this.currentPosition), this.currentPosition, this.branchDirection)) {
                        weightedList.add(entry.getKey(), entry.getValue());
                    }
                }
            }
            return weightedList.build();
        }
        
        
        private static int determineMovesetWeight(Moveset moveset, int singleMoveWeight, int doubleMoveWeight, int tripleMoveWeight, int moveUpWeight, int moveDownWeight, int moveInWeight, int moveOutWeight, int moveSideWeight, BlockPos origin, Direction branchDirection) {
            BlockPos adjusted = moveset.apply(origin);
            
            int weight;
            
            if (moveset.moveCount == 1) {
                weight = singleMoveWeight;
            } else if (moveset.moveCount == 2) {
                weight = doubleMoveWeight;
            } else {
                weight = tripleMoveWeight;
            }
            
            
            if (isPosSide(adjusted, origin, branchDirection)) {
                weight *= moveSideWeight;
            }
            
            if (isPosOut(adjusted, origin, branchDirection)) {
                weight *= moveOutWeight;
            } else if (isPosIn(adjusted, origin, branchDirection)) {
                weight *= moveInWeight;
            }
            
            if (isPosUp(adjusted, origin)) {
                weight *= moveUpWeight;
            } else if (isPosDown(adjusted, origin)) {
                weight *= moveDownWeight;
            }
            
            //ADJUST USING CURRENT FORMULA - THIS IS ROOTING WEIGHTS BY THEIR MOVESET'S MOVECOUNT - HOPEFULLY TO NORMALIZE THEM
            //weight = Math.round((float) Math.pow(weight, ((double)1)/(double)moveset.moveCount));
            
            return weight;
        }
        
        private static boolean isPosUp(BlockPos adjusted, BlockPos origin) {
            return adjusted.getY() - origin.getY() > 0;
        }
        
        private static boolean isPosDown(BlockPos adjusted, BlockPos origin) {
            return adjusted.getY() - origin.getY() < 0;
        }
        
        private static boolean isPosSide(BlockPos adjusted, BlockPos origin, Direction branchDirection) {
            Direction.Axis sideAxis = branchDirection.getClockWise().getAxis();
            return !(adjusted.get(sideAxis) == origin.get(sideAxis));
        }
        
        private static boolean isPosOut(BlockPos adjusted, BlockPos origin, Direction branchDirection) {
            Direction.Axis axis = branchDirection.getAxis();
            Direction.AxisDirection axisDirection = branchDirection.getAxisDirection();
            int newBranchDirectionAxisValue = adjusted.get(axis);
            int oldBranchDirectionAxisValue = origin.get(axis);
            
            if (axisDirection == Direction.AxisDirection.POSITIVE) {
                return newBranchDirectionAxisValue > oldBranchDirectionAxisValue;
            } else {
                return newBranchDirectionAxisValue < oldBranchDirectionAxisValue;
            }
        }
        
        private static boolean isPosIn(BlockPos adjusted, BlockPos origin, Direction branchDirection) {
            Direction.Axis axis = branchDirection.getAxis();
            Direction.AxisDirection axisDirection = branchDirection.getAxisDirection();
            int newBranchDirectionAxisValue = adjusted.get(axis);
            int oldBranchDirectionAxisValue = origin.get(axis);
            
            if (axisDirection == Direction.AxisDirection.POSITIVE) {
                return newBranchDirectionAxisValue < oldBranchDirectionAxisValue;
            } else {
                return newBranchDirectionAxisValue > oldBranchDirectionAxisValue;
            }
        }
        
        protected boolean placeBranchLog(LevelSimulatedReader simulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, BlockPos blockPos, TreeConfiguration treeConfiguration, Function<BlockState, BlockState> function) {
            if (TreeFeature.validTreePos(simulatedReader, blockPos)) {
                biConsumer.accept(blockPos, function.apply(Objects.requireNonNullElseGet(this.branchBlockState, () -> treeConfiguration.trunkProvider).getState(randomSource, blockPos)));
                return true;
            }
            return false;
        }
    }
    
    // BranchMovementWeightsProvider - provides weights for specific movements in branches
    public record BranchMovementWeightsProvider(IntProvider singleMoveWeight, IntProvider doubleMoveWeight, IntProvider tripleMoveWeight, IntProvider moveUpWeight, IntProvider moveDownWeight, IntProvider moveInWeight, IntProvider moveOutWeight, IntProvider moveSideWeight, Boolean canPerformDuplicateMoves, int maxBranchLength) {
        public static final Codec<BranchMovementWeightsProvider> CODEC = RecordCodecBuilder.create((branchMovementWeightsInstance) -> branchMovementWeightsInstance.group(
                IntProvider.NON_NEGATIVE_CODEC.fieldOf("single_move_weight").forGetter((instance) -> instance.singleMoveWeight),
                IntProvider.NON_NEGATIVE_CODEC.fieldOf("double_move_weight").forGetter((instance) -> instance.doubleMoveWeight),
                IntProvider.NON_NEGATIVE_CODEC.fieldOf("triple_move_weight").forGetter((instance) -> instance.tripleMoveWeight),
                
                IntProvider.NON_NEGATIVE_CODEC.fieldOf("move_up_weight").forGetter((instance) -> instance.moveUpWeight),
                IntProvider.NON_NEGATIVE_CODEC.fieldOf("move_down_weight").forGetter((instance) -> instance.moveDownWeight),
                IntProvider.NON_NEGATIVE_CODEC.fieldOf("move_in_weight").forGetter((instance) -> instance.moveInWeight),
                IntProvider.NON_NEGATIVE_CODEC.fieldOf("move_out_weight").forGetter((instance) -> instance.moveOutWeight),
                IntProvider.NON_NEGATIVE_CODEC.fieldOf("move_side_weight").forGetter((instance) -> instance.moveSideWeight),
                
                Codec.BOOL.fieldOf("can_perform_duplicate_moves").forGetter((instance) -> instance.canPerformDuplicateMoves),
                
                ExtraCodecs.NON_NEGATIVE_INT.fieldOf("max_branch_length").forGetter((instance) -> instance.maxBranchLength)
        ).apply(branchMovementWeightsInstance, BranchMovementWeightsProvider::new));
        
        public static BranchMovementWeightsProvider createDefault() {
            return new BranchMovementWeightsProvider(
                    ConstantInt.of(6),  //  Single Move
                    ConstantInt.of(5),  //  Double Move
                    ConstantInt.of(1),  //  Triple Move
                    ConstantInt.of(6),  //  Move Up
                    ConstantInt.of(0),  //  Move Down
                    ConstantInt.of(0),  //  Move In
                    ConstantInt.of(4),  //  Move Out
                    ConstantInt.of(2),  //  Move Side
                    false,
                    10
            );
        }
        
        public int getSingleMoveWeight(RandomSource randomSource) {
            return this.singleMoveWeight.sample(randomSource);
        }
        
        public int getDoubleMoveWeight(RandomSource randomSource) {
            return this.doubleMoveWeight.sample(randomSource);
        }
        
        public int getTripleMoveWeight(RandomSource randomSource) {
            return this.tripleMoveWeight.sample(randomSource);
        }
        
        public int getMoveUpWeight(RandomSource randomSource) {
            return this.moveUpWeight.sample(randomSource);
        }
        
        public int getMoveDownWeight(RandomSource randomSource) {
            return this.moveDownWeight.sample(randomSource);
        }
        
        public int getMoveInWeight(RandomSource randomSource) {
            return this.moveInWeight.sample(randomSource);
        }
        
        public int getMoveOutWeight(RandomSource randomSource) {
            return this.moveOutWeight.sample(randomSource);
        }
        
        public int getMoveSideWeight(RandomSource randomSource) {
            return this.moveSideWeight.sample(randomSource);
        }
    }
    
    // BranchRangeProvider - provides criteria for branch placement
    public record BranchRangeProvider(IntProvider minBranchStart, IntProvider maxBranchStart, IntProvider minBranchEnd, IntProvider maxBranchEnd) {
        public static final Codec<BranchRangeProvider> CODEC = RecordCodecBuilder.create((branchRangeProviderInstance) -> branchRangeProviderInstance.group(
                IntProvider.NON_NEGATIVE_CODEC.fieldOf("min_branch_start").forGetter((instance) -> instance.minBranchStart),
                IntProvider.NON_NEGATIVE_CODEC.fieldOf("max_branch_start").forGetter((instance) -> instance.maxBranchStart),
                IntProvider.NON_NEGATIVE_CODEC.fieldOf("min_branch_end").forGetter((instance) -> instance.minBranchEnd),
                IntProvider.NON_NEGATIVE_CODEC.fieldOf("max_branch_end").forGetter((instance) -> instance.maxBranchEnd)
        ).apply(branchRangeProviderInstance, BranchRangeProvider::new));
        
        public static BranchRangeProvider createDefault() {
            return new BranchRangeProvider(
                    ConstantInt.of(3),  //  min branch start
                    ConstantInt.of(2),  //  max branch start
                    ConstantInt.of(1),  //  min branch end
                    ConstantInt.of(1)   //  max branch end
            );
        }
        
        public int getBranchStart(RandomSource randomSource, BlockPos treeStart, int treeHeight) {
            int min = minBranchStart.sample(randomSource);
            int max = treeHeight - maxBranchEnd.sample(randomSource);
            return randomSource.nextIntBetweenInclusive(Math.min(min, max), Math.max(min, max)) + treeStart.getY();
        }
        
        public int getBranchEnd(RandomSource randomSource, BlockPos treeStart, int treeHeight) {
            int min = - minBranchEnd.sample(randomSource);
            int max = maxBranchEnd.sample(randomSource);
            return randomSource.nextIntBetweenInclusive(Math.min(min, max), Math.max(min, max)) + treeStart.getY() + treeHeight;
        }
    }
    
}
