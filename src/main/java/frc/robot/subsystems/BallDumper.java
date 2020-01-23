/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.Constants;

/**
 * * Instantiates the drive system with a gyro
 */
public class BallDumper extends SubsystemBase {

  // here's some motors
  private Jaguar dumperMotor = new Jaguar(Constants.DriveConstants.DUMPER);
  public SpeedControllerGroup motor = new SpeedControllerGroup(dumperMotor);
  // Initializes an AnalogPotentiometer on analog port 0
  // The full range of motion (in meaningful external units) is 0-180 (this could be degrees, for instance)
  // The "starting point" of the motion, i.e. where the mechanism is located when the potentiometer reads 0v, is 30.
  public AnalogInput turnySensorThing = new AnalogInput(0);
  //public Servo servo1 = new Servo(0);

  public BallDumper(){    
    // PID STUFF: https://frc-pdr.readthedocs.io/en/latest/control/using_WPILIB's_pid_controller.html#implementing-a-basic-pid-control
    // linking motors to ports
     

    }
  }
