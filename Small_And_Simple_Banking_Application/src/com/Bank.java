package com;

public interface Bank {
abstract void deposit(int amount);   //abstract and public is bydefault in interface
abstract void withdraw(int amount);
abstract int getBalance();
}
