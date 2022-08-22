package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import config.DBConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Training
 */
public class Training extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Training() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("i am training");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		System.out.println("inside training post");
		
		System.out.println("start date is " + request.getParameter("startDate"));
		
		String trainingName = request.getParameter("TrainingName");
		String trainingMode = request.getParameter("trainingMode");
		Date startDate = Date.valueOf(request.getParameter("startDate"));
		Date endDate = Date.valueOf(request.getParameter("endDate"));
		String contactPersonId = request.getParameter("contactPersonId");
		String businisessUnit = request.getParameter("businisessUnit");
		
		Connection connection = DBConfig.getConnection();
		String insertTraining = "Insert into Training (TrainingName, StartDate, EndDate, TrainingMode , BusinisessUnit , ContactPersonID) "
				+ "values (?,?,?,?,?,?)";

		 PreparedStatement	pstmt = connection.prepareStatement(insertTraining);
			pstmt.setString(1, trainingName);
			pstmt.setDate(2, startDate);
			pstmt.setDate(3, endDate);
			pstmt.setString(4, trainingMode);
			pstmt.setString(5, businisessUnit);
			pstmt.setString(6, contactPersonId);
			int rows = pstmt.executeUpdate();
			
			if (rows > 0) {
				System.out.println("inserting Training succeded");
				response.sendRedirect("admin");
			}
		} catch (SQLException e) {
			System.out.println("error inserting Training");
			throw new ServletException(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
