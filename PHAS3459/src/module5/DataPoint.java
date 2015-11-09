package module5;

public class DataPoint {
	
	//private variables
	private double x;
	private double y;
	private double ey;
	
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
		return x + "\t" + y + "\t" + ey;
	}
}
