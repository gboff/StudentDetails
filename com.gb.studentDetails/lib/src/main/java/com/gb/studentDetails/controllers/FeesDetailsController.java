package com.gb.studentDetails.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gb.studentDetails.entities.FeesDetails;
import com.gb.studentDetails.services.FeesDetailsService;

@RestController
@CrossOrigin(origins ="*")
public class FeesDetailsController {
	@Autowired
	private FeesDetailsService feesServ;
	
	@PostMapping("/insertFeesDetails")
	public FeesDetails insertFeesDetails(@Valid @RequestBody FeesDetails feesDetails)
	{
		return feesServ.insertFees(feesDetails);
	}
	
	@PutMapping("/updateFeesDetails")
	public FeesDetails updateFeesDetails(@Valid @RequestBody FeesDetails feesDetails)
	{
		return feesServ.updateFees(feesDetails);
	}
	
	@GetMapping("/showAllFeesDetails")
	public List<FeesDetails> showAllFeesDetails()
	{
		return feesServ.showAllFeesDetails();
	}
	
	@GetMapping("/getFeesDetailsByRollNumber/{studentRollNumber}")
	public FeesDetails getFeesDetailsByRollNumber(@PathVariable String studentRollNumber)
	{
		return feesServ.getFeesDetailsByRollNumber(studentRollNumber);
	}
}
