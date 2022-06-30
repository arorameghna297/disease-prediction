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

public class DoctorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);

		try {
			
			String sql="select * from Doctor where username=? and password=?";

			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet resultSet = pstmt.executeQuery();

			if (resultSet.next() == true) {		
			
				response.sendRedirect("doctor.html");
				

			} else {
				
				PrintWriter writer = response.getWriter();
				writer.print("<html>"
						+ "<h2 style='color:red; text-align:center;'>Something went wrong, Go back and try again<h2>"
						+"</html>");
			}

		} catch (Exception e) {
			
			System.out.println("AddPatient "+e);
			PrintWriter writer = response.getWriter();
			writer.print("<html>"
					+ "<h2 style='color:red; text-align:center;'>Something went wrong, Go back and try again<h2>"
					+"</html>");

		}
		
		
		
	}

}
