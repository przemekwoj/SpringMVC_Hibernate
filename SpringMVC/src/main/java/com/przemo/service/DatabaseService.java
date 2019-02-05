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
	
	public void updateUser(Users user);
	
	public void updateCourse(Courses course);
	
	public void createUser(Users user);
	
	public void createCourses(Courses courses);
	
	public List<Users> getAllUsers();
	
	public List<Courses> getAllCourses();
	
	public void saveUser(Users user);
	
	public void saveCourse(Courses course);
	

	
}
