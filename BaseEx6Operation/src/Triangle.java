
/**
 * @author RocancourtM
 */
public class Triangle {
	private static void showTriangle(int triangleHeight) {
		if (triangleHeight < 1) {
			System.err.println("La hauteur du triangle doit être un entier positif.");
		} else {
			for (int line = 1; line <= triangleHeight; line++) {
				double roundedInt = Math.ceil((double) triangleHeight / 2) * 2;

				if (triangleHeight % 2 != 0) {
					roundedInt -= 1;
				}

				char[] rowStar = new char[(int) roundedInt * 2 - 1];

				for (int index = (int) roundedInt - line; index < roundedInt + line - 1; index++) {
					rowStar[index] = '*';
				}
				System.out.println(rowStar);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		showTriangle(0);
	}

}
