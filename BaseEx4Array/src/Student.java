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

	/**
	 * Get the last name.
	 * 
	 * @return Student's last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Get the first name.
	 * 
	 * @return Student's first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Get a list of the student's grades
	 * 
	 * @return List of notes
	 */
	public ArrayList<Double> getNoteList() {
		return this.noteList;
	}

	/**
	 * Change the student's last name.
	 * 
	 * @param lastName The new last name.
	 */
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Change the student's first name.
	 * 
	 * @param lastName The new first name.
	 */
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}

	/**
	 * Combine all of the student's grades into a single string.
	 * 
	 * @return All notes within a string.
	 */
	public String displayAllNotes() {
		StringBuilder notes = new StringBuilder();
		for (double note : this.noteList) {
			notes.append(note);
			notes.append(" - ");
		}
		notes.delete(notes.length() - 3, notes.length() - 1);
		return notes.toString();
	}

	/**
	 * Ask the teacher if they want to add another note.
	 * 
	 * @return true if 'o', 'O' or Enter. false if 'n' or 'N'.
	 */
	private static boolean continueAddNote() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Voulez-vous ajouter une autre note? [O/n]");
			String inputTeacher = sc.nextLine();
			if (inputTeacher.equals("") || inputTeacher.equalsIgnoreCase("o")) {
				return true;
			}
			if (inputTeacher.equalsIgnoreCase("n")) {
				return false;
			}
		}
	}

	/**
	 * Add all the grades entered by the teacher. Once the teacher has finished
	 * entering the grades, display all the grades along with the average.
	 */
	protected void addMultipleNote() {
		boolean wantAddNote = true;
		while (wantAddNote) {
			this.addNote();

			wantAddNote = continueAddNote();
		}
		System.out.println(this.toString() + ": La moyenne est de " + NoteClassroom.average(noteList));
	}

	/**
	 * Add a note to the list of notes.
	 */
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

	/**
	 * Change the student's first name and last name.
	 */
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
