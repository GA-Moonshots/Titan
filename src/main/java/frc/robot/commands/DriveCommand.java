/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Robot;
/**
 * Responding to motor control. Runs infinitely
 */
public class DriveCommand extends Command {

  //private boolean notMoving = true;
  //private boolean driveStraight = false;
 // private double driveStraightAt;

  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivymcDriveDriverson);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0, 0, 0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    switch(OI.xbox.getPOV()){
      case -1:   break;
      // SAVED POSITION HIGH   
      //dpad up 
      case 0:                   
                break;
      case 45:  break;
      //dpad right
      case 90:                  
                break;
      case 135: break;
      // SAVED POSITION LOW
      //dpad down
      case 180:
                break;
      case 225: break;
      //dpad left
      case 270: 
                break;
      case 315: break;
    }
    //SmartDashboard.putBoolean("StraightAssist", driveStraight);
    //MANUAL DEAD ZONE
    double dead = 0.15;

    double valueleftx = OI.xbox.getRawAxis(0);
    double valuelefty = OI.xbox.getRawAxis(1);
    double valuerightx = OI.xbox.getRawAxis(4);
    double valuerighty = OI.xbox.getRawAxis(5);

    if(Math.abs(valueleftx) < dead){
      valueleftx = 0;
    }
    if(Math.abs(valuelefty) < dead){
      valuelefty = 0;
    }
    if(Math.abs(valuerightx) < dead){
      valuerightx = 0;
    }
    if(Math.abs(valuerighty) < dead){
      valuerighty = 0;
    }

    Robot.drivymcDriveDriverson.dMecanumDrive.driveCartesian(valueleftx, valuerightx, valuelefty);
    
    ///*
    // trigger assist driving straight 
    /*if(valuelefty < 0 && valueleftx == 0 && notMoving){
      notMoving = false;
      driveStraight = true;
      this.driveStraightAt = Robot.drivymcDriveDriverson.gyro.getAngle();
    }
    else if(valueleftx != 0){
      notMoving = false;
      driveStraight = false;
    }
    else if(valueleftx == 0 && valuelefty == 0){
      notMoving = true;
      driveStraight = false;
    }

    if(driveStraight){
      double difference = driveStraightAt - Robot.drivymcDriveDriverson.gyro.getAngle(); 
      Robot.drivymcDriveDriverson.dMecanumDrive.driveCartesian(-valuelefty, -(difference * .03), 0); 
    } else {
      Robot.drivymcDriveDriverson.dMecanumDrive.driveCartesian(-valuelefty, -valueleftx*0.5, 0); 
    }
    */
    //*/
    //Robot.drivymcDriveDriverson.drive.arcadeDrive(-valuelefty, -valueleftx*0.5); 



  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
