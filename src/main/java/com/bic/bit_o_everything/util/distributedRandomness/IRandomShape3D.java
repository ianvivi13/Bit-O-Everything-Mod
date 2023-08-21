package com.bic.bit_o_everything.util.distributedRandomness;

import com.bic.bit_o_everything.util.SimplePoint;
import net.minecraft.util.RandomSource;

public interface IRandomShape3D {
    double findVolume();
    double findSurfaceArea();
    SimplePoint generateRandomPoint(RandomSource randomSource);
    
    // Returns in radians
    static double generateRandomAngle(RandomSource randomSource) {
        return randomSource.nextDouble() * 2 * Math.PI;
    }
}
