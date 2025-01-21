package com.ducat.daoo;

import java.util.List;

import com.ducat.model.Student;

public interface Studentdao {
	
	void createtable(); 
	int registerUser(Student student);
	boolean updateStudent(Student student);
	boolean deleteStudent(int id);
	List<Student> getallstudent();
	List<Student> getStudentbyId(int id);
	List<Student> getStudentbyname(String name);
	
}
