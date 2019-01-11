package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import locators.CommonLoctors;

public class LogsViewer implements CommonLoctors {
	
	static String filepath = System.getProperty("user.dir") +"\\TestData\\Inputfile.xlsx";

	WebDriver driver;



	public LogsViewer(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver;
		 
		 }
	
	public void LogViewerDashboard() throws InterruptedException,Exception{
		
		driver.findElement(By.xpath(loc_Settings)).click();
		driver.findElement(By.xpath(loc_logviewer)).click();
		driver.findElement(By.xpath(loc_Processdatefrom)).sendKeys("01/01/2019");

		driver.findElement(By.xpath(loc_Processdateto)).sendKeys("01/01/2019");

		driver.findElement(By.xpath(loc_ApplyFilter)).click();


		
	}
	

}