/**
 * 
 */
package com.metacube.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.assignment.service.MailSender;



/**
 * @author Vinod
 *
 */

@RestController
public class MailController {
	private MailSender mailSender;


	/*	//Constructor dependency injection
		@Autowired
		public MailController(MailSender mailSender){
			this.mailSender = mailSender;
		}*/


	/*	//Dependency Injection by name of mockMailSender
		@Autowired
		public void setMailSender(MailSender mockMailSender){
			this.mailSender = mockMailSender;
		}*/


	/*//Dependency Injection by name of smtpMailSender
		@Autowired
		public void setMailSender(MailSender smtpMailSender){
			this.mailSender = smtpMailSender;
		}*/



	/*//Dependency Injection by @Primary Annotation
		@Autowired
		public void setMailSender(MailSender sender){
			this.mailSender = sender;
		}*/

	//Injection Using Qualifier
	/*@Qualifier("mockMailSender")
	@Autowired
	public void setMailSender(MailSender sender){
		this.mailSender = sender;
	}*/

	//Injection by Primary annotation
	@Autowired
	public void setMailSender(MailSender sender){
		this.mailSender = sender;
	}




	@RequestMapping("/send")
	public String mailBody(){
		System.out.println(mailSender.sendMail());
		return mailSender.sendMail();
	}



}
