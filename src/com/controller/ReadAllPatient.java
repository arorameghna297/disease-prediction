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

public class ReadAllPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
try {
			
			String sql="select * from Patient";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet resultSet = pstmt.executeQuery();

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
				String disease = resultSet.getString("disease");
				String room = resultSet.getString("room");
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
			    +   "room: "+room+"<br>"
			    +   "Disease: "+disease+"<br>"		
			    +   "gender: "+gender+"<br><br><br>"			


				
			    +    "</html>");
				

			 
			}
			
			if(resultSet.next()==false)
			{
				PrintWriter writer = response.getWriter();

				writer.print("No More Data Found");
				
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			PrintWriter writer = response.getWriter();

			writer.print("Something went wrong, Go back and try again");
		}
	}

}
