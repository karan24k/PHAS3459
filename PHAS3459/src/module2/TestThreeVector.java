package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		
		//define some new three vectors
		ThreeVector v1 = new ThreeVector(4,3,3);
		ThreeVector v2 = new ThreeVector(3,5,2);
		ThreeVector v3 = new ThreeVector(0,0,0);
		
		/* whenever we print something of type ThreeVector it'll use the toString method to print it
		 * print the three vectors and their unit vectors
		 */
		
		// print the vectors and their unit vectors
		System.out.println("Vector 1");
		System.out.println(v1);
		System.out.println(v1.unitVector() + " normalised");
		
		System.out.println("\nVector 2");
		System.out.println(v2);
		System.out.println(v2.unitVector() + " normalised");
		
		System.out.println("\nVector 3");
		System.out.println(v3);
		System.out.println(v3.unitVector() + " normalised");
		
		//static methods called from ThreeVector class
		
		System.out.println("\nStatic Methods");
		System.out.println("The scalar product between vectors 1 and 2 is "+ ThreeVector.scalarProduct(v1,v2));
		System.out.println("The scalar product between vectors 1 and 3 is "+ ThreeVector.scalarProduct(v1,v3));
		System.out.println("Vector product between vectors 1 and 2\n"+ ThreeVector.vectorProduct(v1,v2));
		System.out.println("Vector product between vectors 1 and 3\n"+ ThreeVector.vectorProduct(v1,v3));
		System.out.println("The angle in radians between vectors 1 and 2 is " + ThreeVector.angle(v1,v2));
		System.out.println("The angle in radians between vectors 1 and 3 is " + ThreeVector.angle(v1,v3));
		
		//non static methods called from ThreeVector class
		
		System.out.println("\nNon-Static Methods");
		System.out.println("The scalar product between vectors 1 and 2 is "+ v1.scalarProduct(v2));
		System.out.println("The scalar product between vectors 1 and 3 is "+ v1.scalarProduct(v3));
		System.out.println("Vector product between vectors 1 and 2\n"+ v1.vectorProduct(v2));
		System.out.println("Vector product between vectors 1 and 2\n"+ v1.vectorProduct(v3));
		System.out.println("The angle in radians between vectors 1 and 2 is " + v1.angle(v2));
		System.out.println("The angle in radians between vectors 1 and 3 is " + v1.angle(v3));
		
		System.out.println("\nIf you try to print the vectors without the toString method, it'll print the area in the RAM where that information is stored for example\nmodule2.ThreeVector@6d06d69c");
	}

}
