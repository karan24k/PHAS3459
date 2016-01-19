package exam1314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class DataAnalysis {
	private static BufferedReader br;

	public static HashMap<String,String> dataID(String SpeciesURL) throws IOException{
	HashMap<String,String> idmap = new HashMap<String,String>();
	URL uID = new URL(SpeciesURL);
	InputStream is = uID.openStream();
	InputStreamReader isr = new InputStreamReader(is);
	br = new BufferedReader(isr);
	String line = "";
	Scanner s = new Scanner(line);
	Scanner s2 = null;
	while ((line= br.readLine()) != null) {
		s2 = new Scanner(line);
		String id = s2.next();
		String name = s2.next()+" "+s2.next();
		idmap.put(id, name);
		s2.close();
	}
	s.close();
	return idmap;
	}
	
	public static ArrayList<DataPoint> AnimalMap(String SpecimenURL, HashMap<String, String> idmap) throws IOException {
		ArrayList<DataPoint> animalMap = new ArrayList<DataPoint>();
		URL uSpecimen = new URL(SpecimenURL);
		InputStream is = uSpecimen.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		String line = "";
		Scanner s = new Scanner(br.readLine());
		Scanner s2 = null;
		while ((line= br.readLine()) != null) {
			s2 = new Scanner(line);
			double latitude = Double.parseDouble(s2.next());
			double longitude = Double.parseDouble(s2.next());
			String id = s2.next();
			String name = idmap.get(id);
			DataPoint point = new DataPoint(name,longitude,latitude);
			animalMap.add(point);
			s2.close();
		}
		s.close();
		return animalMap;
	}
	public static ArrayList<DataPoint> PlantMap(String SpecimenURL, HashMap<String, String> idmap) throws IOException {
		ArrayList<DataPoint> plantMap = new ArrayList<DataPoint>();
		URL uSpecimen = new URL(SpecimenURL);
		InputStream is = uSpecimen.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		String line = "";
		Scanner s = new Scanner(br.readLine());
		Scanner s2 = null;
		while ((line= br.readLine()) != null) {
			s2 = new Scanner(line);
			double latitude = Double.parseDouble(s2.next());
			double longitude = Double.parseDouble(s2.next());
			String id = s2.next();
			String name = idmap.get(id);
			int height = Integer.parseInt(s2.next());
			PlantPoint point = new PlantPoint(name,longitude,latitude,height);
			plantMap.add(point);
			s2.close();
		}
		s.close();
		return plantMap;
	}
	
	public static void meanHeight(ArrayList<DataPoint> points, HashMap<String,String> idmap) {
		ArrayList<PlantPoint> means = new ArrayList<PlantPoint>();
		for(String id: idmap.keySet()) {
			String name = idmap.get(id);
			double height_sum = 0.0;
			double n=0.0;
			for(int i = 0;i<points.size();i++) {
				if(points.get(i).getName() == name) {
					height_sum += ((PlantPoint) points.get(i)).getHeight();
					n=n+1;
				}
			}
			double mean = height_sum/n;
			System.out.println("mean height of "+name+" is "+mean);
			DataPoint point = new PlantPoint(name,0.0,0.0,(int)mean);
			means.add((PlantPoint) point);
			}
			means.sort(PlantPoint.sortHeight);
			System.out.println("species with min height: "+means.get(0).getName());
			System.out.println("species with max height: "+means.get(means.size()-1).getName());
	}
	
	public static void main(String[] args) {
		try {
			LocMinMax sorter = new LocMinMax();
			DistanceCalculator calc = new DistanceCalculator();
			HashMap<String,String> idmap = dataID("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-plants.txt");
			HashMap<String,String> anIDMap = dataID("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-animals.txt");
			ArrayList<DataPoint> anlist = AnimalMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-animals.txt",anIDMap);
			calc.exclusiveDistanceCalc(anlist,anIDMap);
			ArrayList<DataPoint> plantlist = PlantMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-plants.txt", idmap);
			meanHeight(plantlist,idmap);
			sorter.meanCalculator(sorter.locationSorter(plantlist));
			calc.distanceCalc(plantlist);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
