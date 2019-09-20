/**
 * 
 */
package com.metacube.EADSession14.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.metacube.EADSession14.model.commands.MyUserDetails;
import com.metacube.EADSession14.model.commands.User;
import com.metacube.EADSession14.service.StudentService;

/**
 * This class used to get UserDetailsService Object. this class have implementations of UserDetailsService interface
 * @author Vinod
 *
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	StudentService service;

	/* 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username){
		User user = service.findUserByName(username);
		System.out.println(user.getUsername()+user.getPassword()+user.getRole());
		
		if(user==null){
			throw new UsernameNotFoundException("User Not Found");
		}
			
		return new MyUserDetails(user);
	}

}
