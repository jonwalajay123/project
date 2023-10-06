package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
	@Autowired
	Controlservice service;
	
	@GetMapping("/student")
	public String getStudents(Model m){
		
		m.addAttribute("students",this.service.getallstudent()); 
		 return "students";
	}
	
	@GetMapping("/students/new")
	public String addstudent(Model m) {
		
		Student student = new Student();
		m.addAttribute("student", student);
		return "createstudent";
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student s) {
		this.service.createStudent(s);
		
		return "redirect:/student";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		model.addAttribute("student",this.service.getStudentById(id));
		return "edit_student";
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable int id,
			@ModelAttribute("student") Student student,
			Model model) {
		Student existingStudent = this.service.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setName(student.getName());
		existingStudent.setFees(student.getFees());
		existingStudent.setCourse(student.getCourse());
		
		// save updated student object
		this.service.updateStudent(existingStudent);
		return "redirect:/student";		
	}
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		this.service.deleteStudentById(id);
		return "redirect:/student";
	}
}

