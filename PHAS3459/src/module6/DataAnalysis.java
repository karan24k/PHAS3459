package module6;

import java.util.*;

public class DataAnalysis {

	public static void main(String[] args) {
		try{
			//collection of datapoints
			Collection<DataPoint> datapoints = TestDataPoints.dataFromURL
					("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			/*
			 * define theories
			 * f1: y = x^2
			 * f2: y = x^2.05
			 * f3: y = x^2 + 10x
			 */
			Theory f1 = new PowerLawTheory(2);
			Theory f2 = new PowerLawTheory(2.05);
			Theory f3 = new QuadraticTheory(1, 10, 0);
			
			//collection of theories
			Collection<Theory> theories = new ArrayList<Theory>(Arrays.asList(f1,f2,f3));
			// Goodness of fit calculation using chi-squared
			GoodnessOfFitCalculator gof = new ChiSquared();
			// Calculate best theory
			Theory bestTheory = bestTheory(datapoints, theories, gof);
			System.out.println("The best theory is: "+bestTheory);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//method to calculate best fit for data
	 private static Theory bestTheory(Collection<DataPoint> data,
	            Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
	        boolean first = true;
	        double bestGoodnessOfFit = 0.0;
	        Theory bestTheory = null;
	        //calculate goodness of fit for each theory with the data
	        for (Theory theory : theories) {
	            double gof = gofCalculator.goodnessOfFit(data, theory);
	            if (first) {
	                bestTheory = theory;
	                bestGoodnessOfFit = gof;
	                first = false;
	                //if new chi squared value is less than previous make this the new best theory
	            } else if (gof < bestGoodnessOfFit) {
	                bestTheory = theory;
	                bestGoodnessOfFit = gof;
	            }
	        }
	        return bestTheory;
	    }
}
