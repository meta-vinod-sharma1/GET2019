/**
 * 
 */
package com.metacube.EADSession11.controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.EADSession11.model.commands.StudentCommands;
import com.metacube.EADSession11.service.StudentService;




/**
 * This class is Controller for our application every request will go thorugh this class
 * @author Vinod
 *
 */

@Controller
public class StudentController implements Serializable{
	
	@Autowired
	StudentService service;
	
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "test";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		System.out.println("h");
		model.addAttribute("notice", "here");
		return "home";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute(new StudentCommands());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String doSignup(@Validated StudentCommands student, BindingResult result, RedirectAttributes attributes ) {
		
		System.out.println(student.toString());
		
		
		if(result.hasErrors()) { //For field Errors
			return "signup";
		}else {//For Global Error
			if(service.isEmailExist(student.getEmail())){
				ObjectError objectError = new ObjectError("Email","Email Already Exist");
				result.addError(objectError);
				return "signup";
			}else {
				service.addStudent(student);
				attributes.addFlashAttribute("msg", "Student Added Successfully");
				return "redirect:/home";	
			}
			
		}
		
	}
	
	@GetMapping("/showAll")
	public String showAllStudent(Model model) {
		model.addAttribute("list", service.getAll());
		return "showAll";
	}
	
	
}
