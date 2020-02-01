/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.BallDumper;
/**
 * Responding to motor control. Runs infinitely
 */

public class DumpClose extends CommandBase {

  public DumpClose() {
    // Use requires() here to declare subsystem dependencies
    addRequirements(RobotContainer.dumpymcDumpDumperson);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
      RobotContainer.dumpymcDumpDumperson.servo1.setAngle(5);
      RobotContainer.dumpymcDumpDumperson.isDumpOpen = false;
    }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return RobotContainer.dumpymcDumpDumperson.servo1.getAngle() <= 5;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    RobotContainer.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0, 0, 0);
  }

}