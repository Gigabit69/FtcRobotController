package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import java.util.Timer;
import java.util.TimerTask;

public class Outtake {

    /*when click b the motor spins to a specific velocity
    then sit at that velocity for one second
    then stop spinning when it hits that velocity*/

    public DcMotorEx outtakeMotor;
    public Gamepad gamepad;

    boolean b;
    public final double launchSpeed = 1200;
    public double velocity = 0;
    public double currentVelocity;

    Timer timer = new Timer();
    class Stop extends TimerTask {
        @Override
        public void run() {
            velocity = 0;
            timer.cancel();
            timerRunning = false;
        }
    };

    public boolean timerRunning = false;

    public Stop stopTask = new Stop();

    public Outtake(HardwareMap hwMap, Gamepad gmPad)
    {
        outtakeMotor = hwMap.get(DcMotorEx.class, "");

        gamepad = gmPad;
    }

    public void Loop()
    {
        b = gamepad.b;
        if(b==true)
        {
            velocity = launchSpeed;
        }

        outtakeMotor.setVelocity(velocity);

        currentVelocity = outtakeMotor.getVelocity();
        if (currentVelocity==velocity & timerRunning==false)
        {
            //wait one second before setting velocity to 0
            timer.schedule(stopTask, 5000);
            timerRunning = true;
        }
    }

}
