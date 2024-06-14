package com.gb.studentDetails.services;

import java.util.List;
import com.gb.studentDetails.entities.FeesDetails;

public interface FeesDetailsService {

	public FeesDetails insertFees(FeesDetails feesDetail);
	public FeesDetails updateFees(FeesDetails feesDetail);
	public FeesDetails deleteFeesDetails(int feesId);
	public List<FeesDetails> showAllFeesDetails();
	public FeesDetails getFeesDetailsByRollNumber(String studentRollNumber);
	public FeesDetails getFeesDetailsByFeesId(int feesId);
}
