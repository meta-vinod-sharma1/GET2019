package com.shopping.factory;

import java.sql.SQLException;

import com.shopping.dao.ProductDao;
import com.shopping.enums.DBType;

public class Factory {
       
    /**
     * This method creates and returns ProductDao type Object
     * @return {ProductDao} ProductDao Object
     */
    public static ProductDao createProductDao(DBType dbType){
        try {
			return new ProductDao(dbType);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
}
