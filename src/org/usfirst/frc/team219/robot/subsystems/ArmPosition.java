package org.usfirst.frc.team219.robot.subsystems;


/**
 * This is an enumerated type.  In this class, it holds pre-determined robot arm positions.
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html">Enumerated Types</a>
 * 
 * 
 * @author Mark Szewczuk
 *
 */
public enum ArmPosition {
	HARVESTING(0), NEUTRAL(0), SHOOTING(0), STARTING(0), CLIMBING(0);
	
	private final double position;
	
	ArmPosition(double pos){
		this.position = pos;
	}

	public double getPosition() {
		return position;
	}
	
	
}
