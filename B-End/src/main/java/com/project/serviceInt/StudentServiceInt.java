package com.project.serviceInt;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.StudentModel;
import com.project.repo.StudentRepo;
import com.project.service.StudentService;

@Service
public class StudentServiceInt implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<StudentModel> getStudents() {
		return (List<StudentModel>)studentRepo.findAll();
	}

	@Override
	public StudentModel createStudent(StudentModel studentModel) {
		return studentRepo.save(studentModel);
	}

	@Override
	public void deleteStudent(Integer studentId) {
		studentRepo.deleteById(studentId);
	}

	@Override
	public void updateStudent(StudentModel studentModel) {
		studentRepo.save(studentModel);
	}

	@Override
	public boolean isStudentExist(String studentName) {
		return studentRepo.existsByStudentNameIgnoreCase(studentName);
	}

	@Override
	public boolean isStudentExistbyid(int studentId) {
		return studentRepo.existsById(studentId);
	}

	@Override
	public StudentModel getStudentbyid(int studentId) {
		Optional<StudentModel> optional = studentRepo.findById(studentId);
		StudentModel studentModel = optional.get();
		return studentModel;
	}
	
	@Override
	public List<StudentModel> getStudentbyname(String studentName) 
	{
		return (List<StudentModel>) studentRepo.findByStudentNameContainingIgnoreCase(studentName);
	}
}