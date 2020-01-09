/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.buttons.Buttons;
import edu.wpi.first.wpilibj2.buttons.JoystickButton;
import frc.robot.commands.DriveAdjustRight;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.GripInCommand;
import frc.robot.commands.GripOutCommand;
import frc.robot.commands.DriveToWall;
import frc.robot.commands.SquareUp;
import frc.robot.commands.DumpClose;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    public static Joystick xbox = new Joystick(0);
    public static Button xButton = new JoystickButton(xbox, 3);
    public static Button aButton = new JoystickButton(xbox, 1);
    public static Button bButton = new JoystickButton(xbox, 2);
    public static Button yButton = new JoystickButton(xbox, 4);
    public static Button leftBumper = new JoystickButton(xbox, 5);
    public static Button rightBumper = new JoystickButton(xbox, 6);
    public static Button selectButton = new JoystickButton(xbox, 7);
    public static Button startButton = new JoystickButton(xbox, 8);
    public static Button leftStickClick = new JoystickButton(xbox, 9);
    public static Button rightStickClick = new JoystickButton(xbox, 10);
    
    
    public OI(){
  
      yButton.whenPressed(new DumpClose());
      aButton.whileHeld(new GripOutCommand());
      leftBumper.whenPressed(new ExampleCommand());
      rightBumper.whenPressed(new ExampleCommand());
      leftStickClick.whenPressed(new ExampleCommand());
      rightStickClick.whenPressed(new ExampleCommand());
      startButton.whileHeld(new ExampleCommand());
      selectButton.whenPressed(new ExampleCommand());
      xButton.whenPressed(new DriveToWall());
      bButton.whenPressed(new SquareUp());
    }
  
    
  
  }
