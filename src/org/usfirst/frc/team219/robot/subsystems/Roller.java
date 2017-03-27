package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Roller extends Subsystem {
    
	private CANTalon roller;
	
	public Roller(){
		roller = new CANTalon(RobotMap.MOTOR_PORT_ROLLER);
	}
	
	
	public void setRollerSpeed(double speed){
		roller.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

