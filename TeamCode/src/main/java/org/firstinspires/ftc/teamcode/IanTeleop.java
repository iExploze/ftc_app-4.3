package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Basic: OpmodeLinear", group="OpmodeLinear")
public class IanTeleop extends LinearOpMode {
    private DcMotor RightMotor;
    private DcMotor LeftMotor;
    @Override
    public void runOpMode(){
        RightMotor = hardwareMap.get(DcMotor.class,"right");
        LeftMotor = hardwareMap.get(DcMotor.class,"left");

        telemetry.addData("Status","Initialized");
        telemetry.update();

        waitForStart();
        while(opModeIsActive()){
            double LeftM = this.gamepad1.left_stick_y;
            double RightM = -this.gamepad1.right_stick_y;
            LeftMotor.setPower(LeftM/1);
            RightMotor.setPower(RightM/1);
            telemetry.addData("Status","Running");
            telemetry.addData("Left Joystick",LeftM);
            telemetry.addData("Right Joysticl",RightM);
            telemetry.update();
        }
    }
}