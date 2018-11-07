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

public class iLikeTurtles {
    @TeleOp(name="iLikeTurtles", group="Iterative Opmode")
    public class movingRobot extends OpMode {
        // Declare OpMode members.
        //private ElapsedTime runtime = new ElapsedTime();
        DcMotor leftMotor = null;
        DcMotor rightMotor = null;
        DcMotor leftMotorBack = null;
        DcMotor rightMotorBack = null;

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
            armMotor = hardwareMap.get(DcMotor.class, "glyphMotor");
            // Most robots need the motor on one side to be reversed to drive forward
            // Reverse the motor that runs backwards when connected directly to the battery
            leftMotor.setDirection(DcMotor.Direction.FORWARD);
            rightMotor.setDirection(DcMotor.Direction.REVERSE);
            leftMotorBack.setDirection(DcMotor.Direction.FORWARD);
            rightMotorBack.setDirection(DcMotor.Direction.REVERSE);
            armMotor.setDirection(DcMotor.Direction.FORWARD);

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

            //armServo1.setPosition(1);
            //armServo2.setPosition(0);
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
            leftPower = -gamepad1.left_stick_y;
            rightPower = -gamepad1.right_stick_y;
            armPower = -gamepad1.left_stick_y;
            //Send calculated power to wheels
            leftMotor.setPower(leftPower * 2);
            leftMotorBack.setPower(leftPower * 2);
            rightMotor.setPower(rightPower * 2);
            rightMotorBack.setPower(rightPower * 2);
            armMotor.setPower(armPower);
      }
    }
}
