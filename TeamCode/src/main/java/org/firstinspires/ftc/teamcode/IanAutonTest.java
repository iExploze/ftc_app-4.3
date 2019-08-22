package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="IanAutonTest", group="OpmodeLinear")
public class IanAutonTest extends LinearOpMode {
    private DcMotor RightMotor;
    private DcMotor LeftMotor;

    @Override
    public void runOpMode() {
        RightMotor = hardwareMap.get(DcMotor.class, "right");
        LeftMotor = hardwareMap.get(DcMotor.class, "left");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        GoStaright();
        TurnTst();
        GoStaright();
        TurnTst();
        GoStaright();

    }
    public void GoStaright() {
        ElapsedTime Timer = new ElapsedTime();
        Timer.reset();
        LeftMotor.setPower(.3);
        RightMotor.setPower(.3);
        while (Timer.milliseconds()<5000) {

        }
        LeftMotor.setPower(0);
        RightMotor.setPower(0);
    }
    public void TurnTst(){
        ElapsedTime Timer = new ElapsedTime();
        Timer.reset();
        while (Timer.milliseconds()<1500) {
            LeftMotor.setPower(1);
            RightMotor.setPower(-1);
        }
        LeftMotor.setPower(0);
        RightMotor.setPower(0);
    }
}
