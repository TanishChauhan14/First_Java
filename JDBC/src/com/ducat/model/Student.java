package com.ducat.model;


import java.sql.Time;
import java.time.LocalDate;

public class Student {

	
	private int id;
	private String name;
	private Long mobileno;
	private double fees;
	private boolean Isplaced;
	private LocalDate joinedAt;  
	private char gender;
	private Time createdAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Constructor
	public Student(int id, String name,Long mobileno, double fees, boolean isplaced, LocalDate joinedAt, char gender) {
		this.id = id;
		this.name = name;
		this.mobileno = mobileno;
		this.fees = fees;
		this.Isplaced = isplaced;
		this.joinedAt = joinedAt;
		this.gender = gender;
	}
	
	public Student() {
		super();
	}
	// ToString Method
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", fees=" + fees + ", Isplaced=" + Isplaced + ", joinedAt="
				+ joinedAt + ", gender=" + gender + " Created AT=" +createdAt + "]";
	}
	
	
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public boolean isIsplaced() {
		return Isplaced;
	}
	public void setIsplaced(boolean isplaced) {
		Isplaced = isplaced;
	}
	public LocalDate getJoinedAt() {
		return joinedAt;
	}
	public void setJoinedAt(LocalDate joinedAt) {
		this.joinedAt = joinedAt;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Long getMobileno() {
		return mobileno;
	}
	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}
	public Time getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Time createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
