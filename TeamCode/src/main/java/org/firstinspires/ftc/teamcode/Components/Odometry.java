package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Odometry {

    double deltaX;
    double deltaY;
    double deltaO;
    //tpr ticks per rotation
    double tpr;
    double L; //distance between omX1 and omX2
    double yOff; //y offset from center of robot

    public DcMotorEx omX1;
    public DcMotorEx omX2;
    public DcMotorEx omY;
    public Gamepad gamepad;

    public Odometry (HardwareMap hwMap, Gamepad gmPad) {
        omX1 = hwMap.get(DcMotorEx.class, "idk");
        omX2 = hwMap.get(DcMotorEx.class, "idk2");
        omY = hwMap.get(DcMotorEx.class, "idk3");
        gamepad = gmPad;
    }

    public void loop () {
        int dx1 = omX1.getCurrentPosition();
        int dx2 = omX2.getCurrentPosition();
        int dy = omY.getCurrentPosition();
        //returns the displacement in ticks (maybe idk?)
        deltaO = 0; //not actually just pace holding bc im too lazy to actually code rn
        deltaX = 0; //not actually just pace holding bc im too lazy to actually code rn
        deltaY = 0; //not actually just pace holding bc im too lazy to actually code rn

    }


}
