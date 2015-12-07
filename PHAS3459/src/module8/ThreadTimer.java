package module8;

public class ThreadTimer {

	public static void main(String[] args) {
		 long nPoints = 10000000L;
		  MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints);
		  double pi = task.call();
		  System.out.println(pi);
		  
		  
		  long nPoints  = 10000000L;
		  int  nThreads = 4;
		  ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		  List<Future<Double>> futures = new ArrayList<Future<Double>>();
		  for (int iThread = 0; iThread < nThreads; ++iThread) {
		    MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints/nThreads);
		    Future<Double> future = threadPool.submit(task);
		    futures.add(future);
		  }
		  double sum = 0.0;
		  for (int iThread = 0; iThread < nThreads; ++iThread) {
		    double result = futures.get(iThread).get();
		    sum += result;
		  }
		  threadPool.shutdown();
		  double pi = sum/nThreads;
	}

}
