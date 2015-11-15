package module5;
import java.net.*;
import java.util.*;
import java.io.*;

public class Minerals {

	public static void main(String[] args) {
		try {
			// Define urls
			String samples = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt";
			String locations = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt";

			//initialise hashmaps to read from urls
			HashMap<Integer, Double> massMap =  massMap(samples);
			HashMap<Integer, String> locationMap =  locationMap(locations);

			// Initialise variables for comparison and storing information
			double min = Double.MAX_VALUE;
			double max = Double.MIN_VALUE;
			int minKey = 0;
			int maxKey = 0;

			// for each entry in one map find the lowest and highest mass
			for (Map.Entry<Integer, Double> entry : massMap.entrySet()) {
				double mass = entry.getValue();

				// If value lower than current min, replace min
				if (mass < min) {
					min = mass;
					minKey = entry.getKey();
				}
				
				// If value higher than current max, replace min
				if (mass > max) {
					max = mass;
					maxKey = entry.getKey();
				}
			}

			// Check if Map contains key
			if (locationMap.containsKey(minKey) & locationMap.containsKey(maxKey)) {
				// get location from the other map if it contains the minkey
				String location = locationMap.get(minKey);
				Double mass = massMap.get(minKey);
				String location1 = locationMap.get(maxKey);
				Double mass1 = massMap.get(maxKey);
				
				// Print to screen
				System.out.println("Smallest mass: \nKey: "+minKey+", Mass: "+mass+" g, Location: "+location);
				System.out.println("\nLargest mass: \nKey: "+maxKey+", Mass: "+mass1+" g, Location: "+location1);
			}

		}

		catch (IOException ioe) {
			System.out.println(ioe);
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

	// HashMap of samples data set 
	public static HashMap<Integer, Double> massMap(String samples) throws IOException{
		HashMap<Integer, Double> massMap = new HashMap<Integer, Double>();
		BufferedReader br = brFromURL(samples);
		String line;
		// Read each line and extract data
		while ((line = br.readLine()) != null) {
			//split string up depending on spaces between text
			String[] values = line.split("\\s+");

			//parse vaules
			int id = Integer.parseInt(values[0]);
			double mass = Double.parseDouble(values[1]);

			// Add each line of input to map
			massMap.put(id, mass);
		}

		return massMap;
	}

	// Same concept as massMap
	public static HashMap<Integer, String> locationMap(String locations) throws IOException{
		HashMap<Integer, String> locationMap = new HashMap<Integer, String>();

		BufferedReader br = brFromURL(locations);
		String line;

		while ((line = br.readLine()) != null) {
			String[] values = line.split("\\s+");

			// swap order of key-value from input since the key is in the wrong position
			String location = values[0];
			int id = Integer.parseInt(values[1]);

			locationMap.put(id, location);
		}
		return locationMap;
	}
}