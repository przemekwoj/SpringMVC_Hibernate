package com.przemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.przemo.entity.Courses;
import com.przemo.entity.Users;

@Repository
public class UsersDaoImpl implements UsersDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Users getUsers(int theId) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Users.class, theId);
	}

	public List<Courses> getListOfCourses(int theId) 
	{
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Users.class, theId).getCoursesList();

	}

	public void deleteUser(int theId) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.delete( getUsers(theId) );
		
	}

	public void saveOrUpdateUser(int theId) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate( getUsers(theId) );
		
	}

	public void createUser(Users user) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(user);
	}

}
