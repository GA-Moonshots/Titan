package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveTimeRight;
import frc.robot.commands.DriveToWall;

public class DumpMid extends SequentialCommandGroup {

    public DumpMid() {
        addCommands(
            //Drive to wall
            new DriveToWall(),
            //Drive right
            new DriveTimeRight(1)
            //Dump cells
        );

    }
}