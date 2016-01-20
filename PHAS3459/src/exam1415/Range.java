package exam1415;
import java.util.ArrayList;
import java.util.HashMap;
public class Range implements StatCalc {
	
	@Override
	public double arbitaryStat(HashMap<String, ArrayList<DataPoint>> map){
		for(String id:map.keySet()){
			double range = 0.0;
			ArrayList<DataPoint> curr = map.get(id);
			curr.sort(DataPoint.sortseaLevel);
			range = (curr.get(0).getseaLevel() - curr.get(curr.size()-1).getSeaLevel());
			System.out.println("for the location " + id + " = " + curr.get(0).getName() + ", the range was " + range);
		}
		return 0;
	}
}
