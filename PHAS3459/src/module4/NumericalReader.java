package module4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class NumericalReader {
	
	private double minValue;
    private double maxValue;
    private double nValues;
    private double sumOfValues;
    private PrintWriter pw;

	public static void main(String[] args) {
		NumericalReader nr = new NumericalReader();
		
	}
	public static String getOutputDirectory(){
		
	}
	
	public static BufferedReader brFromURL(String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);

		return b;
	}
}
