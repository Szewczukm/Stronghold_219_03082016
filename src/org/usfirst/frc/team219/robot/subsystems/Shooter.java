package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
	private CANTalon shooterLeft, shooterRight;
	
	public Shooter(){
		shooterLeft = new CANTalon(RobotMap.MOTOR_PORT_SL);
		shooterRight = new CANTalon(RobotMap.MOTOR_PORT_SR);
	}
	
	public void setShooterSpeed(double speed){
		shooterLeft.set(speed);
		shooterRight.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

