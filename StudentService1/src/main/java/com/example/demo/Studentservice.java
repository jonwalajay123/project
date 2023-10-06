package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Studentservice {
	@Autowired
	Myrepo repo;

	public Student addstudent(Student s) {
		
		 return repo.save(s);
	}
	public List<Student> getstudent(){
	
		return repo.findAll();
		
	}
	public Student updatestudent(Student s) {
	
		return repo.save(s);
	}
	public Student studentbyid(int id){
		
		return repo.findById(id).get();
		
	}
    public void deletebyid(int id){
		
		 repo.deleteById(id);
		
	}
}
