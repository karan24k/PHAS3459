package module3;

public class FallingParticle {
	
	private double m; // Mass of Particle kg
	private double d; // Drag Coefficient kg/m
	private double t = 0; // Time Elapsed s
	private double z; // Height of Particle
	private double v; // Velocity of Particle
	public static final double g = 9.81; // acceleration due to gravity m/s^2

	// Constructor
	public FallingParticle(double mass, double drag) throws Exception {
		m = mass; d = drag;
		if (m<0 | d<0 ){
			throw new Exception ("Physically impossible to have a negative mass or drag");
		}
	}
	
	// retrieve and manipulate private variables in the class
	public void setZ(double Height) throws Exception{
		if (Height < 0){
			throw new Exception("Impossible to have a negative height.");
		}
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
