package com.przemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.przemo.dao.CoursesDao;
import com.przemo.dao.UsersDaoImpl;
import com.przemo.entity.Courses;
import com.przemo.entity.Users;

@Service
public class DatabaseServiceImpl implements DatabaseService
{
	@Autowired
	private CoursesDao coursesDao;
	
	@Autowired
	private UsersDaoImpl usersDao;
	
	public Users getUsers(int theId)
	{
		return usersDao.getUsers(theId);
	}
	
	public Courses getCourses(int theId) 
	{
		return coursesDao.getCourses(theId);
	}
	
	public List<Courses> getListOfCourses(int theId) 
	{
		return usersDao.getListOfCourses(theId);
	}

	public List<Users> getListOfUsers(int theId)
	{
		return coursesDao.getListOfUsers(theId);
	}

	public void deleteUser(int theId) 
	{
		usersDao.deleteUser(theId);
	}

	public void deleteCourse(int theId) 
	{
		coursesDao.deleteCourse(theId) ;
	}

	public void saveOrUpdateUser(int theId)
	{
		usersDao.saveOrUpdateUser(theId);
	}

	public void saveOrUpdateCourse(int theId)
	{
		coursesDao.saveOrUpdateCourse(theId);
	}

	public void createUser(Users user) 
	{
		usersDao.createUser(user);
	}

	public void createCourses(Courses courses) 
	{
		coursesDao.createCourses(courses);
	}

	public List<Users> getAllUsers() 
	{
		return usersDao.getAllUsers();
	}

	public void saveUser(Users user) 
	{
		usersDao.saveUser(user);	
	}

	public List<Courses> getAllCourses() 
	{
		return coursesDao.getAllCourses();
	}

	public void saveCourse(Courses course) 
	{
		coursesDao.saveCourse(course);		
	}
	
	




}
