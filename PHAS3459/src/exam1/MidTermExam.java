package exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class MidTermExam {

	

	// Method to read URL and return buffered reader object
	public static BufferedReader brFromURL(String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		return b;
	}

	//  HashMap of earthquake dataset
	public static HashMap<Integer, List<Double>> earthquakeMap(String earthquakes) throws IOException{
		HashMap<Integer, List<Double>> earthquakeMap = new HashMap<Integer, List<Double>>();
		
		BufferedReader br = brFromURL(earthquakes); // read from url
		Scanner s = new Scanner(br);
		br.readLine();
		br.readLine();
		double maxmagnitude = 0.0;
	
		// while the next value is a double, split the string in to parts, separated by whitespace
		while (s.hasNextDouble()) {

			String[] parts = s.nextLine().split("\\s+");
			//parse each part of the string array as a double 
			double year = Double.parseDouble(parts[0]);
			double month = Double.parseDouble(parts[1]);
			double day = Double.parseDouble(parts[2]);
			double hour = Double.parseDouble(parts[3]);
			double minute = Double.parseDouble(parts[4]);
			double second = Double.parseDouble(parts[5]);
			double lat = Double.parseDouble(parts[6]);
			double lon = Double.parseDouble(parts[7]);
			double dep = Double.parseDouble(parts[8]);
			double eh1 = Double.parseDouble(parts[9]);
			double eh2 = Double.parseDouble(parts[10]);
			double az = Double.parseDouble(parts[11]);
			double ez = Double.parseDouble(parts[12]);
			double mag = Double.parseDouble(parts[13]);
			int id = Integer.parseInt(parts[14]);

			//add each double to an arraylist for the hashmap
			ArrayList<Double> data = new ArrayList<Double>();
			data.add(year);
			data.add(month);
			data.add(day);
			data.add(hour);
			data.add(minute);
			data.add(second);
			data.add(lat);
			data.add(lon);
			data.add(dep);
			data.add(eh1);
			data.add(eh2);
			data.add(az);
			data.add(ez);
			data.add(mag);

			//add the ids and arraylists to the hashmap
			earthquakeMap.put(id, data);
			
			//find details of largest magnitude
			if(mag>maxmagnitude){
				maxmagnitude = mag;
				
			}
			
		}
		System.out.println(maxmagnitude);
		s.close();

		return earthquakeMap;
	}
	
	public static void main(String[] args) {
		try {
			String earthquakes = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/earthquakesCA1989.txt";

			HashMap<Integer, List<Double>> earthquakeMap =  earthquakeMap(earthquakes);

			System.out.println("Number of Earthquakes: " + earthquakeMap.size());

		}
		catch (IOException ioe) {
			System.out.println(ioe);
		}


	}

}

