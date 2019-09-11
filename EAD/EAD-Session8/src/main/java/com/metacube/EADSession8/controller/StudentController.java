/**
 * 
 */
package com.metacube.EADSession8.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.EADSession8.model.commands.StudentCommands;
import com.metacube.EADSession8.service.StudentData;


/**
 * This class is Controller for our application every request will go thorugh this class
 * @author Vinod
 *
 */

@Controller
public class StudentController {
	
	//To get value from the yml file for notice at home page
	@Value("${home.notice}")
	private String schoolNotice;
	
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "test";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("notice", schoolNotice);
		return "home";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute(new StudentCommands());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String doSignup(@Validated StudentCommands student, BindingResult result ) {
		
		System.out.println(student.toString());
		
		
		if(result.hasErrors()) { //For field Errors
			return "signup";
		}else {//For Global Error
			if(student.getEmail().equals("vinod.sharma1@metacube.com")) {
				ObjectError objectError = new ObjectError("Email","Email Must be unique");
				result.addError(objectError);
				return "signup";
			}else {
				return "redirect:/home";	
			}
			
		}
		
	}
	
	@GetMapping("/showAll")
	public String showAllStudent(Model model) {
		StudentData obj = new StudentData();
		model.addAttribute("list", obj.getAllStudent());
		//System.out.println("here");
		return "showAll";
	}
	
	
}
