package com;
public class InsufficentBalanceException extends RuntimeException {
	public String message;
	InsufficentBalanceException(String message){
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	
}
//Rules to work with Custom /Userdefiend Exception
// 1 create a class with the exception name
// 2 If class creats run time exception so UNCHECKED exception
//   class creates Exception so CHECKED Exception
// 3 OVerride getMessage() [with variable cunstructor and a method] which is in throwable
// 4 Invoke the exception Object using throw keyord
//   handel it by using try and catch block uing suitable message