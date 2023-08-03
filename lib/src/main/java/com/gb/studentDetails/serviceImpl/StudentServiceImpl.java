package com.gb.studentDetails.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gb.studentDetails.entities.FeesDetails;
import com.gb.studentDetails.entities.Student;
import com.gb.studentDetails.exceptions.StudentNotFoundException;
import com.gb.studentDetails.repository.StudentRepository;
import com.gb.studentDetails.services.StudentService;

@Service 
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public Student insertStudent(Student student)
	{
		return studentRepo.save(student);
	}
	
	@Override 
	public Student updateStudent(Student student) {
		int id = student.getStudentId();
		Optional<Student> cust = studentRepo.findById(id);
		if(cust.isPresent())
			return studentRepo.save(student);
		else
		{
			throw new StudentNotFoundException("No Student Found To Update");
		}
	}
	
	@Override
	public Student deleteStudent(int studentId) {
		Optional<Student> cust = studentRepo.findById(studentId);
		if(cust.isPresent())
		{
			studentRepo.delete(cust.get());
			return cust.get();
		}
		else
		{
			throw new StudentNotFoundException("No Student Found To Delete");
		}
	}
	
	
	@Override
	public Student getStudentByRollNumber(String rollNumber)
	{
		Student stud = studentRepo.getStudentByRollNumber(rollNumber);
		if(stud!=null)
			return stud;
		else
			throw new StudentNotFoundException("Roll Number Does Not Exist");
	}
	
	@Override
	public Student getStudentByName(String name)
	{
		Student stud1 = studentRepo.getStudentByName(name);
		if(stud1!=null)
			return stud1;
		else
			throw new StudentNotFoundException("Student Name Does Not Exist");
	}
	
	@Override
	public List<Student> showAllStudents()
	{
		return studentRepo.findAll();	
	}
}
