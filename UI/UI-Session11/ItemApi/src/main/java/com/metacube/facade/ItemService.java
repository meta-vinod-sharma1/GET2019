package com.metacube.facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.Validation.DataValidation;
import com.metacube.database.DAO;
import com.metacube.model.Item;

/**
 * This class used to take call towards Dao layer
 * @author Vinod
 *
 */
public class ItemService {
	
	
	DAO daoObj = null;

	/**
	 * Service Method to show all books
	 * 
	 * @return
	 */
	public List<Item> getItems() {
		// Adding all books in arrayList
		List<Item> itemList = new ArrayList<Item>();
		try {
			daoObj = new DAO();
			ResultSet result = daoObj.getItems();
			while (result.next()) {
				Item item = new Item();
				item.setId(result.getInt("id"));
				item.setName(result.getString("name"));
				item.setDescription(result.getString("description"));
				item.setPrice(result.getString("price"));
				item.setCategory(result.getString("category"));
				item.setImgUrl(result.getString("imgUrl"));
				itemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}

}
