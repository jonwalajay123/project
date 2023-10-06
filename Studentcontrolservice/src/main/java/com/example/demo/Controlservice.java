package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Controlservice {
	
	@Autowired
	StudentcontrolserviceApplication sc;

	@SuppressWarnings("unchecked")
	public List<Student> getallstudent(){
		
		RestTemplate temp=sc.getresttemplate();
		@SuppressWarnings("rawtypes")
		List l=temp.getForObject("http://localhost:8500/students", List.class);
		return l;
		
	}
		
	public Student createStudent(Student s) {
		
		RestTemplate temp=sc.getresttemplate();

	return temp.postForObject("http://localhost:8500/student/"+s, s,Student.class);
	
	}
public Student updateStudent(Student s) {
		
		RestTemplate temp=sc.getresttemplate();

	return temp.postForObject("http://localhost:8500/student/"+s+"/", s,Student.class);
	
	}
  public Student getStudentById(int id) {
	
	  RestTemplate temp=sc.getresttemplate();
	  return temp.getForObject("http://localhost:8500/student/"+id, Student.class);
}
  public void deleteStudentById(int id) {
		
	  RestTemplate temp=sc.getresttemplate();
	  temp.delete("http://localhost:8500/student/"+id+"/");
  }
	
	
}
