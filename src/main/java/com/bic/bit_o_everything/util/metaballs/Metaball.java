package com.bic.bit_o_everything.util.metaballs;

import net.minecraft.core.BlockPos;

public final class Metaball {
    final int x;
    final int y;
    final int z;
    final int radius;
    final float xScale;
    final float yScale;
    final float zScale;
    
    private Metaball(int xPos, int yPos, int zPos, int radius, float xScale, float yScale, float zScale) {
        this.x = xPos;
        this.y = yPos;
        this.z = zPos;
        this.radius = radius;
        this.xScale = xScale;
        this.yScale = yScale;
        this.zScale = zScale;
    }
    
    public static Metaball createSphere(int xPos, int yPos, int zPos, int radius) {
        return new Metaball(xPos, yPos, zPos, radius, 1F, 1F, 1F);
    }
    public static Metaball createSphere(BlockPos blockpos, int radius) {
        return new Metaball(blockpos.getX(), blockpos.getY(), blockpos.getZ(), radius, 1F, 1F, 1F);
    }
    public static Metaball createEllipsoid(int xPos, int yPos, int zPos, int radius, float xScale, float yScale, float zScale) {
        return new Metaball(xPos, yPos, zPos, radius, xScale, yScale, zScale);
    }
    public static Metaball createEllipsoid(BlockPos blockpos, int radius, float xScale, float yScale, float zScale) {
        return new Metaball(blockpos.getX(), blockpos.getY(), blockpos.getZ(), radius, xScale, yScale, zScale);
    }
    public static Metaball createVerticalStretchedEllipsoid(BlockPos blockpos, int radius, float verticalScale) {
        return new Metaball(blockpos.getX(), blockpos.getY(), blockpos.getZ(), radius, 1F, verticalScale, 1F);
    }
    public static Metaball createVerticalStretchedEllipsoid(int xPos, int yPos, int zPos, int radius, float verticalScale) {
        return new Metaball(xPos, yPos, zPos, radius, 1F, verticalScale, 1F);
    }
    public static Metaball createHorizontalStretchedEllipsoid(int xPos, int yPos, int zPos, int radius, float horizontalScale) {
        return new Metaball(xPos, yPos, zPos, radius, horizontalScale, 1F, horizontalScale);
    }
    public static Metaball createHorizontalStretchedEllipsoid(BlockPos blockpos, int radius, float horizontalScale) {
        return new Metaball(blockpos.getX(), blockpos.getY(), blockpos.getZ(), radius, horizontalScale, 1F, horizontalScale);
    }
    
    public double calculateMagnitude(int xPos, int yPos, int zPos) {
        double dom = (this.xScale * Math.pow(xPos - this.x, 2)) + (this.yScale * Math.pow(yPos - this.y, 2)) + (this.zScale * Math.pow(zPos - this.z, 2));
        return this.radius / dom;
    }
    
    public double calculateMagnitude(BlockPos blockpos) {
        return this.calculateMagnitude(blockpos.getX(), blockpos.getY(), blockpos.getZ());
    }
}
