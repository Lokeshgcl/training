package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.DBConfig;
import jakarta.servlet.ServletException;
import model.TrainingModel;

public class TrainingDAO {

	public static List<model.TrainingModel> getAllTrainings() throws ServletException {

		List<model.TrainingModel> trainingList = new ArrayList<>();
		try {

			Connection connection = DBConfig.getConnection();
			String query = "SELECT * FROM Training";

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				trainingList.add(new model.TrainingModel(rs.getInt("TrainingID"), rs.getString("TrainingName"),
						rs.getDate("StartDate"), rs.getDate("EndDate"), rs.getString("TrainingMode"),
						rs.getString("BusinisessUnit"), rs.getString("ContactPersonID")));
			}

		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
		return trainingList;
	}

	public static void deleteTrainings(String trainings[]) throws IOException {
		try {
			PreparedStatement pstmt = null;
			if (trainings != null && trainings.length > 0) {
				Connection connection = DBConfig.getConnection();
				String deleteTraining = "Delete from Training where TrainingID in ( ";

				for (int i = 0; i < trainings.length; i++) {
					deleteTraining = deleteTraining + " ?,";
				}

				deleteTraining = deleteTraining.substring(0, deleteTraining.length() - 1) + " )";
				pstmt = connection.prepareStatement(deleteTraining);

				for (int i = 0; i < trainings.length; i++) {
					System.out.println("training id to be deleted is " + trainings[i] + "\n");

					pstmt.setInt(i + 1, Integer.parseInt(trainings[i]));
				}
				System.out.println("delete sql " + deleteTraining);
			}

			int rows = pstmt.executeUpdate();

			if (rows > 0) {
				System.out.println("deleting Training succeded!");
			} else {
				System.out.println("delete Training return zero records!");
				throw new IOException("error while deleting trainings!");
			}

		} catch (SQLException e) {
			System.out.println("error while deleting trainings!, sql error!");
			throw new IOException(e.getMessage());
		}
	}

	public static void addTraining(TrainingModel training) throws IOException {
		try {

			Connection connection = DBConfig.getConnection();
			String insertTraining = "Insert into Training (TrainingName, StartDate, EndDate, TrainingMode , BusinisessUnit , ContactPersonID) "
					+ "values (?,?,?,?,?,?)";

			PreparedStatement pstmt = connection.prepareStatement(insertTraining);
			pstmt.setString(1, training.getTrainingName());
			pstmt.setDate(2, training.getStartDate());
			pstmt.setDate(3, training.getEndDate());
			pstmt.setString(4, training.getTrainingMode());
			pstmt.setString(5, training.getBusinisessUnit());
			pstmt.setString(6, training.getContactPersonId());
			int rows = pstmt.executeUpdate();

			if (rows > 0) {
				System.out.println("inserting Training succeded");
			} else {
				throw new IOException("error while inserting training!");
			}

		} catch (SQLException e) {
			System.out.println("error while inserting training!, sql error!");
			throw new IOException(e.getMessage());
		}

	}

}
