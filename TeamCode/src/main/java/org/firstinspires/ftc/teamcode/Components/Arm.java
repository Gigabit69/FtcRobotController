package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {

    public Servo served;
    public double position;

    public Arm(HardwareMap imTheMap) {

        served = imTheMap.get(Servo.class, "servo");

    }

    public void armInputs(Gamepad cheetoFingerPad) {

        if (cheetoFingerPad.aWasPressed()) {
            position = 0;
        }
        if (cheetoFingerPad.left_trigger > 0) {
            position -= cheetoFingerPad.left_trigger;
        }
        else if (cheetoFingerPad.right_trigger > 0) {
            position += cheetoFingerPad.right_trigger;
        }

        if (position > 1) {
            position = 1;
        }
        else if (position < 0) {
            position = 0;
        }

        served.setPosition(position);

    }

}
