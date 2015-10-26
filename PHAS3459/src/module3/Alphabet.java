package module3;
// import necessary classes
import java.util.Random;
import java.lang.Character;
import java.lang.Integer;
import java.lang.StringBuilder;

public class Alphabet {

	private static StringBuilder str = new StringBuilder(500); // create an empty array with 500 spaces for a string
	//initialise variables for use later
	private static int sum = 0; 
	private static int letters = 0;

	public static void main(String[] args) {
		// Run loop 500 times
		int i = 0;
		while (i < 500) {

			char ranChar = randomCharacter(); // Generate random characater - char

			// If char is letter or digit
			if (Character.isLetterOrDigit(ranChar)) {
				str.append(ranChar); // Add to StringBuilder

				// Sum ranChar's
				try {
					sum = sum + Integer.parseInt(Character.toString(ranChar)); 
				} 

				// if the ranChar is a letter ie log number of exceptions (letters)
				catch (Exception e) {
					letters++; 
				}
			}
			i++; //next loop
		}

		//print statements
		System.out.println("StringBuilder: " + str.toString());
		System.out.println("Number of characters: " + str.length());
		System.out.println("Sum of all digits: " + sum);
		System.out.println("Number of letters: " + letters);

	}	


	public static char randomCharacter() {
		int ran = new Random().nextInt(128); // Get random number between 0-127
		return (char) ran; // Cast to char and return

	}
}