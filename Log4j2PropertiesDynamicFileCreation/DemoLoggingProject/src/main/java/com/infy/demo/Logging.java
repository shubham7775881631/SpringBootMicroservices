package com.infy.demo;

import java.util.Properties;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class Logging {
//
//	private static  Category LOGGER = Logger.getLogger("Logging");
	
	private static  Logger logger =  Logger.getLogger(Logging.class); ;
	private  static App app =  new App();
	
	public Logging() throws Exception {
		// TODO Auto-generated constructor stub
		
		 
		 configureLogging();
	}

	public Integer intrestCalculation(int a, int b) throws Exception {

		int c = a + b;
		app.testLog(c);
		logger.info("logging inside Logging class");
		return c;

	}
	
	public void configureLogging() throws Exception
	{
		
		Properties properties = new Properties();
		
		properties.setProperty("log4j.rootLogger","INFO, MyFile");
	    properties.setProperty("log4j.rootCategory","TRACE");
//
//	    properties.setProperty("log4j.appender.stdout",     "org.apache.log4j.ConsoleAppender");
//	    properties.setProperty("log4j.appender.stdout.layout",  "org.apache.log4j.PatternLayout");
//	    properties.setProperty("log4j.appender.stdout.layout.ConversionPattern","%d{yyyy/MM/dd HH:mm:ss.SSS} [%5p] %t (%F) - %m%n");
//	    properties.setProperty("log4j.logger.com.infy.demo.Logging", "INFO,MyFile");
//	    properties.setProperty("log4j.additivity.com.infy.demo.Logging", "false");
//	    properties.setProperty("log4j.appender.MyFile", "org.apache.log4j.RollingFileAppender");
//	    properties.setProperty("log4j.appender.MyFile.File", "D:\\Infosys\\MyFile.log");
//	    properties.setProperty("log4j.appender.MyFile.MaxFileSize", "100KB");
//	    properties.setProperty("log4j.appender.MyFile.MaxBackupIndex", "1");
//	    properties.setProperty("log4j.appender.MyFile.layout",  "org.apache.log4j.PatternLayout");
//	    properties.setProperty("log4j.appender.MyFile.layout.ConversionPattern","%d{yyyy/MM/dd HH:mm:ss.SSS} [%5p] %t (%F) - %m%n");

		PropertyConfigurator.configure("P:\\SpringToolSuite-IDE\\STS-Workspace\\DemoLoggingProject\\log4j.properties");
		
	}
     
	

	public static void main(String[] args) throws Exception {
		
		Logging logObj = new Logging();
		
		logObj.intrestCalculation(23,54);
	
	}

}
