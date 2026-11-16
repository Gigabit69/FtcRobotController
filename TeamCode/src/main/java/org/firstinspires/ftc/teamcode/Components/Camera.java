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

    public List<AprilTagDetection> currentDetections;

    public Pose3D mePose = null;
    public LLResult lresult = null;
    public YawPitchRollAngles yawyaw = null;

    public YawPitchRollAngles orientation;

    // Variable that figures out information from april tags
    private AprilTagProcessor johnCamera;

    private VisionPortal seeingGate;

    private VisionPortal bert;

    public AprilTagDetection curDetection;

    public int curCode = 0;
    public double curYaw = 0;
    public double curDistance = 0;

    public Camera(HardwareMap hwMap)
    {
        johnCamera = new AprilTagProcessor.Builder()
                .setTagFamily(AprilTagProcessor.TagFamily.TAG_36h11)
                .build();

        VisionPortal.Builder bob = new VisionPortal.Builder();

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
    }

}