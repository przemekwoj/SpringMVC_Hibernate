package com.przemo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.przemo.entity.Users;
import com.przemo.service.DatabaseService;

@Controller
@Transactional
@RequestMapping("/begin")
public class ManagementController
{
	@Autowired
	private DatabaseService databaseService;
	
	@GetMapping("/table")
	public String showManagePage(Model theModel)
	{
		List<Users> allUsers = databaseService.getAllUsers();
		
		theModel.addAttribute("allUsers", allUsers);
		
		return "manage";
	}
}
