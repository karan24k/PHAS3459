package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class DataAnalysis {

	public static void main(String[] args) {
		//constructor
		ArrayList<DataPoint> data = new ArrayList<DataPoint>();

		try{
			//take data from url
			data = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");

			//analyse the data for x^2 and x^4 fits
			double f2 = goodnessOfFit(new Theory(2),data);
			double f4 = goodnessOfFit(new Theory(4),data);

			//print chi squared values to screen
			System.out.printf("Chi-squared value for y=x^2: "+"%f\n",f2);
			System.out.printf("Chi-squared value for y=x^4: "+"%f\n",f4);

			//the better fit is the one with the lower chisquared value
			if (f2>f4){
				System.out.println("y=x^4 is a better fit for the data");
			}
			else{
				System.out.println("y=x^2 is a better fit for the data");
			}
		}
		catch(IOException ioe){
			System.out.println(ioe);
		}

	}

	public static ArrayList<DataPoint> dataFromURL(String url) throws IOException {
		ArrayList<DataPoint> dataSet = new ArrayList<DataPoint> ();

		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;
		
		// Read each line and extract data
		while ((line = br.readLine()) != null) {
			
			//split string up depending on spaces between text
			String[] values = line.split("\\s+");
			//create array with 3 spaces
			double [] numbers = new double [3];

			//add data to arraylist
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
