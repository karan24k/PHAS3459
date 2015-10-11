package module1;
import java.lang.Math.*; //imports the math library

public class VectorMethods {
	public static void main(String[] args) {
		VectorMethods vm = new VectorMethods(); //creates an object for calling functions from the main method
		double prod = vm.dotprod(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
		double mag = vm.magnitude(1.0, 2.0, 3.0);
		double ang = vm.angle(2.0, 4.0, 1.0, 5.0, 3.0, 1.0);
		// the data uses in the methods below
		/*double ang = vm.angle(2.0, 4.0, 1.0, 0.0, 0.0, 0.0);
		 * when using the vector (0,0,0) the output is NaN, this is because we are dividing by zero in
		 * the angle method
		 */
	}
	
	public double dotprod(double ax, double ay, double az, double bx, double by, double bz) {
		// method to calculate the dotproduct between two vectors (ax,ay,az) and (bx,by,bz) which are taken from the main method
		double x;
		x = ax*bx + ay*by + az*bz; //dotproduct
		System.out.println("Vector A is " + "(" + ax +","+ ay +"," + az +") " + "and Vector B is "+ "(" + bx +","+ by +"," + bz +")");
		System.out.println("The dot product between the two vectors is " + x);
		return x; // returns the result of the method
			
	}
	
	public double magnitude(double ax, double ay, double az) {
		// method to calculate the magnitude of a vector (ax,ay,az) which are taken from the main method
		double y;
		y = Math.sqrt(ax*ax + ay*ay + az*az); //magnitude
		System.out.println("The magnitude of the vector " + "(" + ax +", "+ ay +", " + az +") is " +y);
		return y; // returns the result of the method
	}
	
	public double angle(double ax, double ay, double az, double bx, double by, double bz) {
		// method to calculate the angle between vectors (ax,ay,az) and (bx,by,bz) which are taken from the main method
		double z;
		z = (Math.acos(dotprod(ax, ay, az, bx, by, bz)/(magnitude(ax, ay, az)*magnitude(bx, by, bz)))) * 180/Math.PI; 
		/* using the two methods above, the angle can be calculted using the mathematical definition of the dot product
		 * given in radians, so using the Math library converts to degrees by x 180/pi
		 */
		final String DEGREE  = "\u00b0"; //gives the degree symbol
		System.out.println("The angle between the two vectors is " + z + DEGREE );
		return z; // returns the result of the method

	}
}
