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
/*
  private double notReallyPID() {
    // NOTE: Negative return values will increase the gyro's value
    double sensor1 = Robot.drivymcDriveDriverson.ultrasonic1.getRangeInches();
    double sensor2 = Robot.drivymcDriveDriverson.ultrasonic1.getRangeInches();
    double MAX_POWER = 0.7; // cap the power 
    double MIN_POWER = 0.45; // lowest effective power
    int ENOUGH_CHECKS = 15; // how many times do we pass our target until we're satisfied?

    // determine the error
    double error = Math.abs(sensor1 - sensor2);

    // determine the power output neutral of direction
    double output = Math.abs(error) * MAX_POWER;
    if(output < MIN_POWER) output = MIN_POWER;
    if(output > MAX_POWER) output = MAX_POWER;

    // are we there yet? this is to avoid ping-ponging
    // plus we never stop the method unless our output is zero
    if(Math.abs(error) < RobotMap.ANGLE_TOLERANCE) check++;
    if(check > ENOUGH_CHECKS) return 0.0;

    // determine the direction
    // if I was trying to go a positive angle change from the start
    if(requestedRotation > 0){
      if(error > 0) return -output; // move in a positive direction
      else return output; // compensate for over-turning by going a negative direction
    }
    // if I was trying to go a negative angle from the start
    else{
      if(error < 0) return output; // move in a negative direction as intended
      else return -output; // compensate for over-turning by moving a positive direction
    }
  }

  */
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.drivymcDriveDriverson.ultrasonic1.getRangeInches() > Robot.drivymcDriveDriverson.ultrasonic2.getRangeInches()){
      Robot.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0.3, 0, 0);
    }
    
    else if(Robot.drivymcDriveDriverson.ultrasonic2.getRangeInches() > Robot.drivymcDriveDriverson.ultrasonic1.getRangeInches()){
      Robot.drivymcDriveDriverson.dMecanumDrive.driveCartesian(-0.3, 0, 0);
    }
  }

  // Make this return true  when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    System.out.println("Right sensor reads " + Robot.drivymcDriveDriverson.ultrasonic2.getRangeInches() + " and left sensor reads " + Robot.drivymcDriveDriverson.ultrasonic1.getRangeInches());
    return Math.abs(Robot.drivymcDriveDriverson.ultrasonic1.getRangeInches() - Robot.drivymcDriveDriverson.ultrasonic2.getRangeInches()) < 1;
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
