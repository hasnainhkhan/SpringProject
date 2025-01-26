package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entites.Student;

public class StudentDaoImpl  implements StudentDao{
	
	private HibernateTemplate hibernateTemplate;

	@Override @Transactional // save method
	public int insert(Student student) {
		
		int i =(int) this.hibernateTemplate.save(student);
		return i;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public Student getStudentId(int studentId) {
		// get single student data
		Student student = this.hibernateTemplate.get(Student.class,studentId);
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		// get all data
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}

	@Override @Transactional
	public void deleteStudent(int studentId) {
		// delete student data
		Student student = this.hibernateTemplate.get(Student.class,studentId );
		this.hibernateTemplate.delete(student);
		
		
	}
	@Override
	public void updateStudent(Student student) {
		// update student
		this.hibernateTemplate.update(student);
		
	}
	
	

}
