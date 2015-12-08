package module8;

public class CountdownTask implements Runnable { // runnable doesn't return a result
	private int count;
	public CountdownTask(int count){
		this.count = count;
	}
	
	@Override
	public void run() {
		int c = count;
		// while c is positive count downwards in integer steps, the while loop pauses for a 1000 milliseconds between each run
		while(c>=0){
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				e.getMessage();
			}
			System.out.println(c);
			c--;

		}
	}

}
