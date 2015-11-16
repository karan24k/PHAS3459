package module6;

public class DataPoint {
	
	//protected variables
	protected double x;
	protected double y;
	protected double ey;
	
	//constructor
	public DataPoint(double x, double y, double ey){
		this.x = x;
		this.y = y;
		this.ey = ey;
	}
	
	//getter methods
	
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	public double getEY(){
		return this.ey;
	}
	
	// toString for printing each value with a tab in-between
	public String toString(){
		return "x = "+x+", y = "+y+" +- "+ey;
	}
}
