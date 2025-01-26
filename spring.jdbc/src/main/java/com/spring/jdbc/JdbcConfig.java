package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = "{com.spring.jdbc.dao}")
public class JdbcConfig {
	@Bean("datasource")
	public DriverManagerDataSource getDataSource() {
			DriverManagerDataSource datasource = new DriverManagerDataSource();
			datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			datasource.setUrl("jdbc:mysql://localhost:3306/jdbc_pratice");
			datasource.setUsername("root");
			datasource.setPassword("542666");
			return datasource;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	@Bean(name = { "studentDao"} )
	public StudentDao getStudentDao() {
		StudentDaoImpl studentDao = new StudentDaoImpl();
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;
	}
	
}
