package utitlities;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnectivity {
	
	
 
	public static String Dbconn(String Query, String username, String password) throws ClassNotFoundException, SQLException
	{
		 String ResultQ = null;
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  

		//step2 create  the connection object  
		Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@bbopmcsd.CTDI.COM:1826:bbopmcsd",username,password);  

		//step3 create the statement object  
		Statement stmt=con.createStatement();  

		//step4 execute query  
		ResultSet rs=stmt.executeQuery(Query); 
		
		
	
		while(rs.next())  {
			
			 ResultQ = rs.getString("NUMBER").toString();
		
		System.out.println(ResultQ);
		//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  


		//step5 close the connection object  
		
	
		}
		con.close();
		return ResultQ;
		

	
		}
		

		
		catch(Exception e){ System.out.println(e);}
		return ResultQ;  

		}  

}
		
	

	
	
