/**
 * Say if a word or a sentence is a palindrome.
 * 
 * @author RocancourtM
 */
public class Palindrome {
	/**
	 * The first way to concatenate two strings.
	 * 
	 * @param str1 First string.
	 * @param str2 Second string.
	 * @return The two concatenated strings.
	 */
	private static String meaning1Concatenate(String str1, String str2) {
		return str1 + str2;
	}

	/**
	 * The second way to concatenate two strings.
	 * 
	 * @param str1 First string.
	 * @param str2 Second string.
	 * @return The two concatenated strings.
	 */
	private static String meaning2Concatenate(String str1, String str2) {
		return str1.concat(str2);
	}

	/**
	 * The third way to concatenate two strings.
	 * 
	 * @param str1 First string.
	 * @param str2 Second string.
	 * @return The two concatenated strings.
	 */
	private static String meaning3Concatenate(String str1, String str2) {
		StringBuilder concat = new StringBuilder();
		concat.append(str1).append(str2);
		return concat.toString();
	}

	/**
	 * Check whether a string is contained in another string.
	 * 
	 * @param sentence A string.
	 * @param wordToSearch A string to search in sentence variable.
	 */
	private static void searchWord(String sentence, String wordToSearch) {
		if (sentence.toLowerCase().contains(wordToSearch.toLowerCase())) {
			System.out.println("Le mot " + wordToSearch + "a été trouvé dans la phrase ci-dessous:\n" + sentence);
		} else {
			System.out.println("Le mot " + wordToSearch + "n'a pas été trouvé dans la phrase ci-dessous:\n" + sentence);
		}
	}

	private static boolean isPalindrome(String sentence) {
		sentence = sentence.replaceAll("[\\p{Punct}\\p{Space}]", "");
		String reverseSentence = new StringBuilder(sentence).reverse().toString();
		return sentence.equalsIgnoreCase(reverseSentence);
	}

	public static void main(String[] args) {
		// Test different meaning to concatenate and search a word in a sentence.
		String str1 = "couCOu ", str2 = "tout Coucou le monde.";

		System.out.println(meaning1Concatenate(str1, str2));
		System.out.println(meaning2Concatenate(str1, str2));
		System.out.println(meaning3Concatenate(str1, str2));
		searchWord(str2, str1);

		// Test palindrome.
		String[] testPalindrome = { "akka", "ottO", "Bonjour", "Elu par cette crapule." };
		for (String sentence : testPalindrome) {
			if (isPalindrome(sentence)) {
				System.out.println("La phrase \"" + sentence + "\" est un palindrome.");
			} else {
				System.out.println("La phrase \"" + sentence + "\" n'est pas un palindrome.");
			}
		}
	}
}
