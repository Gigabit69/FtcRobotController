package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {

  public DcMotorEx topRightMotor;
  public DcMotorEx topLeftMotor;
  public DcMotorEx bottomRightMotor;
  public DcMotorEx bottomLeftMotor;

  public Gamepad gamepad;

  double xt;
  double yt;
  double turnx;

  /*
  2 functions: initialize, loop
  tag name(arguments)
  tag: public void; void means your function does not return something
  Drivetrain is an initialize function
  */

  public Drivetrain(HardwareMap hwMap, Gamepad gmPad)
  {
    topRightMotor = hwMap.get(DcMotorEx.class, "topRightMotor");
    topLeftMotor = hwMap.get(DcMotorEx.class, "topLeftMotor");
    bottomRightMotor = hwMap.get(DcMotorEx.class, "bottomRightMotor");
    bottomLeftMotor = hwMap.get(DcMotorEx.class, "bottomLeftMotor");

    gamepad = gmPad;
  }

  // left_stick_x looks at the left right of the joystick left=-1.0 center=0.0 right=1.0
  //xt is a variable that contains how far left or right the joystick is and yt contains up down

  public void Loop()
  {
    xt = gamepad.left_stick_x;
    yt = -gamepad.left_stick_y;

    turnx = gamepad.right_stick_x;
    /*
    if x=1 then trm&brm= -1 tlm&blm= 1
    topRightMotor.setPower(-turnx);
    bottomRightMotor.setPower(-turnx);
    topLeftMotor.setPower(turnx);
    bottomLeftMotor.setPower(turnx);
    */
    //if x=-1 then trm&brm= 1 tlm&blm= -1

    topRightMotor.setPower(-xt+yt-turnx);
    topLeftMotor.setPower(-1*(xt+yt)+turnx);
    bottomRightMotor.setPower(xt+yt-turnx);
    bottomLeftMotor.setPower(-1*(-xt+yt)+turnx);
  }
}
