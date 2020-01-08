package frc.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class DumpClose extends CommandGroup {

    public DumpClose(){
        addSequential(new DriveTimeLeft(1));
        addSequential(new DriveTimeRight(1));


    }
}