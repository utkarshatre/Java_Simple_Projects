package com;

public class InvalidQuantityException  extends Exception
{
	String mess;
	public InvalidQuantityException(String mess)
	{
		this.mess=mess;
	}
	
	@Override
	public String getMessage()
	{
		return mess;
	}

}
