/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;


public class DriveToWall extends CommandBase {

  public DriveToWall() {
    // Use requires() here to declare subsystem dependencies
    addRequirements(RobotContainer.drivymcDriveDriverson);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    RobotContainer.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0, -0.2, 0);
     }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    if(RobotContainer.drivymcDriveDriverson.rightDistanceSensor.isRangeValid() || RobotContainer.drivymcDriveDriverson.rightDistanceSensor.isRangeValid())
    return RobotContainer.drivymcDriveDriverson.rightDistanceSensor.getRange() < 20 || RobotContainer.drivymcDriveDriverson.leftDistanceSensor.getRange() < 20;
    else return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    RobotContainer.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0, 0, 0);
  }

}
