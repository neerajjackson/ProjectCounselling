package com.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentModel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private String studentUrl;
	private float studentRate;
	private String studentShop;
	private String availability;
	
	public String isAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentUrl() {
		return studentUrl;
	}
	public void setStudentUrl(String studentUrl) {
		this.studentUrl = studentUrl;
	}
	public float getStudentRate() {
		return studentRate;
	}
	public void setStudentRate(float studentRate) {
		this.studentRate = studentRate;
	}
	public String getStudentShop() {
		return studentShop;
	}
	public void setStudentCategory(String studentShop) {
		this.studentShop = studentShop;
	}
	
	@Override
	public String toString() {
		return "StudentModel [StudentId=" + studentId + ", studentName=" + studentName + ", studentUrl=" + studentUrl
				+ ", studentRate=" + studentRate + ", studentShop=" + studentShop + "]";
	}
	
}