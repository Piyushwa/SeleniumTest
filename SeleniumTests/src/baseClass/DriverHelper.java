package baseClass;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import locators.CommonLoctors;
import utitlities.*;


public class DriverHelper implements CommonLoctors {
	
	public static WebDriver driver;
	
	public static String chromedriverPath = "C:\\Users\\IT\\workspace\\Zebra\\chromedriver.exe";
	public static String IEdriverPath = "C:\\Users\\IT\\workspace\\Zebra\\IEDriverServer.exe";
	public static String firefoxdriverPath = "C:\\Users\\IT\\workspace\\Zebra\\geckodriver.exe";
	public static String Browser  = PropertyReader.readpropertyfile("browser");
	public static String ZebraURL  = PropertyReader.readpropertyfile("Zurl");
	
	
	public static ExtentReports report;
	
	public static ExtentTest test;
	
	@BeforeTest
	
	public static void extentreport(){
		report = new ExtentReports("C:\\Users\\IT\\workspace\\SeleniumTests\\ExtentReports\\ExtentReportResults.html", true);
		//report.loadconfig(new File(pathname));
		test = report.startTest("DriverClass");
		
		
		test.log(LogStatus.PASS,"Browser Launched");
	}
			
@BeforeSuite

	public static WebDriver getBrowser() throws Exception 
	{
	
		
	//ReadExcelFile.setExcelFile("C:\\Users\\IT\\workspace\\SeleniumTests\\TestData\\Inputfile.xlsx","input");
	//String Browser = ReadExcelFile.getCellData(1, 1);	
		if (Browser.equalsIgnoreCase("firefox")){
			
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffprofile = profile.getProfile("default");
			
			 // System.setProperty("webdriver.gecko.driver",firefoxdriverPath);
				driver = new FirefoxDriver();					
		}
		
		else if (Browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver",chromedriverPath);
			driver = new ChromeDriver();		
		}
		
	else if (Browser.equalsIgnoreCase("ie")){
			
			File file = new File(IEdriverPath);
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			
			driver =new InternetExplorerDriver();

		}	
		
		else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
		
		Thread.sleep(6000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.navigate().to(ZebraURL);
		// Login into Application
		
		Thread.sleep(6000);
	
		return driver;
		
		
		
	}

@BeforeMethod

public void BeforeMethod() throws InterruptedException{
	
	Thread.sleep(3000);
	
}
	

public static String getDateStamp() {
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	return sdf.format(date);
}


public static void clickWebelement(WebElement element){
	
	try {
		boolean elementIsClickable = element.isEnabled();
		while (elementIsClickable) {
		element.click();
		}

		} catch (Exception e) {
			
		//System.out.println(“Element is not enabled”);
		
		e.printStackTrace();
		}
}

public  static void sendKeys(WebElement element, String TestData){
	

		try {
			
			element.clear();
			element.sendKeys(TestData);
			utitlities.Logs.take_logs("DriverHelper", element + "data is entered");
		} catch (Exception e) {
			
			e.printStackTrace();

		}
		
		
}
public static void waitTillElementFound(WebElement ElementTobeFound,
int seconds) {
WebDriverWait wait = new WebDriverWait(driver, seconds);
wait.until(ExpectedConditions.visibilityOf(ElementTobeFound));
}

public static void waitMyTime(int i) {
driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);

}


public static void checkbox_Checking(WebElement checkbox) {
boolean checkstatus;
checkstatus = checkbox.isSelected();
if (checkstatus == true) {
	
	System.out.println("Checkbox is already checked");
} else {
checkbox.click();
System.out.println("Checked the checkbox");

}
}

public static void radiobutton_Select(WebElement Radio) {
boolean checkstatus;
checkstatus = Radio.isSelected();
if (checkstatus == true) {
	System.out.println("RadioButton is already checked");

} else {
Radio.click();
System.out.println("Selected the Radiobutton");


}
}

// Unchecking
public static void checkbox_Unchecking(WebElement checkbox) {
boolean checkstatus;
checkstatus = checkbox.isSelected();
if (checkstatus == true) {
checkbox.click();

System.out.println("Checkbox is unchecked");

} else {
	
	System.out.println("Checkbox is already unchecked");

}
}

public static void radioButton_Deselect(WebElement Radio) {
boolean checkstatus;
checkstatus = Radio.isSelected();
if (checkstatus == true) {
Radio.click();
System.out.println("Radio Button is deselected");

} else {
	System.out.println("Radio Button was already Deselected");

}
}

public static void doubleClickWebelement(WebElement doubleclickonWebElement)
throws InterruptedException {
Actions builder = new Actions(driver);
builder.doubleClick(doubleclickonWebElement).perform();
Thread.sleep(2000);

}

public static void switchToParentWindow() {
driver.switchTo().defaultContent();
}

public static void switchToNewWindow() {

	Set<String> windows = driver.getWindowHandles();

for(String winHandle : windows){
	 driver.switchTo().window(winHandle);
}
}
public static void scrolltoElement(WebElement ScrolltoThisElement) {
	
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrolltoThisElement);

}

public static void pressKeyDown(WebElement element) {
element.sendKeys(Keys.DOWN);
}

public static void pressKeyEnter(WebElement element) {
element.sendKeys(Keys.ENTER);
}

public static void pressKeyUp(WebElement element) {
element.sendKeys(Keys.UP);
}

public static String getToolTip(WebElement toolTipofWebElement)
throws InterruptedException {
String tooltip = toolTipofWebElement.getAttribute("title");
System.out.println("Tool Text :" +tooltip);
return tooltip;
}

public static void navigate_forward() {
driver.navigate().forward();
}

public static void navigate_back() {
driver.navigate().back();
}

public static void refresh() {
driver.navigate().refresh();
}

public static void clickusingjavaexceutor(WebElement elem){
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", elem);
}


public static void mouseClickByLocator( WebElement MouseClickElem ) {
    
    Actions builder = new Actions(driver);
    builder.moveToElement(MouseClickElem).click(MouseClickElem);
    builder.build().perform();
}


	public static void selectDropdownValue(WebElement elem, String DropDownValue, String loctor ) throws Exception{
		
			try {
				Select select = new Select(driver.findElement(By.xpath(loctor)));
				select.selectByVisibleText(DropDownValue);
			
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			} 
		}
	
/*@AfterSuite
public void browser_close()
{
	driver.close();
	
	utitlities.SendMailSSLWithAttachment.sendmail();
	//test.log(LogStatus.PASS, "Browser Closed Successfully");
	//	report.flush();
	report.close();
}*/

@AfterMethod
	
	public void aftermethod() throws InterruptedException{

DriverHelper.navigate_back();

Thread.sleep(2000);
}
	
}
