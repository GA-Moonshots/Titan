package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class DumpClose extends SequentialCommandGroup {

    public DumpClose() {
        addCommands(
            new DriveTimeLeft(1),
            new DriveTimeRight(1)
        );

    }


}