package com.przemo.dao;

import java.util.List;

import com.przemo.entity.Courses;
import com.przemo.entity.Users;

public interface UsersDao 
{
	public Users getUsers(int theId);
	
	public List<Courses> getListOfCourses(int theId);
	
	public void deleteUser(int theId);

	public void saveOrUpdateUser(int theId);
	
	public void createUser(Users user);
	
}
