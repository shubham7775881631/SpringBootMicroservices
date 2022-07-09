package com.infy.demo;

import java.util.Properties;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static final Logger loggerApp =  Logger.getLogger(App.class);
	
	public App()  {
		 
		
	}
	
	
	
	
    
    
    public void configureLogging() throws Exception
	{
		
		Properties properties = new Properties();
		
		properties.setProperty("log4j.rootLogger","INFO,MyFileAPP");
//	    properties.setProperty("log4j.rootCategory","TRACE");

//	    properties.setProperty("log4j.appender.stdout",     "org.apache.log4j.ConsoleAppender");
//	    properties.setProperty("log4j.appender.stdout.layout",  "org.apache.log4j.PatternLayout");
//	    properties.setProperty("log4j.appender.stdout.layout.ConversionPattern","%d{yyyy/MM/dd HH:mm:ss.SSS} [%5p] %t (%F) - %m%n");

//	    properties.setProperty("log4j.logger.com.infy.demo.App", "ERROR,MyFileAPP");
//	    properties.setProperty("log4j.additivity.com.infy.demo.App", "false");
//	    properties.setProperty("log4j.appender.MyFileAPP", "org.apache.log4j.RollingFileAppender");
//	    properties.setProperty("log4j.appender.MyFileAPP.File", "D:\\Infosys\\MyFileAPP.log");
//	    properties.setProperty("log4j.appender.MyFileAPP.MaxFileSize", "100KB");
//	    properties.setProperty("log4j.appender.MyFileAPP.MaxBackupIndex", "1");
//	    properties.setProperty("log4j.appender.MyFileAPP.layout",  "org.apache.log4j.PatternLayout");
//	    properties.setProperty("log4j.appender.MyFileAPP.layout.ConversionPattern","%d{yyyy/MM/dd HH:mm:ss.SSS} [%5p] %t (%F) - %m%n");

		PropertyConfigurator.configure("P:\\SpringToolSuite-IDE\\STS-Workspace\\DemoLoggingProject\\log4j.properties");
		
	}
    
    
    
    
    public void testLog(int a) throws Exception
    {
    	configureLogging();
    	
    	
    	loggerApp.info("==========Inside testLog App class==========================================");
    	loggerApp.info("==========Inside testLog App class===================================");
    	loggerApp.info("==========Inside testLog App class=========================================");
    	loggerApp.info("==========Inside testLog App class==================================");
    
  
    	
    }
    
    

}
