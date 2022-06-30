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


public class SearchDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		
		try
		{
		String sql="select * from Doctor where name=?";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,name);
		ResultSet resultSet = pstmt.executeQuery();

		if (resultSet.next() == true) {
			

			
		    String id = resultSet.getString("id");
			String age = resultSet.getString("age");
			String date = resultSet.getString("date");
			String address = resultSet.getString("address");
			String phone = resultSet.getString("phone");
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
		         + "<h2 style='color: #17A2B8; text-align: center;'>Doctor's Information</h2>"
		         + "<table border='1' style='width:80%; margin:auto; text-align:center; '>"
		         	+ "<tr style='background-color: lightgray'>"
			         	+ "<th>Id</th>"
			         	+ "<th>Name</th>"
			         	+ "<th>Age</th>"
			         	+ "<th>Date</th>"
			         	+ "<th>Address</th>"
			         	+ "<th>Phone</th>"
			         	+ "<th>Status</th>"
			         	+ "<th>Blood</th>"
			         	+ "<th>Department</th>"
			         	+ "<th>E-mail</th>"
			         	+ "<th>Room No.</th>"
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
					    +   "<td>"+blood+"</td>"			
					    +   "<td>"+dept+"</td>"			
					    +   "<td>"+email+"</td>"			
					    +   "<td>"+room+"</td>"	
					    +   "<td>"+gender+"</td>"
					 + "</tr>"
				+ "</table>"
					    		+ "<br><br>"			

			+   " <form action='BookDoctor' method='post'  style='width:30%; margin:auto; text-align:center; background-color:skyblue; ' >"
				+ "<fieldset>"
				+ "<legend><h5 style='color: blue; text-align: center;'>Get Appoinment</h5></legend>"
		            +   " <input type='text' name='did'  placeholder='Doctor ID'> <br><br>"
		            +   " <input type='text' name='name'  placeholder='Patient Name'> <br><br>"
		            +   " <input type='number' name='phone'  placeholder='Phone Number'> <br><br>"
		            +   " <input type='submit' value='submit'>"
		        + "</fieldset>"
		    +    "</form>"
		    +"</body>"
		    +"</html>");

		} else {
			PrintWriter writer = response.getWriter();
			writer.print("<html><h2 style='color: red; text-align: center;'>Something went wrong, Go back and try again</h2></html>");
		}
	} catch (Exception e) {
		e.printStackTrace();
		PrintWriter writer = response.getWriter();

		writer.print("<html><h2 style='color: black; text-align: center;'>Something went wrong, Go back and try again</h2></html>");

	}
	
		
		
	}

}
