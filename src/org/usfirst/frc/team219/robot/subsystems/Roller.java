package org.usfirst.frc.team219.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Roller extends Subsystem {
    
	private CANTalon roller;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void setRollerSpeed(double speed){
		roller.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
