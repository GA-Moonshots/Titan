/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class Constants {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // BUTTONS
  public static final class OIConstants {

    public static int xBUTTON_NUM = 3;
    public static int aBUTTON_NUM = 1;
    public static int bBUTTON_NUM = 2;
    public static int yBUTTON_NUM = 4;
    public static int LEFTSTICKCLICK_NUM = 9;
    public static final int kDriverControllerPort = 1;

  }

  public static final class DriveConstants {

    // MOTORS
    public static int LEFT1PORT = 0;
    public static int LEFT2PORT = 1;
    public static int RIGHT1PORT = 3;
    public static int RIGHT2PORT = 2;

    public static double ANGLE_TOLERANCE = 2.0;
  
  }

  public static final class DIOConstants {

    // DIO
    public static int GRABBER_ENC_A = 1;
    public static int GRABBER_ENC_B = 0;
    public static int ARM_ENC_A = 6;
    public static int ARM_ENC_B = 7;
    public static int ELEVATOR_ENC_A = 2;
    public static int ELEVATOR_ENC_B = 3; 
    public static int DIO_LIMITUP = 4;
    public static int DIO_LIMITDOWN = 5;

  }

  
}
