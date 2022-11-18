package db;

import base.AutomationConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

	public HashMapNew dictionary;

	public enum DBType {
		ORACLE, MYSQL, MSACCESS, POSTGRESQL, MONGODB
	}

	DBType oDBType;
	static Connection con = null;

	public DataBase(HashMapNew dictionary, DBType oDBType) {

		this.dictionary = dictionary;
		this.oDBType = oDBType;
	}

	public Statement DataBaseConn(String connectionString) {
		switch (oDBType) {
			case ORACLE:
				try {

					//Load the driver class
					String DBClass = "oracle.jdbc.driver.OracleDriver";
					Class.forName(DBClass).newInstance();

					//Create the connection object
					con = DriverManager.getConnection(connectionString, AutomationConstants.oracleUsername,AutomationConstants.oraclePassword);

					//Create the statement object
					Statement stmt = con.createStatement();
					return stmt;
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case MYSQL:
				try {

					//Load the driver class
					String DBClass = "com.mysql.jdbc.Driver";
					Class.forName(DBClass).newInstance();

					//Create the connection object
					con = DriverManager.getConnection("jdbc:mysql://localhost:port/ServiceName", "UserID", "Password");

					//Create the statement object
					Statement stmt = con.createStatement();
					return stmt;

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case MSACCESS:
				try {

					//Load the driver class
					String DBClass = "oracle.jdbc.driver.OracleDriver";
					Class.forName(DBClass).newInstance();

					//Create the connection object
					con = DriverManager.getConnection("connection details", "UserId", "Password");

					//Create the statement object
					Statement stmt = con.createStatement();
					//  Statement stmt = con.createStatement();
					return stmt;

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case POSTGRESQL:
				try {
					//Create the connection object
					//con = DriverManager.getConnection(connectionString, AutomationConstants.postgreUsername, AutomationConstants.postgrePassword);
					//Create the statement object
					Statement stmt = con.createStatement();
					return stmt;
				} catch (Exception e) {
					System.out.println("Connection failure.");
					e.printStackTrace();
				}
				break;
		}
		return null;
	}

	public void closedDbConnection() {
		try {
			con.close();
			//MyTestNGBaseClass.reportResult("INFO", "Connection closed successfully!", false);
		//	Allure.addAttachment("Element is clicked.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
		//	reportResult("PASS", "I clicked the element: " + element, true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

