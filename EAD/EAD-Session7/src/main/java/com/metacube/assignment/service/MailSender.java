/**
 * 
 */
package com.metacube.assignment.service;

/**
 * This class used as interface for implementing Mock and Smtp mail sender
 * @author Vinod
 *
 */
public interface MailSender {
	
	/**
	 * This method used to send a mail
	 * @return mail 
	 */
	public String sendMail();

}
