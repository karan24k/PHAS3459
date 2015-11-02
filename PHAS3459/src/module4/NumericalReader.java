package module4;

import java.io.*;
import java.net.*;
import java.util.*;

public class NumericalReader {

	private double minValue;
	private double maxValue;
	private double nValues;
	private double sumOfValues; 
	private double average;
	private PrintWriter pw;

	public static void main(String[] args) throws IOException {

		String input1 = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt";
		String input2 = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt";
		String line;
		String saveDir = NumericalReader.getOutputDirectory();
		String saveFile1 = (saveDir + File.separator + "numbers1.txt");
		String saveFile2 = (saveDir + File.separator + "numbers2.txt");
		
		

		NumericalReader nr1 = new NumericalReader();
		NumericalReader nr2 = new NumericalReader();

		// Analyse numbers from both files
		try (BufferedReader br1 = nr1.brFromURL(input1);)
		{
			nr1.analysisStart(saveFile1);
			while ((line = br1.readLine()) != null){
				try {
					nr1.analyseData(line);
				}

				catch (Exception e) { 
				}; // If exception, ignore and move to next line
			}

			nr1.analysisEnd();
		}

		catch (Exception e) {
			System.out.println(e);
		}

		try (BufferedReader br2 = nr2.brFromURL(input2);)
		{
			nr2.analysisStart(saveFile2);
			while ((line = br2.readLine()) != null)
			{
				try {
					nr2.analyseData(line);
				}
				catch (Exception e) { 
				} // If exception, ignore and move to next line
			}

			nr2.analysisEnd();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	private static String getOutputDirectory() throws IOException{
		String str = "";
		System.out.println("Please specify output directory");
		try{
			Scanner input = new Scanner(System.in);
			str = input.nextLine();
			input.close();
			if (str.isEmpty())
				throw new Exception();
		}
		catch (Exception e){
			System.out.println("No input detected");
		}

		return str;

	}

	public BufferedReader brFromURL(String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		return b;
	}

	private void analysisStart(String dataFile) throws IOException{

		minValue = Double.MAX_VALUE;
		maxValue = Double.MIN_VALUE;
		nValues = 0;
		sumOfValues = 0;
		
		String dataFile1 = "Macintosh HD" + File.separator + "Users" + File.separator + "karankullar" + File.separator + "Documents" + File.separator + "numbers1.txt";
		File outputfile = new File(dataFile1);
		FileWriter fw = new FileWriter(outputfile);
		this.pw = new PrintWriter(fw);
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

	public void analysisEnd() {

		average = sumOfValues/ nValues;
		// Print values
		System.out.println("Min Value: " + minValue);
		System.out.println("Max Value: " + maxValue);
		System.out.println("Average Value: " + average);
		System.out.println("Total Number of Values: " + nValues);

		// Close PrintWriter
		pw.close();
	}
}