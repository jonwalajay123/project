package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	Studentservice service;
	
	@PostMapping("/student/{s}")
	public Student addstudent(@RequestBody Student s) 
	{
     
	  return this.service.addstudent(s);
    
	}
	@GetMapping("/students")
	public List<Student> showall()
	{
		return this.service.getstudent();
		
	}
	@GetMapping("/student/{id}")
	public Student showstudent(@PathVariable int id)
	{
		return this.service.studentbyid(id);
		
	}
	@PostMapping("/student/{s}/")
	public Student updatestudent(@RequestBody Student s) 
	{
     
	  return this.service.updatestudent(s);
    
	}
	@DeleteMapping("/student/{id}/")
	public void deletestudent(@PathVariable int id)
	{
		 this.service.deletebyid(id);
		
	}
	
}
