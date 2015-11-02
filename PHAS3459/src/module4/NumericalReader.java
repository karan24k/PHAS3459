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
					nr1.analyseData(line, saveFile1);
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
					nr2.analyseData(line, saveFile2);
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
		System.out.println("Enter the location of a directory for writing output files:");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String output = br.readLine();
		return output;
	}

	public BufferedReader brFromURL(String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		return b;
	}

	private void analysisStart(String dFile) throws IOException{

		minValue = Double.MAX_VALUE;
		maxValue = Double.MIN_VALUE;
		nValues = 0;
		sumOfValues = 0;

		String dataFile = "Macintosh HD" + File.separator + "Users" + File.separator + "karankullar" + File.separator + "Documents" + File.separator + "numbers.txt";
		File outputFile = new File(dataFile);
		outputFile.createNewFile();
		FileWriter fw = new FileWriter(outputFile);
		this.pw = new PrintWriter(fw);
	}


	public void analyseData(String line, String saveFile) throws IOException{
		line = line.trim();
		if (!line.isEmpty() && Character.isDigit(line.charAt(0))) {
			// Split string
			String[] splits = line.split("\\s+");
			// Loop over parts
			for (String num : splits) {

				// Print and write to file
				System.out.println(num);
				this.pw.println(num);

				// Parse string
				double x = Double.parseDouble(num);
				// Increment and add to running total
				this.nValues++;
				this.sumOfValues += x;

				// Compare to current value
				if (x < this.minValue)
					this.minValue = x;
				if (x > this.maxValue)
					this.maxValue = x;
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
		this.pw.close();
	}
}