package com.ducat.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ducat.dao.util.Connectionprovider;
import com.ducat.daoo.Studentdao;
import com.ducat.model.Student;
import com.mysql.cj.protocol.Resultset;

public class Studentdaoimpl implements Studentdao {

	
	private static Boolean isTablecreated = false;
	
	public Studentdaoimpl() {
		if(!isTablecreated) {
			createtable();
		}
	}
	
	
	@Override
	public int registerUser(Student student) {
	    int rowsAffected = 0; // Initialize rowsAffected to 0

	    String insertQuery = """
	        INSERT INTO Students(name, mobileno, Isplaced, gender, joinedAt, fees) 
	        VALUES(?, ?, ?, ?, ?, ?)
	        """;

	    try (Connection con = Connectionprovider.getmySqlConnection();
	         PreparedStatement ps = con.prepareStatement(insertQuery)) {

	        // Set query parameters
	        ps.setString(1, student.getName());
	        ps.setLong(2, student.getMobileno());
	        ps.setBoolean(3, student.isIsplaced());
	        ps.setString(4, String.valueOf(student.getGender()));
	        ps.setDate(5, Date.valueOf(student.getJoinedAt()));
	        ps.setDouble(6, student.getFees());

	        System.out.println(ps); 
	        rowsAffected = ps.executeUpdate(); 

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return rowsAffected;
	}


	@Override
	public void createtable() {
	    String createTableQuery = """
	        CREATE TABLE IF NOT EXISTS Students (
	            id INT PRIMARY KEY AUTO_INCREMENT,
	            name VARCHAR(50),
	            mobileno BIGINT,
	            Isplaced BOOLEAN,
	            gender CHAR(1),
	            joinedAt DATE,
	            fees DOUBLE,
	            createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	        )
	        """;

	    try (Connection con = Connectionprovider.getmySqlConnection();
	         Statement st = con.createStatement()) {

	        st.execute(createTableQuery); // Execute the corrected query
	        isTablecreated = true; // Mark table as created
	        System.out.println("Table created successfully.");
	    } catch (Exception e) {
	        System.out.println("Error creating table: " + e.getMessage());
	        e.printStackTrace(); // Log the exception
	    }
	}


	@Override
	public boolean updateStudent(Student student) {
		boolean status = false;
		try {
			Connection con = Connectionprovider.getmySqlConnection();
			PreparedStatement ps = con.prepareStatement("update students set name = ?,fees = ?,mobileno =? where id = ? ");
			ps.setString(1,student.getName());
			ps.setDouble(2,student.getFees());
			ps.setLong(3,student.getMobileno());
			ps.setInt(4,student.getId());
			
			System.out.println(ps);
			status = ps.executeUpdate() > 0 ? true : false ;
			ps.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(" => "+e.getMessage());
		}
		
		
		return status;
	}


	@Override
	public boolean deleteStudent(int id) {
		boolean status = false;
		try {
			Connection con = Connectionprovider.getmySqlConnection();
			Statement st = con.createStatement();
			int rowsaffected = st.executeUpdate("delete from students where id ="+id+";");
			status = rowsaffected > 0 ? true : false ;
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return status;
	}


	@Override
	public List<Student> getallstudent() {
		ArrayList<Student> student = new ArrayList<>();
		try {	
			Connection con  = Connectionprovider.getmySqlConnection();
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery("Select * from students");
			
			while(rs.next()) {
				Student temp = new Student();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				temp.setMobileno(rs.getLong(3));
				temp.setIsplaced(rs.getBoolean(4));
				temp.setGender(rs.getString(5).charAt(0));
				temp.setJoinedAt(rs.getDate(6).toLocalDate());
				temp.setFees(rs.getDouble(7));
				temp.setCreatedAt(rs.getTime(8));
				student.add(temp);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return student;
	}


	@Override
	public List<Student> getStudentbyId(int id) {
		
		ArrayList<Student> arr = new ArrayList<>();
		
		try {
			Connection con = Connectionprovider.getmySqlConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from students where id = "+id+";");
			
			while(rs.next()) {
				Student temp = new Student();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				temp.setMobileno(rs.getLong(3));
				temp.setIsplaced(rs.getBoolean(4));
				temp.setGender(rs.getString(5).charAt(0));
				temp.setJoinedAt(rs.getDate(6).toLocalDate());
				temp.setFees(rs.getDouble(7));
				temp.setCreatedAt(rs.getTime(8));
				arr.add(temp);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arr;
	}


	@Override
	public List<Student> getStudentbyname(String name) {
		
		ArrayList<Student> arr = new ArrayList<>();
		
		try {
			Connection con = Connectionprovider.getmySqlConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from students where name='"+name+"';");
			
			while(rs.next()) {
				Student temp = new Student();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				temp.setMobileno(rs.getLong(3));
				temp.setIsplaced(rs.getBoolean(4));
				temp.setGender(rs.getString(5).charAt(0));
				temp.setJoinedAt(rs.getDate(6).toLocalDate());
				temp.setFees(rs.getDouble(7));
				temp.setCreatedAt(rs.getTime(8));
				arr.add(temp);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arr;
	}


}
