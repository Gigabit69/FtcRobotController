package org.firstinspires.ftc.teamcode.OpModes.Tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name="FIRE")
public class testingOuttake extends OpMode {

    public DcMotorEx theMotor;

    public Gamepad gm;

    @Override
    public void init() {

        theMotor = hardwareMap.get(DcMotorEx.class, "bazinga");
        theMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        gm = gamepad1;

    }

    @Override
    public void loop() {

        if (gm.a)
        {
            theMotor.setVelocity(950);
        }
        else
        {
            theMotor.setVelocity(0);
        }

    }
}
