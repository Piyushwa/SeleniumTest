package utitlities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Logs {
	
	public static void take_logs(String Classname, String message)
	{
		
		DOMConfigurator.configure("C:\\Users\\IT\\workspace\\SeleniumTests\\log4j.xml");
		Logger l = Logger.getLogger(Classname);
		l.info(message);
	}


}
