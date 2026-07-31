import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		System.out.println("bonjour et bienvenu dans mon programme java");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Quel est votre nom ?");
		String lastname = scanner.nextLine();
		
		System.out.print("Quel est votre prénom ?");
		String firstname = scanner.nextLine();
		scanner.close();
		
		System.out.println("Bienvenu " + lastname + ' ' + firstname + " !");
	}
}
