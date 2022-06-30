package com.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory{
	
	public static Connection con;
	
	public static Connection getConnection()
	{
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Hospital";
			String user="root";
			String pass="";
			con= DriverManager.getConnection(url,user,pass);
						
			
		}
		catch(Exception e)
		{
			System.out.println("fac "+e);
			
		}
		return con;
			
	}

}
