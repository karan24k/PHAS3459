package exam1314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class DistanceCalculator implements distanceSorter {
	private static double radius = 6371E3;

	public void distanceCalc(ArrayList<DataPoint> container) {
		LocMinMax locator = new LocMinMax();
		ArrayList<DataPoint> specimens = locator.locationSorter(container);
		ArrayList<DataPoint> withinRadius = new ArrayList<DataPoint>();
		double d = 0.0; double haversineLat = 0.0; double haversineLon = 0.0;
		double h = 0.0;
		InputStreamReader r1 = new InputStreamReader(System.in);
		BufferedReader b1 = new BufferedReader(r1);
		String latitude = null; String longitude = null; String distanceVal = null;
		try {
			//Read input
			System.out.println("Please enter the reference distance:");
			distanceVal = b1.readLine();
			System.out.println("Please enter the latitude reference:");
			latitude = b1.readLine();
			System.out.println("Please enter the longitude reference:");
			longitude = b1.readLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		double refDis = Double.parseDouble(distanceVal)*1000;
		double latitudeval = Math.toRadians(Double.parseDouble(latitude));
		double longitudeval = Math.toRadians(Double.parseDouble(longitude));
		for(DataPoint p:specimens) {
			haversineLat = 0.5*(1 - Math.cos(Math.toRadians(p.getLatitude())-latitudeval ));
			haversineLon = 0.5*(1 - Math.cos(Math.toRadians(p.getLongitude())-longitudeval));
			h = haversineLat+(Math.cos(latitudeval)*Math.cos(Math.toRadians(p.getLatitude()))*haversineLon);
			d = 2*radius*Math.asin(Math.sqrt((h)));
			if (d<refDis){
				withinRadius.add(p);
			}
		}
		double sumHeight = 0.0;
		int n = 0;
		double mean;
		for(DataPoint presorting:withinRadius) {
			sumHeight += ((PlantPoint)presorting).getHeight();
			n++;
		}
		mean = sumHeight/n;
		System.out.println("Mean height is :"+mean);
	}

	public void exclusiveDistanceCalc(ArrayList<DataPoint> container, HashMap<String,String> idmap) {
		ConcurrentHashMap<String, ArrayList<DataPoint>> data = new ConcurrentHashMap<String, ArrayList<DataPoint>>(); 
		for(String id:idmap.values()){
			ArrayList<DataPoint> forEachAn = new ArrayList<DataPoint>();
			for(DataPoint a: container){
				if(a.getName().equals(id)){
					forEachAn.add(a);
				}
			}
			data.put(id, forEachAn);
		}
		double d = 0.0; double haversineLat = 0.0; double haversineLon = 0.0;
		double h = 0.0;
		InputStreamReader r1 = new InputStreamReader(System.in);
		BufferedReader b1 = new BufferedReader(r1);
		String latitude = null; String longitude = null; String distanceVal = null;
		try {
			//Read input
			System.out.println("Please enter the reference distance:");
			distanceVal = b1.readLine();
			System.out.println("Please enter the latitude reference:");
			latitude = b1.readLine();
			System.out.println("Please enter the longitude reference:");
			longitude = b1.readLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		double refDis = Double.parseDouble(distanceVal)*1000;
		double latitudeval = Math.toRadians(Double.parseDouble(latitude));
		double longitudeval = Math.toRadians(Double.parseDouble(longitude));
		System.out.println(data.values());
		DataPoint ap = null;
		for(Iterator<ArrayList<DataPoint>> it = data.values().iterator(); it.hasNext();) {
			for(String ID: data.keySet()){
				for(Iterator<DataPoint> it2 =it.next().iterator();it2.hasNext();){
					ap = it2.next();
					haversineLat = 0.5*(1 - Math.cos(Math.toRadians(ap.getLatitude())-latitudeval ));
					haversineLon = 0.5*(1 - Math.cos(Math.toRadians(ap.getLongitude())-longitudeval));
					h = haversineLat+(Math.cos(latitudeval)*Math.cos(Math.toRadians(ap.getLatitude()))*haversineLon);
					d = 2*radius*Math.asin(Math.sqrt((h)));
					if (d>refDis){
						data.remove(ID);
					}
				}
			}
			System.out.println(data.keySet());
		}

	}
}
