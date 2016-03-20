package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;
import org.usfirst.frc.team219.robot.commands.TeleOp.OpControlArm;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 *@author Jace Beaudoin, Mark Szewczuk, Douglas Mosher
 */
public class Arm extends Subsystem {

	private CANTalon armLifter;
	private double adjustSpeed;
	private double deltaPosition;
	private double deltaSpeed = .05;
	private DigitalInput limitBot;

	
	public Arm() {
		armLifter = new CANTalon(RobotMap.MOTOR_PORT_ARM);
		armLifter.setPosition(0);		//resets arm encoder on turn on
		limitBot = new DigitalInput(RobotMap.LIMIT);
	}
	

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	


	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new OpControlArm());
	}
	
	/**
	 * 
	 * @param speed - Implemented in the OpControlArm Command, used to control the talon's speed output based on joystick Y-axis tilt
	 */
	public void controlArm(double speed)
	{
		if(limitBot.get() && speed > 0  ){
			armLifter.set(speed);
		}
		
		else if(!limitBot.get() && speed < 0 ){
			armLifter.set(0);
		}
		else{
			armLifter.set(speed);
		}
	}
	
	/**
	 * 
	 * @param speed - Speed that you want the arm to travel at.  <-- Should probably be a high value due to gearbox reduction on motor
	 * @param type - The enum type of what position to set the arm to
	 * @see {@link ArmPosition}
	 */
	public void setArmPos(double speed, ArmPosition type){
		double endPos = type.getPosition();
		/*
		 * This needs to be logic checked for going from one position to the next...  Sort of same issue with last years lift
		 */
		deltaPosition = endPos - armLifter.getEncPosition();
		adjustSpeed = (deltaSpeed * deltaPosition);
		armLifter.set(speed*adjustSpeed);
	}
	
	/**
	 * 
	 * @param type - The enum type of what position to set the arm to
	 * @return - True or false depending on if the robot has reached its required desination
	 * @see {@link Position}
	 */
	public boolean isAtPos(ArmPosition type){
		double endPos = type.getPosition();
		/*
		 * This needs to be logic checked for going from one position to the next...  Sort of same issue with last years lift
		 */
		if(armLifter.getEncPosition() > endPos){
			return true;
		}
		return false;
	}
	
	public double getEncPos(){
		return armLifter.getEncPosition();
	}
	
}

