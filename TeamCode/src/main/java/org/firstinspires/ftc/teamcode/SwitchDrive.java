package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="SwitchDrive", group="OpmodeLinear")
public class SwitchDrive extends LinearOpMode {
    private DcMotor RightMotor;
    private DcMotor LeftMotor;

    @Override
    public void runOpMode(){
        RightMotor = hardwareMap.get(DcMotor.class,"right");
        LeftMotor = hardwareMap.get(DcMotor.class,"left");

        telemetry.addData("Status","Initialized");
        telemetry.update();

        waitForStart();
        boolean a;
        a = false;

        boolean check = true;//checks if the previous mode had already been used

        while(opModeIsActive()) {
            double Left = this.gamepad1.left_stick_y;
            double Right = -this.gamepad1.right_stick_y;
            double Forward = this.gamepad1.left_stick_y;
            double turn = -this.gamepad1.left_stick_x;
            if(this.gamepad1.a==true&&check==a){//if check does = a meaning both is true, than need a switch, if not don't switch
                a= !a;
            }
            check = a;
            if(a==true) {
                LeftMotor.setPower(Left);
                RightMotor.setPower(Right);
            }
            else{
                LeftMotor.setPower(Forward+turn);
                RightMotor.setPower(-Forward+turn);
            }
            telemetry.addData("Status", "Running");
            telemetry.addData("Left Joystick", Left);
            telemetry.addData("Right Joysticl", Right);
            telemetry.update();
        }
    }
}

