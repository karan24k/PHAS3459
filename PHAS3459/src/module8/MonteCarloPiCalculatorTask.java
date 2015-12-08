package module8;

import java.util.Random;
import java.util.concurrent.Callable;

//Monte Carlo method for calculating pi, callable returns a restult
public class MonteCarloPiCalculatorTask implements Callable<Double> {
	private final long nPoints;

	public MonteCarloPiCalculatorTask(long nPoints) {
		this.nPoints = nPoints;
	}

	@Override
	public Double call() {
		Random rand = new Random();
		long nIn  = 0;
		for (long iPoint = 0; iPoint < nPoints; ++iPoint) {
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			double r2 = x*x + y*y;
			if (r2 < 1.0) ++nIn;
		}
		return 4.0 * nIn / nPoints;
	}
}
