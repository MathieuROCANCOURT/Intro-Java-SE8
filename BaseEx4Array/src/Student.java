import java.util.*;

/**
 * The Student class allows you to create a student's first name, last name, and
 * a list of grades.
 */
public class Student {
	private String lastName;
	private String firstName;
	private ArrayList<Double> noteList;

	/**
	 * Initialize the Student class without assigning any content to it.
	 */
	public Student() {
		lastName = "";
		firstName = "";
		noteList = new ArrayList<Double>();
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public ArrayList<Double> getNoteList() {
		return this.noteList;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}

	public String displayAllNotes() {
		StringBuilder notes = new StringBuilder();
		for (double note : this.noteList) {
			notes.append(note);
			notes.append(" - ");
		}
		notes.delete(notes.length() - 3, notes.length() - 1);
		return notes.toString();
	}

	private static boolean continueAddNote() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Voulez-vous ajouter une autre note? [O/n]");
			String inputTeacher = sc.nextLine();
			if (inputTeacher.equals("") || inputTeacher.equalsIgnoreCase("o")) {
				;
				return true;
			}
			if (inputTeacher.equalsIgnoreCase("n")) {
				return false;
			}
		}
	}

	protected void addMultipleNote() {
		boolean wantAddNote = true;
		while (wantAddNote) {
			this.addNote();

			wantAddNote = continueAddNote();
		}
		System.out.println(this.toString() + ": La moyenne est de " + NoteClassroom.average(noteList));
	}

	private void addNote() {
		boolean addOneNote = true;
		Scanner sc = new Scanner(System.in);
		while (addOneNote) {
			double note = 0.0;
			System.out.print("Quelle est le note que vous ajoutez? ");
			String noteUser = sc.nextLine();

			try {
				note = Double.parseDouble(noteUser);
				if (note < 0) {
					System.out.println("La note ne doit pas être négative.");
				} else {
					this.noteList.add(note);
					addOneNote = false;
				}
			} catch (Exception e) {
				System.err.println("La valeur rentrée n'est pas un nombre.");
			}
		}
	}

	public void modifyNameStudent() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Veuillez saisir le nom de l'élève:");
			this.setLastName(sc.nextLine());
		} while (this.lastName.equals(""));
		do {
			System.out.print("Veuillez saisir le prénom de l'élève:");
			this.setFirstName(sc.nextLine());
		} while (this.firstName.equals(""));
	}
}
