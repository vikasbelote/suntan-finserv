package com.suntan.finserv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR,reason = "Error Occured while excuting this request.")
public class RestException extends RuntimeException {

}
