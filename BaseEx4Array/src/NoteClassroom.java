import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Create a class with a teacher and a list of students to be entered by thr
 * teacher. The teacher can enter the students' grades.
 * 
 * The grades entered by the teacher are used to calculate the class average.
 * The list of student can be sorted by alphabetic.
 * 
 * @author RocancourtM
 */
public class NoteClassroom {
	/**
	 * Get the minimum number in a list.
	 * 
	 * @param noteList List of number.
	 * @return Minimum number of the list.
	 */
	private static double min(ArrayList<Double> noteList) {
		return Collections.min(noteList);
	}

	/**
	 * Get the maximum number in a list.
	 * 
	 * @param noteList list of number.
	 * @return Maximum number of the list.
	 */
	private static double max(ArrayList<Double> noteList) {
		return Collections.max(noteList);
	}

	/**
	 * Calculate the average of the list of numbers.
	 * 
	 * @param noteList List of number.
	 * @return The average, or 0 if the list is empty.
	 */
	protected static double average(ArrayList<Double> noteList) {
		if (noteList.isEmpty()) {
			return 0;
		}
		double average = 0;

		for (double note : noteList) {
			average += note;
		}

		return average / noteList.size();
	}

	/**
	 * Add a Student to the student list where the teacher can:
	 * Enter the student's first name, last name, and grade(s).
	 * 
	 * @param nbStudent Number of students to add to the list.
	 * @return Student list.
	 */
	private static ArrayList<Student> addNbStudentInList(int nbStudent) {
		ArrayList<Student> studentList = new ArrayList<Student>(nbStudent);
		int nbStudentCreate = 0;

		while (nbStudentCreate < nbStudent) {
			Student student = new Student();
			student.modifyNameStudent();
			student.addMultipleNote();

			studentList.add(student);
			nbStudentCreate++;
		}

		return studentList;
	}

	/**
	 * Tell the teacher how many students he or she would like to add.
	 * 
	 * @return The number of student(s) to add.
	 */
	private static int inputNbStudent() {
		int nbStudent = -1;

		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("Combien d'élèves avez-vous dans votre classe ?");
			try {
				nbStudent = sc.nextInt();
				if (nbStudent < 0) {
					nbStudent = -1;
					System.out.println("Veuillez entrer une valeur positive.");
				}
			} catch (Exception e) {
				System.err.println("La saisie n'est pas un nombre entier.");
			}
		} while (nbStudent == -1);

		return nbStudent;
	}

	/**
	 * Search for a student in the list by entering their first and last name.
	 * When entering the student's full name, be sure to use the correct uppercase and lowercase letters.
	 * 
	 * @param studentList Student list.
	 */
	private static void searchStudent(ArrayList<Student> studentList) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Quelle nom cherchez-vous ?");
		String searchLastName = sc.nextLine();
		System.out.print("Quelle prénom cherchez-vous ?");
		String searchFirstName = sc.nextLine();

		boolean isInList = false;
		for (Student student : studentList) {
			if (student.getFirstName().equals(searchFirstName) && student.getLastName().equals(searchLastName)) {
				System.out.print(student);
				System.out.println(": " + student.displayAllNotes() + ", Moyenne: " + average(student.getNoteList()));
				isInList = true;
			}
		}

		if (!isInList) {
			System.out.println("Ce que vous cherchez n'est pas dans la liste.");
		}
	}

	/**
	 * Rename a student in the student list if their full name appears in that list.
	 * 
	 * @param studentList Student list.
	 * @param firstName The first name to search for in student list.
	 * @param lastName The last name to search for in student list.
	 * @return Student list with the student's name updated.
	 */
	private static ArrayList<Student> renameStudent(ArrayList<Student> studentList, String firstName, String lastName) {
		for (Student student : studentList) {
			if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
				System.out.println("On renomme cet élève: " + student.toString());
				student.modifyNameStudent();
			}
		}

		return studentList;
	}

	/**
	 * Sort a list of students by first name using the Gnome sorting algorithm.
	 * @see <a href="https://www.sortvisualizer.com/gnomesort/">Gnome Sort</a>
	 * 
	 * @param studentList Student list.
	 * @return Sorted list of students.
	 */
	private static ArrayList<Student> sortFirstName(ArrayList<Student> studentList) {
		for (int index = 1; index < studentList.size(); index++) {
			for (int index2 = index; index2 > 0; index2--) {
				Student studentFirstName1 = studentList.get(index2);
				Student studentFirstName2 = studentList.get(index2 - 1);
				if (studentFirstName1.getFirstName().compareTo(studentFirstName2.getFirstName()) < 0) {
					studentList.set(index2, studentFirstName2);
					studentList.set(index2 - 1, studentFirstName1);
				} else {
					break;
				}
			}
		}

		return studentList;
	}
	
	/**
	 * Reverse the sort order of a list of students sorted by first name.
	 * 
	 * @param studentList Student list.
	 * @return List of students in reverse order.
	 */
	private static ArrayList<Student> reverseSortFirstName(ArrayList<Student> studentList) {
		studentList = sortFirstName(studentList);

		for (int index = 0; index < studentList.size() / 2; index++) {
			int indexOppositeArray = studentList.size() - index - 1;
			Student tmp = studentList.get(index);
			studentList.set(index, studentList.get(indexOppositeArray));
			studentList.set(indexOppositeArray, tmp);
		}
		return studentList;
	}

	private static void showListStudent(ArrayList<Student> studentList) {
		for (Student student : studentList) {
			System.out.println(student);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Student> studentList = addNbStudentInList(inputNbStudent());
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Voulez-vous chercher un élève ?[o/n]");
			String inputSearchStudent = sc.nextLine();

			if (inputSearchStudent.equalsIgnoreCase("o")) {
				searchStudent(studentList);
			} else if (inputSearchStudent.equalsIgnoreCase("n")) {
				break;
			} else {
				System.err.println("Saisie incorrect !");
			}
		}

		System.out.println("-------- Les prénoms en ordre croissante -------------");
		showListStudent(sortFirstName(studentList));

		System.out.println("-------- Les prénoms en ordre décroissante -------------");
		showListStudent(reverseSortFirstName(studentList));

		boolean wantRenameStudent = true;

		while (wantRenameStudent) {
			System.out.print("Voulez-vous renommez un élève ?[o/n]");
			String inputSearchStudent = sc.nextLine();

			if (inputSearchStudent.equalsIgnoreCase("o")) {
				System.out.print("Saisir le nom de l'élève qui faut modifier:");
				String targetLastName = sc.nextLine();
				System.out.print("Saisir le prénom de l'élève qui faut modifier:");
				String targetFirstName = sc.nextLine();
				renameStudent(studentList, targetFirstName, targetLastName);

			} else if (inputSearchStudent.equalsIgnoreCase("n")) {
				wantRenameStudent = false;
			} else {
				System.err.println("Saisie incorrect !");
			}
		}

		showListStudent(sortFirstName(studentList));

		sc.close();
	}
}
