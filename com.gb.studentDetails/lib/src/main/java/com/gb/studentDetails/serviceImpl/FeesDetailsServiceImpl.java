package com.gb.studentDetails.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gb.studentDetails.entities.FeesDetails;
import com.gb.studentDetails.entities.Student;
import com.gb.studentDetails.exceptions.FeesDetailsNotFoundException;
import com.gb.studentDetails.exceptions.StudentNotFoundException;
import com.gb.studentDetails.repository.FeesDetailsRepository;
import com.gb.studentDetails.repository.StudentRepository;
import com.gb.studentDetails.services.StudentService;
import com.gb.studentDetails.services.FeesDetailsService;

@Service
public class FeesDetailsServiceImpl implements FeesDetailsService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private FeesDetailsRepository feesRepo;
	
	@Override
	public FeesDetails insertFees(FeesDetails feesDetails)
	{
		String studentId1 = feesDetails.getStudentRollNumber();
		Student student1 = studentRepo.getStudentByRollNumber(studentId1);
		if(student1!=null)
		{
			Student studentActual = studentRepo.getStudentByRollNumber(studentId1);
			String studentName1 = studentActual.getName();
			String studentClass1 = studentActual.getClassName();
			int studentIdReal = studentActual.getStudentId();
			LocalDateTime timestamp = LocalDateTime.now();
			
			int oldB = feesDetails.getOldBalance();
			
			int t1B = feesDetails.getTerm1Balance();
			int t2B = feesDetails.getTerm2Balance();
			int t3B = feesDetails.getTerm3Balance();
			
			int curB = t1B + t2B +t3B;
			
			int totalB = oldB+curB;
			
			feesDetails.setCurrentBalance(curB);
			feesDetails.setStudentId(studentIdReal);
			feesDetails.setLogDate(timestamp);
			feesDetails.setStudentClass(studentClass1);
			feesDetails.setStudentName(studentName1);
			feesDetails.setTotalBalance(totalB);
			
			return feesRepo.save(feesDetails);
		}
		else
			throw new StudentNotFoundException("Student Roll Number does not match");
		
	}
	
	@Override
	public FeesDetails updateFees(FeesDetails feesDetails)
	{
		int id = feesDetails.getFeesId();
		Optional<FeesDetails> feesDetails1 = feesRepo.findById(id);
		if(feesDetails1.isPresent())
		{
			int studentId1 = feesDetails.getStudentId();
			Optional <Student> student1 = studentRepo.findById(studentId1);
			if(student1.isPresent())
			{
				Student studentActual = studentRepo.getById(studentId1);
				String studentName1 = studentActual.getName();
				String studentClass1 = studentActual.getClassName();
				LocalDateTime timestamp = LocalDateTime.now();
				
				int oldB = feesDetails.getOldBalance();
				int curB = feesDetails.getCurrentBalance();
				
				int totalB = oldB + curB;
				
				feesDetails.setLogDate(timestamp);
				feesDetails.setStudentClass(studentClass1);
				feesDetails.setStudentName(studentName1);
				feesDetails.setTotalBalance(totalB);
				
				return feesRepo.save(feesDetails);
			}
			else
				throw new StudentNotFoundException("StudentId does not match");
		}
		else
			throw new FeesDetailsNotFoundException("Fees Details not found");
	}
	
	@Override
	public List<FeesDetails> showAllFeesDetails()
	{
		return feesRepo.findAll();	
	}
	
	@Override
	public FeesDetails getFeesDetailsByRollNumber(String studentRollNumber)
	{
		FeesDetails feesDetail = feesRepo.getFeesDetailsByRollNumber(studentRollNumber);
		if(feesDetail!=null)
			return feesDetail;
		else
			throw new FeesDetailsNotFoundException("Roll Number Invalid");	
	}
}
