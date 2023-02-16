package com.jspiders.MultiplayerCaseStudyJdbc.operation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class SongOperations {
	 
		private static Connection connection;
		private static PreparedStatement preparedStatement;
		private static Properties properties;
		private static int result;
		private static String filepath=("F:\\eclipse workspace\\java project\\"
				+ "JDBC\\Resources\\db_Info.properties");
		
		private static Scanner scanner;;
		private static String name;
		private static String singer;
		private static int duration;
		private static String Movie_album;
		private static String lyricist;
		private static String composer;
		private FileReader FileReader;
		private java.io.FileReader fileReader;
		private int id;

		private void openConnection() {
			try
			{
				setFileReader(new FileReader(filepath));
				properties =new Properties();
				properties.load(FileReader);
				connection=DriverManager.getConnection
						(properties.getProperty("dburl"),properties);
				scanner=new Scanner(System.in);
			
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
			e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		public void addSongs() {
				openConnection();
				try
				{
					preparedStatement=connection.prepareStatement(properties.getProperty("insert"));
				
					System.out.println("Enter the song id: ");
					 id=scanner.nextInt();
					
					preparedStatement.setInt(1, id);
					System.out.println("Enter the song name: ");
					name=scanner.next();
					
					preparedStatement.setString(2,name);
					System.out.println("Enter the song singer: ");
					singer=scanner.next();
					
					preparedStatement.setString(3,singer);
					System.out.println("Enter the song duration :");
					duration=scanner.nextInt();
					
					preparedStatement.setInt(4,duration);
					System.out.println("Enter the song Movie/album: ");
					Movie_album=scanner.next();
					
					preparedStatement.setString(5,Movie_album);
					System.out.println("Enter the song  lyricist: ");
					lyricist=scanner.next();
					
					preparedStatement.setString(6, lyricist);
					System.out.println("Enter the song composer: ");
					composer=scanner.next();
				
					preparedStatement.setString(7,composer);
					System.out.println("Enter the song movie/album: ");
					result =preparedStatement.executeUpdate();
					
					if(result!=0)
					{
						System.out.println(name+ "sucessfully added to plaulist");
					}
 				}catch(SQLException e) {
 					e.printStackTrace();
 				}
				 
				
			}
		public java.io.FileReader getFileReader() {
			return fileReader;
		}
		public void setFileReader(java.io.FileReader fileReader) {
			this.fileReader = fileReader;
		}
		}

