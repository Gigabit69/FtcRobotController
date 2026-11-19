package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {

    public DcMotorEx topRightMotor;
    public DcMotorEx bottomRightMotor;
    public DcMotorEx topLeftMotor;
    public DcMotorEx bottomLeftMotor;

    public float ly;
    public float rx;

    public Drivetrain(HardwareMap imTheMap) {

        topRightMotor = imTheMap.get(DcMotorEx.class, "topRightMotor");
        bottomRightMotor = imTheMap.get(DcMotorEx.class, "bottomRightMotor");
        topLeftMotor = imTheMap.get(DcMotorEx.class, "topLeftMotor");
        bottomLeftMotor = imTheMap.get(DcMotorEx.class,"bottomLeftMotor");

        topRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        bottomRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        topRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        topLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bottomRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bottomLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void gamepadInputs(Gamepad whichCameFirstTheRunOrTheRed) {

        ly = (whichCameFirstTheRunOrTheRed.left_stick_y);
        rx = whichCameFirstTheRunOrTheRed.right_stick_x;

        if (ly == 0) { //stop
            topLeftMotor.setPower(0);
            bottomLeftMotor.setPower(0);
            topRightMotor.setPower(0);
            bottomRightMotor.setPower(0);
        }
        else if (ly < 0) { //forward
            topLeftMotor.setPower(ly);
            bottomLeftMotor.setPower(ly);
            topRightMotor.setPower(ly);
            bottomRightMotor.setPower(ly);
        }
        else if (ly > 0) { //backward
            topLeftMotor.setPower(ly);
            bottomLeftMotor.setPower(ly);
            topRightMotor.setPower(ly);
            bottomRightMotor.setPower(ly);
        }

        if (rx == 0) { //stop
            topLeftMotor.setPower(0);
            bottomLeftMotor.setPower(0);
            topRightMotor.setPower(0);
            bottomRightMotor.setPower(0);
        }
        else if (rx < 0) { //left
            topLeftMotor.setPower(-rx);
            bottomLeftMotor.setPower(-rx);
            topRightMotor.setPower(rx);
            bottomRightMotor.setPower(rx);
        }
        else if (rx > 0) { //right
            topLeftMotor.setPower(-rx);
            bottomLeftMotor.setPower(-rx);
            topRightMotor.setPower(rx);
            bottomRightMotor.setPower(rx);
        }

    }

}
