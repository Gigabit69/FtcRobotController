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

        if(!lemon.currentDetections.isEmpty()) {
            telemetry.addData("what: ", lemon.currentDetections.get(0));
        }

        if (lemon.botPose != null) {
            telemetry.addData("YAW", lemon.botPose);
            telemetry.addData("ROLL", lemon.botPose.getOrientation().getRoll());
            telemetry.addData("PITCH", lemon.botPose.getOrientation().getPitch());


            telemetry.addData("Tx", lemon.llResult.getTx());
            telemetry.addData("Ty", lemon.llResult.getTy());
        }
    }
}
