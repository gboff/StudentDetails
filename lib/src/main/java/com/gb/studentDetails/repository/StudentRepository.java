package com.gb.studentDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gb.studentDetails.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("from Student where studentId=?1")
	public Student getStudent(int studentId);
	
	@Query("from Student where rollNumber=?1")
	public Student getStudentByRollNumber(String rollNumber);
	
	@Query("from Student where name LIKE %?1%")
	public Student getStudentByName(String name);
}
