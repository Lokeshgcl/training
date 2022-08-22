package config;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

	public static final String jdbcURL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
	static {
		Driver driver = new org.h2.Driver();
		try {
			DriverManager.registerDriver(driver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(jdbcURL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
