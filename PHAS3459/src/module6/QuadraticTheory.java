package module6;

public class QuadraticTheory implements Theory {
	//instance variables
	protected double a;
	protected double b;
	protected double c;
	
	//constructor for coefficients
	public QuadraticTheory(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	// Implement methods from Theory interface
	public double y(double x) {
		return a*Math.pow(x,2) + b*x + c;
	}
	
	// toString for quadratic format
	public String toString() {
		return a+"x^2 "+b+"x "+c;
	}
}

