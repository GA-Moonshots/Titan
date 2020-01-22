/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class ButtSpin extends CommandBase {
  private boolean spinToColor;

  public ButtSpin(boolean spinToColor) {
    // Use requires() here to declare subsystem dependencies
    addRequirements(RobotContainer.spinnymcSpinSpinnerson);
    this.spinToColor = spinToColor;

  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    // TODO: Make sure butt wheel is extended
    
  }

  public String getColor(){
    Color reading = RobotContainer.spinnymcSpinSpinnerson.colorSensor.getColor();
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
  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {

    if(spinToColor){
      String gameData;
      gameData = DriverStation.getInstance().getGameSpecificMessage();
      while(!gameData.equals(getColor())){
        // TODO: Motors, apply power to butt wheel
      }

    }
    else{
      String reading = getColor();
      int count = 0;
      while(count < 24){
        // TODO: Butt wheel motors
        if(!getColor().equals(reading)){
          count++;
          reading = getColor();
        }
        // TODO: Butt wheel motors
      }
    }
        
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interupted) {
    // TODO: Kill moters
  }

}

