package module4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WordCounter {

	public static void main(String[] args)  {
		
		// Creates another BufferReader variable using brFromURL and prints the number of words using countsWordsInResource method.
		try {
			BufferedReader data = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
			int words = countWordsInResource(data);
			System.out.println("Number of words " + words);
		}
		
		catch (IOException e){
			System.out.println("Problem: this isn't an acceptable url");
		}
		 
	}

	// Method to read URL and return buffered reader object
	public static BufferedReader brFromURL(String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);

		return b;
	}

	// Counts the number of words in URL
	private static int countWordsInResource(BufferedReader dataAsBR) throws IOException{
		Scanner s = new Scanner(dataAsBR);
		int countwords = 0;
		// While there is a line to read, create a string, and count number of words
		while (s.hasNext()){
			s.next();
			countwords ++;
		}
		s.close();
		return countwords;
	}
}