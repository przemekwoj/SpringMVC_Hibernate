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

	public void updateUser(Users user) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.update(user);
		
	}

	public void createUser(Users user) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(user);
	}

	public List<Users> getAllUsers() 
	{
		Session currentSession = sessionFactory.getCurrentSession();
	
		Query query = currentSession.createQuery("from Users");
		List allUsers = query.list();
		
		return allUsers;
	}

	public void saveUser(Users user) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(user);
	}

}
