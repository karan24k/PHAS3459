package module3;

public class TestExceptions {

	public static void main(String[] args) {
		Complex c1 = new Complex(1,-2);
		ThreeVector v1 = new ThreeVector(0,0,0);
		ThreeVector v2 = new ThreeVector(2,2,2);

		try {
			Complex a = Complex.ZERO.normalised();
			System.out.println(a);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			Complex b = Complex.divide(c1, Complex.ZERO);
			System.out.println(b);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			ThreeVector a = v1.unitVector();
			System.out.println(a);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			double b = ThreeVector.angle(v1,v2);
			System.out.println(b);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			FallingParticle particle = new FallingParticle(-1, -2);
			System.out.println(particle);
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		try{
			FallingParticle particle = new FallingParticle(1, 2);
			particle.setZ(-2);
			particle.getZ();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

}
