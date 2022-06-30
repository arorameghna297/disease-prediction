package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.ConnectionFactory;

@WebServlet("/LoginPatient")
public class LoginPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String puser = request.getParameter("puser");
		String ppass = request.getParameter("ppass");
		System.out.println(puser);
		System.out.println(ppass);

		try {
			
			String sql="select * from Patient where puser=? and ppass=?";

			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, puser);
			pstmt.setString(2, ppass);
			
			ResultSet resultSet = pstmt.executeQuery();

			if (resultSet.next() == true) {		
			
				response.sendRedirect("patient1.html");
				

			} else {
				
				PrintWriter writer = response.getWriter();
				writer.print("ELSE: Something went wrong, Go back and try again");
			}

		} catch (Exception e) {
			
			System.out.println("AddPatient "+e);
			PrintWriter writer = response.getWriter();
			writer.print("E: Something went wrong, Go back and try again");

		}
		
		
		
		
		
	}

}
