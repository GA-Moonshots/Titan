package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class DumpFar extends SequentialCommandGroup {

    public DumpFar() {
        addCommands(
            //Go forward
            new DriveToWall(),
            //Go right
            new DriveTimeRight(2)
            //Dump cells
        );

    }

}