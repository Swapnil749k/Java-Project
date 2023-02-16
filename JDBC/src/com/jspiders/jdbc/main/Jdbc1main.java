package com.jspiders.jdbc.main;

 
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc1main {
public static void main(String[] args) {
	 try {
	//step 1:Load the driver class.
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 
	 //step 2: Open connection
	 Connection connection=DriverManager.getConnection
			 ("jdbc:mysql://localhost:3306/wejm4?user=root&password=root");
	 
	 //step 3:Create/prepare statement.
	 Statement statement=connection.createStatement();
	 ResultSet resultset=statement.executeQuery("select * from students");
	 
	 //step 4:Process the result
	 while (resultset.next()) {
		 System.out.println(
		 resultset.getInt(1)+" | "
		 +resultset.getString(2)+" | "
		 +resultset.getString(3)+" | "
		 +resultset.getLong(4)+" | "
		 +resultset.getString(5));
	 }
	 
	 //step 5: Close connection
	 	connection.close();
	 	statement.close();
	 	resultset.close();
		
	} catch (ClassNotFoundException |SQLException e) {
		 e.printStackTrace();
	}
}
}
