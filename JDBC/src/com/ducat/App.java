package com.ducat;

import java.time.LocalDate;

import com.ducat.dao.impl.Studentdaoimpl;
import com.ducat.daoo.Studentdao;
import com.ducat.model.Student;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Hello  World!");

		
		
	    Studentdao dao = new Studentdaoimpl();
//	    int rowsaffected = dao.registerUser( new Student(1,"Tanish",98100017430l,23.80,false,LocalDate.of(2021,07,16),'M'));
//	    boolean Status = dao.updateStudent( new Student(1,"Tannu",9315306736l,23.00,false,LocalDate.of(2021,07,16),'M'));
//	    boolean Status = dao.deleteStudent(1);
//	    if(Status) 
//	    {
//	    	System.out.println("Row is  Successfully");
//	    }
//	    else {
//	    	System.out.println("Check your code");
//	    }
	    
	    dao.getallstudent().forEach(s -> System.out.println(s));
	    
	    
//	    dao.getStudentbyId(2).forEach(s -> System.out.println(s));
	    
	    System.out.println("Student by Name :- ");
	    dao.getStudentbyname("Tanish").forEach(s -> System.out.println(s));
	    
	}

}
