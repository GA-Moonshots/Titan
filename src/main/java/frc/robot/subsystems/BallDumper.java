/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.Constants;
import frc.robot.RobotContainer;

/**
 * * Instantiates the drive system with a gyro
 */
public class BallDumper extends SubsystemBase {

  public boolean isDumpOpen;
  // here's some motors
  private Jaguar dumperMotor = new Jaguar(Constants.DriveConstants.DUMPER);
  public SpeedControllerGroup motor = new SpeedControllerGroup(dumperMotor);
  // Initializes an AnalogPotentiometer on analog port 0
  // The full range of motion (in meaningful external units) is 0-180 (this could be degrees, for instance)
  // The "starting point" of the motion, i.e. where the mechanism is located when the potentiometer reads 0v, is 30.
  public AnalogPotentiometer turnySensorThing = new AnalogPotentiometer(0);

  // Servos must be plugged into the Roborio itself, not the extention board, as it does not provide enough power.
  public Servo servo1 = new Servo(0);
  //public Servo servo2 = new Servo(1);

  public BallDumper(){
    //RobotContainer.dumpymcDumpDumperson.servo1.setAngle(180);
    //RobotContainer.dumpymcDumpDumperson.servo2.setAngle(180);
    }
  }
