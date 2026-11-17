package org.firstinspires.ftc.teamcode.OpModes.Tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Components.Drivetrain;
import org.firstinspires.ftc.teamcode.Components.Lights;

@TeleOp(name = "#1 kweesher")
public class numberOneKweesher extends OpMode {

    Drivetrain drivetrain;
    Lights allOfTheLights;

    @Override
    public void init() {

        drivetrain = new Drivetrain(hardwareMap);
        allOfTheLights = new Lights(hardwareMap);
        allOfTheLights.runtime.reset();

    }

    @Override
    public void loop() {

        drivetrain.gamepadInputs(gamepad1);
        allOfTheLights.colorSwitch(gamepad1);

        if (allOfTheLights.mode % 2 == 0) {
            allOfTheLights.timeColorChange();
        }
        else {
            allOfTheLights.movingColorChange(gamepad1);
        }



        telemetry.addData("ly", drivetrain.ly);
        telemetry.addData("rx", drivetrain.rx);
        telemetry.addData("mode", allOfTheLights.mode);
        telemetry.addData("pattern", allOfTheLights.colorscolorscolors);
        telemetry.addData("time elapsed", allOfTheLights.runtime.seconds());

    }
}
