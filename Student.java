package studentutils;

public class Student {
	private int id;
	private String name;
	private int age;
	private String city;
	
	// must create argument-less constructor as well!
	public Student() {
		
	}
	
	public Student(int id, String name, int age, String city) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "\nStudent [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}
}
