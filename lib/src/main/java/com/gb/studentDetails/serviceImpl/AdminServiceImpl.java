package com.gb.studentDetails.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gb.studentDetails.services.*;
import com.gb.studentDetails.repository.*;
import com.gb.studentDetails.entities.*;
import com.gb.studentDetails.exceptions.*;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	
	@Override
	public Admin insertAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
	
	@Override
	public Admin updateAdmin(Admin admin) {
		int id = admin.getAdminId();
		Optional<Admin> ad = adminRepo.findById(id);
		if(ad.isPresent())
		{
			return adminRepo.save(admin);
		}
		else
			throw new AdminNotFoundException("Admin Account Not Found");
	}
	
	@Override
	public Admin deleteAdmin(int adminId) {
		Optional<Admin> admin = adminRepo.findById(adminId);
		if(admin.isPresent())
		{
			adminRepo.delete(admin.get());
			return admin.get();
		}
		else
			throw new AdminNotFoundException("Admin Account Not Found");
	}
	
	@Override
	public Admin validateAdmin(String username, String password) {
		Admin admin = adminRepo.validateAdmin(username, password);
		if(admin!=null)
			return admin;
		else {
			throw new AdminNotFoundException("Unauthorized Access");
		}
	}
	
}
