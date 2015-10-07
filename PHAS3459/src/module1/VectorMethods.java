package module1;
import java.lang.Math.*;

public class VectorMethods {
	public static void main(String[] args) {
		VectorMethods vm = new VectorMethods();
		double prod = vm.dotprod(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
		double mag = vm.magnitude(1.0, 2.0, 3.0);
		double ang = vm.angle(2.0, 4.0, 1.0, 5.0, 3.0, 1.0);

	}
	
	public double dotprod(double ax, double ay, double az, double bx, double by, double bz) {
		double x;
		x = ax*bx + ay*by + az*bz;
		System.out.println("Vector A is " + "(" + ax +","+ ay +"," + az +") " + "and Vector B is "+ "(" + bx +","+ by +"," + bz +")");
		System.out.println("The dot product between the two vectors is " + x);
		return x;
			
	}
	
	public double magnitude(double ax, double ay, double az) {
		double y;
		y = Math.sqrt(ax*ax + ay*ay + az*az);
		System.out.println("The magnitude of the vector (1.0,2.0,3.0) is " + y);
		return y;
	}
	
	public double angle(double ax, double ay, double az, double bx, double by, double bz) {
		double z;
		z = (Math.acos(dotprod(ax, ay, az, bx, by, bz)/(magnitude(ax, ay, az)*magnitude(bx, by, bz)))) * 180/Math.PI;
		System.out.println(z);
		return z;

	}
}
