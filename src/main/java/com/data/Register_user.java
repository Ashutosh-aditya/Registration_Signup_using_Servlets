package com.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register_user")
public class Register_user extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException {
		String url="jdbc:mysql://localhost:3306/users";
		String uname="root";
		String upw="0000";
		String query="Select * from records";
		String name,password,phone,gender;
		int age=0;
		
		name=req.getParameter("name");
		password=req.getParameter("password");
		phone=req.getParameter("phone");
		if(req.getParameter("age")==null)
			age=0;
		else
			age=Integer.parseInt(req.getParameter("age"));
		
		gender=req.getParameter("gender");
		
		String q2="INSERT INTO records (name, password, phone, age, gender) VALUES ('"+name+"','"+password+"','"+phone+"',"+age+",'"+gender+"');";
		PrintWriter out = resp.getWriter();
//		out.print(q2);
		System.out.println(q2);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Connection failed"+e);
		}
		
		try {
		Connection con = DriverManager.getConnection(url,uname,upw);
		System.out.println("Connection Successful");
		Statement st = con.createStatement();
		int r = st.executeUpdate(q2);
		System.out.println(r);
		resp.setContentType("text/html");
		
		if(r==1) {
			out.print("<h3 style='color:green'> Registration Successful </h3> ");

		}
		
		else {
			out.print("<h3 style='color:red'> Registration Failed  </h3><br>"
					+ " <a href=\"login.html\"><button class=\"submit\">Login</button></a>"
					+ " <a href=\"register.html\"><button class=\"submit\">register</button></a>");
			
		}
		
//		ResultSet res =st.executeQuery(query);
//
//		while (res.next()) {
//            System.out.println(res.getString("name"));
//        }

        // Close the resources
//        res.close();
        st.close();
        con.close();
		}
		catch(Exception e) {
			System.out.println("Error Occured");
		}
		
		}
}
