package com.metacube.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Book POJO
 * @author Vinod
 *
 */
@XmlRootElement
public class Book {
	private int id;
	private int publishedYear;
	private String title;
	private String writer;
	private String publisher;
	
	
	
	/**
	 * @return the bookID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param bookID the bookID to set
	 */
	public void setId(int bookID) {
		this.id = bookID;
	}
	/**
	 * @return the publishedYear
	 */
	public int getPublishedYear() {
		return publishedYear;
	}
	/**
	 * @param publishedYear the publishedYear to set
	 */
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}
	/**
	 * @param writer the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}	
}
