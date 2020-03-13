package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.*;

public class DumpFromMidPos extends SequentialCommandGroup {

    public DumpFromMidPos() {
        addCommands(
            
            //Drive to wall
            new DriveToWall(),
            
            //Align with the wall
            new DriveSquareUp(),
            
            //Drive right
            new DriveTimeRight(1),  // TODO: experiment with this time/magic number
            
            new DumpOpen(),
            

            new DumpClose(),
               
            new DriveTimeReverse(1) // TODO: experiment with this time/magic number
                
        );

    }
}