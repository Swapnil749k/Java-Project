package com.jspiders.jdbc.main;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.FileReader;
import java.io.IOException;

public class Jdbc3Main {
public static void main(String[] args) {
	
	try {
		//step1: Load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//loading the db_info file in fileReader object
		FileReader fileReader=new FileReader 
				("F:\\eclipse workspace\\java project\\"
						+ "JDBC\\Resources\\db_Info.properties");
		
		//load the file as properties of jdbc
		Properties properties= new Properties();
		properties.load(fileReader);
		
		//step2: Open connection
		Connection connection = DriverManager.getConnection("jdbc:mysql:\\localhost:3306:wejm4",properties);
		
		//step3: Create /prepare statement
		Statement statement=connection.createStatement();
		
		ResultSet resultSet=statement.executeQuery("select * from students");
		
		//step4: Process the result
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)
					+"|"+resultSet.getString(2)
					+"|"+resultSet.getString(3)
					+"|"+resultSet.getLong(4)
					+"|"+resultSet.getString(5));
		}
		//step5: Close the Connection
		connection.close();
		statement.close();
		resultSet.close();
					
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}

}
}
