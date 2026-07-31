import java.util.Scanner;

public class Test {
	private static String posNegNumber(int number) {
		if (number > 0) {
			return " est positif";
		} else if (number < 0) {
			return " est négatif";
		}
		return " vaut zéro";
	}

	private static String parity(int number) {
		if (number % 2 == 0) {
			return " est pair";
		}
		return " est impair";
	}

	private static boolean isNumber(String number) {
		try {
			int test_number = Integer.parseInt(number);
			return true;
		} catch (Exception e) {
			System.out.println("Votre saisie n'est pas un entier.");
		}
		return false;
	}

	public static void main(String[] args) {
		boolean isANumber = false;
		String inputUserNumber = "";
		int number;

		if (args.length > 0) {
			isANumber = isNumber(args[0]);
			if (isANumber) {
				inputUserNumber = args[0];
			}
		}
		
		while (! isANumber) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Veuillez saisir un nombre:");
			inputUserNumber = scan.nextLine();
			isANumber = isNumber(inputUserNumber);
		}
		number = Integer.parseInt(inputUserNumber);

		System.out.println(number + posNegNumber(number) + " et" + parity(number) + '.');
	}
}
