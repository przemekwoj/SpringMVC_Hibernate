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
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private DatabaseService databaseService;
	
	@GetMapping("/update")
	public String updateUser(@RequestParam("userId") int theId)
	{
		System.out.println("updated"+theId);
		return "update_user";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int theId)
	{
		
		System.out.println("deleted"+theId);
		databaseService.deleteUser(theId);
		return "firstpage";
	}
	
	@GetMapping("/view")
	public String viewUser(@RequestParam("userId") int theId, Model theModel)
	{
		Users user_proxy = databaseService.getUsers(theId);
		theModel.addAttribute("user",user_proxy);
		
		List<Courses> listCourses = new ArrayList<Courses>();
		//we need to do this coz getCoursesList() at Lazy fetch , works only when is session open , 
		//so we cant use it in jsp , so we have to get value from session and copy it to other object
		//that we can use it later in jsp
		int size = user_proxy.getCoursesList().size();
		
		for(int i = 0 ; i < size ; i++)
		{
			Courses course = user_proxy.getCoursesList().get(i);
			listCourses.add(course);
		}
		
		theModel.addAttribute("listCourses",listCourses);
				
		return "view_user_page";
	}
	
	@GetMapping("/addUserForm")
	public String addUser(Model theModel)
	{
		theModel.addAttribute("user", new Users());
		return "addUserForm";
	}
	
	//I used here RedirectAttributes coz i want to send error to other controller
	@PostMapping("/saveUser")     
	public ModelAndView saveUser(@ModelAttribute("user") Users user, RedirectAttributes redirectAttributes)
	{
		if(user.getEmail().contains("@"))
		{
		databaseService.saveUser(user);
		return new ModelAndView("redirect:/begin/table");
		}
		else
		{
			ModelAndView modelAndView = new ModelAndView("redirect:/user/addUserForm");
			redirectAttributes.addFlashAttribute("error", "you didnt use email!");
			return modelAndView;
		}
			

	}
}
