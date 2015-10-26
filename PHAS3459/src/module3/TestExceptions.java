package module3;

public class TestExceptions {

	public static void main(String[] args) {
		
		//create complex and threevector instances
		Complex c1 = new Complex(1,-2);
		ThreeVector v1 = new ThreeVector(0,0,0);
		ThreeVector v2 = new ThreeVector(2,2,2);

		//try to normalise a complex number with modulus zero
		try {
			Complex a = Complex.ZERO.normalised();
			System.out.println(a);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		//try to divide a complex number by zero
		try {
			Complex b = Complex.divide(c1, Complex.ZERO);
			System.out.println(b);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		//try to find the unit vector of the origin
		try {
			ThreeVector a = v1.unitVector();
			System.out.println(a);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		//try to find the angle between a vector and the origin
		try {
			double b = ThreeVector.angle(v1,v2);
			System.out.println(b);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		// try to create a particle instance with a negative mass
		try {
			FallingParticle particle = new FallingParticle(-1, 2);
			System.out.println(particle);
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		// try to create a particle instance with a negative drag
		try {
			FallingParticle particle = new FallingParticle(1, -2);
			System.out.println(particle);
		}
		catch (Exception e){
			System.out.println(e);
		}

		// try to set the height of a particle to a negative number
		try{
			FallingParticle particle = new FallingParticle(1, 2); //particle instance
			particle.setZ(-2);
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

}
