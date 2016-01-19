package exam1314;

public class DataPoint {
	public String name;
	public double longitude;
	public double latitude;
	
	public DataPoint(String name_val,double longitude_val, double latitude_val) {
		name = name_val;
		longitude = longitude_val;
		latitude = latitude_val;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", longitude=" + longitude + ", latitude=" + latitude
				+ "]";
	}

}
