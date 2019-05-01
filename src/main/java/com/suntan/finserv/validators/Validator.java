package com.suntan.finserv.validators;

public interface Validator {
	
	public <T> boolean validate(T dto, Class<T> model);

}
