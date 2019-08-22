package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="AutonTest2", group="OpmodeLinear")
public class AutonTest2 extends LinearOpMode {
    private DcMotor RightMotor;
    private DcMotor LeftMotor;

    public void GoStaright(int a){
        LeftMotor.setPower(a);
        RightMotor.setPower(-a);
    }

    public static int GoDistanceStarightNum(int a){
        int result = (int)Math.ceil(((a/(3.14*10.2))*1440));
        return result;
    }

    public void stopp() {
        LeftMotor.setPower(0);
        RightMotor.setPower(0);
        }

    public void RunDis(int a){


        LeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        RightMotor.setTargetPosition(GoDistanceStarightNum(a));
        LeftMotor.setTargetPosition(-GoDistanceStarightNum(a));

        LeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        GoStaright(1);

        while(LeftMotor.isBusy()&RightMotor.isBusy()){
        }
        stopp();
    }

    @Override
    public void runOpMode() {
        waitForStart();
        LeftMotor = hardwareMap.get(DcMotor.class,"left");
        RightMotor = hardwareMap.get(DcMotor.class, "right");
        RunDis(30);

}
}