package com.ducat.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionprovider {

	public static Connection con = null;
	
	public static Connection getmySqlConnection() 

	{
		final String URL = "jdbc:mysql://localhost:3306/";
		final String DB = "jdbc?createDatabaseIfNotExist=true";
		final String USERNAME = "root";
		final String PASSWORD = "12345678910";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(URL+DB,USERNAME,PASSWORD);
			
			System.out.println("Connected succesfully");
			
		} catch (ClassNotFoundException  e) {
			System.out.println("Driver not found "+e.getMessage());
		}
		catch(SQLException e) {
			System.out.println(" Check : "+e.getMessage());
		}
		
		return con;
	}
	
	public static Connection getmyPostConnection() 
	{
		final String URL = "jdbc:postgresql://localhost:5432/jdbc";
		final String DB = "jdbc";
		final String USERNAME = "postgres";
		final String PASSWORD = "12345678910";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			DriverManager.getConnection(URL+DB,USERNAME,PASSWORD);
			
			System.out.println("Connected succesfully");
			
		} catch (ClassNotFoundException  e) {
			System.out.println("Driver not found "+e.getMessage());
		}
		catch(SQLException e) {
			System.out.println(" Check : "+e.getMessage());
		}
		
		return con;
	}
}
