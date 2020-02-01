/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.Jaguar;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.SpeedControllerGroup;



public class ButtWheel extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // here's a motor i'm declaring here, sorry Mr. A it's not in a command
  public final I2C.Port i2cPort = I2C.Port.kOnboard;
  private Jaguar buttMotor = new Jaguar(Constants.DriveConstants.BUTT_WHEEL);
  //track the desired position of the arm
  // public int holdAt;
  public ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  public SpeedControllerGroup buttMotorGroup;


  /**
   * Open Smart Dashboard or Shuffleboard to see the color detected by the 
   * sensor.
   */
  public ButtWheel(){
    //armEncoder.reset(); // encoder starts at zero. Max is ~900?
    buttMotorGroup = new SpeedControllerGroup(buttMotor);

  }
}