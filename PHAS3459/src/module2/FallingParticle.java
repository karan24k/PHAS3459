package module2;

public class FallingParticle {
	// Mass of Particle kg
	private double m;
	
	// Drag Coefficient kg/m
	private double d;
	
	// Time Elapsed s
	private double t = 0;
	
	// Height of Particle
	private double z;
	
	// Velocity of Particle
	private double v;
	
	// acceleration due to gravity m/s^2
	public static final double g = 9.81;

	// Constructor
	public FallingParticle(double mass, double drag) {
		m = mass; d = drag;
	}
	
	// retrieve and manipulate private variables in the class
	public void setZ(double Height) {
		z = Height;
	}
	public void setV(double Velocity) {
		v = Velocity;
	}
	public void setT(double Time){
		t = Time;
	}
	public double getZ() {
		return z;
	}
	public double getV() {
		return v;
	}
	public double getT() {
		return t;
	}
	
	//calculate the variables at each time
	public void doTimeStep(double deltaT) {
		// Calculate acceleration in m/s^2
		double a = ((d*v*v)/m) - g; 
		z = z - v*deltaT; //new position in m;
		v = v - a*deltaT; //new velocity in m/s
		t = t + deltaT; //new time in s
	}	
	public void drop(double deltaT){
		//stops particle once it hits ground
		while(z>0){
			doTimeStep(deltaT);
		}
		
	}
}