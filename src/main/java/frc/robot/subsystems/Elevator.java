/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Jaguar;
import frc.robot.Constants;

/**
 * * Instantiates the drive system with a gyro
 */
public class Elevator extends SubsystemBase {
  // here's some motors
  public Jaguar leftMotor1;
  public Jaguar leftMotor2;
  public Jaguar rightMotor1;
  public Jaguar rightMotor2;

  public Elevator(){    
    // PID STUFF: https://frc-pdr.readthedocs.io/en/latest/control/using_WPILIB's_pid_controller.html#implementing-a-basic-pid-control
    
    // linking motors to ports
    leftMotor1 = new Jaguar(Constants.DriveConstants.LEFT1PORT);
    leftMotor2 = new Jaguar(Constants.DriveConstants.LEFT2PORT);
    rightMotor1 = new Jaguar(Constants.DriveConstants.RIGHT1PORT);
    rightMotor2 = new Jaguar(Constants.DriveConstants.RIGHT2PORT); 
  }
  }
