
/**
 * 
 * @author RocancourtM
 */
public class Operation {
	private static int add(int a, int b) {
		return a + b;
	}
	
	private static int sub(int a, int b) {
		return a - b;
	}
	
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
