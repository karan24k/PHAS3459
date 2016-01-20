package exam1415;

public class DataPoint {
	public String site;
	public int year;
	public int month;
	public int day;
	public int hTime;
	public int mTime;
	public double seaLevel;
	public double pSeaLevel;
	
	public DataPoint(String site_val,int year_val, int month_val, int day_val, int hTime_val, 
			int mTime_val, double seaLevel_val, double pSeaLevel_val) {
		site = site_val;
		year = year_val;
		month = month_val;
		day = day_val;
		hTime = hTime_val;
		mTime = mTime_val;
		seaLevel = seaLevel_val;
		pSeaLevel = pSeaLevel_val;
	}

	public String getsite() {
		return site;
	}

	public void setsite(String site) {
		this.site = site;
	}

	public int getyear() {
		return year;
	}

	public void setyear(int year) {
		this.year = year;
	}

	public int getmonth() {
		return month;
	}

	public void setmonth(int month) {
		this.month = month;
	}
	
	public int getday() {
		return day;
	}

	public void setday(int day) {
		this.day = day;	
	}
	
	public int gethTime() {
		return hTime;
	}

	public void sethTime(int hTime) {
		this.hTime = hTime;
	}
	
	public int getmTime() {
		return mTime;
	}

	public void setmTime(int mTime) {
		this.mTime = mTime;
	}
	
	public double getseaLevel() {
		return seaLevel;
	}

	public void setseaLevel(double seaLevel) {
		this.seaLevel = seaLevel;
	}
	
	public double getpSeaLevel() {
		return pSeaLevel;
	}

	public void setpSeaLevel(double pSeaLevel) {
		this.pSeaLevel = pSeaLevel;
	}
	
	@Override
	public String toString() {
		return "[site=" + site + ", year=" + year + ", month=" + month
				+ ", day=" + day + ", hour=" + hTime + ", minute=" + mTime + ", Sea Level=" + seaLevel
				+ ", Predicted Sea Level=" + pSeaLevel +"]";
	}

}
