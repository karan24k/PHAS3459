package module6;

public class PowerLawTheory implements Theory{
	// instance variable
	protected double n;
	
	// constructor
	public PowerLawTheory(double n) {
		this.n = n;
	}
	
	// Implement methods from Theory interface
	public double y(double x) {
		return Math.pow(x,n);
	}
	
	// toString for power format
	public String toString() {
		return "x^"+n;
	}
}

