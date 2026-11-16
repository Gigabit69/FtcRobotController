package org.firstinspires.ftc.teamcode.OpModes.Tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "sixseven")
public class sixseven extends OpMode
{

    Gamepad pads;
    public DcMotorEx topLeftMotor;
    public DcMotorEx bottomLeftMotor;
    public DcMotorEx topRightMotor;
    public DcMotorEx bottomRightMotor;

    public void init() {

        pads = gamepad1;

        topLeftMotor = hardwareMap.get(DcMotorEx.class, "topLeftMotor");
        bottomLeftMotor = hardwareMap.get(DcMotorEx.class, "bottomLeftMotor");
        topRightMotor = hardwareMap.get(DcMotorEx.class, "topRightMotor");
        bottomRightMotor = hardwareMap.get(DcMotorEx.class, "bottomRightMotor");

    }

    public void loop() {

        //float lx = pads.left_stick_x;
        double ly = pads.left_stick_y;
        double rx = -pads.right_stick_x;

        if (ly == 0) { //stop
            topLeftMotor.setPower(0);
            bottomLeftMotor.setPower(0);
            topRightMotor.setPower(0);
            bottomRightMotor.setPower(0);
        }
        else if (ly < 0) { //forward
            topLeftMotor.setPower(ly);
            bottomLeftMotor.setPower(ly);
            topRightMotor.setPower(-ly);
            bottomRightMotor.setPower(-ly);
        }
        else if (ly > 0) { //backward
            topLeftMotor.setPower(ly);
            bottomLeftMotor.setPower(ly);
            topRightMotor.setPower(-ly);
            bottomRightMotor.setPower(-ly);
        }

        if (rx == 0) { //stop
            topLeftMotor.setPower(0);
            bottomLeftMotor.setPower(0);
            topRightMotor.setPower(0);
            bottomRightMotor.setPower(0);
        }
        else if (rx < 0) { //left
            topLeftMotor.setPower(rx);
            bottomLeftMotor.setPower(rx);
            topRightMotor.setPower(rx);
            bottomRightMotor.setPower(rx);
        }
        else if (rx > 0) { //right
            topLeftMotor.setPower(rx);
            bottomLeftMotor.setPower(rx);
            topRightMotor.setPower(rx);
            bottomRightMotor.setPower(rx);
        }

        telemetry.addData("ly: ", ly);
        telemetry.addData("rx: ", rx);

    }

}