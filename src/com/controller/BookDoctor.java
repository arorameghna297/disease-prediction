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


public class BookDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("ys");
		
		String did = request.getParameter("did");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		

		try {

			
	String sql="insert into Booking(did,name,phone) values (?,?,?)";

			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, did);
			pstmt.setString(2, name);
			pstmt.setString(3, phone);
			


			int x = pstmt.executeUpdate();
			if (x == 1) {
			
				PrintWriter writer = response.getWriter();
				writer.print("<html><h2 style='color: green; text-align: center;'>Booking Successfully</h2></html>");
				

			} else {
				
				PrintWriter writer = response.getWriter();
				writer.print("<html><h2 style='color: red; text-align: center;'>Something went wrong, Go back and try again</h2></html>");
			}

		} catch (Exception e) {
			
			System.out.println("AddPatient "+e);
			PrintWriter writer = response.getWriter();
			writer.print("<html><h2 style='color: red; text-align: center;'>Something Went Wrong</h2></html>");

		}
		
		
		
		
		
		
	}

}
