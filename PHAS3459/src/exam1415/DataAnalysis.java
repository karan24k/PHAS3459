package exam1415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class DataAnalysis { 
	
	private static BufferedReader br;
	
	public static HashMap<String,String> dataID(String siteURL) throws IOException{
		HashMap<String,String> idmap = new HashMap<String,String>();
		URL uID = new URL(siteURL);
		InputStream is = uID.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		String line = "";
		Scanner s = new Scanner(line);
		br.readLine();
		Scanner s2 = null;
		while ((line= br.readLine()) != null) {
			s2 = new Scanner(line);
			String site = s2.next();
			String id = s2.next();
			idmap.put(id, site);
			s2.close();
		}
		s.close();
		return idmap;
		}
	
	
	public static ArrayList<DataPoint> tidesMap(String tidesURL, HashMap<String, String> idmap) throws IOException {
		ArrayList<DataPoint> tidesMap = new ArrayList<DataPoint>();
		URL uTides = new URL(tidesURL);
		InputStream is = uTides.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		String line = "";
		Scanner s = new Scanner(br.readLine());
		Scanner s2 = null;
		double maxSeaLevel = 0.0;
		int maxyear = 0;
		String maxid = null;
		String maxsite = null;
		int maxday = 0;
		int maxmonth = 0;
		int maxmTime = 0;
		int maxhTime = 0;
		
		while ((line= br.readLine()) != null) {
			s2 = new Scanner(line);
			String id = s2.next();
			String site = idmap.get(id);
			int year = Integer.parseInt(s2.next());
			int month = Integer.parseInt(s2.next());
			int day = Integer.parseInt(s2.next());
			int hTime = Integer.parseInt(s2.next());
			int mTime = Integer.parseInt(s2.next());
			double seaLevel = Double.parseDouble(s2.next());
			double pSeaLevel = Double.parseDouble(s2.next());
			DataPoint point = new DataPoint(site, year, month, day, 
					hTime, mTime, seaLevel, pSeaLevel);
			tidesMap.add(point);
			s2.close();
			
			if(seaLevel>maxSeaLevel){
				maxSeaLevel = seaLevel;
				maxid = id;
				maxsite = site;
				maxday = day;
				maxmonth = month;
				maxyear = year;
				maxmTime = mTime;
				maxhTime = hTime;
				
			}
		}
		System.out.println("The maximum sea level is " + maxSeaLevel + " at " + maxid + "=" + maxsite + " on " + maxday+
				"/"+maxmonth+"/"+maxyear + " at " + maxhTime + ":" + maxmTime );
		s.close();
		return tidesMap;
	
	}
	public static void main(String[] args) {
		try {
			HashMap<String,String> idmap = dataID("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/sites.txt");
			ArrayList<DataPoint> tidelist99 = tidesMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-1999.txt",idmap);
			ArrayList<DataPoint> tidelist00 = tidesMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2000.txt",idmap);
			ArrayList<DataPoint> tidelist01 = tidesMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2001.txt",idmap);
			
			Calculator c = new Calculator();
			c.arbitaryStat(tidelist99);
			
			//Range r = new Range();
			//r.arbitaryStat(tideData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


