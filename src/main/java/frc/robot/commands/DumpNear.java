package frc.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class DumpNear extends CommandGroup {

    public DumpNear(){
        addSequential(new DriveToWall());


    }
}