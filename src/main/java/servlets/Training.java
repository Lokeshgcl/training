package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import config.DBConfig;
import dao.TrainingDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TrainingModel;

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
		System.out.println("inside training post");
		String actionType = request.getParameter("actionType");

		if (actionType.equals("AddTraining")) {
			TrainingModel training = new TrainingModel(request.getParameter("trainingName"),
					Date.valueOf(request.getParameter("startDate")), Date.valueOf(request.getParameter("endDate")),
					request.getParameter("trainingMode"), request.getParameter("businisessUnit"),
					request.getParameter("contactPersonId"));

			TrainingDAO.addTraining(training);
			
			
		} else if (actionType.equals("DeleteTraining")) {
			System.out.println("delete trainings called");
			String s[] = request.getParameterValues("trainingCheckBox");
			
			TrainingDAO.deleteTrainings(s);
		}
		response.sendRedirect("admin");
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

		String s[] = request.getParameterValues("trainingCheckBox");

	}

}
