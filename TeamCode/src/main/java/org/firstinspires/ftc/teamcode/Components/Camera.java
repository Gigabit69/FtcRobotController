package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

public class Camera {

    //limelight :D
    public Limelight3A lemon;
    public IMU imu;

    public Pose3D mePose = null;
    public LLResult lresult = null;
    public YawPitchRollAngles yawyaw = null;

    public int curCode = 0;
    public double curYaw = 0;
    public double curDistance = 0;

    public final double hiveDownHeight = 1.0;
    public final double hiveUpHeight = 1.0;

    public Camera(HardwareMap hwMap)
    {
        lemon = hwMap.get(Limelight3A.class, "limelight3a");
        lemon.pipelineSwitch(0);

        imu = hwMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot revHubOrientationOnRobot = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP);
        imu.initialize(new IMU.Parameters(revHubOrientationOnRobot));
    }

    public void startCam()
    {
        lemon.start();
    }

    public void update(Gamepad gmpad, double cur0) {

        lresult = lemon.getLatestResult();
        yawyaw = imu.getRobotYawPitchRollAngles();

        if (lresult != null && lresult.isValid()) {
            mePose = lresult.getBotpose_MT2();
        }

        lemon.updateRobotOrientation(yawyaw.getYaw());
        curDistance = getDistance(lresult.getTa());
    }

    public double getDistance(double ta)
    {
        double distance = 70.52322*Math.pow(ta,-0.503861);
        return distance *100;
    }

    public String isDown()
    {
        double h = curDistance*Math.sin(yawyaw.getPitch());

        if(Math.abs(hiveDownHeight-h) <= 5.0)
        {
            return "down";
        }
        else if(Math.abs(hiveUpHeight-h) <= 5.0)
        {
            return "up";
        }

        return "none";
    }





}