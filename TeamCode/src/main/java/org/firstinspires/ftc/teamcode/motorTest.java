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

    /**
     * This file contains an example of an iterative (Non-Linear) "OpMode".
     * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
     * The names of OpModes appear on the menu of the FTC Driver Station.
     * When an selection is made from the menu, the corresponding OpMode
     * class is instantiated on the Robot Controller and executed.
     *
     * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
     * It includes all the skeletal structure that all iterative OpModes contain.
     *
     * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
     * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
     */

    @TeleOp(name="motorTest", group="Iterative Opmode")
    public class motorTest extends OpMode {
        // Declare OpMode members.
        //private ElapsedTime runtime = new ElapsedTime();
        // DcMotor leftMotor = null;
        //private DcMotor rightMotor = null;
        // DcMotor leftMotorBack = null;
        //private DcMotor rightMotorBack = null;
        //private DcMotor glyphMotor = null;
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
            //leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
            armMotor = hardwareMap.get(DcMotor.class, "armMotor");
            //rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
            //leftMotorBack = hardwareMap.get(DcMotor.class, "leftMotorBack");
            //rightMotorBack = hardwareMap.get(DcMotor.class, "rightMotorBack");
            //glyphMotor = hardwareMap.get(DcMotor.class, "glyphMotor");
            // Most robots need the motor on one side to be reversed to drive forward
            // Reverse the motor that runs backwards when connected directly to the battery
            //leftMotor.setDirection(DcMotor.Direction.FORWARD);
            //rightMotor.setDirection(DcMotor.Direction.REVERSE);
            //leftMotorBack.setDirection(DcMotor.Direction.FORWARD);
            //rightMotorBack.setDirection(DcMotor.Direction.REVERSE);
            //glyphMotor.setDirection(DcMotor.Direction.FORWARD);

            // Tell the driver that initialization is complete.
            telemetry.addData("Status", "Initialized");
        }

        @Override
        public void loop() {
            // Setup a variable for each drive wheel to save power level for telemetry
            //double leftPower;
            double armPower;
            //double rightPower;
            //double glyphPower;

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
            //leftPower = -gamepad1.left_stick_y;
            //rightPower = -gamepad1.right_stick_y;
            armPower = -gamepad1.left_stick_y;
            //Send calculated power to wheels
            //leftMotor.setPower(leftPower/1.2);

            armMotor.setPower(armPower/4);
            //leftMotorBack.setPower(leftPower/1.2);
            //rightMotor.setPower(rightPower/1.2);
            //rightMotorBack.setPower(rightPower/1.2);
        }
        /*
         * Code to run ONCE after the driver hits STOP
         */
    }

