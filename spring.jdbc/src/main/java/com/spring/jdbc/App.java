package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

    	StudentDao studentDao= context.getBean("studentDao",StudentDao.class);
    	
//    	Student newstudent = new Student();
//    	newstudent.setName("Hasnain");
//    	newstudent.setId(109);
//    	newstudent.setCity("Lucknow");
////    	
//    	int result = studentDao.insert(newstudent);
//    	
//    	System.out.println(result  + "Data Inserted");
    	
//    	updating data into databases;
//    	Student student = new Student();
//    	student.setId(107);
//    	student.setName("Tasleem ahmad");
//    	student.setCity("gorakhpur");
//    	
//    	int result = studentDao.modifyData(student);
//    	System.out.println("data updated successfully"+result);
    	
    	//delete data into table
//    	Student student = new Student();
//    	student.setId(246);
//    	int result = studentDao.deleteData(245);
//    	System.out.println("deleted successfully"+result); 
    	
//    	Student result = studentDao.getStudent(107);
//    	System.out.println(result);
    	
    	List<Student> result = studentDao.getAllStudent();
		for(Student student:result) {
			System.out.println(student);
		}
    	
    }
}
