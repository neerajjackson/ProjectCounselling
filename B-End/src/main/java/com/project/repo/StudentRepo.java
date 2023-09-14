package com.project.repo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.project.model.StudentModel;

public interface StudentRepo extends CrudRepository<StudentModel, Integer>
{

	boolean existsByStudentNameIgnoreCase(String studentName);

    List<StudentModel> findByStudentNameContainingIgnoreCase(String studentName);
	
}