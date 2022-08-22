package config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ServletInitConfig implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		Connection connection = H2Config.getConnection();
		String sql = "Create table Users (ID int primary key, name varchar(50), password varchar(50), type char)";
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.execute(sql);
			System.out.println("Created table users.");

			sql = "Insert into Users (ID, name, password, type) values (1, 'admin','admin', 'A')";

			int rows = statement.executeUpdate(sql);

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
