package com.zilker.blog.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import com.zilker.blog.constants.ConstantStatements;
public class DatabaseConfig {

	public static final Logger logger = Logger.getLogger("DatabaseConfig");
	public final String URL = "jdbc:mysql://localhost:3306/blog";
	public final String USERNAME = "root";
	public final String PASSWORD = "root";
	public Connection CON = null;

	public Connection getConnection() {
		try {
			Properties properties = new Properties();
			properties.setProperty("user", USERNAME);
			properties.setProperty("password", PASSWORD);
			properties.setProperty("useSSL", "true");
			properties.setProperty("autoReconnect", "true");
			CON = DriverManager.getConnection(URL, properties);
		} catch (SQLException ex) {
			logger.info(ConstantStatements.DATABASE_ERROR_LOG);
		}
		return CON;
	}

	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			logger.info(ConstantStatements.CLOSE_DATABASE_ERROR);
		}
	}

}