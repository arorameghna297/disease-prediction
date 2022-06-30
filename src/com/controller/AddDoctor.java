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

public class AddDoctor extends HttpServlet {
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

		try {

			
	String sql="insert into Doctor(id,name,age,gender,blood,dept,phone,"
	+ "email,status,address,room,date,username,password) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, age);
			pstmt.setString(4, gender);
			pstmt.setString(5, blood);
			pstmt.setString(6, dept);
			pstmt.setString(7, phone);
			pstmt.setString(8,email);
			pstmt.setString(9, status);
			pstmt.setString(10, address);
			pstmt.setString(11, room);
			pstmt.setString(12, date);
			pstmt.setString(13, username);
			pstmt.setString(14, password);


			int x = pstmt.executeUpdate();
			if (x == 1) {
			
				PrintWriter writer = response.getWriter();
				writer.print("<html><h2 style= 'color: green; text-align: center;'><br><br>Doctor's Info Added Successfully</h2></html>");
				

			} else {
				
				PrintWriter writer = response.getWriter();
				writer.print("<html>"
						+ "<h2 style= 'color: red; text-align: center;'><br><br>Something went wrong, Go back and try again<h2>"
						+"</html>");
			}

		} catch (Exception e) {
			
			System.out.println("AddPatient "+e);
			PrintWriter writer = response.getWriter();
			writer.print("<html>"
					+ "<h2 style= 'color: red; text-align: center;'><br><br>Something went wrong, Go back and try again<h2>"
					+"</html>");

		}
		
		
		
	}

}
