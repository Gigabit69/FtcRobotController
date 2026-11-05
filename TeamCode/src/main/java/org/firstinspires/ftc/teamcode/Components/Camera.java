package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

public class Camera {

    //limelight :D
    Limelight3A lemon;

    IMU imu;

    public List<AprilTagDetection> currentDetections;

    public Pose3D botPose = null;
    public LLResult llResult = null;

    public YawPitchRollAngles orientation;

    // Variable that figures out information from april tags
    private AprilTagProcessor johnCamera;

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

    public void update(Gamepad gmpad, double cur0)
    {
        orientation = imu.getRobotYawPitchRollAngles();
        lemon.updateRobotOrientation(orientation.getYaw());
        llResult = lemon.getLatestResult();
        if (llResult != null && llResult.isValid())
        {
            botPose = llResult.getBotpose();

            curDistance = getDistance(llResult.getTa());
        }
        currentDetections = johnCamera.getDetections();
    }

    public double getDistance(double ta)
    {
        double distance = 70.52322*Math.pow(ta,-0.503861);
        return distance *100;
    }

    //boom




/*
    public void telemetryAprilTag(Telemetry telemetry) {

        List<AprilTagDetection> currentDetections = johnCamera.getDetections();
        telemetry.addData("# AprilTags Detected", currentDetections.size());

        // Step through the list of detections and display info for each one.
        for (AprilTagDetection detection : currentDetections) {
            if (detection.metadata != null) {
                telemetry.addLine(String.format("\n==== (ID %d) %s", detection.id, detection.metadata.name));
                telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (inch)", detection.ftcPose.x, detection.ftcPose.y, detection.ftcPose.z));
                telemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detection.ftcPose.pitch, detection.ftcPose.roll, detection.ftcPose.yaw));
                telemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (inch, deg, deg)", detection.ftcPose.range, detection.ftcPose.bearing, detection.ftcPose.elevation));
            } else {
                telemetry.addLine(String.format("\n==== (ID %d) Unknown", detection.id));
                telemetry.addLine(String.format("Center %6.0f %6.0f   (pixels)", detection.center.x, detection.center.y));
            }
        }   // end for() loop

        // Add "key" information to telemetry
        telemetry.addLine("\nkey:\nXYZ = X (Right), Y (Forward), Z (Up) dist.");
        telemetry.addLine("PRY = Pitch, Roll & Yaw (XYZ Rotation)");
        telemetry.addLine("RBE = Range, Bearing & Elevation");

    }
*/
//hey

}