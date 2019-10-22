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

import com.metacube.facade.ItemService;
import com.metacube.model.Item;

@Path("items")
public class BookResource {
	
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("get")
	/**
	 * This method used to get all items 
	* @return
	*/
	public List<Item> getItems() {
	
		ItemService itemService = new ItemService();
		List<Item> itemList = itemService.getItems();
		System.out.println(itemList.size());
		return itemList;
	}
	
}
