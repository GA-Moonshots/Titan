package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;
/**
 * Responding to motor control. Runs infinitely
 */

public class SquareUp extends CommandBase {

  double sensor1 = RobotContainer.drivymcDriveDriverson.ultrasonic1.getRangeInches();
  double sensor2 = RobotContainer.drivymcDriveDriverson.ultrasonic2.getRangeInches();
  private double target;
  private int check;

  private Drive drive = RobotContainer.drivymcDriveDriverson;
  
  public SquareUp() {
    // Use requires() here to declare subsystem dependencies
    addRequirements(RobotContainer.drivymcDriveDriverson);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    //target = drive.gyro.getAngle() + requestedRotation;
    check = 0;
    
  }
  private double notReallyPID() {
    // NOTE: Negative return values will increase the gyro's value
    double MAX_POWER = 0.45; // cap the power 
    double MIN_POWER = 0.20; // lowest effective power
    int ENOUGH_CHECKS = 15; // how many times do we pass our target until we're satisfied?

    // determine the error
    double error = Math.abs(sensor1 - sensor2);

    // determine the power output neutral of direction
    double output = Math.abs(error) * MAX_POWER;
    if(output < MIN_POWER) output = MIN_POWER;
    if(output > MAX_POWER) output = MAX_POWER;

    // are we there yet? this is to avoid ping-ponging
    // plus we never stop the method unless our output is zero
    if(Math.abs(error) < Constants.DriveConstants.ANGLE_TOLERANCE) check++;
    if(check > ENOUGH_CHECKS) return 0.0;

    // determine the direction
    // if I was trying to go a positive angle change from the start
    if(sensor1 > sensor2){
      if(error > 0) return -output; // move in a positive direction
      else return output; // compensate for over-turning by going a negative direction
    }
    // if I was trying to go a negative angle from the start
    else{
      if(error < 0) return output; // move in a negative direction as intended
      else return -output; // compensate for over-turning by moving a positive direction
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
      //if(java.lang.Double.isInfinite(sensor1) == false && java.lang.Double.isInfinite(sensor2) == false){
        RobotContainer.drivymcDriveDriverson.dMecanumDrive.driveCartesian(notReallyPID(), 0, 0);
      }
    //}

  // Make this return true  when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    System.out.println("Right sensor reads " + RobotContainer.drivymcDriveDriverson.ultrasonic2.getRangeInches() + " and left sensor reads " + RobotContainer.drivymcDriveDriverson.ultrasonic1.getRangeInches());
    return Math.abs(RobotContainer.drivymcDriveDriverson.ultrasonic1.getRangeInches() - RobotContainer.drivymcDriveDriverson.ultrasonic2.getRangeInches()) < 1;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    RobotContainer.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0, 0, 0);
  }

}
