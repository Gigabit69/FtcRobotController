package org.firstinspires.ftc.teamcode.OpModes.Tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Components.Camera;

@TeleOp(name="SEE")
public class testingCamera extends OpMode {

    public Camera lemon;

    @Override
    public void init() {

        lemon = new Camera(hardwareMap);
        lemon.startCam();

    }

    @Override
    public void loop() {
        lemon.update(gamepad1,0);

        if(lemon.lresult != null && lemon.lemon != null) {
            telemetry.addData("X: ", lemon.lresult.getTx());
            telemetry.addData("Y: ", lemon.lresult.getTy());
            if(lemon.mePose != null) {
                telemetry.addData("raise your yawyawyaw", lemon.yawyaw);
            }
        } else {
            telemetry.addData("what", "false");
        }

//wooo

    }
}

