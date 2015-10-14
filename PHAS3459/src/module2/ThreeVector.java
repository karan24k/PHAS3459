package module2;
public class ThreeVector {
private double x;
private double y;
private double z;
		
	public ThreeVector(double xx, double yy, double zz){
		x = xx;
		y = yy;
		z = zz;
	}
	
	public double magnitude() {
		return Math.sqrt(x*x + y*y + z*z); // returns magnitude of three vector 
	}
	
	public ThreeVector unitVector (){
		double mag = this.magnitude();
		return new ThreeVector(x/mag, y/mag, z/mag);
	}
	public String toString(){
		return "The normalised vector is ("+x+","+y+","+z+")";
	}
	
	public static double scalarProduct(ThreeVector a, ThreeVector b){
		return (a.x*b.x) + (a.y*b.y) + (a.z*b.z);
	}
	
	public static ThreeVector vectorProduct (ThreeVector a, ThreeVector b){
		return new ThreeVector (a.y*b.z - a.z*b.y, a.z*b.x - a.x*b.z, a.x*b.y - a.y*b.x);
	}
	
	public static ThreeVector add(ThreeVector a, ThreeVector b){
		return new ThreeVector (a.x+b.x, a.y+b.y, a.z +b.z);
	}
	
	public static double angle(ThreeVector a, ThreeVector b){
		return Math.acos(scalarProduct(a,b)/(a.magnitude()*b.magnitude()));
	}
	
	public double scalarProduct(ThreeVector vector){
		return ThreeVector.scalarProduct(this,vector);
	}
	
	public ThreeVector vectorProduct(ThreeVector vector){
		return ThreeVector.vectorProduct(this, vector);
	}
	
	public ThreeVector add(ThreeVector vector){
		return ThreeVector.add(this, vector);
	}
	
	public double angle(ThreeVector vector){
		return ThreeVector.angle(this,vector);
	}
}
