package exam1415;

import java.util.ArrayList;
import java.util.HashMap;

public class Calculator implements StatCalc {

	@Override
	public double arbitaryStat(HashMap<String,ArrayList<DataPoint>> map){
		for(String id:map.keySet()){
			int n = 0;
			double sum = 0.0;
			ArrayList<DataPoint> curr = map.get(id);
			for(DataPoint t:curr){
				sum += t.getseaLevel();
				n++;
			}
			double mean = sum / n;
			System.out.println("for the location " +id +", the mean value was "+ mean);
		}
		return 0;
	}
}