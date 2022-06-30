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

public class DeletePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");

		try {
			String sql = "Delete from Patient where id=?";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int e = pstmt.executeUpdate();
			if (e==1) {
				
				System.out.println("done");
				PrintWriter writer = response.getWriter();
				writer.print("<html><h2 style= 'text-align: center; color: green;'>Patient's Info Deleted Successfully</h2></html>");


			} else {
				System.out.println("wrong");
				PrintWriter writer = response.getWriter();
				writer.print("<html><h2 style= 'text-align: center; color: red;'>Something went wrong, Go back and try again</h2></html>");

			}

		} catch (Exception e) {
			
			System.out.println(e);
			PrintWriter writer = response.getWriter();
			writer.print("<html><h2 style= 'text-align: center; color: red;'>Something went wrong, Go back and try again</h></html>");

		}

	}

}
