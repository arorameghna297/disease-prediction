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

public class FindMyDisease extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String symptom1 = request.getParameter("symptom1");
		String symptom2 = request.getParameter("symptom2");
		String symptom3 = request.getParameter("symptom3");
		
		System.out.println(symptom1);
		System.out.println(symptom2);
		System.out.println(symptom2);


		
		try
		{
	    String sql="select name from Disease where "
	    		+ "symptom1=? and symptom2=? and symptom3=?";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,symptom1);
		pstmt.setString(2,symptom2);
		pstmt.setString(3,symptom3);
		ResultSet resultSet = pstmt.executeQuery();
		System.out.println(resultSet);

		if (resultSet.next() == true) {

			System.out.println("ffff");
			String name = resultSet.getString("name");
			PrintWriter writer = response.getWriter();
			writer.print("<html><h2 style='text-align: center; color: blue;'>Expected Disease: " +name+"</h2></html>");
			
		   }
		else
		{
			System.out.println("else");
			PrintWriter writer = response.getWriter();
			writer.print("<html><br><h2 style='text-align: center; color: blue;'>Sorry.. AI is Unable to Detect Your Disease</h2>"
					+ "<h2 style='text-align: center; color: red;'>Please, Consult A Doctor</h2></html>");
		}
			

		
	} catch (Exception e) {
		e.printStackTrace();
		PrintWriter writer = response.getWriter();
		writer.print("<html><h2 style='text-align: center; color: red;'>Something went wrong</h2></html>");
	}
	
		
	}

}
