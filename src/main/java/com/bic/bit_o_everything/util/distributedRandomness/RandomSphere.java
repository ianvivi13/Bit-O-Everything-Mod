package com.bic.bit_o_everything.util.distributedRandomness;

import com.bic.bit_o_everything.util.SimplePoint;
import net.minecraft.util.RandomSource;

public class RandomSphere implements IRandomShape3D {
    double radius;
    SimplePoint origin;
    
    public RandomSphere(SimplePoint origin, double radius) {
        this.origin = origin;
        this.radius = radius;
    }
    
    public RandomSphere(double originX, double originY, double originZ, double radius) {
        new RandomSphere(new SimplePoint(originX, originY, originZ), radius);
    }
    
    @Override
    public double findVolume() {
        return (4d/3) * Math.PI * Math.pow(radius, 3);
    }
    
    @Override
    public double findSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
    
    @Override
    public SimplePoint generateRandomPoint(RandomSource randomSource) {
        double r = randomSource.nextDouble() * radius;
        double theta = IRandomShape3D.generateRandomAngle(randomSource);
        double rho = IRandomShape3D.generateRandomAngle(randomSource);
        double rSinTheta = Math.sin(theta) * r;
        return new SimplePoint(Math.cos(rho) * rSinTheta, Math.sin(rho) * rSinTheta, Math.cos(theta) * r).offset(origin);
    }
}
