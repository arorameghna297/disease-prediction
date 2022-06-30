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
public class ReadAllDisease extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		try {
			
			String sql="select * from Disease";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()==true) {
				
				String id=resultSet.getString("id");
				String name = resultSet.getString("name");
				String symptom1 = resultSet.getString("symptom1");
				String symptom2 = resultSet.getString("symptom2");
				String symptom3 = resultSet.getString("symptom3");
				String type = resultSet.getString("typeofdisease");
				
				PrintWriter writer = response.getWriter();
				writer.print(
						
						
						
			         "<html>"
			    +   "Id: "+id+"<br>"	
			    +   "name: "+name+"<br>"			
			    +   "symptom1: "+symptom1+"<br>"			
			    +   "symptom2: "+symptom2+"<br>"			
			    +   "symptom3: "+symptom3+"<br>"			
			    +   "Type of Disease: "+type+"<br><br>"			
			    			


			    +    "</html>");

				
				

				
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
