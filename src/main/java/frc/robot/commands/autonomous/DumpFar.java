package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveTimeRight;
import frc.robot.commands.DriveToWall;

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