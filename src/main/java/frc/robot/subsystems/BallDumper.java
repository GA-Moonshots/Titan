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
import frc.robot.Constants;

/**
 * * Instantiates the drive system with a gyro
 */
public class BallDumper extends SubsystemBase {

  // here's some motors
  public Jaguar dumperMoter;

  public SpeedControllerGroup dumper;


  public BallDumper(){    
    // PID STUFF: https://frc-pdr.readthedocs.io/en/latest/control/using_WPILIB's_pid_controller.html#implementing-a-basic-pid-control
    // linking motors to ports
    dumperMoter = new Jaguar(Constants.DriveConstants.DUMPER);
    dumper = new SpeedControllerGroup(dumperMoter);

    }
  }
