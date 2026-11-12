package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Components.Drivetrain;

@TeleOp (name="testing")
public class testMode extends OpMode {

    public Drivetrain drtrain;

    @Override
    public void init(){

        drtrain = new Drivetrain(hardwareMap, gamepad1);

    }

    @Override
    public void loop() {

        drtrain.Loop();

    }


}
