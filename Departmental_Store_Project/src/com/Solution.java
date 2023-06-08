package com;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		System.out.println("Welcome to shop");
		System.out.println("========================");
		Scanner ip = new Scanner(System.in);
		DepartMentalStore store = new DepartMentalStoreImpl();
		store.addProduct();
		int choice = 1;
		while(choice==1) {
			store.displayProduct();
			store.buyproduct();
			System.out.println("+====================================+");
			System.out.println("press 1 to continue or any other to checkout");
			choice = ip.nextInt();
		}
		store.checkout();
	}
}