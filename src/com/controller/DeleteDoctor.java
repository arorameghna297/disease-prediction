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

public class DeleteDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		try {
			String sql = "Delete from Doctor where id=?";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			int e = pstmt.executeUpdate();
			if (e==1) {
				
				PrintWriter writer = response.getWriter();
				writer.print("<html><h2 style='color: green; text-align: center;'>Doctor's Details Deleted Successfully</h2></html>");


			} else {
				
				PrintWriter writer = response.getWriter();
				writer.print("<html><h2 style='color: red; text-align: center;'>Something went wrong, Go back and try again</h2></html>");


			}

		} catch (Exception e) {
			
			PrintWriter writer = response.getWriter();
			writer.print("<html><h2 style='color: red; text-align: center;'>Something went wrong, Go back and try again</h2></html>");


		}

		

		
				
		
	}

}
