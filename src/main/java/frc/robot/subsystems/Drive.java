/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;
//import frc.robot.commands.xDriveCommand;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Ultrasonic.Unit;
import edu.wpi.first.wpilibj.SendableBase;


/**
 * * Instantiates the drive system with a gyro
 */
public class Drive extends Subsystem {
  
  // here's a gyro
  public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  public Ultrasonic ultrasonic1 = new Ultrasonic(0, 1, Unit.kInches);
  public Ultrasonic ultrasonic2 = new Ultrasonic(2, 3, Unit.kInches);
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
    leftMotor1 = new Jaguar(RobotMap.LEFT1PORT);
    leftMotor2 = new Jaguar(RobotMap.LEFT2PORT);
    rightMotor1 = new Jaguar(RobotMap.RIGHT1PORT);
    rightMotor2 = new Jaguar(RobotMap.RIGHT2PORT);
    
    // setting up the motor groups
    frontRightMotor = new SpeedControllerGroup(rightMotor1);
    frontLeftMotor = new SpeedControllerGroup(leftMotor1);
    backRightMotor = new SpeedControllerGroup(rightMotor2);
    backLeftMotor = new SpeedControllerGroup(leftMotor2);
    rightSide = new SpeedControllerGroup(rightMotor1, rightMotor2);
    leftSide = new SpeedControllerGroup(leftMotor1, leftMotor2);

    // making differential drive  
    //drive = new DifferentialDrive(rightSide, leftSide);
    dMecanumDrive = new MecanumDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
    //drive = new DifferentialDrive (leftSide, rightSide);

    //int raw = analogSensor.getValue();
    //double volts = analogSensor.getVoltage();
    //int averageRaw = analogSensor.getAverageValue();
    ultrasonic1.setAutomaticMode(true);
    ultrasonic2.setAutomaticMode(true);
    
    //AnalogInput.setGlobalSampleRate(62500);
    

    
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand()); // THIS IS HOW WE DRIVE THE // ROBOT
  }


  }
