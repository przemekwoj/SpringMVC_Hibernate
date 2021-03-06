package com.przemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.przemo.entity.Courses;
import com.przemo.entity.Users;

@Repository
public class CoursesDaoImpl implements CoursesDao
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Courses getCourses(int theId)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		return currentSession.get(Courses.class, theId);
	}

	public List<Users> getListOfUsers(int theId)
	{	
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Courses.class, theId).getUsersList();
	}

	public void deleteCourse(int theId)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.delete( getCourses(theId) );
	}

	public void supdateCourse(int theId) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate( getCourses(theId) );

	}

	public void createCourses(Courses courses) 
	{
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.save(courses);
	}

	public List<Courses> getAllCourses()
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("from Courses");
		List allCourses= query.list();
		
		return allCourses;
	}

	public void saveCourse(Courses course)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(course);
	}


	@Override
	public void updateCourse(Courses course) 
	{
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.update(course);
	}

	
	
	

}
