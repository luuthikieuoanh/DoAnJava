package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBModel {
	private static String dbURL = "jdbc:mysql://localhost:3306/ourstore_data?charaterEncoding=latin1&useConfigs=maxPermance";
	private static String dbUsername = "root";
	private static String dbPassword = "";

	public DBModel() {
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		} catch (Exception e) {

		}
		return connection;
	}
}
