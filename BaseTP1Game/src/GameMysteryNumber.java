import java.util.Scanner;

/**
 * Play this game, in which the user must choose a number between 1 and 100 and
 * guess the hidden number. The user can play multiple rounds.
 * 
 * @author RocancourtM
 */
public class GameMysteryNumber {
	/**
	 * Ask the user if they want to play.
	 * 
	 * @param start true it's the first round, else false.
	 * @param sc    Read input by user.
	 * @return true if "o" or "oui", false if "n" or "non", regardless of cases.
	 */
	private static boolean play(boolean start, Scanner sc) {
		String display;
		if (start)
			display = "Bonjour! Souhaitez-vous jouer [o/oui/n/non]?";
		else
			display = "Voulez-vous rejouer [o/oui/n/non]?";

		while (true) {
			System.out.println(display);
			String input = sc.nextLine().toLowerCase();
			if (input.equals("o") || input.equals("oui"))
				return true;
			if (input.equals("n") || input.equals("non")) {
				System.out.println("En revoir!");
				return false;
			}
		}
	}

	public static void main(String[] args) {
		boolean first = true;
		Scanner sc = new Scanner(System.in);

		while (play(first, sc)) {
			first = false;
			int genNumber = (int) (Math.random() * 100) + 1, inputNumber = 0, nbTurn = 0;

			while (genNumber != inputNumber) {
				if (nbTurn == 0)
					System.out.print("Saisir une valeur entre 1 et 100 inclus:");
				else if (genNumber > inputNumber)
					System.out.print("Saisir une valeur plus grande:");
				else
					System.out.print("Saisir une valeur plus petite:");
				try {
					inputNumber = Integer.parseInt(sc.nextLine());
					nbTurn++;
				} catch (Exception e) {
					System.err.println("Votre saisie n'est pas un entier.");
				}
			}
			System.out.println("Vous avez trouvé en " + nbTurn + " coup(s).");
		}
	}
}