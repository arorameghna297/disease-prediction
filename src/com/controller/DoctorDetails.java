package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.ConnectionFactory;

public class DoctorDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		try
		{
		String sql="select * from doctor where username=? and password=?";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,username);
		pstmt.setString(2,password);

		ResultSet resultSet = pstmt.executeQuery();
 
		if (resultSet.next() == true) {
			

			/*student = new Student();
			student.setSid(resultSet.getString("sid"));
			student.setSname(resultSet.getString("sname"));
			student.setSaddress(resultSet.getString("saddress"));*/

		} else {
			// record not available

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
		
		
		
		
	}

}
