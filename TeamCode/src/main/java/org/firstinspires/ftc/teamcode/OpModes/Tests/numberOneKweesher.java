package org.firstinspires.ftc.teamcode.OpModes.Tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Components.Drivetrain;
import org.firstinspires.ftc.teamcode.Components.Lights;

@TeleOp(name = "#1 kweesher")
public class numberOneKweesher extends OpMode {

    Drivetrain legs;
    Lights allOfTheLights;
    Gamepad kweeshPad;
    public int mode = 0;

    @Override
    public void init() {

        legs = new Drivetrain(hardwareMap);
        allOfTheLights = new Lights(hardwareMap);
        allOfTheLights.runtime.reset();
        kweeshPad = gamepad1;

    }

    @Override
    public void loop() {

        legs.gamepadInputs(kweeshPad);

        if (kweeshPad.dpadDownWasPressed()) {
            mode++;
        }
        if (mode % 2 == 0) {
            allOfTheLights.timeColorChange();
        }
        else {
            allOfTheLights.movingColorChange(gamepad1);
        }

        telemetry.addData("ly", legs.ly);
        telemetry.addData("rx", legs.rx);
        telemetry.addData("mode", mode);
        telemetry.addData("pattern", allOfTheLights.colorscolorscolors);
        telemetry.addData("time elapsed", allOfTheLights.runtime.seconds());

    }
}
