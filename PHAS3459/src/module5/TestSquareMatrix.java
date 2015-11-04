package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {
		
		// create matrices
		SquareMatrix A = new SquareMatrix(new double[][] {{1,0,-2},{0,3,0},{2,0,1}});
		SquareMatrix B = new SquareMatrix(new double[][] {{0,0,1},{0,1,0},{-1,0,1}});
		SquareMatrix C = new SquareMatrix(new double[][] {{4,3},{3,2}});
		SquareMatrix D = new SquareMatrix(new double[][] {{-2,3},{3,-4}});
		// testing toString System.out.println(A);
		// testing unitMatrix System.out.println(SquareMatrix.unitMatrix(3));
		
		/*try adding, subtracting, multiplying and finding the commutator of matrices A and B, multiply C and D 
		 * and test whether the outcome it is equal to the identity
		 */
		
		try {
			System.out.println("A+B =\n" + A.add(B));
			System.out.println("A-B =\n" + A.subtract(B));
			System.out.println("A x B =\n" + A.multiply(B));
			System.out.println("B x A =\n" + B.multiply(A));
			System.out.println("[A,B] =\n" + A.commutator(B));
			SquareMatrix CD = C.multiply(D);
			System.out.println("C x D =\n" + CD);
			System.out.println("C x D = I? \n" + CD.equals(SquareMatrix.unitMatrix(2)));
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// test must be square exception SquareMatrix E = new SquareMatrix(new double[][] {{1,0,-2},{0,3,0}});
	// test same size exception SquareMatrix CD = B.multiply(D); 

}
