package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.*;

public class DumpStraightAhead extends SequentialCommandGroup {

    public DumpStraightAhead() {
        addCommands(

            //Drive to wall
            new DriveToWall(),

            //Align to wall
            //new DriveSquareUp(),
            
            //Dump cells
            new DumpOpen(),

            
            
            new DumpClose(),
                
            new DriveTimeReverse(1) // TODO: experiment with this time/magic number
            
        );

    }


}