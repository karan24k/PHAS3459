package module2;

public class Complex {
	
	//store double variables for use in complex numbers
	private double Re;
	private double Im;
	
	//constructor with real and imaginary parts
	public Complex(double real, double imag){
		Re = real;
		Im = imag;
	}
	
	public double Real() {
		return Re;
	}
	
	public double Imag() {
		return Im;
	}
	
	public double modulus(){
		return Math.sqrt(Re*Re + Im*Im);		
	}
	
	public double angle(){
		return Math.atan2(Im,Re);
	}
	
	public Complex conjugate(){
		return new Complex(Re,-Im);
	}
	
	public Complex normalised() throws Exception{
		double mod = this.modulus();
		if (mod == 0)
			// Since cannot divide by zero
			throw new Exception("Cannot normalise number with modulus zero");
		return new Complex(Re/mod, Im/mod);
	}
	
	boolean equals(Complex c) {
		if (this.Re == c.Re && this.Im == c.Im) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return Re+" + "+Im+"i";
	}
	
	public Complex setFromModulusAngle(double mag, double ang) {
		return new Complex(mag * Math.cos(ang),mag * Math.sin(ang));
	}
	
	// The following static methods calculate the sum, difference, product and quotient of two complex numbers 
		static Complex add(Complex a, Complex b) {
			return new Complex(a.Re + b.Re, a.Im + b.Im);
		}
		static Complex subtract(Complex a, Complex b) {
			return new Complex(a.Re - b.Re, a.Im - b.Im);
		}
		static Complex multiply(Complex a, Complex b) {
			double re = (a.Re * b.Re) - (a.Im * b.Im);
			double i = (a.Re * b.Im) + (b.Re * a.Im);
			return new Complex(re, i);
		}
		static Complex divide(Complex a, Complex b) throws Exception {
			// Numerator
			Complex numerator = Complex.multiply(a, b.conjugate());
			// Denominator, c*c* only returns a real number
			double denominator = Complex.multiply(b, b.conjugate()).Real();
			if (denominator == 0)
				throw new Exception("Cannot divide by zero");
			// Divide numerator by denominator
			numerator.Re = numerator.Re / denominator;
			numerator.Im = numerator.Im / denominator;
			return numerator;
		}
		
		// basic complex numbers
		static Complex ZERO = new Complex(0,0);
		static Complex ONE = new Complex(1,0);
		static Complex I = new Complex(0,1);
		
	
	
}
