package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandGroupBase;

public class DriveAdjustRight extends CommandGroupBase {
    public  DriveAdjustRight() {
    	addSequential(new DriveToAngle(-30));
        addSequential(new DriveTimeReverse(1.5));
        addSequential(new DriveToAngle(30));
    }
}
