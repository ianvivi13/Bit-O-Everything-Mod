package com.bic.bit_o_everything.util.metaballs;

import net.minecraft.core.BlockPos;

import java.util.ArrayList;
import java.util.Arrays;

public class Metafield {
    final float threshold;
    ArrayList<Metaball> metaballs = new ArrayList<>();
    
    public Metafield(float threshold) {
        this.threshold = threshold;
    }
    
    public double calculateTotalVoxelMagnitude(int xPos, int yPos, int zPos) {
        //System.err.println("---------");
        double total = 0;
        for (Metaball metaball : this.metaballs) {
            total += metaball.calculateMagnitude(xPos, yPos, zPos);
        }
        //System.err.println(total);
        return total;
    }
    
    public ArrayList<BlockPos> determineLeafPlacements(int xPos, int yPos, int zPos, int maxRadius) {
        ArrayList<BlockPos> positions = new ArrayList<>();
        for (int x = xPos - maxRadius ; x <= xPos + maxRadius ; x ++) {
            for (int y = yPos - maxRadius ; y <= yPos + maxRadius ; y ++) {
                for (int z = zPos - maxRadius ; z <= zPos + maxRadius ; z ++) {
                    if (calculateTotalVoxelMagnitude(x, y, z) > this.threshold) {
                        positions.add(new BlockPos(x, y, z));
                    }
                }
            }
        }
        return positions;
    }
    
    public ArrayList<BlockPos> determineLeafPlacements(BlockPos blockpos, int maxRadius) {
        return determineLeafPlacements(blockpos.getX(), blockpos.getY(), blockpos.getZ(), maxRadius);
    }
    
    public double calculateTotalVoxelMagnitude(BlockPos blockpos) {
        return this.calculateTotalVoxelMagnitude(blockpos.getX(), blockpos.getY(), blockpos.getZ());
    }
    
    public void addMetaball(Metaball... balls) {
        this.metaballs.addAll(Arrays.asList(balls));
    }
    
    public void addMetaball(Metaball ball) {
        this.metaballs.add(ball);
    }
}
