package com.jspiders.jdbc.select;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcSelect {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static FileReader fileReader;
	private static Properties properties;
	private static String Query;
	private static String FilePath;
	private static  String driverPath="com.mysql.cj.jdbc.Driver";
	
	private static String dburl="jdbc:mysql://localhost:3306/wejm4";
	public static void main(String[] args) {
		try {
			Class.forName(driverPath);
			FilePath ="F:\\eclipse workspace\\java project\\"
					+ "JDBC\\Resources\\db_Info.properties";
			fileReader =new FileReader(FilePath);
			properties =new Properties();
			properties.load(fileReader);
			
			connection =DriverManager.getConnection(dburl,properties);
			statement =connection.createStatement();
			Query=" select * from students ";
			
			resultSet=statement.executeQuery(Query);
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)
						+"|"+resultSet.getString(2)
						+"|"+resultSet.getString(3)
						+"|"+resultSet.getLong(4)
						+"|"+resultSet.getString(5));
			}
		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
				
		}if(statement!=null) {
			try {
				statement.close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}if (resultSet!=null) {
			try {
				resultSet.close();
			}catch (SQLException e) {
				e.printStackTrace();			
			}
		
		}
		
	}
	}	
}

