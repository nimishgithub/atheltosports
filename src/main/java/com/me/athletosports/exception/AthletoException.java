package com.me.athletosports.exception;

public class AthletoException extends Exception {
	public AthletoException(String message)
	{
		super(message);
	}
	
	public AthletoException(String message, Throwable cause)
	{
		super(message,cause);
	}
}