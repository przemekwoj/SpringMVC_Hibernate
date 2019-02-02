package com.przemo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
