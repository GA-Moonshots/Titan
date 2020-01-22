package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveToWall;

public class DumpClose extends SequentialCommandGroup {

    public DumpClose() {
        addCommands(
            //Drive to the wall
            new DriveToWall()
            //Dump cells
            
        );

    }


}