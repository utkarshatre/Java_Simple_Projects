

package sdbms;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		System.out.println("welcomme to student database management system");
		System.out.println("================================================");
		Scanner ip = new Scanner(System.in);
		StudentManagementSystem sms = new StudentManagementSystemImpl();
		while(true) {
			System.out.println("1:  Add Student\n2:  DisplayStudent");
			System.out.println("3:  DisplayAllStudent\n4:  RemoveStudent");
			System.out.println("5:  RemoveAllStudent\n6:  CountStudent");
			System.out.println("7:  SortStudent\n8:  GetStudentWithHighestMarks");
			System.out.println("9:  GetStudentWithLowestMarks\n10: Exit");
			int choice=ip.nextInt();
			switch(choice) {
			case 1: 
		         sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudent();
			case 4:
				sms.removeStudent();
			case 5:
				sms.removeAllStudent();
			case 6:
				sms.countStudent();
			case 7:
				sms.sortStudent();
			case 8:
				sms.getStudentWithHighestMarks();
			case 9:
				sms.getStudentWithLowestMarks();
			case 10:
				System.out.println("Thankyou");
				System.exit(0);
			default:
				           //custom exception
				try {
					String msg="Invalid choice !kindly enter valid choice";
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			} //end 
			System.out.println("_-----------------------------------------------------_");
		}

	}
}
