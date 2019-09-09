/**
 * 
 */
package com.metacube.assignment.service.imp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.metacube.assignment.service.MailSender;



/**
 * @author Vinod
 *
 */
//@Primary
//@Component
public class SmtpMailSender implements MailSender {

	/* 
	 * @see com.metacube.session7.service.MailSender#sendMail()
	 */
	@Override
	public String sendMail() {
		return "This mail is coming from Smtp Mail sender";
	}

}
