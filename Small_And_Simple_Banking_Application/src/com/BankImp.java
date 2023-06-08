package com;

class BankImp implements Bank {
	int balance;
	BankImp(int balance){
		this.balance=balance;
	}
	@Override
	public void deposit(int amount) {
		System.out.println("depositing amount: "+amount);
		balance+=amount;
		System.out.println("amount "+amount+ " deposit successfully and blc is "+balance);
	}
	@Override
	public void withdraw(int amount) {
		System.out.println("withdrawing amount: "+amount);
		if(amount<=balance) {
		balance-=amount;
		System.out.println("amount "+amount+ " withdrawing successfully and blc is "+balance);
		}
		else {
			try {
				throw new InsufficentBalanceException("Insufficent Balance");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public int getBalance(){
		return balance;
	}
}
