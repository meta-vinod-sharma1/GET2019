/**
 * 
 */
package com.metacube.assignment.service.imp;

import org.springframework.stereotype.Component;

import com.metacube.assignment.service.MailSender;


/**
 * @author Vinod
 *
 */
//@Component
public class MockMailSender implements MailSender {

	/* 
	 * @see com.metacube.session7.service.MailSender#sendMail()
	 */
	@Override
	public String sendMail() {
		return "This mail is coming from Mock Mail sender";
	}

}
