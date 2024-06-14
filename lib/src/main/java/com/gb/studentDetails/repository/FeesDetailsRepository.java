package com.gb.studentDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gb.studentDetails.entities.FeesDetails;

@Repository
public interface FeesDetailsRepository extends JpaRepository<FeesDetails, Integer> {
	
	@Query("from FeesDetails where studentRollNumber=?1")
	public FeesDetails getFeesDetailsByRollNumber(String studentRollNumber);
	
	@Query("from FeesDetails where feesId =?1")
	public FeesDetails getFeesDetailsById(int feesId);

}
