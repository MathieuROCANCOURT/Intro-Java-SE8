
/**
 * Draw an equilateral triangle with '*' symbol in the command line.
 * 
 * @author RocancourtM
 */
public class Triangle {
	/**
	 * Draw an equilateral triangle containing the symbol “*” in the command line,
	 * specifying its height.
	 * 
	 * @param triangleHeight Height of the triangle.
	 */
	private static void showTriangle(int triangleHeight) {
		if (triangleHeight < 1) {
			System.err.println("La hauteur du triangle doit être un entier positif.");
		} else {			
			for (int line = 1; line <= triangleHeight; line++) {
				char[] rowStar = new char[triangleHeight * 2 - 1];

				for (int index = triangleHeight - line; index < triangleHeight + line - 1; index++) {
					rowStar[index] = '*';
				}
				System.out.println(rowStar);
			}
		}
	}

	/**
	 * Main program for testing the construction of a triangle.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		showTriangle(9);
	}
}
