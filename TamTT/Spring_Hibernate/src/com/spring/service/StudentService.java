package com.spring.service;

import java.util.List;

import com.spring.model.Student;

public interface StudentService {
	public List<Student> listStudent();

	public Student findById(int id);

	public void delete(int id);

	public void update(Student student);

	public void create(Student student);
	
	public List<Student> findAllForPaging(int startPosition,int maxResult);
}
