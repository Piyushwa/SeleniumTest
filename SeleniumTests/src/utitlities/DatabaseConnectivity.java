package utitlities;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseConnectivity {
	
	public static void Dbconn (String username, String password)
	{
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  

		//step2 create  the connection object  
		Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@bbopmcsd.CTDI.COM:1826:bbopmcsd",username,password);  

		//step3 create the statement object  
		Statement stmt=con.createStatement();  

		//step4 execute query  
		ResultSet rs=stmt.executeQuery("select * from ASSETS where ASSETTAG ='HWRF0001'");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		
		String ROnumber =  rs.getString("ASSETTAG");
		
		System.out.println("Rnumber is: " +ROnumber);

		//step5 close the connection object  
		con.close();  

		}catch(Exception e){ System.out.println(e);}  

		}  
		}  
	

	
	
