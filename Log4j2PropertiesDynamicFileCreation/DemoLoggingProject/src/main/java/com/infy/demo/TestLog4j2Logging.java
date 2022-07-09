package com.infy.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

public class TestLog4j2Logging {
	
	private static final Logger log = LogManager.getLogger(TestLog4j2Logging.class);
	
	public TestLog4j2Logging() {
		logInfo("Logging has been initalized");
	}
	
	static {
		ThreadContext.put("keyname","P:/TestLogging/TestLog4j2Logging");
		Configurator.initialize(null, "./properties/log4j2.properties");
	}
	
	public  void testMsg()
	{
		
		String[] arr = {"Msg1111111111111","Msg222222222222222","Msg3333333333333","Msg44444444444"};
		for (String string : arr) {
			logInfo(string);
			logError(string);
			log.debug(string);
		}
	}
	
	public void logMqMsg() throws Exception
	{
		
		
		String[] mqArr = {"MQ111111111111111111","MQ222222222222222222222222","MQ3333333333333333333333"};
		for (String string : mqArr) {
			log.info(string);
		}
	}
	
	
	public static void main(String[] args) throws Exception
	{
		TestLog4j2Logging testLog4j2Logging = new TestLog4j2Logging();
//		System.setProperty("log4j2.configurationFile", "./properties/log4j2.properties");
//		String propertiesFile = "./log4j2.properties";  
//		ConfigurationSource source = new ConfigurationSource(new FileInputStream(propertiesFile));
	
		testLog4j2Logging.testMsg();
		ThreadContext.remove("keyname");
		ThreadContext.put("keyname", "P:/TestLogging/Queue.Name");
		testLog4j2Logging.logMqMsg();
		ThreadContext.remove("keyname");
		ThreadContext.put("keyname", "P:/TestLogging/TestLog4j2Logging");
		

//		try {
//			InputStream inputStream = new FileInputStream("./log4j2.properties");
//			ConfigurationSource source = new ConfigurationSource(inputStream);
//			Configurator.initialize(null, source);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		logInfo("Logging is Complted sucessfully");
		System.out.println("Messages are getting Logged");
	}
	
	private static String getCurrentDateAndTime() {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
//		   LocalDateTime now = LocalDateTime.now(); 
		return dtf.format(LocalDateTime.now());
	}
	
	private static void logInfo(String msg) {
		log.info("{} INFO {} - {}",getCurrentDateAndTime(),TestLog4j2Logging.class.getName(),msg);
	}
	
	private static void logError(String msg) {
		log.info("{} ERROR {} - {}",getCurrentDateAndTime(),TestLog4j2Logging.class.getName(),msg);
	}

}
