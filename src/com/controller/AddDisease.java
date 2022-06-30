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

public class AddDisease extends HttpServlet {
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
		
		String sql = "insert into Disease(id,name,symptom1"
				+ ",symptom2,symptom3,typeofdisease) values (?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, symptom1);
		pstmt.setString(4, symptom2);
		pstmt.setString(5, symptom3);
		pstmt.setString(6, typeofdisease);

		int x = pstmt.executeUpdate();
		if (x == 1) {
			
			PrintWriter writer = response.getWriter();
			writer.print(
					
					"<html>"
					+ "<h2 style='color: green; text-align:center;'>Disease Details Added Successfully<h2>"
					+"</html>");
			

		} else {
			
			PrintWriter writer = response.getWriter();
			writer.print("<html>"
					+ "<h2 style='color:red; text-align:center;'>Something went wrong, Go back and try again<h2>"
					+"</html>");

		}
		}

	 catch (Exception e) {
		
		System.out.println("AddPatient "+e);
		PrintWriter writer = response.getWriter();
		writer.print("<html>"
				+ "<h2 style='color:blue; text-align:center;'>Disease Info Already Exist<h2>"
				+"</html>");

		
	}


		
		
		
		
	}

}
