package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	private Connection connection;
	
	public ConnectionUtil(){
		try {
			this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","");
		} catch (Exception e) {
			System.out.println("Failed to create connection");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return this.connection;
	}
}

