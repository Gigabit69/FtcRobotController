package org.firstinspires.ftc.teamcode.Components;

import org.firstinspires.ftc.teamcode.tools.Targets;

public class Pathfinder {

    // FINALS

    public final double buffer = 15.0;
    public final double damp = 0.5;

    public final double maxRange = 50.0;
    public final double maxHeading = 90.0;

    // DATA VARIABLES

    public double tarX;
    public double tarY;
    public double tarHead;

    public double x;
    public double y;
    public double theta;

    public double xMov;
    public double yMov;
    public double headMov;

    public boolean isAtTarPos = true;

    // OPERATING VARIABLES

    public boolean isRunning = true;

    public Pathfinder()
    {

    }

    public void update(double[] pos)
    {
        x = pos[0];
        y = pos[1];
        theta = pos[2];

        if (isRunning){
            moveToTarget();
        }

        isAtTarPos = checkTarPos();
    }


    public void setTargetPos(double tarXp, double tarYp, double tarHeadp)
    {
        tarX = tarXp;
        tarY = tarYp;
        tarHead = tarHeadp;

        isAtTarPos = checkTarPos();
    }

    public boolean checkTarPos()
    {
        return Math.abs(tarX-x) <= buffer && Math.abs(tarY-y) <= buffer && Math.abs(tarHead-theta) <= buffer;
    }


    public void moveToTarget()
    {
        double lastX = xMov;
        double lastY = yMov;
        double lastHead = headMov;

        if(!checkTarPos()){
            xMov = ((Math.abs(tarX-x)/(tarX-x)) * Math.min(maxRange, Math.abs(tarX-x))/maxRange);
            yMov = ((Math.abs(tarY-y)/(tarY-y)) * Math.min(maxRange, Math.abs(tarY-y))/maxRange);
            headMov = (Math.abs(tarHead-theta)/(tarHead-theta)) * Math.min(maxHeading, Math.abs(tarHead-theta))/maxHeading;

            xMov -= (xMov-lastX)*damp;
            yMov -= (yMov-lastY)*damp;
            headMov -= (headMov-lastHead)*damp;
        }
        else {
            xMov = 0;
            yMov = 0;
            headMov = 0;
        }
    }

    public int count = 0;

    public void continueSequence(Targets[] points)
    {

        if(!checkTarPos()){
            setTargetPos(points[count].x, points[count].y, points[count].theta);
        }
        else{
            count += 1;
        }

    }

}
