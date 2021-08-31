package com.example.demo.utils.exception;

import org.apache.log4j.Logger;

import java.util.HashMap;


public class ConstantErrors {

	public static final HashMap<String, UMBError> ERRORS_STATES = new HashMap<>();
	final static Logger logger = Logger.getLogger(ConstantErrors.class);
	
	static {
		ERRORS_STATES.put(UMBErrorEnum.SUCCESS_TRANSACTION.getCode(), new UMBError(UMBErrorEnum.SUCCESS_TRANSACTION.getCode(),"SU transacción  fue procesa con exito."));

		ERRORS_STATES.put(UMBErrorEnum.GENERIC_ERROR.getCode(), new UMBError(UMBErrorEnum.GENERIC_ERROR.getCode(),"Se presentaron problemas tecnicos por favor intente nuevamente."));

		ERRORS_STATES.put(UMBErrorEnum.LOGIN_PASSWORD_AND_USER_CONSULTING.getCode(), new UMBError(UMBErrorEnum.LOGIN_PASSWORD_AND_USER_CONSULTING.getCode(),"Por favor revise el usuario o clave digitado."));

		ERRORS_STATES.put(UMBErrorEnum.DATABASE_OBJECT_CONSULTING.getCode(), new UMBError(UMBErrorEnum.DATABASE_OBJECT_CONSULTING.getCode(),"No tenemos registro asociados para esta solicitud."));
	}
}
