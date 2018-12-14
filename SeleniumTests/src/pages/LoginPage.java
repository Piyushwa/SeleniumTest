package pages;

import static org.testng.Assert.assertEquals;
import baseClass.DriverHelper;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

import baseClass.*;
import locators.CommonLoctors;
import utitlities.*;




public class LoginPage implements CommonLoctors {

	//public static String User  = PropertyReader.readpropertyfile("Username");

	//public static String Pass  = PropertyReader.readpropertyfile("Password");
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		 this.driver = driver;
		 
		 }

	public void loggedin(String usernamevalue, String passwordvalue) throws InterruptedException, Exception {
		
		Logs.take_logs("Login", "Entered Username");	   
		
		WebElement username = driver.findElement(By.id(loc_Username));
		
		DriverHelper.sendKeys(username, usernamevalue);
		
		Logs.take_logs("Login", "Entered Username");	   
		
		//username.sendKeys(usernamevalue);
		

	WebElement Password = driver.findElement(By.id(loc_PassWord));
	Password.sendKeys(passwordvalue);
	
	Logs.take_logs("Login", "Entered Password");	 
	
	WebElement Submit = driver.findElement(By.xpath(loc_LoginSubmit));

      Submit.click();	
      
      WebElement HomepageOLP = driver.findElement(By.xpath("//a/span[2]/img[contains(@src,'olp-logo')]"));
      
      System.out.println(HomepageOLP.getText());
		
      DriverHelper.waitTillElementFound(HomepageOLP, 90);

   String Homepage =   driver.getTitle();
   
   String ExpectedHomepage = "B2B OLP";
   
   if(Homepage.equalsIgnoreCase(ExpectedHomepage)){
	   
Logs.take_logs("Login", "Login Successfully");	   

   }
   
   else {
	   
	   
	   Logs.take_logs("Login", "Login Fial");	   
	   
Screenshots.takeSnapShot(driver, "C:\\Users\\IT\\workspace\\SeleniumTests\\Screenshots\\testimage.png");

   }
   //assertEquals(Homepage, ExpectedHomepage);
   
    
	

}

}