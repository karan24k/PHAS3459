package module6;

public class LabelledDataPoint extends DataPoint {

	//private string variable for data point label
	private String label;
	
	// Constructor
	public LabelledDataPoint(double x, double y, double ey, String label) {
		super(x,y,ey);
		this.label = label;
	}
	// Getter for label
	public String getLabel() {
		return label;
	}
	// Override superclass toString method
	@Override
	public String toString() {
		return label+": x = "+x+", y = "+y+" +- "+ey;
	}
}