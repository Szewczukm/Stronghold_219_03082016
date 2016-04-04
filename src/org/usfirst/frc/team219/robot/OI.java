package org.usfirst.frc.team219.robot;

import org.usfirst.frc.team219.robot.commands.AutonRoutines.CancelVision;
import org.usfirst.frc.team219.robot.commands.AutonRoutines.TurnWithVision;
import org.usfirst.frc.team219.robot.commands.TeleOp.ExtendClimbAssist;
import org.usfirst.frc.team219.robot.commands.TeleOp.Fire;
import org.usfirst.frc.team219.robot.commands.TeleOp.Harvest;
import org.usfirst.frc.team219.robot.commands.TeleOp.RegularHarvest;
import org.usfirst.frc.team219.robot.commands.TeleOp.Retract;
import org.usfirst.frc.team219.robot.commands.TeleOp.RetractClimbAssist;
import org.usfirst.frc.team219.robot.commands.TeleOp.StartRoller;
import org.usfirst.frc.team219.robot.commands.TeleOp.StartShooter;

//import org.usfirst.frc.team219.robot.commands.Harvest;
//import org.usfirst.frc.team219.robot.commands.StartShooterWheels;s

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    private Joystick driveController;
    private Joystick armController;
    
	public OI(){
		  driveController = new Joystick(0);
		  armController = new Joystick(1);
		  
		  JoystickButton a = new JoystickButton(driveController, 1);
		  a.whenPressed(new Fire());
		  SmartDashboard.putString("A", "FIRE");
		  JoystickButton y = new JoystickButton(driveController, 4);
		  y.whenPressed(new Retract());
		  SmartDashboard.putString("Y", "RETRACT");
		  JoystickButton x = new JoystickButton(driveController,3);
		  x.whenPressed(new TurnWithVision());
		  SmartDashboard.putString("X", "TURN WITH VISION");
		  JoystickButton b = new JoystickButton(driveController,2);
		  b.whenPressed(new CancelVision());
		  SmartDashboard.putString("B", "CANCEL VISION");
		  
		  JoystickButton three = new JoystickButton(armController, 3);
		  three.whileHeld(new Harvest());
		  SmartDashboard.putString("3", "HARVEST");
		  JoystickButton one = new JoystickButton(armController, 1);
		  one.whileHeld(new StartRoller());
		  SmartDashboard.putString("1", "START ROLLER");		  
		  JoystickButton eleven = new JoystickButton(armController,11);
		  eleven.whileHeld(new StartShooter());
		  SmartDashboard.putString("11", "START SHOOT WHEELS");		  
		  JoystickButton seven = new JoystickButton(armController, 7);
		  seven.whenPressed(new ExtendClimbAssist());
		  SmartDashboard.putString("7", "EXTEND CLIMB ASSIST");
		  JoystickButton eight = new JoystickButton(armController, 8);
		  eight.whenPressed(new RetractClimbAssist());
		  SmartDashboard.putString("8", "RETRACT CLIMB ASSIST");
		  
		  JoystickButton nine = new JoystickButton(armController, 9);
		  nine.whileHeld(new RegularHarvest());
		  SmartDashboard.putString("9", "REGULAR HARVEST");
	}
	
	/**
	 * 
	 * @return - Driver controller's left joystick Y-axis tilt squared input -- for a speed curve
	 */
	public double getLeftYDrive(){
//		double squared = driveController.getRawAxis(1);
//		
//		if(squared < .05)
//			squared = 0;
//		else if(squared > .90)
//			squared = 1;
//		
//		return squared;
		return driveController.getRawAxis(1);
	}
	
	/**
	 * 
	 * @return - Driver controller's right joystick Y-axis tilt squared input -- for a speed curve
	 */
	public double getRightYDrive(){
//		double squared = driveController.getRawAxis(5);
//		
//		if(squared < .05)
//			squared = 0;
//		else if(squared > .90)
//			squared = 1;
//		
//		return squared;
		return driveController.getRawAxis(5);
	}
	
	/**
	 * 
	 * @return - Co-Driver controller's joystick Y-axis tilt
	 */
	public double getYArm()
	{
		return armController.getY();
	}	
    
	/**
	 * 
	 * @return - Whether or not the Co-Driver controller is pressing down button number 2
	 */
	public boolean buttonTwoPressed()
	{
		if(armController.getRawButton(2))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @return - Whether or not the Co-Driver controller is pressing down button number 1
	 */
	public boolean buttonOnePressed()
	{
		if(armController.getRawButton(1))
			return true;
		return false;
	}
	
	public boolean buttonThreePressed()
	{
		if(armController.getRawButton(3))
			return true;
		return false;
	}
	
	public boolean getButtonLB(){
		if(driveController.getRawButton(5))
			return true;
		return false;
	}
	
	public boolean getButtonRB(){
		if(driveController.getRawButton(6))
			return true;
		return false;
	}
	
}

