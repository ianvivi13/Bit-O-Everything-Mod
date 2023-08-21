package com.bic.bit_o_everything.util.bezier;

import com.bic.bit_o_everything.util.distributedRandomness.Inequality3D;
import net.minecraft.core.BlockPos;

import java.util.LinkedList;

public class BezierCurve {
    public BezierPoint startPoint;
    public BezierPoint controlPointA;
    public BezierPoint controlPointB;
    public BezierPoint endPoint;
    
    private LinkedList<BlockPos> branchBlocks = new LinkedList<>();
    private BezierPoint previous;
    
    public BezierCurve(BezierPoint startPoint, BezierPoint controlPointA, BezierPoint controlPointB, BezierPoint endPoint) {
        this.startPoint = startPoint;
        this.controlPointA = controlPointA;
        this.controlPointB = controlPointB;
        this.endPoint = endPoint;
        pixelizeCurve();
    }
    
    public LinkedList<BlockPos> getBranchBlocks() {
        return branchBlocks;
    }
    
    private void conditionallyAddPoint(BezierPoint point) {
        if (point.isEquivalent(branchBlocks.getLast())) return;
        if (point.isNotAdjacent(branchBlocks.getLast())) {
            this.conditionallyAddPoint(point.createMiddleBezierPoint(previous));
            this.conditionallyAddPoint(point);
        } else {
            this.unconditionallyAddPoint(point);
        }
    }
    
    private void unconditionallyAddPoint(BezierPoint point) {
        branchBlocks.add(point.toBlockPos());
        previous = point;
    }
    
    private void pixelizeCurve() {
        this.unconditionallyAddPoint(startPoint);
        double length = Math.ceil(startPoint.distance(endPoint));
        for (int i = 1 ; i < length ; i++) {
            double t = i / length;
            
            double r = (1-t);
            double prefixA = Math.pow(r, 3);
            double prefixB = 3*t*Math.pow(r, 2);
            double prefixC = 3*r*Math.pow(t, 2);
            double prefixD = Math.pow(t, 3);
            
            this.conditionallyAddPoint(new BezierPoint(
                    prefixA*this.startPoint.x + prefixB*this.controlPointA.x + prefixC*this.controlPointB.x + prefixD*this.endPoint.x,
                    prefixA*this.startPoint.y + prefixB*this.controlPointA.y + prefixC*this.controlPointB.y + prefixD*this.endPoint.y,
                    prefixA*this.startPoint.z + prefixB*this.controlPointA.z + prefixC*this.controlPointB.z + prefixD*this.endPoint.z));
        }
        this.conditionallyAddPoint(endPoint);
    }
    
    @Override
    public String toString() {
        return branchBlocks.toString();
    }
    
    public void prettyPrint() {
        for (BlockPos block : this.branchBlocks) {
            System.out.println("X: " + block.getX() + " Y: " + block.getY() + " Z: " + block.getZ());
        }
        Inequality3D p = ((x, y, z) -> x < y);
    }
    
    
}
