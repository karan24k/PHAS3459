package module3;

import java.util.Random;
import java.lang.Character;
import java.lang.Integer;
import java.lang.StringBuilder;

public class Alphabet {

	private static StringBuilder str = new StringBuilder(500);
	private static int sum = 0;
	private static int letters = 0;

	public static void main(String[] args) {
		// Run loop 1000 times (undetermined no. of characters)
		int i = 0;
		while (i < 500) {

			// Generate random char
			char ranChar = randomCharacter();

			// If char is letter or digit
			if (Character.isLetterOrDigit(ranChar)) {

				// Add to StringBuilder
				str.append(ranChar);
				try {
					// Sum ranChar's
					sum = sum + Integer.parseInt(Character.toString(ranChar));
				} catch (Exception e) {
					// Log number of exceptions (letters)
					letters++;
				}
			}
			i++;
		}
		System.out.println("StringBuilder: " + str.toString());
		System.out.println("Sum of all digits: " + sum);
		System.out.println("Number of letters: " + letters);

	}	


	public static char randomCharacter() {

		// Get random number between 0-127
		int ran = new Random().nextInt(128);

		// Cast to char and return
		return (char) ran;

	}
}