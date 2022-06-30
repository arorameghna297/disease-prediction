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


public class UpdateDisease extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String symptom1 = request.getParameter("symptom1");
		String symptom2 = request.getParameter("symptom2");
		String symptom3 = request.getParameter("symptom3");
		String typeofdisease = request.getParameter("typeofdisease");
		
		try
		{
		
		String sql = "Update Disease set name=?,symptom1=?,"
				+ "symptom2=?,symptom3=?,typeofdisease=? where id=?";
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, name);
		pstmt.setString(2, symptom1);
		pstmt.setString(3, symptom2);
		pstmt.setString(4, symptom3);
		pstmt.setString(5, typeofdisease);
		pstmt.setString(6, id);
		
		int e = pstmt.executeUpdate();
		
		if(e==1)
		{
			PrintWriter writer = response.getWriter();
			writer.print("<html><h2 style= 'color: green; text-align: center;'>Disease Info Updated Successfully</h2></html>");

		}
		else
		{
			PrintWriter writer = response.getWriter();
			writer.print("<html><h2 style= 'color: red; text-align: center;'>Something went wrong, Go back and try again</h2></html>");

		}
		
		
		
		}

    	catch (Exception e) {
		
		System.out.println("AddPatient "+e);
		PrintWriter writer = response.getWriter();
		writer.print("<html><h2 style= 'color: red; text-align: center;'>Something went wrong, Go back and try again.</h2></html>");


	}
	
		
	}

}
