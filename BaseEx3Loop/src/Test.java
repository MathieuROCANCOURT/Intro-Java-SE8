import java.util.Scanner;

/**
 * Indicate whether the number is positive, negative or zero, as well as its parity.
 * 
 * @author RocancourtM
 */
public class Test {
	/**
	 * Test the number is positive, negative or zero.
	 * 
	 * @param number The number to test.
	 * @return String indicating the number is positive, negative or zero.
	 */
	private static String posNegNumber(int number) {
		if (number > 0) {
			return " positif";
		}
		if (number < 0) {
			return " négatif";
		}
		return " vaut zéro";
	}

	/**
	 * Test number the parity
	 * 
	 * @param number The number to test.
	 * @return String indicating the parity.
	 */
	private static String parity(int number) {
		if (number % 2 == 0) {
			return " pair";
		}
		return " impair";
	}

	/**
	 * Verify the input if it's a int type.
	 * 
	 * @param number Input by user
	 * @return true if input user is a int, else false.
	 */
	private static boolean isNumber(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (Exception e) {
			System.err.println("Votre saisie n'est pas un entier.");
		}
		return false;
	}
	
	/**
	 * Display number is positive, negative or zero, as well as its parity.
	 * 
	 * @param numberString The input user.
	 */
	private static void result(String numberString) {
		int number = Integer.parseInt(numberString);
		System.out.println(number + posNegNumber(number) + " et" + parity(number) + '.');
	}

	public static void main(String[] args) {
		boolean isANumber = false;

		for (String argument: args) {
			isANumber = isNumber(argument);
			if (isANumber) {
				result(argument);
			}
		}
		
		String inputUserNumber = "";
		while (! isANumber) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Veuillez saisir un nombre:");
			inputUserNumber = scan.nextLine();
			if (isNumber(inputUserNumber)) {
				result(inputUserNumber);
				isANumber = true;
				scan.close();
			}
		}
	}
}
