package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;

public class DumpFar extends CommandGroupBase {

    public DumpFar() {
        addSequential(new DriveToWall());

    }

    @Override
    public void addCommands(Command... commands) {
        // TODO Auto-generated method stub

    }
}