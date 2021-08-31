package com.example.demo.adapter;
import org.apache.log4j.Logger;
import org.springframework.core.env.ConfigurableEnvironment;

public class ApiConst {

    final static Logger logger = Logger.getLogger(ApiConst.class);
    
	protected ApiConst() {
		super();
	}

	public static final String LOGIN_PATH = "/UMB";
	
	public static final String SWAGGER_PATH = "com.co.umb.login.management";

	public static ConfigurableEnvironment CONFIGURABLE_PROPERTIES;

}