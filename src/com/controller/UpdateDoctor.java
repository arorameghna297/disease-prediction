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

public class UpdateDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String date = request.getParameter("date");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String status = request.getParameter("status");
		String blood = request.getParameter("blood");
		String dept = request.getParameter("dept");
		String email = request.getParameter("email");
		String room = request.getParameter("room");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		try
		{
		
		String sql = "Update Doctor set name=?,age=?,"
				+ "gender=?,blood=?,dept=?,phone=?,email=?,status=?,"
				+ "address=?,room=?,date=?,username=?,password=? where id=?";
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, name);
		pstmt.setString(2, age);
		pstmt.setString(3, gender);
		pstmt.setString(4, blood);
		pstmt.setString(5, dept);
		pstmt.setString(6, phone);
		pstmt.setString(7,email);
		pstmt.setString(8, status);
		pstmt.setString(9, address);
		pstmt.setString(10, room);
		pstmt.setString(11, date);
		pstmt.setString(12, username);
		pstmt.setString(13, password);
		pstmt.setString(14, id);

		int e = pstmt.executeUpdate();
		if(e==1)
		{
		
		PrintWriter writer = response.getWriter();
		writer.print("<html><h2 style='color: green; text-align: center;'>Doctor Details Updated Successfully</h2></html>");
		}
		else
		{
			PrintWriter writer = response.getWriter();
			writer.print("<html><h2 style='color: red; text-align: center;'>Something went wrong, Go back and try again</h2></html>");

		}

		
		}

    	catch (Exception e) {
		
		System.out.println("AddPatient "+e);
		PrintWriter writer = response.getWriter();
		writer.print("<html><h2 style='color: red; text-align: center;'>Something went wrong, Go back and try again</h2></html>");


	}
		
		
		
		
		
	}

}
