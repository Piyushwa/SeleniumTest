package testscripts;

import java.io.IOException;
import org.testng.annotations.Test;
import utitlities.*;
import baseClass.DriverHelper;
import pages.*;

public class TestCase1 extends DriverHelper {

	
	@Test
	public static void test_Sce1() throws InterruptedException, IOException,Exception{
		// Logs - helps the User to understand the test steps or any failure during the test case execution.
		
		Logs.take_logs("TestCase1","Login on OLP URL");
		
		LoginPage lp = new LoginPage(driver);
		
		//Login method helps to login with different users
		
		lp.loggedin("pwadhwa@ctdi.com","1Nd1@123");
		
		Logs.take_logs("TestCase1","Logged In OLP URL");
	       Thread.sleep(2000);
		CreateOrder co = new CreateOrder(driver);
		co.Createorderform();
		Thread.sleep(3000);
		ReceiveOrder ro = new ReceiveOrder(driver);
		ro.Receiveorderform();
		
		
		
		
		
		
	}

}
