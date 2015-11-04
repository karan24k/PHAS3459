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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matrixArray);
		return result;
	}

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
	




