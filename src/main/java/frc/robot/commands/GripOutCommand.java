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
public class GripOutCommand extends Command {

  public GripOutCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.gripper);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // if we triggered a setPoint
    Robot.gripper.motorOne.set(0.45);
    Robot.gripper.motorTwo.set(-0.45);
  } 

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.gripper.motorOne.set(0.0);
    Robot.gripper.motorTwo.set(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.gripper.motorOne.set(0.0);
    Robot.gripper.motorTwo.set(0.0);
  }

}
