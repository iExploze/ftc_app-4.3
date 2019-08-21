import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


    @TeleOp(name = "DriveWithArm", group = "OpmodeLinear")
    public class DriveWithArm extends LinearOpMode {
        private DcMotor RightMotor;
        private DcMotor LeftMotor;
        private DcMotor scoop;
        private DcMotor ElevatorMotor;
        @Override
        public void runOpMode() {
            RightMotor = hardwareMap.get(DcMotor.class, "right");
            LeftMotor = hardwareMap.get(DcMotor.class, "left");
            scoop = hardwareMap.get (DcMotor.class,"scoop");
            ElevatorMotor = hardwareMap.get(DcMotor.class,"elevator");

            telemetry.addData("Status", "Initialized");
            telemetry.update();

            waitForStart();


            while (opModeIsActive()) {
                double Forward = this.gamepad1.left_stick_y;
                double turn = -this.gamepad1.left_stick_x;
                boolean roll = this.gamepad1.left_bumper;
                boolean rollR = this.gamepad1.right_bumper;
                boolean Elevator = this.gamepad1.y;
                boolean ElevatorR = this.gamepad1.b;
                LeftMotor.setPower(Forward + turn);
                RightMotor.setPower(-Forward + turn);
                if(roll) {
                    scoop.setPower(1);
                }
                else if(rollR){
                    scoop.setPower(-1);
                }
                else{
                    scoop.setPower(0);
                }
                if(Elevator){
                    ElevatorMotor.setPower(0.5);
                }
                else if(ElevatorR){
                    ElevatorMotor.setPower(-5.5);
                }
                else {
                    ElevatorMotor.setPower(0);
                }
                telemetry.addData("Status", "Running");
                telemetry.addData("Left Joystick y", Forward);
                telemetry.addData("Left Joystick x", turn);
                telemetry.addData("B", roll);
                telemetry.addData("X", Elevator);
                telemetry.update();
            }
        }
    }

