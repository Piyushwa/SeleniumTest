package utitlities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
	
	 public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws IOException{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(fileWithPath);

	                //Copy file at destination
	                
	                FileUtils.copyFile(SrcFile, DestFile);
	                
	 }	              

	//public static void getScreenShotOnCheckpointFailure(String Methodname) throws IOException{
		/*Methodname = Methodname.replace("*", "").replace(":", "").replace(":", "").replace("+", "").replace(" ", "");
		Date date = new Date();
		SimpleDateFormat sdf3 = new SimpleDateFormat("MM-dd-yyyy h-mm-ss a");
		String imagePath1 = "C:\\Users\\IT\\workspace\\SeleniumTests\\Screenshots";
		String formattedDate3 = sdf3.format(date);
		String imageName=Methodname.replace("*", "")+"_CheckpointFailure_"+formattedDate3+".jpg";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile, new File(imagePath1 + File.separator + imageName)); 	
		String FullPath = imagePath1+File.separator+imageName;		
		System.out.println(FullPath);
	}*/

}
