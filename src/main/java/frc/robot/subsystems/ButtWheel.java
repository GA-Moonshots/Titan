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
import edu.wpi.first.wpilibj.I2C.Port;



public class ButtWheel extends SubsystemBase {
  
  private Jaguar buttMotor = new Jaguar(Constants.DriveConstants.BUTT_WHEEL);
  public ColorSensorV3 colorSensor = new ColorSensorV3(Port.kMXP);
  public SpeedControllerGroup buttMotorGroup;


  /**
   * Open Smart Dashboard or Shuffleboard to see the color detected by the 
   * sensor.
   */
  public ButtWheel(){
    //armEncoder.reset(); // encoder starts at zero. Max is ~900?
    buttMotorGroup = new SpeedControllerGroup(buttMotor);
  }

  public String getColor(){
    Color reading = colorSensor.getColor();
    double blue = reading.blue;
    double red = reading.red;
    double green = reading.green;
    String colorInfo;
    if (blue<0.15 && red>0.3 && green>0.5){
      colorInfo = "Y";
    }
    else if (blue>red && blue>0.3 && green<0.5){
      colorInfo = "B";
    }
    else if (red>blue && red>0.3 && green<0.5){
      colorInfo = "R";
    }
    else if (green>blue && green>red){
      colorInfo = "G";
    }
    else {
      colorInfo = "?";
    }
    return colorInfo;
  }
}