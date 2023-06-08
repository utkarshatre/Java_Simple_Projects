package sdbms; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import customexception.InvalidChoiceException;
import customexception.StudentnotfoundException;
import customsorting.SortStudentById;
import customsorting.SortStudentByName;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByAge;

public class StudentManagementSystemImpl implements StudentManagementSystem{
	Scanner ip = new Scanner(System.in);
	Map<String,Student> db = new LinkedHashMap<String,Student>();
	@Override
	public void addStudent() {
		System.out.println("enter student Name");
		String name = ip.next();
		System.out.println("enter student Age");
		int age = ip.nextInt();
		System.out.println("enter student Marks");
		int marks = ip.nextInt();
		Student std = new Student(name,age,marks);
		db.put(std.getId(),std);
	}
	@Override
	public void displayStudent() {
		System.out.println("Enter Stdent ID");
		String id = ip.next();
		id = id.toUpperCase();
		if(db.containsKey(id)) {
			Student std = db.get(id);
			System.out.println("id : "+std.getId());
			System.out.println("age : "+std.getAge());
			System.out.println("name : "+std.getName());
			System.out.println("marks : "+std.getMarks());
			//or can direclty	System.out.println(std); //direct output bcz tostring method is overriden
		}
		else {
			try {
				String message="Student with id "+id+" not found";
				throw new StudentnotfoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void displayAllStudent() {
		if(db.size()!=0) {
			Set<String> keys=db.keySet(); //jsp101,jsp102
			for(String key: keys) {
				Student std = db.get(key);
				System.out.println(std);
				// or directly System.out.println(db.get(key));
			}
		}
		else {
			try {
				String message="Student with no data found";
				throw new StudentnotfoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeStudent() {
		System.out.println("enteer student id");
		String id = ip.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student id found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student record deleted successfully");
		}
		else {
			try {
				String message = "Student with the id "+id+" not found";
				throw new StudentnotfoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudent() {
		if(db.size()!=0) {
			System.out.println("Studnt recode available "+db.size());
			db.clear();
			System.out.println("All student reord deleted suceessfuly");
			System.out.println("Studetn record avaibility "+db.size());
		}
		else {
			try {
				String message="Studnt database is exmpty nothing to delete";
				throw new StudentnotfoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateStudent() {
		System.out.println("Enter the updating id");
		String id = ip.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student id found");
			Student std = db.get(id);
			System.out.println("1: update age \n2: update name \n3: update marks");
			System.out.println("enter choice");
			int choice= ip.nextInt();
			switch(choice) {
			case 1:
				System.out.println("enter age");
				int age = ip.nextInt();
				std.setAge(age);
				break;
			case 2:
				System.out.println("enter name");
				String name = ip.next();
				std.setName(name);
				break;
			case 3:
				System.out.println("enter marks");
				int marks = ip.nextInt();
				std.setMarks(marks);
				break;
			default:
				try {
					String msg = "invalid choice kindly enter valid choice";
					throw new InvalidChoiceException(msg);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}
		else {
			try {
				String message = "Student with id "+id+" not present";
				throw new StudentnotfoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void countStudent() {
		System.out.println("no of students"+db.size());
	}
	@Override
	public void sortStudent() {
		Set<String> keys = db.keySet();
		List <Student> list = new ArrayList<Student>();
		for(String key : keys) {
			list.add(db.get(key));
		}
		int choice = ip.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(list,new SortStudentById());
			//for(Student s : list) {
			//System.out.println(s);
			display(list);
			break;
		case 2:
			Collections.sort(list,new SortStudentByName());
			//for(Student s : list) {
			//System.out.println(s);
			display(list);
			break;

		case 3:
			Collections.sort(list,new SortStudentById());
			//for(Student s : list) {
			//System.out.println(s);
			display(list);
			break;

		case 4:
			Collections.sort(list,new SortStudentByMarks());
			//for(Student s : list) {
			//System.out.println(s);
			display(list);
			break;
		default : try {
			throw new InvalidChoiceException("invalid choice");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			updateStudent();
		}
		}
	}
	public static void display(List<Student> list) {
		for(Student s : list) {
			System.out.println(s);
		}
	}	
	@Override
	public void getStudentWithHighestMarks() {
		Set<String> keys=db.keySet();
		List<Student> list = new ArrayList<Student>();
		for(String key : keys) {
			list.add(db.get(key));
		}
		Collections.sort(list, new SortStudentByMarks());
		System.out.println(list.get(list.size()-1));
	}
	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List<Student> list = new ArrayList<Student>();
			for(String key : keys) {
				list.add(db.get(key));
			}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(0));	
		}
	}
}

