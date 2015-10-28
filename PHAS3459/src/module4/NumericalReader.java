package module4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class NumericalReader {

	private static final String OPD = null;
	private double minValue;
	private double maxValue;
	private double nValues;
	private double sumOfValues; 
	private PrintWriter pw;

	public static void main(String[] args) {
		saveDir = NumericalReader.getOutputDirectory();

		saveFile = (saveDir + File.separator + dataFile);
		NumericalReader nr = new NumericalReader();

	}
	public static String getOutputDirectory() throws IOException{
		System.out.println("Please specify output directory");
		InputStreamReader a = new InputStreamReader(System.in);
		BufferedReader o = new BufferedReader(a);
		return o;

	}

	public static BufferedReader brFromURL(String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);

		return b;
	}

	public void analysisStart(String dataFile) throws IOException{

		minValue = Double.MAX_VALUE;
		maxValue = Double.MIN_VALUE;
		nValues = 0;
		sumOfValues = 0;
	}

	public void analyseData(String line){
		line = line.trim();
		if (!line.isEmpty() && Character.isDigit(line.charAt(0))) {
			// Split string
			String[] splits = line.split("\\s+");
			// Loop over parts
			for (String num : splits) {

				// Print and write to file
				System.out.println(num);
				pw.println(num);

				// Parse string
				double x = Double.parseDouble(num);
				// Increment and add to running total
				nValues++;
				sumOfValues += x;

				// Compare to current value
				if (x < minValue)
					minValue = x;
				if (x > maxValue)
					maxValue = x;
			}
		}
	}

	void analysisEnd() {

		// Print values
		System.out.println("Min Value: " + minValue);
		System.out.println("Max Value: " + maxValue);
		System.out.println("Average Value: " + sumOfValues/nValues);
		System.out.println("Total Number of Values: " + nValues);

		// Close PrintWriter
		pw.close();
	}
}