package module5;

import java.util.*;
import java.lang.StringBuilder;

public class SquareMatrix {

	int matrixSize;
	double[][] matrixArray;

	// Constructor
	public SquareMatrix(double[][] elements) throws RuntimeException {

		// Store size of matrix
		matrixSize = elements.length;

		// Loop of each row
		for (int i = 0; i < matrixSize; i++) {
			if (matrixSize != elements[i].length)
				throw new RuntimeException("Matrix must be square!");
		}
		matrixArray = elements;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		// for each row in matrixArray
		for (double[] val : matrixArray) {
			// Add row array to StringBuilder
			str.append(Arrays.toString(val)).append("\n");
		}
		// Return StringBuilder string
		return str.toString();
	}

	public static SquareMatrix unitMatrix(int size){
		double [][] ijvalue = new double [size][size];

		for (int x = 0; x<size; x++){
			for (int y = 0; y<size; y++){
				if (x == y){
					ijvalue [x][y] = 1;
				}
				else{
					ijvalue [x][y] = 0;
				}
			}
		}

		return new SquareMatrix(ijvalue);
	}

	// find out if two matrices are equal
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(matrixArray, other.matrixArray))
			return false;
		return true;
	}

	// add
	public static SquareMatrix add(SquareMatrix a, SquareMatrix b) throws Exception {

		if (a.matrixSize != b.matrixSize)
			// Throw exception for multiplying different size matrices
			throw new Exception("Matrix sizes must be the same");

		// Size of matrix
		int size = a.matrixSize;
		// Create new matrix
		double newMatrix[][] = new double[size][size];

		// Loop over each row
		for (int i = 0; i < size; i++) {
			// Loop over each column in row
			for (int j = 0; j < size; j++) {
				newMatrix[i][j] = a.matrixArray[i][j] + b.matrixArray[i][j];
			}
		}

		// Return new matrix
		return new SquareMatrix(newMatrix);
	}

	// subtract
	public static SquareMatrix subtract(SquareMatrix a, SquareMatrix b) throws Exception {

		if (a.matrixSize != b.matrixSize)
			// Throw exception for multiplying different size matrices
			throw new Exception("Matrix sizes must be the same");

		// Size of matrix
		int size = a.matrixSize;
		// Create new matrix
		double newMatrix[][] = new double[size][size];

		// Loop over each row
		for (int i = 0; i < size; i++) {
			// Loop over each column in row
			for (int j = 0; j < size; j++) {
				newMatrix[i][j] = a.matrixArray[i][j] - b.matrixArray[i][j];
			}
		}

		// Return new matrix
		return new SquareMatrix(newMatrix);
	}
	// multiply
	public static SquareMatrix multiply(SquareMatrix a, SquareMatrix b) throws Exception {

		if (a.matrixSize != b.matrixSize)
			// Throw exception for multiplying different size matrices
			throw new Exception("Matrix sizes must be the same");

		// Size of matrix
		int size = a.matrixSize;
		// Create new matrix
		double newMatrix[][] = new double[size][size];

		// Loop over each row
		for (int i = 0; i < size; i++) {
			// Loop over each column in row
			for (int j = 0; j < size; j++) {
				// Generic iterator for length of matrix
				for (int k = 0; k < size; k++) {
					// Value is the respective row values of a * column values of b
					// [i][k] is iterating along a row and [k][j] is down a column
					newMatrix[i][j] += a.matrixArray[i][k] * b.matrixArray[k][j];
				}
			}
		}

		// Return new matrix
		return new SquareMatrix(newMatrix);
	}
	// Non static helpers
	SquareMatrix multiply(SquareMatrix b) throws Exception {
		return SquareMatrix.multiply(this, b);
	}

	SquareMatrix add(SquareMatrix b) throws Exception {
		return SquareMatrix.add(this, b);
	}

	SquareMatrix subtract(SquareMatrix b) throws Exception {
		return SquareMatrix.subtract(this, b);
	}

	SquareMatrix commutator(SquareMatrix b) throws Exception {
		return SquareMatrix.commutator(this, b);
	}
	// commutator
	public static SquareMatrix commutator(SquareMatrix a, SquareMatrix b) throws Exception {
		// a*b and b*a
		SquareMatrix ab = a.multiply(b);
		SquareMatrix ba = b.multiply(a);
		// Return new matrix of ab-ba
		return new SquareMatrix(SquareMatrix.subtract(ab,ba).matrixArray);


	}
}


