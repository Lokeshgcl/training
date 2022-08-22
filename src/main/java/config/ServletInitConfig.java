package config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ServletInitConfig implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		Connection connection = DBConfig.getConnection();
		String userTable = "Create table Users (ID int primary key, name varchar(100), password varchar(100), type char)";
		String trainingTable = "Create table Training (TrainingID int auto_increment primary key, TrainingName varchar(500), "
				+ "StartDate DATE, EndDate DATE, TrainingMode varchar(100), BusinisessUnit varchar(100), ContactPersonID varchar(500))";
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.execute(userTable);
			statement.execute(trainingTable);
			System.out.println("Created table users.");

			String insertUser = "Insert into Users (ID, name, password, type) values (1, 'admin','admin', 'A')";

			int rows = statement.executeUpdate(insertUser);

			if (rows > 0) {
				System.out.println("Inserted a new user admin.");
			}

			connection.close();
		} catch (SQLException e) {
			System.out.println("error in ServletInitConfig - contextInitialized method");
			e.printStackTrace();
		}

	}

}
