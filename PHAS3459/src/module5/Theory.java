package module5;

public class Theory {
	
	//private variables
	private double n;
	
	//constructor
	public Theory(double n){
		this.n = n;
	}
	
	// method to calculate y = x^n 
	public double y(double x){
		return Math.pow(x, n);
	}

}
