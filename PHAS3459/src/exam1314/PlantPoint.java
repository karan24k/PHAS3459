package exam1314;
import java.util.Comparator;

public class PlantPoint extends DataPoint {
	private int height;

	
	public PlantPoint(String name_val,double longitude_val, double latitude_val,int height_val) {
		super(name_val,longitude_val,latitude_val);
		height = height_val;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString() {
		return super.toString()+ " height: "+height;
	}

	public static Comparator<PlantPoint> sortHeight = new Comparator<PlantPoint>() {
		public int compare(PlantPoint p1, PlantPoint p2) {
			return p1.getHeight()-p2.getHeight();
		}
	};
}
