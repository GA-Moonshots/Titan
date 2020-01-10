/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Ultrasonic.Unit;
import frc.robot.Constants;

/**
 * * Instantiates the drive system with a gyro
 */
public class Drive extends SubsystemBase {
  
  // here's a gyro
  public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  public UltrasonicWrapper ultrasonic1 = new UltrasonicWrapper(0, 1, Unit.kInches);
  public UltrasonicWrapper ultrasonic2 = new UltrasonicWrapper(2, 3, Unit.kInches);
  //public Ultrasonic ultrasonic = new Ultrasonic(0, 1);
  
  

  // here's some motors
  public Jaguar leftMotor1;
  public Jaguar leftMotor2;
  public Jaguar rightMotor1;
  public Jaguar rightMotor2;

  // drive system
  //public DifferentialDrive drive;
  public MecanumDrive dMecanumDrive;

  // grouping the motors
  public SpeedControllerGroup frontRightMotor;
  public SpeedControllerGroup frontLeftMotor;
  public SpeedControllerGroup backRightMotor;
  public SpeedControllerGroup backLeftMotor;
  public SpeedControllerGroup rightSide;
  public SpeedControllerGroup leftSide;



  public double pidTune;

  public Drive(){    
    // PID STUFF: https://frc-pdr.readthedocs.io/en/latest/control/using_WPILIB's_pid_controller.html#implementing-a-basic-pid-control
    
    //gyro.reset();
    // linking motors to ports
    leftMotor1 = new Jaguar(Constants.DriveConstants.LEFT1PORT);
    leftMotor2 = new Jaguar(Constants.DriveConstants.LEFT2PORT);
    rightMotor1 = new Jaguar(Constants.DriveConstants.RIGHT1PORT);
    rightMotor2 = new Jaguar(Constants.DriveConstants.RIGHT2PORT);
    
    // setting up the motor groups
    frontRightMotor = new SpeedControllerGroup(rightMotor1);
    frontLeftMotor = new SpeedControllerGroup(leftMotor1);
    backRightMotor = new SpeedControllerGroup(rightMotor2);
    backLeftMotor = new SpeedControllerGroup(leftMotor2);
    rightSide = new SpeedControllerGroup(rightMotor1, rightMotor2);
    leftSide = new SpeedControllerGroup(leftMotor1, leftMotor2);

    // making a mecanum drive
    dMecanumDrive = new MecanumDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);

    //int raw = analogSensor.getValue();
    //double volts = analogSensor.getVoltage();
    //int averageRaw = analogSensor.getAverageValue();
    ultrasonic1.setAutomaticMode(true);
    ultrasonic2.setAutomaticMode(true);
    
    //AnalogInput.setGlobalSampleRate(62500);
    

    
  }

  }
