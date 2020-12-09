package studentutils;

public class Main {

	public static void main(String[] args) {
		Student[] students = new Student[4];

		students[0] = new Student(100, "Mike", 42, "New York");
		students[1] = new Student(101, "Emmanuel", 29, "Atlanta");
		students[2] = new Student(102, "Sean", 31, "Manhattan");
		students[3] = new Student(103, "Darren", 27, "Brooklyn");

		StudentUtils su = new StudentUtils(students);
		
		System.out.println(su);

		System.out.println("Student with id 102 is: " + su.getStudentById(102));
		System.out.print("Students named Darren are: ");
		Student[] namedStudents = su.getStudentsByName("darren");
		for (int i = 0; i < namedStudents.length; i++) {
			System.out.println(namedStudents[i]);
		}
		if (su.updateStudent(100, "Michael", 37, "Bronx")) {
			System.out.println("Updated student: " + su.getStudentById(100));
		} else {
			System.out.println("Update not possible");
		}
		if (su.removeStudent(101)) {
			System.out.println("Student with id 101 removed");
		} else {
			System.out.println("No student with id 101");
		}
		System.out.println(su);
		if (su.removeStudent(101)) {
			System.out.println("Student with id 101 removed");
		} else {
			System.out.println("No student with id 101");
		}
		System.out.println(su);

		Student[] s = su.getOlderStudents(28);
		System.out.print("Students older than 28:");
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]);
		}
		System.out.println();
		
		s = su.getYoungerStudents(30);
		System.out.print("Students younger than 30:");
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]);
		}

	}

}
