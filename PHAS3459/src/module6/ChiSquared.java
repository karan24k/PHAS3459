package module6;

import java.util.Collection;

public class ChiSquared implements GoodnessOfFitCalculator {
	public double goodnessOfFit(Collection<DataPoint> data, Theory t) {
		//initialise
				double CHISQUARE = 0;
				// for each datapoint in data from url
				for (DataPoint p : data){

					// calculate theoretical y
					double tY = t.y(p.getX());
					// get measured y
					double mY = p.getY();
					// calculate chi squared numerator and denominator
					double dY = Math.pow((mY-tY), 2);
					double eYsquare = Math.pow(p.getEY(), 2);
					CHISQUARE += dY/eYsquare;
				}
				return CHISQUARE;
	}
}
