package module2;

public class Complex {
	
	//store double variables for use in complex numbers
	private double Re;
	private double Im;
	
	//place variables in new type - ComplexNumber
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
	
	public Complex normalised(){
		double mod = this.modulus();
		return new Complex(Re/mod, Im/mod);
	}
	
	/*
	 * public boolean equals(Complex c){
	 * if (c == ReIm ){
			return true;
		}
		
	}
	 */
	
	public String toString() {
        if (Re!=0 && Im>0) {
            return Re+" + "+Im+"i";
        }
        if (Re!=0 && Im<0) {
            return Re+" - "+(-Im)+"i";
        }
        if (Im==0) {
            return String.valueOf(Re);
        }
        if (Re==0) {
            return Im+"i";
        }
		return Re+" + "+Im+"i";

	}
}
