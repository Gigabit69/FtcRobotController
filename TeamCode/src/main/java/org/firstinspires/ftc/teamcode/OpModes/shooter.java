package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Components.Outtake;

public class shooter extends OpMode {

    public Outtake shoot;

    @Override
    public void init() {

        shoot = new Outtake(hardwareMap, gamepad1);
        
    }

    @Override
    public void loop() {

        shoot.Loop();

    }
}
