/**
 * 
 */

import java.math.BigInteger;

/**
 * @author RocancourtM
 */
public class Factorial {
	private static BigInteger factorial(int number) {
		if (number == 0) {
			return BigInteger.valueOf(1L);
		}

		return factorial(number - 1).multiply(new BigInteger(Integer.toString(number)));
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] testNumber = {6, 0, 1, 5, 67, 10000000};
		
		for (int number : testNumber) {
			System.out.println("Factoriel de " + number + " vaut " + factorial(number) + ".");
		}
	}

}
