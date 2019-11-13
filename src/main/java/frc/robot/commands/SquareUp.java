package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
/**
 * Responding to motor control. Runs infinitely
 */

public class SquareUp extends Command {

  public SquareUp() {
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
    if(Robot.drivymcDriveDriverson.ultrasonic1.getRangeInches() > Robot.drivymcDriveDriverson.ultrasonic2.getRangeInches()){
      Robot.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0.2, 0, 0);
    }
    
    if(Robot.drivymcDriveDriverson.ultrasonic2.getRangeInches() > Robot.drivymcDriveDriverson.ultrasonic1.getRangeInches()){
      Robot.drivymcDriveDriverson.dMecanumDrive.driveCartesian(-0.2, 0, 0);
    }
  }

  // Make this return true  when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.drivymcDriveDriverson.ultrasonic1.getRangeInches() == Robot.drivymcDriveDriverson.ultrasonic2.getRangeInches();
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
