package exam1314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LocMinMax implements Sorter {

	public ArrayList<DataPoint> locationSorter(ArrayList<DataPoint> plantlist) {
		ArrayList<DataPoint> sorted = new ArrayList<DataPoint>();
		//Create reader objects
		InputStreamReader r1 = new InputStreamReader(System.in);
		BufferedReader b1 = new BufferedReader(r1);
		//Dummy variable
		String name = null; 
		try {
			//Read input
			System.out.println("Please enter the species name:");
			name = b1.readLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		for(DataPoint presorting:plantlist){
			if(presorting.getName().equals(name)){
				sorted.add(presorting);
			}
		}
		return sorted;
	}
	
	public void meanCalculator(ArrayList<DataPoint> arrayList) {
		InputStreamReader r2 = new InputStreamReader(System.in);
		BufferedReader b2 = new BufferedReader(r2);
		String latitude = null;
		try {
			//Read input
			System.out.println("Please enter the latitude:");
			latitude = b2.readLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		double latVal = Double.parseDouble(latitude);
		double sumHeight = 0.0;
		int n = 0;
		double mean;
		for(DataPoint presorting:arrayList) {
			if(presorting.getLatitude()>latVal){
				sumHeight += ((PlantPoint)presorting).getHeight();
				n++;
			}
		}
		mean = (sumHeight/n);
		System.out.println("Mean height for species north of "+latVal+" = "+mean);
		sumHeight = 0.0;
		n = 0;
		for(DataPoint presorting:arrayList) {
			if(presorting.getLatitude()<latVal){
				sumHeight += ((PlantPoint)presorting).getHeight();
				n++;
			}
		}
		mean = (sumHeight/n);
		System.out.println("Mean height for species south of "+latVal+" = "+mean);
	}
}
