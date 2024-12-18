package com.itranswarp.learnjava;

public class BaseException extends RuntimeException {

	public BaseException() {
		super();
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

}

class UserNotFoundException extends BaseException{
	UserNotFoundException(String s){
		System.out.println(s);
	}
}

class LoginFailedException extends BaseException{
	public LoginFailedException(String s) {
		System.out.println(s);
	}
}