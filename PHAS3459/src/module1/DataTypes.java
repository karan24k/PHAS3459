package module1;

public class DataTypes {

	public static void main(String[] args) {
		double doubVar = 10.0; //double sets the data type to a decimal with 64 bits storage (double precision)
		System.out.println("The double value is " + doubVar);
		System.out.println("The square is " + doubVar*doubVar + "\n");
		
		float floatVar = 10f; //float is a decimal, 32 bits (single precision)
		System.out.println("The float value is " + floatVar);
		System.out.println("The square is " + floatVar*floatVar + "\n");
		
		int intVar = 10; //int gives an integer
		System.out.println("The integer value is " + intVar);
		System.out.println("The square is " + intVar*intVar + "\n");
		
		long longVar = 10; //64 bit integer
		System.out.println("The long value is " + longVar);
		System.out.println("The square is " + longVar*longVar + "\n");
		
		byte byteVar = 10; // 8 bit integer
		System.out.println("The byte value is " + byteVar);
		System.out.println("The square is " + byteVar*byteVar + "\n");
		
		char charVar = 'a' + 10; //16 bit unicode character
		System.out.println("The character output is " + charVar + "\n");
		/*The output gives 10 letters along the alphabet from a
		 *  (GENIUS)
		 */
		
		char charVar2 = 'z' - 2;
		System.out.println("The character output is " + charVar2 + "\n");
		// The same works for the opposite operation//
		 
		char charVar3 = 'z' + 1;
		System.out.println("The character output is " + charVar3 + "\n");
		/* Past letters we get non alphabetical characters
		 * Uppercase characters come before lowercase this is because it goes through unicode
		 */
		
		/* int j = 1; int i; j = i + 1;
		 * System.out.println(j);
		 * trying to say j is i + 1 when i isn't given a value (initialised) is impossible
		 */
		
		double castTest = 4.99;
		int x = (int)castTest;
		System.out.println("Casting from a double to an integer gives " + x + "\n");
		/* when casting to an integer from a double, the computer simply
		 *  disregards anything  after a decimal point
		 *  i.e. always rounds down
		 */
	}

}
