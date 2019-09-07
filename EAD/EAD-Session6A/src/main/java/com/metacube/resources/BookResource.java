package com.metacube.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.metacube.facade.BookResourceService;
import com.metacube.model.Book;

@Path("books")
public class BookResource {
	
	
	BookResourceService bookService = null;
	
	// Create a new book record
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("add")
	
	/**
	 * This method used to add book in the book table
	 * @param book book pojo 
	 * @return message of successful or failed
	 */
	public String handleAddBookRequest(Book book) {
	//	System.out.println(book.getId()+book.getTitle());
		
		bookService = new BookResourceService();
		boolean isAdded = bookService.addBook(book);
		if (isAdded)
			return "Book Added Successfully";
		else
			return "Unsucessful!! Please try again";
	}
	
	
	
	// Retrieve all books

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("showAll")
	/**
	 * This method used to show all books in the book table
	* @return
	*/
	public List<Book> handleShowAllBooks() {
		bookService = new BookResourceService();
			List<Book> bookList = bookService.getAllBooks();
			return bookList;
	}
	
	// Retrieve book by title

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("showByTitle/{title}")
	/**
	 * This method used to show book by it's title
	 * @param title
	 * @return
	 */
	public List<Book> handleShowBooksByTitle(@PathParam("title") String title) {
		bookService = new BookResourceService();
		System.out.println(title);
		List<Book> bookList = bookService.getBooksByTitle(title);
		return bookList;
	}
	
	//Update book by title and published year
	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Path("updateBook")
	/**
	 * This method handles the update book by title and publisher year request
	 * @param book
	 * @return
	 */
	public String handleUpdateBookRequest(Book book) {
		System.out.println(book.toString());
		bookService = new BookResourceService();
		boolean isUpdated = bookService.updateBooks(book);
		if (isUpdated)
			return "Update Successful";
		else
			return "Update Unsuccessful";
	}
	
	//Delete by book id
	@DELETE
	@Produces(MediaType.TEXT_HTML)
	@Path("deleteById/{id}")
	/**
	 * This method handles delete book by id request
	 * @param id
	 * @return
	 */
	public String handleDeleteBooksByIdRequest(@PathParam("id") int id) {
		bookService = new BookResourceService();
		boolean isDeleted = bookService.deleteBooksById(id);
		if (isDeleted)
			return "Deleted Successfully";
		else
			return "Unsuccessful!! Please Try Again";
	}
	
	//Delete all records
	@DELETE
	@Produces(MediaType.TEXT_HTML)
	@Path("deleteAll")
	/**
	 * This method handles the request of deleting all books
	 * @return
	 */
	public String handleDeleteAllBooksRequest() {
		bookService = new BookResourceService();
		if (bookService.deleteAllBooks() > 0)
			return "Delete Successful";
		else
			return "Unsuccessfull";
	}
}
