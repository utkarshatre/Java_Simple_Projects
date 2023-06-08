package com;

public class DefaultException extends ArithmeticException {

	String value;
	DefaultException(String value)
	{
		this.value=value;
	}
	@Override
	public String getMessage() {
		return value;
	}
}
