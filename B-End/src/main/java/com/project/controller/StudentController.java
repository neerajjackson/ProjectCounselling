package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.StudentModel;
import com.project.service.StudentService;

@RestController
@RequestMapping(value="/student")
@CrossOrigin("*")
public class StudentController{
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value="/getall")
	private ResponseEntity<Object> getStudents() 
	{
		List<StudentModel> studentList = studentService.getStudents();
		return new ResponseEntity<>(studentList, HttpStatus.OK);
	}

	@GetMapping(value="/getbyid/{studentId}")
	private ResponseEntity<Object> getStudentbyid(@PathVariable int studentId) 
	{
		boolean isStudentExistbyid = studentService.isStudentExistbyid(studentId);
		if (isStudentExistbyid)
		{
		StudentModel studentModel = studentService.getStudentbyid(studentId);
		return new ResponseEntity<>(studentModel, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("ID not found",HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/getbyname/{studentName}")
	private ResponseEntity<Object> getStudentbyname(@PathVariable String studentName) 
	{
		List<StudentModel> studentModel = studentService.getStudentbyname(studentName);
		return new ResponseEntity<>(studentModel, HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public String createStudent(@RequestBody StudentModel studentModel)
	{
		boolean isStudentExist = studentService.isStudentExist(studentModel.getStudentName());
		if(isStudentExist)
			return "Student exists already";
		else {
		studentModel = studentService.createStudent(studentModel);
		return "Student added";}
	}
	
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<Object> deleteStudent(@RequestParam int studentId)
	{
			studentService.deleteStudent(studentId);
			return new ResponseEntity<>("R.I.P."
					+ "\nCause of Death : StudentPageModel Deletion", HttpStatus.OK);
	}
	
	
	@PutMapping(value="/edit/{studentId}")
	public ResponseEntity<Object> updateStudent(@PathVariable int studentId, @RequestBody StudentModel studentModel)
	{
			studentModel.setStudentId(studentId);
			studentService.updateStudent(studentModel);
			return new ResponseEntity<>("StudentPageModel details are updated successsfully !", HttpStatus.OK);
	}
		
	
}