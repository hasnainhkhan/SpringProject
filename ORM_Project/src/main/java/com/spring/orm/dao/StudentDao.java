package com.spring.orm.dao;

import java.util.List;

import com.spring.orm.entites.Student;


public interface StudentDao {
	
	public int insert(Student student);
	public Student getStudentId(int studentId);
	public List<Student> getAllStudent();
	public void deleteStudent(int studentId);
	void updateStudent(Student student);
}
