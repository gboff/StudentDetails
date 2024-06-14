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
			
			Integer oldB = feesDetails.getOldBalance();
			if (oldB == null)
				oldB = 0;
			
			Integer t1B = feesDetails.getTerm1Balance();
			if (t1B == null)
				t1B =0;
			
			Integer t2B = feesDetails.getTerm2Balance();
			if(t2B == null)
				t2B =0;
			
			Integer t3B = feesDetails.getTerm3Balance();
			if(t3B == null)
				t3B = 0;
			
			Integer curB = t1B + t2B +t3B;
			
			Integer totalB = oldB+curB;
			
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
		String rollNumber = feesDetails.getStudentRollNumber();
		FeesDetails cust = feesRepo.getFeesDetailsByRollNumber(rollNumber);
		if(cust!=null)
		{
			int studentId = cust.getStudentId();
			LocalDateTime timestamp = LocalDateTime.now();
			String name = cust.getStudentName();
			String className = cust.getStudentClass();
			feesDetails.setStudentName(name);
			feesDetails.setStudentClass(className);
			feesDetails.setStudentId(studentId);
			Integer oldBI = feesDetails.getOldBalance();
			Integer oldBAct = cust.getOldBalance();
			Integer oldB =0;
			if(oldBI != null)
				oldB = oldBI;
			else
				oldB = oldBAct;

			Integer term1I = feesDetails.getTerm1Balance();
			Integer term1Act = cust.getTerm1Balance();
			Integer term1 = 0;
			if(term1I != null)
				term1 = term1I;
			else
				term1 = term1Act;
			
			Integer term2I = feesDetails.getTerm2Balance();
			Integer term2Act = cust.getTerm2Balance();
			Integer term2 = 0;
			if(term2I != null)
				term2 = term2I;
			else
				term2 = term2Act;
			
			Integer term3I = feesDetails.getTerm3Balance();
			Integer term3Act = cust.getTerm3Balance();
			Integer term3 = 0;
			if(term3I != null)
				term3 = term3I;
			else
				term3 = term3Act;
			
			feesDetails.setTerm1Balance(term1);
			feesDetails.setTerm2Balance(term2);
			feesDetails.setTerm3Balance(term3);
			
			Integer curB = term1+term2+term3;
			Integer totB = oldB+curB;
			feesDetails.setOldBalance(oldB);
			feesDetails.setCurrentBalance(curB);
			feesDetails.setTotalBalance(totB);
			feesDetails.setLogDate(timestamp);
			feesRepo.delete(cust);
			return feesRepo.save(feesDetails);
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

	@Override
	public FeesDetails deleteFeesDetails(int feesId) {
		Optional<FeesDetails> cust=feesRepo.findById(feesId);
		if(cust.isPresent()) {
			feesRepo.delete(cust.get());
		    return cust.get();
		}
		else
		{
			throw new FeesDetailsNotFoundException("Roll Number Invalid");
		}

	}

	@Override
	public FeesDetails getFeesDetailsByFeesId(int feesId)
	{
		FeesDetails feesDetail = feesRepo.getFeesDetailsById(feesId);
		if(feesDetail!=null)
		{
			return feesDetail;
		}
		else
			throw new FeesDetailsNotFoundException("Not Found// Get By ID");
		
	}
}
