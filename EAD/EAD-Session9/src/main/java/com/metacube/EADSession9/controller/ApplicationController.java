package com.metacube.EADSession9.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.EADSession9.mode.commands.EmployeeCommands;
import com.metacube.EADSession9.mode.commands.EmployeeInfo;
import com.metacube.EADSession9.mode.commands.ProfileCommands;
import com.metacube.EADSession9.service.ApplicationService;
import com.metacube.EADSession9.service.DecodePass;

@Controller
public class ApplicationController {
	
	@Autowired
	ApplicationService service;
	
	//for getting home page
	@GetMapping("/home")
	public String home(){
		return "home";
	}
	
	//login page and after login request
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	@PostMapping("/login")
	public String loggedIn(@RequestParam String email, @RequestParam String password,HttpSession session,Model model){
		EmployeeInfo info = service.getEmpoyeeInfo(email);
		if(info == null){
			return "login";
		}else{
			session.setAttribute("email", info.getEmail());
			session.setAttribute("image", info.getImage());
			if(info.getVehicleNumber()== null){//first time or not check
				model.addAttribute("empId", info.getEmpId());
				return "vehicleForm";
			}else{	
				return "home";
			}
		}
		
		
	}
	
	//Register page and Register a Employee
	@GetMapping("/register")
	public String registerPage(Model model){
		System.out.println("here");
		model.addAttribute(new EmployeeCommands());
		return "register";
	}
	@PostMapping("/register")
	public String doRegister(@Validated EmployeeCommands emp, BindingResult result){
		System.out.println(emp.toString());
		if(result.hasErrors()){
			return "register";
		}else{
			if(!emp.getPassword().equals(emp.getConfirmPassword())){
				ObjectError objectError = new ObjectError("name","Password is not Matching");
				result.addError(objectError);
				return "register";
			}else{//All validated
				if(service.addEmployee(emp)){
					System.out.println("Added successfully ");
					return "login";
				}else{
					System.out.println("Error while adding");
					return "Error";
				}
				
			}
		}
		
	} 
	
	//Edit Profile
	@GetMapping("/editProfile")
	public String edit(EmployeeCommands emp,Model model){
		emp.setEmail("vinod.shram1@metacube.com");
		emp.setName("vinod");
		emp.setPhoneNumber("9660366429");
		model.addAttribute(emp);
		return "editProfile";
	}
	
	@PostMapping("/editProfile")
	public String doEdit(@Validated EmployeeCommands emp, BindingResult result){
		System.out.println(emp.toString());
		if(result.hasErrors()){
			return "editProfile";
		}else{
			if(!emp.getPassword().equals(emp.getConfirmPassword())){
				ObjectError objectError = new ObjectError("name","Password is not Matching");
				result.addError(objectError);
				return "editProfile";
			}else{//All validated
				return "home";
			}
		}
	}
	
	//Vehicle Form submitted
	@PostMapping("/vehicleRegister")
	public String vehicleDetails(@RequestParam String vname, @RequestParam String vtype ,
			@RequestParam String vnumber, @RequestParam String empId, @RequestParam String price,@RequestParam String identification, DecodePass decode){
		//System.out.println(vname+vtype+vnumber+empId+decode.plan(price)+decode.price(price)+identification);
		return "home";
	}
	
	//for see Profile
	@GetMapping("/viewProfile")
	public String viewProfile(@RequestParam String email,Model model){
		System.out.println(email);
		ProfileCommands profile = new ProfileCommands("vinod","vinod.sharma1@metacube.com","966036429","Rj41-CA-4050","Metacube");
		model.addAttribute("profile", profile);
		return "viewProfile";
	}
	
	//friends
	@GetMapping("/friends")
	public String friends(Model model){
		List<String> list = new ArrayList<String>();
		list.add("vinod.sharma1@metacube.com");
		list.add("vinod.sharma2@metacube.com");
		list.add("vinod.sharma3@metacube.com");
		model.addAttribute("list", list);
		return "friends";
	}
	
	@GetMapping("/uploadPhoto")
	public String uploadPhoto(){
		return "uploadPhoto";
	}
	@PostMapping("/uploadPhoto")
	public String doUploadPhoto(@RequestParam("file") MultipartFile file){
		 byte[] bytes;
		try {
			bytes = file.getBytes();
			System.out.println(bytes);
			Path path = Paths.get("C:\\Users\\Vinod\\Documents\\work\\EAD\\Spring\\EAD-Session9\\src\\main\\resources\\static\\images" + file.getOriginalFilename());
	        Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		return "redirect:home";
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession session){
		session.invalidate();
		return "home";
	}
}
