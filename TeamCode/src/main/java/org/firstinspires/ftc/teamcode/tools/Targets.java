package org.firstinspires.ftc.teamcode.tools;

public class Targets {

    public double x;
    public double y;
    public double theta;

    String eventType = "";

    public Targets(double xp, double yp, double thetap){
        x = xp;
        y = yp;
        theta = thetap;
    }

    public Targets(double xp, double yp, double thetap, String eventTypep){
        x = xp;
        y = yp;
        theta = thetap;
        eventType = eventTypep;
    }

}
