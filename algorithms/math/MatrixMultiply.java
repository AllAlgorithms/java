
public class MatrixMultiply {

	/**
	 * Multiples 2 2-dimensional matrices together given their dimensions are
	 * compatible
	 * 
	 * @param mat_a A 2-Dimensional matrix to be multiplied
	 * @param mat_b A 2-Dimensional matrix to be multiplied
	 * @return The product of the two matrices if compatible dimensions, null
	 *         otherwise
	 */
	public static double[][] matrixMultiply2D(double[][] mat_a, double[][] mat_b) {
		int aRows = mat_a.length;
		int aColumns = mat_a[0].length;
		int bRows = mat_b.length;
		int bColumns = mat_b[0].length;

		if (aColumns != bRows)
			throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");

		double[][] mat_result = new double[aRows][bColumns];
		for (int i = 0; i < aRows; i++) {
			for (int j = 0; j < bColumns; j++) {
				mat_result[i][j] = 0.00000;
			}
		}

		for (int i = 0; i < aRows; i++) { // aRow
			for (int j = 0; j < bColumns; j++) { // bColumn
				for (int k = 0; k < aColumns; k++) { // aColumn
					mat_result[i][j] += mat_a[i][k] * mat_b[k][j];
				}
			}
		}
		return mat_result;
	}

}
