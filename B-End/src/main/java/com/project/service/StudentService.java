package com.project.service;

import java.util.List;

import com.project.model.StudentModel;

public interface StudentService{

	public abstract List<StudentModel> getStudents();

	public abstract StudentModel createStudent(StudentModel studentModel);

	public abstract void updateStudent(StudentModel studentModel);

	public abstract void deleteStudent(Integer studentId);

	public abstract boolean isStudentExist(String studentName);

	public abstract boolean isStudentExistbyid(int studentId);

    public abstract StudentModel getStudentbyid(int studentId);

    public abstract List<StudentModel> getStudentbyname(String studentName);
	
}