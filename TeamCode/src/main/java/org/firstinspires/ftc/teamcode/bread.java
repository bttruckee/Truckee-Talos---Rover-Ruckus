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

@Autonomous(name="Bread")
public class bread extends LinearOpMode {
    DcMotor leftMotor = null;
    DcMotor rightMotor = null;
    DcMotor leftMotorBack = null;
    DcMotor rightMotorBack = null;
    //DcMotor glyphMotor = null;
    DcMotor armMotor = null;

    Servo armServo1 =null;
    Servo armServo2 = null;
    //Sensor color = null;

    @Override public void runOpMode () throws InterruptedException {
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
        Thread.sleep(3700);
        armMotor.setPower(0);
        DriveForward(0);
        Thread.sleep(1000);

        turnRight(.5);
        Thread.sleep(2050);
        DriveForward(0);
        Thread.sleep(1000);

        DriveForward(.33);
        Thread.sleep(1200);
        DriveForward(0);
        Thread.sleep(1000);

        DriveForward(.33);
        Thread.sleep(1800);
        DriveForward(0);
        Thread.sleep(1000);


        turnLeft(.5);
        Thread.sleep(1900);
        DriveForward(0);
        Thread.sleep(1000);

        armServo1.setPosition(1);
        Thread.sleep(2000);

        DriveForward(0);
        Thread.sleep(2000);

        armServo1.setPosition(0);
        DriveForward(0);
        Thread.sleep(1000);

        armServo2.setPosition(0);

        DriveForward(1);
        Thread.sleep(3200);

        DriveForward(0);
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






