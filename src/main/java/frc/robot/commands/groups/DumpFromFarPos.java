package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.*;


public class DumpFromFarPos extends SequentialCommandGroup {

    public DumpFromFarPos() {
        addCommands(

            //Close dumper in case its open
            new DumpClose(),
            //Go forward
            new DriveToWall(),
            //Align with the wall
            new DriveSquareUp(),

            //Go right
            new DriveTimeRight(2),  // TODO: experiment with this time/magic number
            
            //Dump cells
            new DumpOpen(),
            
            new DumpClose(),

            new DriveTimeReverse(2) // TODO: experiment with this time/magic number

        );

    }

}