package com;
import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		Bank superup=new BankImp(5000);
		while(true) {
			System.out.println("1: deposit \n2: withdraw\n3: check balance\n------exit------");
			int choice=ip.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter amount to deposit");
				int damount=ip.nextInt();   //
				superup.deposit(damount);    //superup.deposit(ip.nextInt());
				break;
			case 2:
				
				System.out.println("Enter amount to withdraw");
				int wamount=ip.nextInt();
				superup.withdraw(wamount);   //	superup.withdraw(ip.nextInt());
				break;
			case 3:
				System.out.println("Balance is "+superup.getBalance());
				break;
			case 4:
				System.out.println("thankyou visit again");
				System.exit(0);
				break;
			default:
				try {
					throw new DefaultException("3");
				}
				catch(Exception e){
					System.out.println("wrong choice and your balance is "+superup.getBalance());
				}
			}
			System.out.println("----------------------------------------");
		}


	}
}
