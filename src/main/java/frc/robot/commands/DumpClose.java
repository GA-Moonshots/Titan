package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;

public class DumpClose extends CommandGroupBase {

    public DumpClose() {
        addSequential(new DriveTimeLeft(1));
        addSequential(new DriveTimeRight(1));

    }

    @Override
    public void addCommands(Command... commands) {
        // TODO Auto-generated method stub

    }
}