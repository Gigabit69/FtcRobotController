package org.firstinspires.ftc.teamcode.Components;

public class Calculator {
    public float[] odometryFormula(float xp, float xc, float theta){
        float deltax= (float) (xc*Math.cos(-theta)-xp*Math.sin(theta));
        float deltay= (float) (xc*Math.sin(theta)+xp*Math.cos(-theta));

        float[] deltaArray = {deltax,deltay};
        //deltaArray[0] = dx;
        //deltaArray[1] = dy;

        return deltaArray;

    }

    public quadraticFormula(){

    }

}
