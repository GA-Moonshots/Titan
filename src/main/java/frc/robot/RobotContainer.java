/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.DriveTimeForward;
import frc.robot.commands.DriveTimeReverse;
import frc.robot.commands.DriveToAngle;
import frc.robot.commands.DriveToWall;
import frc.robot.commands.DumpClose;
import frc.robot.commands.DumpFar;
import frc.robot.commands.DumpMid;
//import frc.robot.commands.DumpNear;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.SquareUp;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants.OIConstants;

import static edu.wpi.first.wpilibj.XboxController.Button;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
*/
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public static Drive drivymcDriveDriverson = new Drive();

  public static XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);
  SendableChooser<CommandBase> m_chooser = new SendableChooser<>();



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_chooser.setDefaultOption("Drive FWD", new DriveTimeReverse(5));
    m_chooser.addOption("Rotate 90 Degrees", new DriveToAngle(90));
    m_chooser.addOption("Dump them cells when close", new DumpClose());
    m_chooser.addOption("Dump them cells when far", new DumpFar());
    m_chooser.addOption("Dump them cells at a medium distance", new DumpMid());
    SmartDashboard.putData("Auto mode", m_chooser);

    drivymcDriveDriverson.setDefaultCommand(new DriveCommand());
  }
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    // X button
    new JoystickButton(m_driverController, Button.kX.value)
    .whenPressed(new DriveToWall());
    
    // B button
    new JoystickButton(m_driverController, Button.kB.value)
    .whenPressed(new SquareUp());

    // A button
    new JoystickButton(m_driverController, Button.kA.value)
    .whenPressed(new DriveToAngle(90));

    // Y button
    new JoystickButton(m_driverController, Button.kY.value)
    .whenPressed(new SquareUp());

    // Right bumper
    new JoystickButton(m_driverController, Button.kBumperRight.value)
    .whenPressed(new SquareUp()); 

    // Left bumper
    new JoystickButton(m_driverController, Button.kBumperLeft.value)
    .whenPressed(new SquareUp());

    // Right Trigger
    /*new JoystickButton(m_driverController, Button.kA.value)
    .whenPressed(new SquareUp());

    // Left Trigger
    new JoystickButton(m_driverController, Button.kB.value)
    .whenPressed(new SquareUp());

    // D-Pad up
    new JoystickButton(m_driverController, Button.kB.value)
    .whenPressed(new SquareUp());

    // D-Pad down
    new JoystickButton(m_driverController, Button.kB.value)
    .whenPressed(new SquareUp());

    // D-Pad Right
    new JoystickButton(m_driverController, Button.kB.value)
    .whenPressed(new SquareUp());

    // D-Pad Left
    new JoystickButton(m_driverController, Button.kB.value)
    .whenPressed(new SquareUp());*/
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
