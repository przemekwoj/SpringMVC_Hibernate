package com.przemo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.przemo.entity.Courses;
import com.przemo.entity.TestEntity;
import com.przemo.entity.Users;
import com.przemo.service.DatabaseService;
import com.przemo.service.DatabaseServiceImpl;







@Controller
@Transactional
public class TestDatabase 
{
	@Autowired
	private DatabaseService databaseService;
	

	@Autowired
	SessionFactory sessionFactory;
	
	@GetMapping("/db")
	public String showFormForAdd() {
		
		
		
		System.out.println("hehe");
		Users u = databaseService.getUsers(1);
		
		
		System.out.println(u.getCoursesList().get(1).getName());
		
		Users us = new Users();
		us.setEmail("test");;
		us.setPassword("test123");
		
		databaseService.createUser(us);
		return "firstpage";
	}
}
