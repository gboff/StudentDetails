package com.gb.studentDetails.repository;

import java.lang.System.Logger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.gb.studentDetails.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query("from Admin a where a.username=?1 and a.password=?2")
	public Admin validateAdmin(String username,String password);	
	
}
