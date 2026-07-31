
/**
 * Create operation class with:
 * <ul>
 * <li>Add between 2 numbers.</li>
 * <li>Subtraction between 2 numbers.</li>
 * <li>Multiplication between 2 numbers.</li>
 * <li>Division between 2 numbers.</li>
 * 
 * @author RocancourtM
 */
public class Operation {
	/**
	 * Addition between 2 integers.
	 * 
	 * @param a First integer.
	 * @param b Second integer.
	 * @return Sum between two integers.
	 */
	private static int add(int a, int b) {
		return a + b;
	}

	/**
	 * Subtraction between 2 integers.
	 * 
	 * @param a First integer.
	 * @param b Second integer.
	 * @return Difference between two integers.
	 */
	private static int sub(int a, int b) {
		return a - b;
	}

	/**
	 * Multiply between 2 integers.
	 * 
	 * @param a First integer.
	 * @param b Second integer.
	 * @return Multiplication between two integers.
	 */
	private static int mul(int a, int b) {
		return a * b;
	}

	private static double div(double a, double b) {
		if (b == 0) {
			System.err.println("La division par 0 est illégale.");
			return Double.NaN;
		}
		return a / b;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 89, b = 37;
		System.out.println(a + " + " + b + " = " + add(a, b));
		System.out.println(a + " - " + b + " = " + sub(a, b));
		System.out.println(a + " * " + b + " = " + mul(a, b));
		System.out.println(a + " / " + b + " = " + div(a, b));
		System.out.println(a + " / " + b + " = " + div(a, 0));
	}
}
