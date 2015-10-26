package module4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WordCounter {

	public static void main(String[] args)  {
		
		try {
			BufferedReader data = brFromURL("xjnxbjkasb");
			int words = countWordsInResource(data);
			System.out.println("Number of words " + words);
		}
		
		catch (IOException e){
			System.out.println("Problem: this isn't an acceptable url");
		}
		 
	}

	public static BufferedReader brFromURL(String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);

		return b;
	}

	private static int countWordsInResource(BufferedReader dataAsBR) throws IOException{
		Scanner s = new Scanner(dataAsBR);
		int countwords = 0;
		while (s.hasNext()){
			s.next();
			countwords ++;
		}
		s.close();
		return countwords;
	}
}