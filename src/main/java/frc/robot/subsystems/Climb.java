/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.Constants;

/**
 * * Instantiates the drive system with a gyro
 */
public class Climb extends SubsystemBase {

  // here's some motors
  private Jaguar rightMotor = new Jaguar(Constants.DriveConstants.WINCH_RIGHT);
  private Jaguar leftMotor = new Jaguar(Constants.DriveConstants.WINCH_LEFT);
  private Jaguar elevatorMotor = new Jaguar(Constants.DriveConstants.ELEVATOR);
  //private Jaguar rightMotor2 = new Jaguar(Constants.DriveConstants.WINCH_RIGHT);
  //private Jaguar leftMotor2 = new Jaguar(Constants.DriveConstants.WINCH_LEFT);

  public SpeedControllerGroup winchMotors;
  public SpeedControllerGroup elevatorMotorGroup;
  
  public Encoder encoder = new Encoder(1, 2);

  
  public Climb(){    
    // PID STUFF: https://frc-pdr.readthedocs.io/en/latest/control/using_WPILIB's_pid_controller.html#implementing-a-basic-pid-control
    // linking motors to ports
    //leftMotor.setInverted(true);  
    winchMotors = new SpeedControllerGroup(rightMotor, leftMotor);
    elevatorMotorGroup = new SpeedControllerGroup(elevatorMotor);


    }
  }
