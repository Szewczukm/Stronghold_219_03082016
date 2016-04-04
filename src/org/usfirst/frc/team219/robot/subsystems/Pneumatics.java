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
	
	private DoubleSolenoid climberLeft, climberRight;
	private DoubleSolenoid assistLeft, assistRight;
	private Compressor c;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Pneumatics(){
		climberLeft = new DoubleSolenoid(RobotMap.PCM_PORT,RobotMap.CLIMBER_LEFT_FORWARD,RobotMap.CLIMBER_LEFT_REVERSE);
		climberRight = new DoubleSolenoid(RobotMap.PCM_PORT,RobotMap.CLIMBER_RIGHT_FORWARD,RobotMap.CLIMBER_RIGHT_REVERSE);
		assistLeft = new DoubleSolenoid(RobotMap.PCM_PORT,RobotMap.CLIMB_ASSIST_LEFT_FORWARD,RobotMap.CLIMB_ASSIST_LEFT_BACKWARD);
		assistRight = new DoubleSolenoid(RobotMap.PCM_PORT,RobotMap.CLIMB_ASSIST_RIGHT_FORWARD,RobotMap.CLIMB_ASSIST_RIGHT_BACKWARD);
		
		c = new Compressor(RobotMap.PCM_PORT);
		c.setClosedLoopControl(true);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	public void extendClimbers(){
		climberLeft.set(Value.kForward);
		climberRight.set(Value.kReverse);
	}
	
	public void retractClimbers(){
		climberLeft.set(Value.kReverse);
		climberRight.set(Value.kForward);
	}
	
	public void extendClimbAssist()
	{
		assistLeft.set(Value.kReverse);
		assistRight.set(Value.kForward);
	}
	
	public void retractClimbAssist()
	{
		assistLeft.set(Value.kForward);
		assistRight.set(Value.kReverse);
	}
}

