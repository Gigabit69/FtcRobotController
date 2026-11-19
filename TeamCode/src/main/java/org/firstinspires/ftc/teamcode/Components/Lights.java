package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Lights {

    public RevBlinkinLedDriver zeppelin;
    public RevBlinkinLedDriver.BlinkinPattern colorscolorscolors;
    public float lightLY;
    public float lightRX;

    public ElapsedTime runtime = new ElapsedTime();

    public Lights(HardwareMap imTheMap) {

        zeppelin = imTheMap.get(RevBlinkinLedDriver.class, "led");
        zeppelin.setPattern(RevBlinkinLedDriver.BlinkinPattern.RAINBOW_RAINBOW_PALETTE);

    }

    public void movingColorChange(Gamepad lightPad) {

        lightLY = -(lightPad.left_stick_y);
        lightRX = lightPad.right_stick_x;

        if (lightLY == 0) {
            colorscolorscolors = RevBlinkinLedDriver.BlinkinPattern.RAINBOW_RAINBOW_PALETTE;
        } else if (lightLY > 0) {
            colorscolorscolors = RevBlinkinLedDriver.BlinkinPattern.GREEN;
        } else if (lightLY < 0) {
            colorscolorscolors = RevBlinkinLedDriver.BlinkinPattern.RED;
        }

        zeppelin.setPattern(colorscolorscolors);

    }

    public void timeColorChange() {

        if (runtime.seconds() <= 10) {
            colorscolorscolors = RevBlinkinLedDriver.BlinkinPattern.BLUE;
        } else if (runtime.seconds() > 10 && runtime.seconds() <= 20) {
            colorscolorscolors = RevBlinkinLedDriver.BlinkinPattern.ORANGE;
        } else if (runtime.seconds() > 20) {
            colorscolorscolors = RevBlinkinLedDriver.BlinkinPattern.RED;
        }

        zeppelin.setPattern(colorscolorscolors);
    }

}