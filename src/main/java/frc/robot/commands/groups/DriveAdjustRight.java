package frc.robot.commands.groups;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveToAngle;
import frc.robot.commands.DriveTimeReverse;


public class DriveAdjustRight extends SequentialCommandGroup {
    public  DriveAdjustRight() {
        addCommands(
            new DriveToAngle(-30),
            new DriveTimeReverse(1.5),
            new DriveToAngle(30)
        );
    }
}
