package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entity.Student;

public interface StudentDao {
	public int insert(Student student);
	
	public int modifyData(Student student);
	
	public int deleteData(int id);
	
	public Student getStudent(int studentId);
	
	public List<Student> getAllStudent();
}
