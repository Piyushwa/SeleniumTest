package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import locators.CommonLoctors;
import utitlities.ReadExcelFile;
import utitlities.Screenshots;

public class UserMaster implements CommonLoctors {
	
static String filepath = System.getProperty("user.dir") +"\\TestData\\Inputfile.xlsx";

WebDriver driver;


public UserMaster(WebDriver driver) throws InterruptedException{
	
	 this.driver = driver;
	 
	 }

public void CreateNewUser() throws InterruptedException,Exception{
	
	
	ReadExcelFile.setExcelFile(filepath,"input");
	
driver.findElement(By.xpath(loc_Settings)).click();
	
Thread.sleep(3000);
		
driver.findElement(By.xpath(loc_UserMaster)).click();
	
Thread.sleep(3000);

driver.findElement(By.xpath(loc_CreateNewuser)).click();
	
Thread.sleep(3000);
	

driver.findElement(By.xpath(loc_UserFname)).sendKeys("Test");

driver.findElement(By.xpath(loc_UserLastname)).sendKeys("User");

driver.findElement(By.xpath(loc_UserUsername)).sendKeys("Tuser");

driver.findElement(By.xpath(loc_UserEmail)).sendKeys("Tuser@gmail.com");


WebElement Userrole =   driver.findElement(By.xpath(loc_UserRole));
Userrole.sendKeys("Developer");
Thread.sleep(6000);
Userrole.sendKeys(Keys.DOWN);
Userrole.sendKeys(Keys.ENTER);

driver.findElement(By.xpath(loc_CreateUserButton)).click();

Thread.sleep(6000);

driver.findElement(By.xpath(loc_SearchUserfilter)).sendKeys("Tuser");

driver.findElement(By.xpath(loc_SearchUserApplyFilter)).click();

List<WebElement> Usernamecol = driver.findElements(By.xpath("//div/div/table/tbody/tr/td[3]"));



for(int i=0;i<Usernamecol.size();i++){
       // match the content here in the if loop
	 
	 System.out.println("Size of Order" +Usernamecol.size());

	
	String UserName = Usernamecol.get(i).getText();
	System.out.println("Nu  is  " +UserName);
	System.out.println("Order is Created");
	
	Thread.sleep(4000);

	try{
Assert.assertEquals(UserName, "Tuser");
	}

	catch(Exception e){
		Screenshots.takeSnapShot(driver, "C:\\Users\\IT\\workspace\\SeleniumTests\\Screenshots\\Orderfail.png");
	}

	
}
	

}


public void CreateRoleUser() throws InterruptedException,Exception{
	
	driver.findElement(By.xpath(loc_Settings)).click();
	
	Thread.sleep(3000);
			
	driver.findElement(By.xpath(loc_UserMaster)).click();
		
	Thread.sleep(3000);
	
	driver.findElement(By.xpath(loc_UserRolebutton)).click();
	
	Thread.sleep(6000);
	
	driver.findElement(By.xpath(loc_CreateRolebutton)).click();
	Thread.sleep(3000);
	

driver.findElement(By.xpath(loc_Rolename)).sendKeys("Test");

WebElement  RolePermission = driver.findElement(By.xpath(loc_UserRolePermission));

RolePermission.sendKeys("ViewOrders");
Thread.sleep(6000);

RolePermission.sendKeys(Keys.DOWN);
RolePermission.sendKeys(Keys.ENTER);


driver.findElement(By.xpath(loc_CreateRoleButton)).click();

}


public void EditRoleUser() throws InterruptedException,Exception{
	
	driver.findElement(By.xpath(loc_Settings)).click();
	
	Thread.sleep(3000);
			
	driver.findElement(By.xpath(loc_UserMaster)).click();
		
	Thread.sleep(3000);
	
	driver.findElement(By.xpath(loc_UserRolebutton)).click();
	
	Thread.sleep(6000);
}
}
