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
	
	String UserFistname = ReadExcelFile.getCellData(33,1);
	String UserLastname = ReadExcelFile.getCellData(33,2);
	String UserUsername = ReadExcelFile.getCellData(33,3);
	String UserUsermail = ReadExcelFile.getCellData(33,4);
	String UserRole = ReadExcelFile.getCellData(33,5);


driver.findElement(By.xpath(loc_Settings)).click();
	
Thread.sleep(3000);
		
driver.findElement(By.xpath(loc_UserMaster)).click();
	
Thread.sleep(3000);

driver.findElement(By.xpath(loc_CreateNewuser)).click();
	
Thread.sleep(3000);
	

driver.findElement(By.xpath(loc_UserFname)).sendKeys(UserFistname);

driver.findElement(By.xpath(loc_UserLastname)).sendKeys(UserLastname);

driver.findElement(By.xpath(loc_UserUsername)).sendKeys(UserUsername);

driver.findElement(By.xpath(loc_UserEmail)).sendKeys(UserUsermail);

WebElement Userrole =   driver.findElement(By.xpath(loc_UserRole));
Userrole.sendKeys(UserRole);
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
	
ReadExcelFile.setExcelFile(filepath,"input");
	
	String RoleName = ReadExcelFile.getCellData(33,6);
	String RoleType = ReadExcelFile.getCellData(33,7);

	
	driver.findElement(By.xpath(loc_Settings)).click();
	
	Thread.sleep(3000);
			
	driver.findElement(By.xpath(loc_UserMaster)).click();
		
	Thread.sleep(3000);
	
	driver.findElement(By.xpath(loc_UserRolebutton)).click();
	
	Thread.sleep(6000);
	
	driver.findElement(By.xpath(loc_CreateRolebutton)).click();
	Thread.sleep(3000);
	

driver.findElement(By.xpath(loc_Rolename)).sendKeys(RoleName);

WebElement  RolePermission = driver.findElement(By.xpath(loc_UserRolePermission));

RolePermission.sendKeys(RoleType);
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
