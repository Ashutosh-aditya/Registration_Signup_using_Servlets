package com.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login_user")
public class Login extends HttpServlet{
	@Override
	public void service(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException {
		String url="jdbc:mysql://localhost:3306/users";
		String uname="root";
		String upw="0000";
		String name,password;
		
		name=req.getParameter("name");
		password=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Connection failed"+e);
		}
		
		try {
		Connection con = DriverManager.getConnection(url,uname,upw);
		System.out.println("Connection Successful");
		Statement st = con.createStatement();

		String query="Select * from records where name='"+name+"' and password='"+password+"';";
//		System.out.println(query);
		ResultSet r = st.executeQuery(query);
//		System.out.println(r);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		if(r.next()) {
			out.print("<h3 style='color:green'> Login Successful </h3> <br>"
					+ "Welcome <b>"+r.getString("name")+"</b>");

		}
		
		else {
			out.print("<h3 style='color:red'> Login Failed  </h3><br>"
					+ "Username or Password didn't match <br>"
					+ " <a href=\"login.html\"><button class=\"submit\">Login</button></a>"
					+ " <a href=\"register.html\"><button class=\"submit\">register</button></a>");
			
		}

        st.close();
        con.close();
		}
		catch(Exception e) {
			System.out.println("Error Occured");
		}
		
	}

}
