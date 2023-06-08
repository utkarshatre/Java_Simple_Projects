package com;

public class Employee {
	String id="jsp";
static int count=101;
String name;
Employee(String name){
	this.id="jsp"+count;
	this.name=name;
count++;
}
public static void main(String[] args) {
	Employee e1 = new Employee("Tom");
	System.out.println(e1.id+" "+e1.name);   //jsp101 Tom
	Employee e2 = new Employee("Tomy");
	System.out.println(e2.id+" "+e2.name);   //jsp102 Tomy
	Employee e3 = new Employee("Jerry"); 
	System.out.println(e3.id+" "+e3.name);   //jsp103 Jerry
	Employee e4 = new Employee("Jack");
	System.out.println(e4.id+" "+e4.name);   //jsp104 Jack
	Employee e5 = new Employee("JAcky");
	System.out.println(e5.id+" "+e5.name);   //jsp105 JAcky
}

}
