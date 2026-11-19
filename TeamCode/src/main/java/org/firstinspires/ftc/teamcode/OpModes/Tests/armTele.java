package org.firstinspires.ftc.teamcode.OpModes.Tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Components.Arm;

@TeleOp(name = "Arm tele")
public class armTele extends OpMode {

    Arm bras;
    Gamepad limbPad;

    @Override
    public void init() {

        bras = new Arm(hardwareMap);
        limbPad = gamepad1;

    }

    @Override
    public void loop() {

        bras.armInputs(limbPad);

        telemetry.addData("left trigger", limbPad.left_trigger);
        telemetry.addData("right trigger", limbPad.right_trigger);
        telemetry.addData("position", bras.position);

    }
}
