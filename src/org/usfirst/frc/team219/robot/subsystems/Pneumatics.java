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
	private Compressor c;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Pneumatics(){
		climberLeft = new DoubleSolenoid(RobotMap.PCM_PORT,RobotMap.CLIMBER_LEFT_FORWARD,RobotMap.CLIMBER_LEFT_REVERSE);
		climberRight = new DoubleSolenoid(RobotMap.PCM_PORT,RobotMap.CLIMBER_RIGHT_FORWARD,RobotMap.CLIMBER_RIGHT_REVERSE);
		
		
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
}

