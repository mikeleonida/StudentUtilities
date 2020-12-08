package StudentUtils;

import java.util.Arrays;

public class StudentUtils {
	private Student[] students;
	
	public StudentUtils(Student[] students) {
		super();
		boolean studentUtilsCreated = true;
		for (int i=0; (i<students.length && studentUtilsCreated); i++) {
			for (int j=i+1; j<students.length; j++) {
				if (students[i].getId() == students[j].getId()) {
					studentUtilsCreated = false;
					break;
				}
			}
		}
		if (studentUtilsCreated) {
			this.students = students;
		}
	}

	public Student getStudentById(int id) {
		for (Student s : students) {
			if (s.getId() == id) {
				return s;
			}
		}

		return null;
	}
	
	public Student[] getStudentsByName(String name) {
		int count = 0;
		for (Student s : students) {
			if (s.getName().equalsIgnoreCase(name)) {
				count++;
			}
		}
		
		Student[] nameStudents = new Student[count];
		count = 0;
		for (Student s : students) {
			if (s.getName().equalsIgnoreCase(name)) {
				nameStudents[count++] = s;
			}
		}
		
		return nameStudents;
	}
	
	public boolean updateStudent(int id, String name, int age, String city) {
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
	
	public boolean removeStudent(int id) {
		int numRemoved=0;
		for (int i=0; i<students.length; i++) {
			if (id == students[i].getId() ) {
				numRemoved++;
			}
		}
		if (numRemoved == 0) {
			return false;
		}
		
		Student[] newStudentArr = new Student[students.length-numRemoved];
		for (int i=0, j=0; i<students.length; i++, j++ ) {
			if (id != students[i].getId()) {
				newStudentArr[j] = students[i];
			} else {
				j--;
			}
		}
		
		students = newStudentArr;
		return true;
	}
	
	public Student[] getStudentsByCity(String city) {
		Student[] cityStudents = new Student[students.length];
		int count = 0;
		for (Student s : students) {
			if (s.getCity().equalsIgnoreCase(city)) {
				cityStudents[count++] = s;
			}
		}
		
		return cityStudents;
	}
	
	public Student[] getOlderStudents(int age) {
		if (age < 0) {
			return null;
		}
		
		int count = 0;
		for (Student s : students) {
			if (s.getAge() > age) {
				count++;
			}
		}
		if (count == 0) {
			return null;
		}
		
		Student[] olderStudents = new Student[count];
		count = 0;
		for (Student s : students) {
			if ( s.getAge() > age ) {
				olderStudents[count++] = s;
			}
		}
		
		return olderStudents;
	}
	
	public Student[] getYoungerStudents(int age) {
		if (age < 0) {
			return null;
		}
		
		int count = 0;
		for (Student s : students) {
			if (s.getAge() < age) {
				count++;
			}
		}
		if (count == 0) {
			return null;
		}
		
		Student[] youngerStudents = new Student[count];
		count = 0;
		for (Student s : students) {
			if ( s.getAge() < age ) {
				youngerStudents[count++] = s;
			}
		}
		
		return youngerStudents;
	}
	
	@Override
	public String toString() {
		return "Current students are: [students=" 
				+ Arrays.toString(students) + "]";
	}
}
