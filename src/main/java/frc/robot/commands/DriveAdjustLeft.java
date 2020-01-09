package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;

public class DriveAdjustLeft extends CommandGroupBase {
    public DriveAdjustLeft() {
        addSequential(new DriveToAngle(30));
        addSequential(new DriveTimeReverse(1.5));
        addSequential(new DriveToAngle(-30));
    }

    @Override
    public void addCommands(Command... commands) {
        // TODO Auto-generated method stub

    }
}
