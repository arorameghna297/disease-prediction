package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.ConnectionFactory;


public class EditDoctorDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		String status = request.getParameter("status");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(id);
		System.out.println(phone);
		System.out.println(status);
		System.out.println(email);
		System.out.println(username);
		System.out.println(password);

		
		try
		{
		String sql = "Update Doctor set phone=?,email=?,status=?,username=?,password=? where id=?";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, phone);
		pstmt.setString(2,email);
		pstmt.setString(3, status);
		pstmt.setString(4, username);
		pstmt.setString(5, password);
		pstmt.setString(6, id);

		int e = pstmt.executeUpdate();
		System.out.println(e);
		if(e==1)
		{
		
		PrintWriter writer = response.getWriter();
		writer.print("<html><h2 style='color: green; text-align: center;'><br><br><br>Doctor Details Updated Successfully</h2></html>");
		}
		else
		{
			System.out.println("else");
			PrintWriter writer = response.getWriter();
			writer.print("<html><h2 style='color: red; text-align: center;'><br><br><br>Something went wrong, Go back and try again</h2></html>");

		}

		
		}

    	catch (Exception e) {
		
		System.out.println("AddPatient "+e);
		PrintWriter writer = response.getWriter();
		writer.print("<html><h2 style='color: red; text-align: center;'><br><br><br>Something went wrong, Go back and try again</h2></html>");


	}
		
		
		
	}

}
