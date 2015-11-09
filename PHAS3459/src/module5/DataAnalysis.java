package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class DataAnalysis {

	public static void main(String[] args) {
		ArrayList<DataPoint> data = new ArrayList<DataPoint> ();
		
		try{
			data = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
			double f2 = goodnessOfFit(new Theory(2),data);
			double f4 = goodnessOfFit(new Theory(4),data);
			
			System.out.printf("Chi-squared value for y=x^2: "+"%f\n",f2);
			System.out.printf("Chi-squared value for y=x^4: "+"%f\n",f4);
			// Inline if statement to check which chi-squared value is bigger
			System.out.println((f2>f4 ? "y=x^2" : "y=x^4")+" is a better fit for the measured data.");
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public static ArrayList<DataPoint> dataFromURL(String url) throws IOException {
		ArrayList<DataPoint> dataSet = new ArrayList<DataPoint> ();

		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		
		String line;
		line = b.readLine();
		
		while(line != null){
			String[] values = line.split("\\s+");
			double [] numbers = new double [3];
			
			for (int i=0; i<values.length; i++) {
				numbers [i] = Double.parseDouble(values[i]);
			}
			
			dataSet.add(new DataPoint(numbers[0],numbers[1],numbers[2]));
		}
		
		return dataSet;
	}
	
	public static double goodnessOfFit(Theory t, ArrayList<DataPoint> data){
		//initialise
		double CHISQUARE = 0;
		// for each datapoint in data from url
		for (DataPoint p : data){
			
			// calculate theoretical y
			double tY = t.y(p.getX());
			// get measured y
			double mY = p.getY();
			// calculate chi squared numerator and denominator
			double dY = Math.pow((mY-tY), 2);
			double eYsquare = Math.pow(p.getEY(), 2);
			CHISQUARE += dY/eYsquare;
		}
		return CHISQUARE;
	}

}
