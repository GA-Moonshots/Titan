/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.autonomous.*;
//import frc.robot.commands.DumpNear;
import frc.robot.commands.*;
import frc.robot.subsystems.BallDumper;
import frc.robot.subsystems.ButtWheel;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import com.revrobotics.Rev2mDistanceSensor.Port;

import frc.robot.Constants.OIConstants;

import static edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
*/
public class RobotContainer {
  // The robot's subsystems and commands are defined here...\

  // STATIC SUBSYSTEMS
  public static Drive drivymcDriveDriverson = new Drive();
  public static ButtWheel spinnymcSpinSpinnerson = new ButtWheel();
  public static BallDumper dumpymcDumpDumperson = new BallDumper();
  public static Climb climbymcClimbClimberson = new Climb();

  public static XboxController XboxController = new XboxController(OIConstants.XBOX_PORT);
  public static Joystick JoystickController = new Joystick(OIConstants.JOYSTICK_PORT);
  
  SendableChooser<CommandBase> m_chooser = new SendableChooser<>();


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_chooser.setDefaultOption("Drive FWD", new DriveTimeReverse(5));
    m_chooser.addOption("Rotate 90 Degrees", new DriveToAngle(90));
    m_chooser.addOption("Dump them cells when near", new DumpNear());
    m_chooser.addOption("Dump them cells when far", new DumpFar());
    m_chooser.addOption("Dump them cells at a medium distance", new DumpMid());
    SmartDashboard.putData("Auto mode", m_chooser);

    
    
    // SET DEFAULT COMMANDS
    drivymcDriveDriverson.setDefaultCommand(new DriveCommand());
  }
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////*** XBOX BINDINGS ***///////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    // X button
    new JoystickButton(XboxController, Button.kX.value)
    .whileHeld(new DumpDown());
    
    // B button
    new JoystickButton(XboxController, Button.kB.value)
    .whileHeld(new ClimbUp());

    // A button
    new JoystickButton(XboxController, Button.kA.value)
    .whenPressed(new DriveToWall());

    // Y button
    new JoystickButton(XboxController, Button.kY.value)
    .whenPressed(new ButtSpin(true));

    // Right bumper
    new JoystickButton(XboxController, Button.kBumperRight.value)
    .whenPressed(new DumpClose()); 

    // Left bumper
    new JoystickButton(XboxController, Button.kBumperLeft.value)
    .whenHeld(new ElevatorRetract());

    // Left Stick
    new JoystickButton(XboxController, Button.kStickLeft.value)
    .whenPressed(() -> {
      CommandScheduler.getInstance().cancelAll();
    });

    // Right Stick
    new JoystickButton(XboxController, Button.kStickRight.value)
    .whenPressed(new DriveSquareUp());

    ///////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////*** JOYSTICK BINDINGS ***/////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    new JoystickButton(JoystickController, 1)
    .whenPressed(new DumpLift());

    new JoystickButton(JoystickController, 2)
    .whenPressed(new DumpDown());

    new JoystickButton(JoystickController, 3)
    .whenPressed(new ClimbUp());

    new JoystickButton(JoystickController, 4)
    .whenPressed(new ButtSpin(true));

    new JoystickButton(JoystickController, 5)
    .whenPressed(new ElevatorExtend());

    new JoystickButton(JoystickController, 6)
    .whenPressed(new ElevatorRetract());

    new JoystickButton(JoystickController, 7)
    .whenPressed(new ButtSpin(false));


    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {

    return m_chooser.getSelected();

  }
}
