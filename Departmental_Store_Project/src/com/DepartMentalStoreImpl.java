package com;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DepartMentalStoreImpl implements DepartMentalStore
{
	Scanner ip = new Scanner(System.in);

	//Key -> Product ID -> Integer & Value -> Product Instance/Object -> Product
	Map<Integer,Product>db = new LinkedHashMap<Integer,Product>();
	int totalBill = 0;

	@Override
	public void addProduct()
	{
		db.put(1, new Product("Milky Bar",10,10));
		db.put(2, new Product("Biscuts",20,20));
		db.put(3, new Product("Sprite",10,35));
		//		db.put(4, new Product("Coke",5,35));
		//		db.put(5, new Product("Kit-kat",10,20));
		//		db.put(6, new Product("Lifeboy",3,35));
		//		db.put(7, new Product("Dairy Milk",5,20));
		//		db.put(8, new Product("Sneaker",10,10));


	}

	@Override
	public void displayProduct() 
	{
		Set<Integer> keys=db.keySet();
		for(Integer key : keys)
		{
			Product p = db.get(key);
			System.out.println("Enter "+key+" to Order "+p.getName());
			System.out.println("Available quantity: "+p.getQuantity());
			System.out.println("Cost per pice: "+p.getCost());
			System.out.println("--------------------------------------------------------");
		}

	}

	@Override
	public void buyproduct()
	{
		System.out.println("Enter Choice ");
		int choice = ip.nextInt();
		Product p =db.get(choice);
		if(p != null)
		{
			System.out.println("Enter the Quantity: ");
			int quantity = ip.nextInt();
			if(quantity <= p.getQuantity())
			{
				//calculating current product cost 
				int productCost = quantity*p.getCost();

				//Adding productCost to total bill
				totalBill += quantity*p.getCost();

				//Updating the new Quantity
				p.setQuantity(p.getQuantity()-quantity);

				System.out.println("Ordered "+quantity+" "+p.getName());
				System.out.println("product Cost: "+productCost);
				System.out.println("Total Bill as of now: "+totalBill);
			}
			else
			{
			
				try {
					
					String mess="Invalid Quantity"+p.getName()+" is not Available:";
					throw new InvalidQuantityException(mess);
				}
				catch(Exception e)
				{
					System.out.println("check");
					e.getMessage();
				}

			}
		}
		else
		{
			try {
				String mess="Invalid Choice Please Enter The Valid Choice:";
				throw new InvalidChoiceException(mess);
			}
			catch(Exception e)
			{
				e.getMessage();
			}
		}




	}

	@Override
	public void checkout()
	{
		System.out.println("Total Bill : "+totalBill);
		System.out.println("Thank you for shopping");

	}




}