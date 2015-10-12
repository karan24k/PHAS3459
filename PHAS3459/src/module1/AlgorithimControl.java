package module1;
public class AlgorithimControl {

	public static void main(String[] args) {
		AlgorithimControl ac = new AlgorithimControl();//creates an object for calling functions from the main method
		ac.loop(1,16);
		ac.decrement(10,-5);
		ac.increment(2.4,8.3,0.2);
		int tim = ac.timer(5000,100); //every 100 loops see timer method below for use of data
		int finalLoop1 = ac.timer(5000,200); //every 200 loops see timer method below for use of data
		int finalLoop2 = ac.timer(5000, 50000); // every 50000 loops see timer method below for use of data
		System.out.println("Total loops per 200: " + finalLoop1 + " and Total Loops per 50000: " + finalLoop2);
		System.out.println("We can see that the total loops completed in the second run is greater than the first, this is because they can be processed faster \n as there is more time between printing");
		// the data uses in the methods below
	}
	
	 void loop(int xintital, int xmax){	
		//method to count from an initial value to a max value, using a for loop
		int x;
		for (x = xintital ; x <= xmax; x++) //for x less than or equal to 16, add one to x
		System.out.println("x = " + x); //prints x as long as it is less than or equal to 16
		System.out.print("\n");
	}
	
	 void decrement(int ay, int ymin){
		//method to count down from an initial value to a minimum value, using a while loop
		int y = ay;
		while(ay >=ymin){ //while y is greater than or equal to y
			System.out.println("y =" + ay); //print y
			ay--; //then take one from y
		}
	}
	
	
	 void increment(double zinitial, double zmax, double increment){
		//method to count from an initial value to a max value in incements of 0.2, using a for loop
		double z;
		for ( z = zinitial; z < zmax; z += increment){ // for values of z less than 8.2, add 0.2 to the value
		System.out.printf("\n z = " +"%.1f",z); //print each value to one d.p.
		}
			
	}
	
	public int timer(long maxTime, int loopSteps){
		//method to print how many loops have run every 100 loops for 5 seconds
		long startTime = System.currentTimeMillis();  //time at start
	    long endTime = startTime + maxTime;  // end after t = 5000 = 5 sec
	    int counter = 0; //initial value for the counter, will increase by one each while loop, hence counting number of loops
		while(System.currentTimeMillis() < endTime) { //run for 5 secs
			counter ++; // add 1 to count each while loop
			if(counter % loopSteps == 0){ 
				/*if the remainder from dividing the counter by the loop steps is 0 it is in integer, 
				 * hence 100x loops have occurred
				 */
				System.out.println(counter);
			}
		}
		return counter;
	}
	
}
		
