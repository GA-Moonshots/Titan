package frc.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class DumpFar extends CommandGroup {

    public DumpFar(){
        addSequential(new DriveToWall());


    }
}