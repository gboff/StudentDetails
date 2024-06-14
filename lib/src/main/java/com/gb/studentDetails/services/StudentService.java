package com.gb.studentDetails.services;

import java.util.List;

import com.gb.studentDetails.entities.Student;

public interface StudentService {

	public Student insertStudent(Student Student);
	public Student updateStudent(Student Student);
	public Student deleteStudent(int studentId);
	
	public List<Student> showAllStudents();
	
	public Student getStudentByRollNumber(String rollNumber);
	public Student getStudentByName(String name);
	public Student getStudentById(int studentId);
	
}
