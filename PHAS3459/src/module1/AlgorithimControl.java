package module1;
public class AlgorithimControl {

	public static void main(String[] args) {
		int x = 1;
		int xmax = 17;
		
		int y = 10;
		int ymin = -5;
		
		double z = 2.4;
		double zmax = 8.3;
		double increment = 0.2; 
		
		System.out.println("x = " +x);
		System.out.print("\n");
		
		for (x = 1 ; x < xmax; x++) {}

		while( y >= ymin) {
		System.out.print("y = " +y );
		y--;
		System.out.print("\n");
		}
		
		{
		System.out.print("\n");
		}
		
		for ( z = 2.4; z < zmax; z += increment) {
		System.out.printf("z = " +"%.1f",z);
		System.out.print("\n");
		}
		}
}
		
