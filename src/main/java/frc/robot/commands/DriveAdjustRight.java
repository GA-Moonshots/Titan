package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class DriveAdjustRight extends SequentialCommandGroup {
    public  DriveAdjustRight() {
        addCommands(
            new DriveToAngle(-30),
            new DriveTimeReverse(1.5),
            new DriveToAngle(30)
        );
    }
}
