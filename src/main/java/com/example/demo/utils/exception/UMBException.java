package com.example.demo.utils.exception;

import org.apache.log4j.Logger;

public class UMBException extends Exception {

    final static Logger logger = Logger.getLogger(UMBException.class);
    private static final long serialVersionUID = 4607469051774932616L;

    public UMBException(String code) {
        super(code);
    }
}
