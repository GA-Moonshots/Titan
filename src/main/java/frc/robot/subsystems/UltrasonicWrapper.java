package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Ultrasonic.Unit;

public class UltrasonicWrapper extends Ultrasonic{

    public UltrasonicWrapper(final int pingChannel, final int echoChannel, Unit units){
        super(pingChannel, echoChannel, units);
    }
    @Override
    public double getRangeInches() {
        double first, second, third;
        do{
            first = super.getRangeInches();
            second = super.getRangeInches();
            third = super.getRangeInches();
        }while(Math.abs(first - second) > 2 || Math.abs(second - third) > 2) ;




        return first;
    }
}