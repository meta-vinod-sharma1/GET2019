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
/**
 * This is Controller class of Application Every Request of application will be handle here
 * @author Vinod
 *
 */
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
		System.out.println("here");
		return "login";
	}
	@PostMapping("/login")
	public String loggedIn(@RequestParam String email, @RequestParam String password,HttpSession session,Model model){
		EmployeeInfo info = service.getEmpoyeeInfo(email, password);
		//System.out.println(info.toString());
		if(info == null){
			System.out.println("Invalid Email and Password");
			return "login";
		}else{
			session.setAttribute("email", info.getEmail());
			session.setAttribute("image", info.getImage());
			model.addAttribute("empId", info.getEmpId());
			if(info.getVehicleNumber()== null){//first time or not check
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
	public String edit(EmployeeCommands emp, Model model, HttpSession session){
		emp = service.getEmployeeByEmail((String)session.getAttribute("email"));
		System.out.println(emp.toString());
		model.addAttribute(emp);
		return "editProfile";
	}
	
	@PostMapping("/editProfile")
	public String doEdit(@Validated EmployeeCommands emp, BindingResult result){
		if(result.hasErrors()){
			return "editProfile";
		}else{
			if(!emp.getPassword().equals(emp.getConfirmPassword())){
				ObjectError objectError = new ObjectError("name","Password is not Matching");
				result.addError(objectError);
				return "editProfile";
			}else{
				if(service.update(emp)){
					System.out.println("Updated");
				}else{
					System.out.println("Error while updating");
				}
				return "home";
			}
		}
	}
	
	//Vehicle Form submitted
	@PostMapping("/vehicleRegister")
	public String vehicleDetails(@RequestParam String vname, @RequestParam String vtype ,
			@RequestParam String vnumber, @RequestParam String empId, @RequestParam String price,@RequestParam String identification, DecodePass decode){
		if(service.addVehicle(Integer.parseInt(empId.trim()), vname, vtype, vnumber, identification) &&
				service.addPlan(Integer.parseInt(empId.trim()), vnumber, decode.plan(price),decode.price(price) )){
			System.out.println("Succesfully Added");
			return "home";
		}else{
			System.out.println("here");
			return "home";
		}
		
	}
	
	//for see Profile
	@GetMapping("/viewProfile")
	public String viewProfile(@RequestParam String email,Model model, HttpSession session){
		
		if(email == null){
			email = (String)session.getAttribute("email");
		}
		System.out.println(email);
		model.addAttribute("profile", service.getProfile(email));
		return "viewProfile";
	}
	
	//friends
	@GetMapping("/friends")
	public String friends(Model model,HttpSession session){
		model.addAttribute("list", service.getFriends((String)session.getAttribute("email")));
		return "friends";
	}
	
	@GetMapping("/uploadPhoto")
	public String uploadPhoto(){
		return "uploadPhoto";
	}
	@PostMapping("/uploadPhoto")
	public String doUploadPhoto(@RequestParam("file") MultipartFile file, HttpSession session){
		 byte[] bytes;
		try {
			bytes = file.getBytes();
			System.out.println(bytes);
			Path path = Paths.get("C:\\Users\\Vinod\\Documents\\work\\EAD\\Spring\\EAD-Session9\\src\\main\\resources\\static\\images\\" + file.getOriginalFilename());
	        Files.write(path, bytes);
	        if(service.uploadPhoto((String)session.getAttribute("email"),file.getOriginalFilename(),(String)session.getAttribute("image"))){
	        	System.out.println("Image Successfully Added");
	        	session.setAttribute("image", file.getOriginalFilename());
	        }else{
	        	System.out.println("Error: in adding image");
	        }
	        
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
