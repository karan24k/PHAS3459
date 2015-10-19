package module3;

public class TestExceptions {

	public static void main(String[] args) {
		Complex c1 = new Complex(1,-2);
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
	}

}
