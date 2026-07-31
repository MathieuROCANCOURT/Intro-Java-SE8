
/**
 * Matrix class where can we make differents operations where can we:<br>
 * <ul>
 * <li>Add between 2 matrix.</li>
 * <li>Substract between 2 matrix.</li>
 * <li>Multiply a matrix by a factor.</li>
 * <li>Multiply between 2 matrix.</li>
 * </ul>
 * 
 * @author RocancourtM
 */
public class Matrix {
	/**
	 * Display a matrix in the command line.
	 * 
	 * @param matrix Matrix to display.
	 */
	public static void showValuesMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[0].length; column++) {
				System.out.print(matrix[row][column] + " ");
			}
			System.out.println();
		}
	}

	public static void showOperation(int[][] matrix1, int[][] matrix2, char operation, int[][] res) {
		showValuesMatrix(matrix1);
		System.out.println(operation);
		showValuesMatrix(matrix2);
		System.out.println('=');
		showValuesMatrix(res);
	}

	public static int[][] add(int[][] matrix1, int[][] matrix2) {
		if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
			System.out.println(
					"Pour les additionner, les matrices douvent avoir le même nombre de colonne(s) et de ligne(s).");
			return null;
		}

		int[][] resMatrix = new int[matrix1.length][matrix1[0].length];
		for (int row = 0; row < matrix1.length; row++) {
			for (int column = 0; column < matrix1[0].length; column++) {
				resMatrix[row][column] = matrix1[row][column] + matrix2[row][column];
			}
		}
		showOperation(matrix1, matrix2, '+', resMatrix);
		return resMatrix;
	}

	public static int[][] sub(int[][] matrix1, int[][] matrix2) {
		if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
			System.out.println(
					"Pour soustraire, les matrices douvent avoir le même nombre de colonne(s) et de ligne(s).");
			return null;
		}

		int[][] resMatrix = new int[matrix1.length][matrix1[0].length];
		for (int row = 0; row < matrix1.length; row++) {
			for (int column = 0; column < matrix1[0].length; column++) {
				resMatrix[row][column] = matrix1[row][column] - matrix2[row][column];
			}
		}
		showOperation(matrix1, matrix2, '-', resMatrix);
		return resMatrix;
	}

	public static int[][] multByFactor(int[][] matrix, int factor) {
		int[][] resMatrix = new int[matrix.length][matrix[0].length];

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[0].length; column++) {
				resMatrix[row][column] = factor * matrix[row][column];
			}
		}

		showOperation(new int[][] { { factor } }, matrix, '*', resMatrix);
		return matrix;
	}

	public static int[][] mult(int[][] matrix1, int[][] matrix2) {
		if (matrix1[0].length != matrix2.length) {
			System.out.println(
					"Pour les multiplier, les matrices douvent avoir le même nombre de colonne(s) et de ligne(s).");
			return null;
		}

		int[][] resMatrix = new int[matrix1.length][matrix2[0].length];
		for (int row = 0; row < matrix1.length; row++) {
			for (int column = 0; column < matrix2[0].length; column++) {
				for (int nbOperation = 0; nbOperation < matrix1[0].length; nbOperation++) {
					resMatrix[row][column] += matrix1[row][nbOperation] * matrix2[nbOperation][column];
				}
			}
		}
		showOperation(matrix1, matrix2, '*', resMatrix);
		return resMatrix;
	}

	public static void main(String[] args) {
		int[][] matrix1 = { { 5, 2, 4 }, { 0, 1, 1 }, { 6, 3, 1 } };
		int[][] matrix2 = { { 1, 1, 3 }, { 2, 5, 6 }, { 3, 0, 5 } };
		int[][] matrix3 = { { 8, 7 }, { 5, 4 }, { 2, 1 } };
		int[][] matrix4 = { { 0, 2 }, { 1, 2 }, { 1, 1 } };
		String deliminator = "-------------------";

		add(matrix1, matrix2);
		System.out.println(deliminator);
		add(matrix1, matrix3);
		System.out.println(deliminator);
		sub(matrix3, matrix4);
		System.out.println(deliminator);
		multByFactor(matrix4, 2);
		System.out.println(deliminator);
		mult(matrix1, matrix2);
		System.out.println(deliminator);
		mult(matrix2, matrix3);
		System.out.println(deliminator);
		mult(matrix4, matrix3);
	}
}
