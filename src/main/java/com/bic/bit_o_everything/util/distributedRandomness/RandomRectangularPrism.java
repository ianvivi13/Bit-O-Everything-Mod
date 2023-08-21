package com.bic.bit_o_everything.util.distributedRandomness;

import com.bic.bit_o_everything.util.SimplePoint;
import net.minecraft.util.RandomSource;

public class RandomRectangularPrism implements IRandomShape3D {
    double minX;
    double deltaX;
    double minY;
    double deltaY;
    double minZ;
    double deltaZ;
    
    public RandomRectangularPrism(double minX, double deltaX, double minY, double deltaY, double minZ, double deltaZ) {
        this.minX = minX;
        this.deltaX = deltaX;
        this.minY = minY;
        this.deltaY = deltaY;
        this.minZ = minZ;
        this.deltaZ = deltaZ;
    }
    
    @Override
    public double findVolume() {
        return deltaX * deltaY * deltaZ;
    }
    
    @Override
    public double findSurfaceArea() {
        return (deltaX * deltaY + deltaZ * deltaY + deltaX * deltaZ) * 2;
    }
    
    @Override
    public SimplePoint generateRandomPoint(RandomSource randomSource) {
        return new SimplePoint(randomSource.nextDouble() * deltaX + minX, randomSource.nextDouble() * deltaY + minY, randomSource.nextDouble() * deltaZ + minZ);
    }
}
