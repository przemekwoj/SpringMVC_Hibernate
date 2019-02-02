package com.przemo.service;

import java.util.List;

import com.przemo.entity.Courses;
import com.przemo.entity.Users;

public interface DatabaseService 
{
	public Users getUsers(int theId);
	
	public Courses getCourses(int theId);
	
	public List<Courses> getListOfCourses(int theId);
	
	public List<Users> getListOfUsers(int theId);
	
	public void deleteUser(int theId);
	
	public void deleteCourse(int theId);
	
	public void saveOrUpdateUser(int theId);
	
	public void saveOrUpdateCourse(int theId);
	
	public void createUser(Users user);
	
	public void createCourses(Courses courses);
	
	

	
}
