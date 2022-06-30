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

public class ReadDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private static ResultSet resultSet;  
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			
			String id = request.getParameter("id");
			System.out.println(id);
			
			try
			{
			String sql="select * from Doctor where id=?";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			resultSet = pstmt.executeQuery();
			
		
                       
			while(resultSet.next()==true)
			{
				System.out.println("inside while");
				
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
			         "<html><body><h2 style= 'color: #17A2B8; text-align: center;'>"
			         + "<br>Doctor's Information</h2><table border='1' style='width:80%; margin:auto; text-align:center; '>"
			         + "<tr style='background-color :lightgrey'><th>ID</th><th>name</th>"
			         + "<th>age</th>"
			         + "<th>date</th>"
			         + "<th>address</th>"
			         + "<th>phone</th"
			         + "><th>status</th>"
			         + "<th>blood</th>"
			         + "<th>dept</th>"
			         + "<th>email</th>"
			         + "<th>room</th>"+ "<th>username</th>"+"<th>password</th>"+"<th>gender</th>"
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
			    +   "<td>"+username+"</td>"			
			    +   "<td>"+password+"</td>"		
			    +   "<td>"+gender+"</td>"			
			    +    "</tr></table><br></body></html>");

			}
			
			if(resultSet.next()==false)
			{
				PrintWriter writer = response.getWriter();

				writer.print("<html><h5 style='text-align: center; color:blue;'>No More Data Found<h5></html>");
				
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			PrintWriter writer = response.getWriter();

			writer.print("<html><h2 style='text-align: center;'>Something went wrong, Go back and try again</h></html>");
		}
		
	}

}
