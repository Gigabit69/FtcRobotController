package org.firstinspires.ftc.teamcode.OpModes;

import org.firstinspires.ftc.teamcode.Components.Calculator;

public class idk {
    public Calculator calcObject = null;

    public void init() {
        calcObject = new Calculator();
        calcObject.odometryFormula(0,0,0);
    }
}
