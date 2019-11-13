/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
/**
 * Responding to motor control. Runs infinitely
 */

public class DriveToWall extends Command {

  public DriveToWall() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivymcDriveDriverson);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0, 0, -0.2);
     }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.drivymcDriveDriverson.ultrasonic1.getRangeInches() < 20;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0, 0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0, 0, 0);

  }

}
