package com.example.demo.utils.exception;

import org.apache.log4j.Logger;

public class UMBError {
	final static Logger logger = Logger.getLogger(UMBError.class);
	private String code;
	private String message;

	public UMBError(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
