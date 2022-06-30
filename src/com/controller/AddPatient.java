package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.ConnectionFactory;

public class AddPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		try {

			String sql = "insert into Patient(id,name,age"
					+ ",gender,address,phone,status,disease,room,date,puser,ppass) values (?,?,?,?,?,?,?,?,?,?,?,?)";

			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, age);
			pstmt.setString(4, gender);
			pstmt.setString(5, address);
			pstmt.setString(6, phone);
			pstmt.setString(7, status);
			pstmt.setString(8, disease);
			pstmt.setString(9, room);
			pstmt.setString(10, date);
			pstmt.setString(11, puser);
			pstmt.setString(12, ppass);


			int x = pstmt.executeUpdate();
			if (x == 1) {
				
				System.out.println("done");
				
				PrintWriter writer = response.getWriter();
				writer.print("<html>"
						+ "<h1 style='text-align:center; color:green;  '>Patient Inserted Successfully<h1>"
						+"</html>");

			} else {
				
				PrintWriter writer = response.getWriter();
				writer.print("<html><h2 style= 'text-align: center; color: red;'>Something went wrong, Go back and try again</h></html>");

			}

		} catch (Exception e) {
			
			PrintWriter writer = response.getWriter();
			writer.print("<html><h2 style= 'text-align: center; color: red;'>Something went wrong, Go back and try again</h></html>");
			System.out.println("AddPatient "+e);

		}

	}

}
