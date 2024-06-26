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
		String id = student.getRollNumber();
		Student cust = studentRepo.getStudentByRollNumber(id);
		if(cust!=null)
		{
			String name1 = student.getName();
			String nameAct = cust.getName();
			if(name1 == null)
				student.setName(nameAct);
			
			String mobileNumber1 = student.getMobileNumber();
			String mobileNumberAct = cust.getMobileNumber();
			if(mobileNumber1 == null)
				student.setMobileNumber(mobileNumberAct);
			
			String className1 = student.getClassName();
			String classNameAct = cust.getClassName();
			if(className1 == null)
				student.setClassName(classNameAct);
			
			String dob1 = student.getDob();
			String dobAct = cust.getDob();
			if(dob1 == null)
				student.setDob(dobAct);
			
			String aadhar1 = student.getAadhar();
			String aadharAct = cust.getAadhar();
			if(aadhar1 == null)
				student.setAadhar(aadharAct);
			
			String address1 = student.getAddress();
			String addressAct = cust.getAddress();
			if(address1 == null)
				student.setAddress(addressAct);
			
			String bloodGroup1 = student.getBloodGroup();
			String bloodGroupAct = cust.getBloodGroup();
			if(bloodGroup1 == null)
				student.setBloodGroup(bloodGroupAct);
			
			String emis1 = student.getEmis();
			String emisAct = cust.getEmis();
			if(emis1 == null)
				student.setEmis(emisAct);
			
			String fatherName1 = student.getFatherName();
			String fatherNameAct = cust.getFatherName();
			if(fatherName1 == null)
				student.setFatherName(fatherNameAct);
			
			String motherName1 = student.getMotherName();
			String motherNameAct = cust.getMotherName();
			if(motherName1 == null)
				student.setMotherName(motherNameAct);
			studentRepo.delete(cust);
			return studentRepo.save(student);
			
		}
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

	@Override
	public Student getStudentById(int studentId)
	{
		Student student = studentRepo.getStudent(studentId);
		if(student!=null)
		{
			return student;
		
		}
		else
			throw new StudentNotFoundException("Unexpected error");
	}
}
