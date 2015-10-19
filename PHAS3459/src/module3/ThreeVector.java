package module3;

public class ThreeVector {
	
	//store double variables for use in three vectors
	private double x;
	private double y;
	private double z;
	
	//constructor with threevector variables 
	public ThreeVector(double xx, double yy, double zz){
		x = xx;
		y = yy;
		z = zz;
	}
	
	// method to calculate magnitude of a vector
	public double magnitude() {
		return Math.sqrt(x*x + y*y + z*z); // returns magnitude of three vector 
	}
	
	//method to calculate the normalised vector utilising the magnitude method
	public ThreeVector unitVector () throws Exception{
		double mag = this.magnitude();
		if (mag == 0) {
			throw new Exception ("Unit Vector can't be calculated, as the magnitude is zero");
		}
		return new ThreeVector(x/mag, y/mag, z/mag);
	}
	
	// method to print anything of type ThreeVector in a specific string
	public String toString(){
		return "The vector is ("+x+","+y+","+z+")";
	}
	
	/*the methods below calculate the scalar product, vector product, sum and angle between two given vectors
	 * they are written in both a static and non static form, the non-static methods are written such that they call the
	 * static function
	 */
	
	//static methods which take two ThreeVector objects as arguments
	
	public static double scalarProduct(ThreeVector a, ThreeVector b){
		return (a.x*b.x) + (a.y*b.y) + (a.z*b.z);
	}
	
	public static ThreeVector vectorProduct (ThreeVector a, ThreeVector b){
		return new ThreeVector (a.y*b.z - a.z*b.y, a.z*b.x - a.x*b.z, a.x*b.y - a.y*b.x);
	}
	
	public static ThreeVector add(ThreeVector a, ThreeVector b){
		return new ThreeVector (a.x+b.x, a.y+b.y, a.z +b.z);
	}

	public static double angle(ThreeVector a, ThreeVector b) throws Exception{
		if (a.magnitude() == 0 | b.magnitude() == 0) {
			throw new Exception ("Angle can't be calculated as the magnitude of one of the vectors is zero, therefore unable"
					+ "to divide by zero");
		}
		return Math.acos(scalarProduct(a,b)/(a.magnitude()*b.magnitude()));
	}
	
	
	//non-static methods which call the static methods, performs a function on an object (this) with another object as an argument (vector)
	
	public double scalarProduct(ThreeVector vector){
		return ThreeVector.scalarProduct(this,vector);
	}
	
	public ThreeVector vectorProduct(ThreeVector vector){
		return ThreeVector.vectorProduct(this, vector);
	}
	
	public ThreeVector add(ThreeVector vector){
		return ThreeVector.add(this, vector);
	}
	
	public double angle(ThreeVector vector) throws Exception{
		double vv = 0;
		try {
			vv = ThreeVector.angle(this, vector);
		}
		catch (Exception e){
			throw e;
		}
		return vv;
	}
}
