/**
 * 
 */
package com.metacube.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.assignment.service.MailSender;
import com.metacube.assignment.service.imp.MockMailSender;
import com.metacube.assignment.service.imp.SmtpMailSender;



/**
 * This class used to Config beans by methods
 * @author Vinod
 *
 */
@Configuration
public class MailConfig {
	
	@Primary
	@Bean
	public MailSender smtpMailSender() {
		return new SmtpMailSender();
	}
	
	
	@Bean
	public MailSender mockMailSender() {
		return new MockMailSender();
	}

}
