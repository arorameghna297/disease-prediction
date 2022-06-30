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

public class UpdatePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("UP");
		
		String name = request.getParameter("name");
		String puser = request.getParameter("puser");
		String ppass = request.getParameter("ppass");
		String age = request.getParameter("age");
		String id = request.getParameter("id");
		String date = request.getParameter("date");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String status = request.getParameter("status");
		String disease = request.getParameter("disease");
		String room = request.getParameter("room");
		
		try
		{
		
		String sql = "Update Patient set name=?,age=?,"
				+ "gender=?,address=?,phone=?,status=?,disease=?,room=?,date=?,puser=?,ppass=? where id=?";
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, age);
		pstmt.setString(3, gender);
		pstmt.setString(4, address);
		pstmt.setString(5, phone);
		pstmt.setString(6, status);
		pstmt.setString(7, disease);
		pstmt.setString(8, room);
		pstmt.setString(9, date);
		pstmt.setString(10, puser);
		pstmt.setString(11, ppass);
		pstmt.setString(12, id);

		
		int e = pstmt.executeUpdate();
		
		if(e==1)
		{
			System.out.println("updated");
			PrintWriter writer = response.getWriter();
			writer.print("<html><h2 style= 'text-align: center; color: green;'>Patient Details Updated Successfully</h2></html>");
			
		}
		else
		{
			PrintWriter writer = response.getWriter();
			writer.print("<html><h2 style= 'text-align: center; color: red;'>Something went wrong, Go back and try again</h></html>");
			
		}
		
		
		}

    	catch (Exception e) {
		
		System.out.println("AddPatient "+e);
		PrintWriter writer = response.getWriter();
		writer.print("<html><h2 style= 'text-align: center; color: red;'>Something went wrong, Go back and try again</h></html>");

	}
		
		
	}

}
