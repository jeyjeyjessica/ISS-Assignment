package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 Testing whether request is properly routed or not
		PrintWriter out = response.getWriter();
		out.print("working");
		*/
		
		//Taking the data from the form
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String repeat_password = request.getParameter("re_pass");
		String mobile = request.getParameter("contact");
		
		RequestDispatcher dispatcher = null;
		
		/*
		 Testing whether data is sent correctly or not
		 PrintWriter out = response.getWriter();
		out.print(name);
		 */
		
		//Server side validation
		
		if(email==null || email.equals("") ) {
			request.setAttribute("status", "invalidEmail");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		if(password==null || password.equals("") ) {
			request.setAttribute("status", "invalidPassword");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}else if(!password.equals(repeat_password)) {
			request.setAttribute("status", "invalidPasswordConfirm");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		if(name==null || name.equals("") ) {
				request.setAttribute("status", "invalidName");
				dispatcher = request.getRequestDispatcher("register.jsp");
				dispatcher.forward(request, response);
			}
			if(mobile==null || mobile.equals("")) {
				request.setAttribute("status", "invalidMobile");
				dispatcher = request.getRequestDispatcher("register.jsp");
				dispatcher.forward(request, response);
			} else if(mobile.length()>10) {
				request.setAttribute("status", "invalidMobileLength");
				dispatcher = request.getRequestDispatcher("register.jsp");
				dispatcher.forward(request, response);
			}
		//Database logic
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  //MySQL package
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","A2009SJs!");
			PreparedStatement pst = conn.prepareStatement("INSERT into USERS(username,userpwd,email,mobile) VALUES(?,?,?,?);");
			pst.setString(1, name);
			pst.setString(2, password);
			pst.setString(3, email);
			pst.setString(4, mobile);
			
			int rowCount = pst.executeUpdate(); //returns 1 if row is inserted
			
			dispatcher = request.getRequestDispatcher("registration.jsp");
			//to check if the row is inserted successfully in the database
			if (rowCount>0) {
				request.setAttribute("status", "success"); //status passed to the jsp page and based on that alert is displayed
			}else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
