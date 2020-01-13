package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

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