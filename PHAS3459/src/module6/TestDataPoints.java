package module6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestDataPoints {

	public static void main(String[] args) {
		try {
			// New collection holding data
			Collection<DataPoint> datapoints = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			// Using iterator to iterate through datapoints collection
			Iterator<DataPoint> dpi = datapoints.iterator();
			while (dpi.hasNext()) {
				Object dataPoint = dpi.next();
				// print datapoint
				System.out.println(dataPoint);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static Collection<DataPoint> dataFromURL(String url) throws IOException, IllegalArgumentException {
		Collection<DataPoint> dataSet = new ArrayList<DataPoint>();

		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;
		// Read each line and extract data
		while ((line = br.readLine()) != null) {

			//split string up depending on spaces between text
			String[] values = line.split("\\s+");

			if(values.length == 3){
				double [] numbers = new double [3];

				//add data to arraylist
				for (int i=0; i<values.length; i++) {
					numbers [i] = Double.parseDouble(values[i]);
				}

				dataSet.add(new DataPoint(numbers[0],numbers[1],numbers[2]));
			}

			else if(values.length == 4){
				double [] numbers = new double [3];

				//add data to arraylist
				for (int i=0; i<values.length-1; i++) {
					numbers [i] = Double.parseDouble(values[i]);
				}
				String label = values[3];
				dataSet.add(new LabelledDataPoint(numbers[0],numbers[1], numbers[2], label));
			}
			else {
				// if input is not of valid size, throw exception
				throw new IllegalArgumentException("Input contains more than 3 or 4 values per data point.");
			}
		}
		return dataSet;
	}
}