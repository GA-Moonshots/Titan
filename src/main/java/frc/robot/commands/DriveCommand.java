/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
/**
 * Responding to motor control. Runs infinitely
 */
public class DriveCommand extends CommandBase {

    private boolean notMoving = true;
    private boolean driveStraight = false;
    private double driveStraightAt;

  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    addRequirements(RobotContainer.drivymcDriveDriverson);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    driveStraight = !driveStraight;    
    this.driveStraightAt = RobotContainer.drivymcDriveDriverson.gyro.getRawAngle();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    switch(RobotContainer.XboxController.getPOV()){
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

    double valueleftx = RobotContainer.XboxController.getRawAxis(0);
    double valuelefty = RobotContainer.XboxController.getRawAxis(1);
    double valuerightx = RobotContainer.XboxController.getRawAxis(4);
    double valuerighty =RobotContainer.XboxController.getRawAxis(5);

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
    
    
    
    
    // // trigger assist driving straight 
    // if(valuelefty < 0 && valueleftx == 0 && notMoving){
    //   notMoving = false;
    //   driveStraight = true;
    //   this.driveStraightAt = RobotContainer.drivymcDriveDriverson.gyro.getAngle();
    // }
    // else if(valueleftx != 0){
    //   notMoving = false;
    //   driveStraight = false;
    // }
    // else if(valueleftx == 0 && valuelefty == 0){
    //   notMoving = true;
    //   driveStraight = false;
    // }

    if(true == false && Math.abs(valueleftx) > 0){
      double difference = driveStraightAt - RobotContainer.drivymcDriveDriverson.gyro.getRawAngle();
      double power = -0.80;
      if(valueleftx > 0) power = 0.80;
      RobotContainer.drivymcDriveDriverson.dMecanumDrive.driveCartesian(-valueleftx, valuelefty, power); 
    } else {
      RobotContainer.drivymcDriveDriverson.dMecanumDrive.driveCartesian(-valueleftx, valuelefty, valuerightx);
    }



  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    RobotContainer.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0, 0, 0);
  }

}
