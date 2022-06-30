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


public class ReadDisease extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");

		try {
			
			String sql="select * from Disease where id=?";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()==true) {
				
				String name = resultSet.getString("name");
				String symptom1 = resultSet.getString("symptom1");
				String symptom2 = resultSet.getString("symptom2");
				String symptom3 = resultSet.getString("symptom3");
				String type = resultSet.getString("typeofdisease");
				
				PrintWriter writer = response.getWriter();
				writer.print(
						
						
						
			         "<html>"
			         + "<h2 style= 'text-align: center; color:#17A2B8;'>Disease Information</h2>"
			         + "<table border='1' style='width:80%; margin:auto; text-align:center; '>"
			         	+ "<tr style= 'background-color: lightgray;'>"
			         		+ "<th>Id</th>"
			         		+ "<th>Name</th>"
			         		+ "<th>Symptom 1</th>"
			         		+ "<th>Symptom 2</th>"
			         		+ "<th>Symptom 3</th>"
			         		+ "<th>Type</th>"
			         	+ "</tr>"
			         	+ "<tr>"
						    +   "<td>"+id+"</td>"	
						    +   "<td>"+name+"</td>"			
						    +   "<td>"+symptom1+"</td>"			
						    +   "<td>"+symptom2+"</td>"			
						    +   "<td>"+symptom3+"</td>"			
						    +   "<td>"+type+"</td>"
						+ "</tr>"
					 + "</table>"			
			    +    "</html>");

				
			}
			
			if(resultSet.next()==false) {
				
				PrintWriter writer = response.getWriter();
				writer.print("<html> <h5 style= 'text-align: center; color:blue;'>No More Data Found<h5> </html>");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter writer = response.getWriter();
			writer.print("<html> <h2 style= 'text-align: center; color: red;'>Something went wrong, Go back and try again<h2></html>");
		}
		
	}

}
