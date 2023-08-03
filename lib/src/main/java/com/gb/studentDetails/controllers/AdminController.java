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


import com.gb.studentDetails.entities.*;
import com.gb.studentDetails.services.*;


@RestController
@CrossOrigin(origins ="*")
public class AdminController {

	@Autowired
	private AdminService adminServ;
	
	@PostMapping("/registerAdmin")
	public Admin insertAdmin(@Valid @RequestBody Admin admin) {
		return adminServ.insertAdmin(admin);
	}
	
	@PostMapping("/validateAdmin")
	public Admin validateAdmin(@RequestBody LoginBean logb) {
		return adminServ.validateAdmin(logb.getUsername(),logb.getPassword());
	}
	
	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@Valid @RequestBody Admin admin) {
		return adminServ.updateAdmin(admin);}
	
	@DeleteMapping("/deleteAdminById/{adminId}")
	public Admin deleteAdmin(@PathVariable int adminId) {
		return adminServ.deleteAdmin(adminId);}
}
