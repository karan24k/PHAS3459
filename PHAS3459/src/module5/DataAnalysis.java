package module5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class DataAnalysis {

	public static void main(String[] args) {


	}

	public static ArrayList<DataPoint> dataFromURL(String url) {
		ArrayList<DataPoint> dataSet = new ArrayList<DataPoint> ();
		
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		String line;
		
		while((line = b.readLine()) != null){
			String[] values = line.split("\\s+");
		}
		
		double [] numbers = new double [3];
		for (int i=0; i<values.length; i++) {
			numbers [i] = Double.parseDouble(values[i]);
		}
		
		dataSet.add(new DataPoint(numbers[0],numbers[1],numbers[2]));
	}
	
	return dataSet;
}
