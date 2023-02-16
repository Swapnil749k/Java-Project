package com.jspiders.jdbc.Insert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcInsert {
	private static Connection connection;
	private static Statement statement;
	private static int result;
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
			Query="insert into students values "
					+"(6,'Amit',22,7499994568,'nagpur')";
			result=statement.executeUpdate(Query);
			System.out.println(result +"row(s) affected");
			
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(connection!=null) {
				connection.close();
			}
			 
	
				if(statement!=null) {
		 statement.close();
		}
		
	}catch (Exception e2) {
		e2.printStackTrace();
 	}
	}	
	}
}
