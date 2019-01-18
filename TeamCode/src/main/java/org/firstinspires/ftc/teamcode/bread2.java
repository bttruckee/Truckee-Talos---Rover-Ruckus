package org.firstinspires.ftc.teamcode;

import android.hardware.Sensor;
//driscoll is the zodiac killer. no fucking way!!!! What!!! noooo!!! But he is my niBBa, how? I like cokeane.
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import android.hardware.Sensor;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 /**
 * Created by sawyerthompson on 10/27/17.
 */

@Autonomous(name="bread2")
public class bread2 extends LinearOpMode {
    DcMotor leftMotor = null;
    DcMotor rightMotor = null;
    DcMotor leftMotorBack = null;
    DcMotor rightMotorBack = null;
    //DcMotor glyphMotor = null;
    DcMotor armMotor = null;

    Servo armServo1 = null;
    Servo armServo2 = null;
    //Sensor color = null;

    @Override
    public void runOpMode() throws InterruptedException {
        //frontR = hardwareMap.dcMotor.get("frontR");
        //frontL = hardwareMap.dcMotor.get("frontL");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        leftMotorBack = hardwareMap.dcMotor.get("leftMotorBack");
        rightMotorBack = hardwareMap.dcMotor.get("rightMotorBack");
        //glyphMotor = hardwareMap.dcMotor.get("glyphMotor");
        armMotor = hardwareMap.dcMotor.get("armMotor");
        armServo1 = hardwareMap.servo.get("armServo1");
        armServo2 = hardwareMap.servo.get("armServo2");
        armMotor.setPower(0);
        armServo1.setPosition(0);
        armServo2.setPosition(0);
        waitForStart();

        armServo2.setPosition(1);
        armMotor.setPower(-1);
        Thread.sleep(3600);
        armMotor.setPower(0);
        Thread.sleep(1000);

        // each turn left will be 180 degrees so 2 turns will be a full 360 turnaround
        // this will help with consistancy of the program

        turnRight(.5);
        Thread.sleep(2200);
        DriveForward(0);
        Thread.sleep(1000);

        DriveForward(.33);
        Thread.sleep(490);
        DriveForward(0);
        Thread.sleep(1000);

        armServo2.setPosition(0);
        Thread.sleep(1000);
        // down snowplow

        turnLeft(.5);
        Thread.sleep(950);
        DriveBackwards(0);
        Thread.sleep(1000);

        DriveForward(.33);
        Thread.sleep(1300);
        DriveForward(0);
        Thread.sleep(1000);

        turnLeft(.75);
        Thread.sleep(280);
        turnRight(0);
        Thread.sleep(1000);

        DriveForward(.75);
        Thread.sleep(1650);
        DriveForward(0);
        Thread.sleep(1000);

        DriveBackwards(.5);
        Thread.sleep(200);
        DriveForward(0);
        Thread.sleep(1000);

        turnLeft(.85);
        Thread.sleep(1550);
        DriveForward(0);
        Thread.sleep(1000);

        DriveBackwards(.5);
        Thread.sleep(400);
        DriveForward(0);
        Thread.sleep(900);

        DriveForward(.5);
        Thread.sleep(200);
        DriveForward(0);
        Thread.sleep(900);

        armServo1.setPosition(1);
        Thread.sleep(1000);
        // down marker

        armServo1.setPosition(0);
        Thread.sleep(1000);
        DriveForward(0);
        Thread.sleep(900);

        armServo2.setPosition(0);
        Thread.sleep(1000);
        //up snowplow

        DriveForward(1);
        Thread.sleep(3000);
        DriveForward(0);
        Thread.sleep(1000);
    }

    public void DriveForward(double power) {
        //frontL.setPower(power);
        //frontR.setPower(power);
        leftMotor.setPower(power);
        //glyphMotor.setPower(-1);
        leftMotorBack.setPower(power);
        rightMotorBack.setPower(-power);
        rightMotor.setPower(-power);
    }

    public void DriveBackwards(double power) {
        //frontL.setPower(power);
        //frontR.setPower(power);
        //glyphMotor.setPower(-1);
        leftMotorBack.setPower(-power);
        leftMotor.setPower(-power);
        rightMotor.setPower(power);
        rightMotorBack.setPower(power);
    }

    public void turnRight(double power) {
        //glyphMotor.setPower(-1);
        leftMotorBack.setPower(-power);
        leftMotor.setPower(-power);
        rightMotor.setPower(-power);
        rightMotorBack.setPower(-power);
        //frontR.setPower(power);
        //frontL.setPower(-power);
    }

    public void turnLeft(double power) {
        turnRight(-power);
    }

}