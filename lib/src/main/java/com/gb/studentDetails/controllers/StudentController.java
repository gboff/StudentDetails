package com.gb.studentDetails.controllers;

import java.util.List;

import javax.validation.Valid;

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
import com.gb.studentDetails.entities.Student;
import com.gb.studentDetails.services.StudentService;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	private StudentService studentServ;
	
	@PostMapping("/insertStudent")
	public Student insertStudent(@Valid @RequestBody Student student) {
		return studentServ.insertStudent(student);
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@Valid @RequestBody Student student) {
		return studentServ.updateStudent(student);
	}
	
	@DeleteMapping("/deleteStudent/{studentId}")
	public Student deleteStudent(@PathVariable("studentId") int studentId) {
		return studentServ.deleteStudent(studentId);
	}
	
	@GetMapping("/getStudentByRollNumber/{rollNumber}")
	public Student getStudentByRollNumber(@PathVariable String rollNumber) {
		return studentServ.getStudentByRollNumber(rollNumber);
	}
	
	@GetMapping("/getStudentByName/{name}")
	public Student getStudentByName(@PathVariable String name) {
		return studentServ.getStudentByName(name);
	}
	
	@GetMapping("/showAllStudents")
	public List<Student> showAllStudents()
	{
		return studentServ.showAllStudents();
	}

	@GetMapping("/getStudentById/{studentId}")
	public Student getStudentById(@PathVariable int studentId)
	{
		return studentServ.getStudentById(studentId);
	}
}
