package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Pneumatics extends Subsystem {
	
	private DoubleSolenoid climberLeft, climberRight, shooter;
	Solenoid portcullis;
	private Compressor c;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Pneumatics(){
		shooter = new DoubleSolenoid(RobotMap.PCM_PORT,RobotMap.SHOOTER_FORWARD,RobotMap.SHOOTER_REVERSE);
		climberLeft = new DoubleSolenoid(RobotMap.PCM_PORT,RobotMap.CLIMBER_LEFT_FORWARD,RobotMap.CLIMBER_LEFT_REVERSE);
		climberRight = new DoubleSolenoid(RobotMap.PCM_PORT,RobotMap.CLIMBER_RIGHT_FORWARD,RobotMap.CLIMBER_RIGHT_REVERSE);
		portcullis = new Solenoid(RobotMap.PCM_PORT,RobotMap.PORTCULLIS_FORWARD);
		
		
		c = new Compressor(RobotMap.PCM_PORT);
		c.setClosedLoopControl(true);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	public void extendPortcullis(){
		portcullis.set(true);
	}
	
	public void retractPortcullis(){
		portcullis.set(false);
	}
	
	public void extendClimbers(){
		climberLeft.set(Value.kForward);
		climberRight.set(Value.kReverse);
	}
	
	public void retractClimbers(){
		climberLeft.set(Value.kReverse);
		climberRight.set(Value.kForward);
	}
	
	/*
	 * Test this?
	 */
	
	public void extendShooter(){
		shooter.set(Value.kForward);
		SmartDashboard.putBoolean("SHOOTER OUT?",true);
	}
	
	public void retractShooter(){
		shooter.set(Value.kReverse);
		SmartDashboard.putBoolean("SHOOTER OUT?", false);
	}
    
}

