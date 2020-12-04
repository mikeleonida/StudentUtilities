package StudentUtils;

public class StudentUtils {
	private static Student[] students;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		students = new Student[4];
		
		students[0] = new Student(100, "Mike", 42, "New York");
		students[1] = new Student(101, "Emmanuel", 29, "Atlanta");
		students[2] = new Student(102, "Sean", 31, "Manhattan");
		students[3] = new Student(103, "Darren", 27, "Brooklyn");
		
		printCurrentStudents();
		
		System.out.println("Student with id 102 is: " + getStudentById(102));
		System.out.println("Students named Darren are: ");
		Student[] namedStudents =  getStudentsByName("darren");
		for (int i=0; i<namedStudents.length; i++) {
			System.out.println(namedStudents[i]);
		}
		if (updateStudent(100, "Michael", 37, "Bronx")) {
			System.out.println("Updated student: " + getStudentById(100));
		} else {
			System.out.println("Update not possible");
		}
		if (removeStudent(101)) {
			System.out.println("Student with id 101 removed");
		} else {
			System.out.println("No student with id 101");
		}
		printCurrentStudents();
		if (removeStudent(101)) {
			System.out.println("Student with id 101 removed");
		} else {
			System.out.println("No student with id 101");
		}
		printCurrentStudents();
		
		Student[] s =  getOlderStudents(28);
		System.out.println("Students older than 28:");
		for (int i=0; i<s.length; i++) {
			System.out.println(s[i]);
		}
		s =  getYoungerStudents(50);
		System.out.println("Students younger than 50:");
		for (int i=0; i<s.length; i++) {
			System.out.println(s[i]);
		}

	}

	public static Student getStudentById(int id) {
		for (Student s : students) {
			if (s.getId() == id) {
				return s;
			}
		}

		return null;
	}
	
	public static Student[] getStudentsByName(String name) {
		Student[] nameStudents = new Student[students.length];
		int count = 0;
		for (Student s : students) {
			if (s.getName().equalsIgnoreCase(name)) {
				nameStudents[count++] = s;
			}
		}
		
		return nameStudents;
	}
	
	public static boolean updateStudent(int id, String name, int age, String city) {
		for (Student s : students) {
			if (s.getId() == id) {
				s.setName(name);
				s.setAge(age);
				s.setCity(city);
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean removeStudent(int id) {
		Student[] newStudentArr = new Student[(students.length)-1];
		for (int i = 0; i<students.length; i++) {
			if (i != (students.length-1)) {
				newStudentArr[i] = students[i]; // copy to new array just in case we remove
			}
			if (students[i].getId() == id) {
				for (int j = i; j < (students.length-1) ; j++) {
					newStudentArr[j] = students[j+1];
				}
				students = newStudentArr;
				return true;
			}
		}
		return false;
	}
	
	public static Student[] getStudentsByCity(String city) {
		Student[] cityStudents = new Student[students.length];
		int count = 0;
		for (Student s : students) {
			if (s.getCity().equalsIgnoreCase(city)) {
				cityStudents[count++] = s;
			}
		}
		
		return cityStudents;
	}
	
	public static Student[] getOlderStudents(int age) {
		if (age < 0) {
			return null;
		}
		Student[] olderStudents = new Student[students.length];
		int count = 0;
		for (Student s : students) {
			if ( s.getAge() > age ) {
				olderStudents[count++] = s;
			}
		}
		
		return olderStudents;
	}
	
	public static Student[] getYoungerStudents(int age) {
		if (age < 0) {
			return null;
		}
		Student[] youngerStudents = new Student[students.length];
		int count = 0;
		for (Student s : students) {
			if ( s.getAge() < age ) {
				youngerStudents[count++] = s;
			}
		}
		
		return youngerStudents;
	}
	
	private static void printCurrentStudents() {
		System.out.println("Current students are: ");
		for (int i = 0; i<students.length; i++) {
			System.out.println(students[i]);
		}
	}
}
