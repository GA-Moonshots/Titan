package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveToWall;

public class DumpNear extends SequentialCommandGroup {

    public DumpNear() {
        addCommands(
            //Drive to the wall
            new DriveToWall()
            //Dump cells
            
        );

    }


}