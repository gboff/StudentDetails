package com.gb.studentDetails.services;

import java.util.List;
import com.gb.studentDetails.entities.FeesDetails;

public interface FeesDetailsService {

	public FeesDetails insertFees(FeesDetails feesDetail);
	public FeesDetails updateFees(FeesDetails feesDetail);
	//public FeesDetails deleteFees(FeesDetails feesDetail);
	public List<FeesDetails> showAllFeesDetails();
	public FeesDetails getFeesDetailsByRollNumber(String studentRollNumber);
}
