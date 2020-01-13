package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class DumpClose extends SequentialCommandGroup {

    public DumpClose() {
        addCommands(
            //Drive to the wall
            new DriveToWall()
            //Dump cells
            
        );

    }


}