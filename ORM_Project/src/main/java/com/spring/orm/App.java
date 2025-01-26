package com.spring.orm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entites.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
		StudentDao studentDao = (StudentDao) context.getBean("studentDao");

//		Student student = new Student(234, "Hasnain", "Lucknow");
//		int r = studentDao.insert(student);
//		System.out.println("done" + r);
//		List<Student>students = studentDao.getAllStudent();
//		for(Student s:students) {
//			System.out.println("ID: "+ s.getStudentId() + " Name:"+s.getStudentName()+" City:"+s.getStudentCity());
//		}
		
//		Student student = studentDao.getStudentId(234);
//		System.out.println(student.getStudentId()+ student.getStudentName()+student.getStudentCity());
		
		studentDao.deleteStudent(234);
	}
}
