package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher req = request.getRequestDispatcher("index.jsp");
		req.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("login post invoked");
		RequestDispatcher req = null;
		try {

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Connection connection = DBConfig.getConnection();

			String query = "SELECT * FROM Users WHERE name = ? and password = ?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				System.out.print("Name: " + rs.getString("name") + ", ");
				System.out.print("Password: " + rs.getString("password") + ", ");
				System.out.print("type: " + rs.getString("type"));
				System.out.println();

				if (rs.getString("type").equals("A")) {
					response.sendRedirect("admin");
					System.out.println("I am after send redirect");
				} else {
					req = request.getRequestDispatcher("jsps/employee.jsp");
					req.include(request, response);
				}
			} else {
				req = request.getRequestDispatcher("jsps/error.jsp");
				req.include(request, response);
			}
		} catch (SQLException e) {
			throw new IOException(e.getMessage());
		}
	}

}
