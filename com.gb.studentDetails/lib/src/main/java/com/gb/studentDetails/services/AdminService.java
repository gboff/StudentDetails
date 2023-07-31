package com.gb.studentDetails.services;

import java.time.LocalDateTime;
import java.util.List;

import com.gb.studentDetails.entities.Admin;

public interface AdminService {
	
	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Admin deleteAdmin(int adminId);
	public Admin validateAdmin(String username,String password);

}
