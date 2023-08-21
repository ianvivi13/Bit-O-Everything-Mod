package com.bic.bit_o_everything.util.bezier;

import com.bic.bit_o_everything.util.SimplePoint;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;

import java.util.Objects;

public class BezierPoint extends SimplePoint {
    
    public BezierPoint(double x, double y, double z) {
        super(x, y, z);
    }
    
    public BezierPoint createMiddleBezierPoint(BezierPoint other) {
        double x = ((this.x + other.x) / 2d);
        double y = ((this.y + other.y) / 2d);
        double z = ((this.z + other.z) / 2d);
        return new BezierPoint(x, y, z);
    }
    
    public boolean isNotAdjacent(BlockPos other) {
        return ((Mth.abs(Mth.floor(this.x) - other.getX()) > 1) || (Mth.abs(Mth.floor(this.y) - other.getY()) > 1) || (Mth.abs(Mth.floor(this.z) - other.getZ()) > 1));
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (o.getClass() == getClass()) {
            BezierPoint that = (BezierPoint) o;
            return ((Mth.floor(this.x) == Mth.floor(that.x)) && (Mth.floor(this.y) == Mth.floor(that.y)) && (Mth.floor(this.z) == Mth.floor(that.z)));
        }
        return false;
    }
    
    public boolean isEquivalent(BlockPos position) {
        return ((Mth.floor(this.x) == position.getX()) && (Mth.floor(this.y) == position.getY()) && (Mth.floor(this.z) == position.getZ()));
    }
    
    
    @Override
    public int hashCode() {
        return Objects.hash(Mth.floor(x), Mth.floor(y), Mth.floor(z));
    }
    
    @Override
    public String toString() {
        return "BezierPoint |" + " X: " + x + " Y: " + y + " Z: " + z;
    }
}
