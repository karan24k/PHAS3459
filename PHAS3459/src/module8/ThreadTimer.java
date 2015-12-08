package module8;

import java.util.*;
import java.util.concurrent.*;

public class ThreadTimer {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// calculate pi with a single thread and calculate time taken for calculation
		double initial = System.currentTimeMillis(); //time at start of calculation
		long nPoints = 10000000L;
		MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints);
		double pi = task.call();
		double fin = System.currentTimeMillis() - initial; //time at start of calculation
		
		System.out.println("Pi calculated with single thread " + pi);
		System.out.println("Time to calculate pi  with single thread " + fin  + " milliseconds");

		
		// calculate pi with four threads and calculate time taken for calculation - take a mean of each pi calculated by each thread
		double inital1 = System.currentTimeMillis(); // time at start of calculation
		int  nThreads = 4;
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			MonteCarloPiCalculatorTask task1 = new MonteCarloPiCalculatorTask(nPoints/nThreads);
			Future<Double> future = threadPool.submit(task1);
			futures.add(future);
		}

		double sum = 0.0;
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			double result = futures.get(iThread).get();
			sum += result;
		}

		threadPool.shutdown(); //no new tasks are submitted
		
		double pi1 = sum/nThreads;
		double fin1 = System.currentTimeMillis() - inital1;
		
		System.out.println("\nPi calculated with four threads " + pi1);
		System.out.println("Time to calculate pi with four threads " + fin1 + " milliseconds");
		
		System.out.println("\nThe time taken is shorter using multiple threads, as they can share memory space"); 
	}

}
