/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;


/**
 * * Instantiates the drive system with a gyro
 */
public class Gripper extends Subsystem {
  

  // here's some motors
  public Jaguar orangeGripper;
  public Jaguar blackGripper;
  


  // grouping the motors
  public SpeedControllerGroup motorOne;
  public SpeedControllerGroup motorTwo;



  public Gripper(){    

    // linking motors to ports
    orangeGripper = new Jaguar(RobotMap.ORANGEGRIPPER);
    blackGripper = new Jaguar(RobotMap.BLACKGRIPPER);

    
    // setting up the motor groups
    motorOne = new SpeedControllerGroup(orangeGripper);
    motorTwo = new SpeedControllerGroup(blackGripper);




  }

  @Override
  public void initDefaultCommand() {

                                                                                         // ROBOT
  }


  }
