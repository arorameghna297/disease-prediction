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


public class MyAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
try {
			int count=1;
			String did = request.getParameter("did");
			System.out.println(did);
			String sql="select * from Booking where did=?";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,did);
			ResultSet resultSet = pstmt.executeQuery();
			System.out.println(resultSet);
			
			
			PrintWriter writer = response.getWriter();
			
			
			writer.print("<html><h2 style= 'text-align: center; color: #17A2B8'>My Appointments<h2></html>"	
			         );
			


			while(resultSet.next()==true) {
				
				System.out.println("inside");
				String name = resultSet.getString("name");
				int phone = resultSet.getInt("phone");
				System.out.println(name);
				System.out.println(phone);;
				
				//PrintWriter writer = response.getWriter();
								
				writer.print(
						
						"<html>"
						
						        +"<table border='1' style='width:80%; margin:auto; text-align:center;'>"
						        + "<tr style='background-color: lightgray; '>"
						        + "<th>Appointment No.</th>"
						        + "<th>Patient Name</th>"
						        + "<th>Patient Contact Number</th>"
						        + "</tr>"
						
						+ "<tr>"
					         + "<td>"+count+"</td>"
					         + "<td>"+name+"</td>"
					         + "<td>"+phone+"</td>"
					     + "</tr>"
					  +"</table>"
					  +"<html>" );

				
             count++; 
			} 
			
			if(resultSet.next()==false)
			{
				//PrintWriter writer = response.getWriter();
				writer.print(
					 	
						
						
			         "<html>"
						+"<h5 style= 'color: blue; text-align: center;'>No more data found<h5>"
			   
		        +"<html>" );
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter writer = response.getWriter();
			writer.print(
					
					
					
		         "<html>"
					+"<h2 style= 'color: red; text-align: center;'>No data found<h2>"
		   
	        +"<html>" );
			
		}
		
		
		
		
	}

}
