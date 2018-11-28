package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
			
		public static String PropertiesfilePath = "C:\\Users\\IT\\workspace\\SeleniumTests\\Environmentconfig.properties";


		public static String readpropertyfile(String key){

			String value = "";
			File f = new File(PropertiesfilePath);
			
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();
			
			//load properties file
			try {
				prop.load(fileInput);
				value = prop.getProperty(key);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			 return value;
		}



	}


