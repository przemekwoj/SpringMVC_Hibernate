package com.przemo.dao;

import java.util.List;

import com.przemo.entity.Courses;
import com.przemo.entity.Users;

public interface CoursesDao 
{
	public Courses getCourses(int theId);
	
	public List<Users> getListOfUsers(int theId);
	
	public void deleteCourse(int theId);

	public void updateCourse(Courses course);
	
	public void createCourses(Courses courses);
	
	public List<Courses> getAllCourses();
	
	public void saveCourse(Courses course);
}
