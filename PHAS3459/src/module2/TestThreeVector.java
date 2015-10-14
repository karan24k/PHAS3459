package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		ThreeVector v1 = new ThreeVector(4,3,3);
		ThreeVector v2 = new ThreeVector(3,5,2);
		ThreeVector v3 = new ThreeVector(0,0,0);
		
		System.out.println("Vector 1");
		System.out.println(v1);
		System.out.println(v1.unitVector() + " normalised");
		
		System.out.println("\nVector 2");
		System.out.println(v2);
		System.out.println(v2.unitVector() + " normalised");
		
		System.out.println("\nVector 3");
		System.out.println(v3);
		System.out.println(v3.unitVector() + " normalised");
		
		//static methods
		
		System.out.println("\nStatic Methods");
		System.out.println("The scalar product between vectors 1 and 2 is "+ ThreeVector.scalarProduct(v1,v2));
		System.out.println("The scalar product between vectors 1 and 3 is "+ ThreeVector.scalarProduct(v1,v3));
		System.out.println("Vector product between vectors 1 and 2\n"+ ThreeVector.vectorProduct(v1,v2));
		System.out.println("Vector product between vectors 1 and 3\n"+ ThreeVector.vectorProduct(v1,v3));
		
		
	}

}
