package com.bic.bit_o_everything.util.distributedRandomness;

import com.bic.bit_o_everything.util.SimplePoint;
import net.minecraft.util.RandomSource;

import java.util.ArrayList;
import java.util.Optional;

public class Random3DInequalitySet {
    ArrayList<Inequality3D> inequalitySet = new ArrayList<>();
    IRandomShape3D boundaryShape;
    
    public Random3DInequalitySet(IRandomShape3D boundaryShape) {
        this.boundaryShape = boundaryShape;
    }
    
    public void addInequality(Inequality3D inequality) {
        inequalitySet.add(inequality);
    }
    
    private boolean testPoint(SimplePoint point) {
        return inequalitySet.stream().allMatch(inequality -> inequality.test(point.x, point.y, point.z));
    }
    
    public Optional<SimplePoint> generateRandomPoint(RandomSource randomSource, int attempts) {
        for (; attempts > 0; attempts--) {
            SimplePoint point = boundaryShape.generateRandomPoint(randomSource);
            if (testPoint(point)) {
                return Optional.of(point.generateRandomCartesianFromCylinder(randomSource));
            }
        }
        return Optional.empty();
    }
}
