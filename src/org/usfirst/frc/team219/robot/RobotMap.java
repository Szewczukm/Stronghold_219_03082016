package org.usfirst.frc.team219.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {    
	//Our RobotMap will be used to declare port numberings for all devices on our robot
	//Declare your port numberings here:
	
	
	/**
	 * CAN Talon speed controller port declarations
	 */
	public static final int MOTOR_PORT_FL = 8;
	public static final int MOTOR_PORT_BL = 1;
	public static final int MOTOR_PORT_FR = 3;
	public static final int MOTOR_PORT_BR = 2;
	public static final int MOTOR_PORT_ROLLER = 4;
	public static final int MOTOR_PORT_ARM_LEFT = 5;
	public static final int MOTOR_PORT_ARM_RIGHT = 6;
	
	/**
	 * Gyro port declaration
	 */
	public static final int GYRO_PORT = 1;

	/**
	 * Pneumatics port declarations
	 */
	public static final int PCM_PORT = 15;
	public static final int CLIMBER_LEFT_FORWARD = 3;
	public static final int CLIMBER_LEFT_REVERSE = 2;
	public static final int CLIMBER_RIGHT_FORWARD = 6;
	public static final int CLIMBER_RIGHT_REVERSE = 5;

}


