/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
/**
 * Responding to motor control. Runs infinitely
 */

public class DumpToggle extends CommandBase {

  public DumpToggle() {
    // Use requires() here to declare subsystem dependencies
    addRequirements(Robot.container.dumpymcDumpDumperson);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
      if(Robot.container.dumpymcDumpDumperson.isDumpOpen == false){
        Robot.container.dumpymcDumpDumperson.servo1.setAngle(90);
        Robot.container.dumpymcDumpDumperson.isDumpOpen = true;
      }
      if(Robot.container.dumpymcDumpDumperson.isDumpOpen == true){
        Robot.container.dumpymcDumpDumperson.servo1.setAngle(5);
        Robot.container.dumpymcDumpDumperson.isDumpOpen = true;
      }
    }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return Robot.container.dumpymcDumpDumperson.servo1.getAngle() <= 90;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    Robot.container.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0, 0, 0);
  }

}