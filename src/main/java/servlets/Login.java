package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.H2Config;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("login post invoked");
		RequestDispatcher req = null;
		try {
			
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Connection connection = H2Config.getConnection();
		
		 String query = "SELECT * FROM Users WHERE name = ? and password = ?";
	      //Creating the PreparedStatement object
	      PreparedStatement pstmt = connection.prepareStatement(query);
	      pstmt.setString(1, username);
	      pstmt.setString(2, password);
	      ResultSet rs = pstmt.executeQuery();
	      
	      if(rs.next()) {
	         
	    	 System.out.print("Name: "+rs.getString("name")+", ");
	         System.out.print("Password: "+rs.getString("password")+", ");
	         System.out.print("type: "+rs.getString("type"));
	         System.out.println();
	         
	         if(rs.getString("type").equals("A")) {
	        	 req = request.getRequestDispatcher("jsps/admin.jsp");    	 
	         }else {
	        	 req = request.getRequestDispatcher("jsps/employee.jsp");
	         }
	    
	         req.include(request, response);
	      }else {
	    	  //error page here
	      }
		} catch (SQLException e) {
			throw new IOException(e.getMessage());
		}
	}

}
