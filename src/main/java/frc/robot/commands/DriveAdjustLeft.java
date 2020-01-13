package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class DriveAdjustLeft extends SequentialCommandGroup {
    public DriveAdjustLeft() {
        addCommands(
            new DriveToAngle(30), 
            new DriveToAngle(30)
        ); 
    }

}
