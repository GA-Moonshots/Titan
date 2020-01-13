package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class DumpNear extends SequentialCommandGroup {

    public DumpNear() {
        addCommands(
            new DriveToWall()
        );

    }
}