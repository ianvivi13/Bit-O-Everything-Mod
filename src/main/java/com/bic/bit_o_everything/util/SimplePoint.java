package com.bic.bit_o_everything.util;

import com.bic.bit_o_everything.util.distributedRandomness.IRandomShape3D;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;

public class SimplePoint {
    public double x;
    public double y;
    public double z;
    
    public SimplePoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public double distance(SimplePoint other) {
        double x = Math.pow((other.x - this.x), 2);
        double y = Math.pow((other.y - this.y), 2);
        double z = Math.pow((other.z - this.z), 2);
        return Math.sqrt(x+y+z);
    }
    
    public SimplePoint offset(SimplePoint other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
        return this;
    }
    
    public SimplePoint generateRandomCartesianFromCylinder(RandomSource randomSource) {
        double angle = IRandomShape3D.generateRandomAngle(randomSource);
        return new SimplePoint(Math.cos(angle) * this.x, this.y, Math.sin(angle) * this.x);
    }
    
    
    public BlockPos toBlockPos() {
        return new BlockPos(this.x, this.y, this.z);
    }
}
