package module1;
public class AlgorithimControl {

	public static void main(String[] args) {
		AlgorithimControl ac = new AlgorithimControl();
		int lp = ac.loop(1,16);
		int dec = ac.decrement(10,-5);
		double inc = ac.increment(2.4,8.3,0.2);
		
	}
	
	public int loop(int ax, int xmax){	
		int x;
		for (x = ax ; x <= xmax; x++)
		System.out.println("x = " + x);
		System.out.print("\n");
		return x;
	}
	
	public int decrement(int ay, int ymin){
		int y = ay;
		while(ay >=ymin){
			System.out.println("y =" + ay);
			ay--;
	}
		return y;
	}
	
	
	public double increment(double az, double zz, double i){
		double z;
		for ( z = az; z < zz; z += i){
		System.out.printf("\n z = " +"%.1f",z);
		}
		return z;
			
	}
}
		
