package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
@TeleOp(name="iLikeTurtles", group="Iterative Opmode")
public class iLikeTurtles extends OpMode{
        // Declare OpMode members.
        //private ElapsedTime runtime = new ElapsedTime();
        DcMotor leftMotor = null;
        DcMotor rightMotor = null;
        DcMotor leftMotorBack = null;
        DcMotor rightMotorBack = null;
        Servo armServo2 = null;
        private DcMotor armMotor = null;
        /*
         * Code to run ONCE when the driver hits INIT
         */
        @Override
        public void init() {
            telemetry.addData("Status", "Initialized");

            // Initialize the hardware variables. Note that the strings used here as parameters
            // to 'get' must correspond to the names assigned during the robot configuration
            // step (using the FTC Robot Controller app on the phone).
            leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
            //armMotor = hardwareMap.get(DcMotor.class, "armMotor");
            rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
            leftMotorBack = hardwareMap.get(DcMotor.class, "leftMotorBack");
            rightMotorBack = hardwareMap.get(DcMotor.class, "rightMotorBack");
            armMotor = hardwareMap.get(DcMotor.class, "armMotor");
            armServo2 = hardwareMap.servo.get("armServo2");
            // Most robots need the motor on one side to be reversed to drive forward
            // Reverse the motor that runs backwards when connected directly to the battery
            leftMotor.setDirection(DcMotor.Direction.FORWARD);
            rightMotor.setDirection(DcMotor.Direction.REVERSE);
            leftMotorBack.setDirection(DcMotor.Direction.FORWARD);
            rightMotorBack.setDirection(DcMotor.Direction.REVERSE);
            armMotor.setDirection(DcMotor.Direction.FORWARD);
            armServo2.setPosition(0);
            // Tell the driver that initialization is complete.
            telemetry.addData("Status", "Initialized");
        }

        @Override
        public void loop() {
            // Setup a variable for each drive wheel to save power level for telemetry
            //double leftPower;
            double leftPower;
            double rightPower;
            double armPower;
            double servoPower;

            //armServo1.setPosition(1);
            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV.

            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
            //double drive = -gamepad1.left_stick_y;
            //double turn  =  gamepad1.right_stick_x;
            //armPower  = Range.clip(drive + turn, -1.0, 1.0) ;
            //rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;


            // Tank Mode uses one stick to control each wheel.
            // - This requires no math, but it is hard to drive forward slowly and keep straight.
            rightPower  = -gamepad1.left_stick_y ;
            leftPower = -gamepad1.right_stick_y ;
            // Send calculated power to wheels
            armPower = -gamepad2.left_stick_y;
            //Send calculated power to wheels
            leftMotor.setPower(leftPower/1.5);
            leftMotorBack.setPower(leftPower/1.5);
            rightMotor.setPower(rightPower/1.5);
            rightMotorBack.setPower(rightPower/1.5);
            armMotor.setPower(armPower);
            if(gamepad2.x) {
                armServo2.setPosition(1);
            }
            else if (gamepad2.y)  {
                armServo2.setPosition(0);
            }
      }
    }
