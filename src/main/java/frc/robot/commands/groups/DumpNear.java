package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveSquareUp;
import frc.robot.commands.DriveTimeReverse;
import frc.robot.commands.DriveTimeRight;
import frc.robot.commands.DriveToWall;
import frc.robot.commands.DumpClose;
import frc.robot.commands.DumpLift;
import frc.robot.commands.DumpToggle;
import frc.robot.commands.DumpOpen;
import frc.robot.commands.DumpDown;

public class DumpNear extends SequentialCommandGroup {

    public DumpNear() {
        addCommands(
            //Drive to wall
            new DriveToWall(),
            //Align to wall
            new DriveSquareUp(),
            //Double check alignmnet
            new DriveSquareUp(),
            //Dump cells

            //new DumpLift(),
    
            //new DumpOpen(),
            
            //new DumpClose(),

            //new DumpDown(),
    
            new DriveTimeReverse(1)
            
        );

    }


}