package utitlities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Logs {
	
	public static void take_logs(String Classname, String message)
	{
		String LogFilePath = System.getProperty("user.dir") +"\\log4j.xml";
		
		
		
		DOMConfigurator.configure(LogFilePath);
		
		Logger l = Logger.getLogger(Classname);
		
		l.info(message);
	}


}
