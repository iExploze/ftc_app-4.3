package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Arcade", group="OpmodeLinear")
public class IanTst extends LinearOpMode {
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
            double Forward = this.gamepad1.left_stick_y;
            double turn = -this.gamepad1.left_stick_x;
            LeftMotor.setPower(Forward+turn);
            RightMotor.setPower(-Forward+turn);
            telemetry.addData("Status","Running");
            telemetry.addData("Left Joystick y",Forward);
            telemetry.addData("Left Joystick x",turn);
            telemetry.update();
        }
    }
}