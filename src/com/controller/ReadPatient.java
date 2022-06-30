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

public class ReadPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			String id = request.getParameter("id");
			String sql="select * from Patient where id=?";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			ResultSet resultSet = pstmt.executeQuery();

			while(resultSet.next()==true)
			{
				System.out.println("inside while");
				
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
			         + "<h2 style= 'color: #17A2B8; text-align: center;'>Patient Information</h2>"
			         + "<table border='1' style='width:80%; margin:auto; text-align:center; ' >"
				         + "<tr style = 'background-color: lightgray;'>"
				         	+ "<th>Id</th>"
				         	+ "<th>Name</th>"
				         	+ "<th>Age</th>"
				         	+ "<th>Date</th>"
				         	+ "<th>Address</th>"
				         	+ "<th>Phone</th>"
				         	+ "<th>Status</th>"
				         	+ "<th>Room</th>"
				         	+ "<th>Disease</th>"
				         	+ "<th>Gender</th>"
				         + "</tr>"
				         + "<tr>"
						    +   "<td>"+id+"</td>"	
						    +   "<td>"+name+"</td>"			
						    +   "<td>"+age+"</td>"			
						    +   "<td>"+date+"</td>"			
						    +   "<td>"+address+"</td>"			
						    +   "<td>"+phone+"</td>"			
						    +   "<td>"+status+"</td>"			
						    +   "<td>"+room+"</td>"
						    +   "<td>"+disease+"</td>"		
						    +   "<td>"+gender+"</td>"
						 + "<tr>"
					 + "</table>"			
				+"</html>"); 
			}
			
			if(resultSet.next()==false)
			{
				PrintWriter writer = response.getWriter();

				writer.print("<html><h5 style='text-align: center; color: blue;'>No More Data Found</h5></html>");
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			PrintWriter writer = response.getWriter();

			writer.print("<html><h2 style='text-align: center; color: red;'>Something went wrong, Go back and try again</h2></html>");
		}
		
		
	}

}
