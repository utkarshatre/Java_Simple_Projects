package sdbms;

public class Student {
	private String id;
	private int age;
	private String name;
	private int marks;
	static int count=101;
	public Student(String name,int age, int marks) {
		this.id = "jsp"+count;
		this.name = name;
		this.age = age;
		this.marks = marks;
		count++;
	}
	public String getId() {
		return id;
	}
	public  void setId(String id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer  getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override	
	public String toString() {
		return "Student Details \nid    : "+id+"\nage   : "+age+"\nname  : "+name+"\nmarks : "+marks+"";
	}
	
}

