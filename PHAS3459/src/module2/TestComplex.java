package module2;

public class TestComplex {

	public static void main(String[] args) {
			
		// Create and show new Complex's
		Complex c1 = new Complex(1,-2);
		Complex c2 = new Complex(-2,1);
		System.out.println("Complex number 1 is " + c1);
		System.out.println("Complex number 2 is " + c2);
		
		// Show calculations
		System.out.println("\nProduct of c1 andc2: " + Complex.multiply(c1, c2));
		System.out.println("\nRatio c1/2: " + Complex.divide(c1, c2));
		
		System.out.println("\nProduct of c1 and I: " + Complex.multiply(c1, Complex.I));	
		
		// Cannot divide by Zero
		System.out.println("\nRatio c1/ZERO: " + Complex.divide(c1, Complex.ZERO)); 
		
		System.out.println("\nProduct of c1 with it's conjugate: " + Complex.multiply(c1, c1.conjugate()));
		System.out.println("Product of c2 with it's conjugate: " + Complex.multiply(c2, c2.conjugate()));

	}

}
