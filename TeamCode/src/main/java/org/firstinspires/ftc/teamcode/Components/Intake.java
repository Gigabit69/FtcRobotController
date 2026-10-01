package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    public DcMotorEx intakeMotor;
    public Gamepad gamepad;

    double rt;
    double lt;

    public Intake(HardwareMap hwMap, Gamepad gmPad)
    {
        intakeMotor = hwMap.get(DcMotorEx.class, "");

        gamepad = gmPad;
    }

    public void Loop()
    {
        rt = gamepad.right_trigger;
        lt = gamepad.left_trigger;

        intakeMotor.setPower(rt-lt);
    }
}
