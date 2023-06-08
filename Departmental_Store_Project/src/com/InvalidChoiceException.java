package com;

public class InvalidChoiceException extends Exception
{
	String mess;
	public InvalidChoiceException(String mess)
	{
		this.mess=mess;
	}
	
	@Override
	public String getMessage()
	{
		return mess;
	}

}
