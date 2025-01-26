package com.spring.jdbc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entity.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//insert data into databases
	@Override
	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}
	//updating data into database
	@Override
	public int modifyData(Student student) {
		String query = "update student set name= ?, city = ? where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}
	
	//deleting data into databases
	@Override
	public int deleteData(int id) {
		String query = "delete from student where id = ?";
		int r = this.jdbcTemplate.update(query,id);
		return r;
	}
	
	@Override
	public Student getStudent(int studentId) {
		// select data query
		String query = "select * from student where id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper , studentId);
		return student;
	}
	@Override
	public List<Student> getAllStudent() {
		// get all student data
		String query = "select * from student";
		List <Student> student = this.jdbcTemplate.query(query, new RowMapperImpl());
		return student;
	}



	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

}
