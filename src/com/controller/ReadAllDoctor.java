package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.ConnectionFactory;

public class ReadAllDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ResultSet resultSet;  

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
		
		try
		{
		String sql="select * from Doctor";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
	
		resultSet = pstmt.executeQuery();
		
	
                   
		while(resultSet.next()==true)
		{
			System.out.println("inside while");
			String id = resultSet.getString("id");
			String name = resultSet.getString("name");
			int age = resultSet.getInt("age");
			String date = resultSet.getString("date");
			String address = resultSet.getString("address");
			long phone = resultSet.getLong("phone");
			String status = resultSet.getString("status");
			String blood = resultSet.getString("blood");
			String dept = resultSet.getString("dept");
			String email = resultSet.getString("email");
			String room = resultSet.getString("room");
			String username = resultSet.getString("username");
			String password = resultSet.getString("password");
			String gender = resultSet.getString("gender");
			
			PrintWriter writer = response.getWriter();
			writer.print(
					
					
					
		         "<html>"
		    +   "Id: "+id+"<br>"	
		    +   "name: "+name+"<br>"			
		    +   "age: "+age+"<br>"			
		    +   "date: "+date+"<br>"			
		    +   "address: "+address+"<br>"			
		    +   "phone: "+phone+"<br>"			
		    +   "status: "+status+"<br>"			
		    +   "Blood Group: "+blood+"<br>"			
		    +   "dept: "+dept+"<br>"			
		    +   "email: "+email+"<br>"			
		    +   "room: "+room+"<br>"
		    +   "username: "+username+"<br>"			
		    +   "password: "+password+"<br>"		
		    +   "gender: "+gender+"<br><br><br>"			


			
		    +    "</html>");
			

		 
		}
		
		if(resultSet.next()==false)
		{
			PrintWriter writer = response.getWriter();

			writer.print("No More Data found");
			
		}
		
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
		PrintWriter writer = response.getWriter();

		writer.print("Something went wrong, Go back and try again");
	}
	
	}

}
