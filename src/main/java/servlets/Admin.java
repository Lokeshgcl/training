package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.DBConfig;
import dao.TrainingDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin
 */
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<model.TrainingModel> trainingList = TrainingDAO.getAllTrainings();
		
		request.setAttribute("TrainingList", trainingList);
		
		request.getRequestDispatcher("/jsps/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionType = request.getParameter("actionType");
		try {

			if (actionType.equals("AddTraining")) {
				request.getRequestDispatcher("/jsps/training.jsp").forward(request, response);
			} else if (actionType.equals("DeleteTraining")) {
				
				List<model.TrainingModel> trainingList = TrainingDAO.getAllTrainings();
				
				request.setAttribute("TrainingList", trainingList);
				request.getRequestDispatcher("/jsps/delete-training.jsp").forward(request, response);
			}

			System.out.println("trainings fetched successfully!");
		} catch (Exception e) {
			System.out.println("error while fetching trainings!");
			throw new ServletException(e.getMessage());
		}
	}
}
