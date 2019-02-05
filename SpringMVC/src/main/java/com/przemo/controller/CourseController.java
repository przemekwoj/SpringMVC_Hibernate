package com.przemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.przemo.entity.Courses;
import com.przemo.entity.Users;
import com.przemo.service.DatabaseService;

@Controller
@Transactional
@RequestMapping("/course")
public class CourseController
{
	@Autowired
	private DatabaseService databaseService;
	
	@GetMapping("/addCourseForm")
	public String addUser(Model theModel)
	{
		theModel.addAttribute("course",new Courses());
		return "addCourseForm";
	}
	
	
	@GetMapping("/showCoursesForm")
	public String showCoursesForm(Model theModel)
	{
		List<Courses> allCourses = databaseService.getAllCourses();
		theModel.addAttribute("allCourses",allCourses);
		
		return "showCourses";
	}
	
	@PostMapping("/saveCourse")     
	public ModelAndView saveUser(@ModelAttribute("course") Courses course, RedirectAttributes redirectAttributes)
	{
		
		boolean repeatedName = false;
		List<Courses> listCourses = databaseService.getAllCourses();
		//check f name is repeated
		for(Courses cr : listCourses)
		{
			if(cr.getName().equals(course.getName()))
			{
				repeatedName = true;
				break;
			}
		}
		//redirect if wrong
		if(repeatedName == true)
		{
			ModelAndView modelAndView = new ModelAndView("redirect:/course/addCourseForm");
			redirectAttributes.addFlashAttribute("error", "this course is already exist");
			return modelAndView;
		}
		else
		{
			databaseService.saveCourse(course);
			return new ModelAndView("redirect:/begin/table");
		}
		
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteCourse(@RequestParam("courseId") int theId)
	{
		databaseService.deleteCourse(theId);
		return new ModelAndView("redirect:/course/showCoursesForm");
	}
	
	@GetMapping("/update")
	public String updateCourse(@RequestParam("courseId") int theId)
	{
		return "updateForm";
	}
	
	@GetMapping("/view")
	public String viewCourse(@RequestParam("courseId") int theId,Model theModel)
	{
		Courses course = databaseService.getCourses(theId);
		theModel.addAttribute("course",course);
		
		List<Users> listUsers = new ArrayList<Users>();
		//we need to do this coz getCoursesList() at Lazy fetch , works only when is session open , 
		//so we cant use it in jsp , so we have to get value from session and copy it to other object
		//that we can use it later in jsp
		int size = course.getUsersList().size();
		
		for(int i = 0 ; i < size ; i++)
		{
			Users user = course.getUsersList().get(i);
			listUsers.add(user);
		}
		
		theModel.addAttribute("listUsers",listUsers);
		
		
		return "particularCourse";
	}
	
}
