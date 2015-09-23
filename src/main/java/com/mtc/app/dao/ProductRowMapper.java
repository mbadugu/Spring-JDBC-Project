package com.mtc.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mtc.app.vo.Product;

@Component("productRowMapper")
public class ProductRowMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet resultSet, int rowNo) throws SQLException {
		
		Product product = new Product();
		product.setId(resultSet.getInt("product_id"));
		product.setName(resultSet.getString("product_name"));
		product.setPrice(resultSet.getFloat("product_price"));
		product.setDescription(resultSet.getString("product_description"));
		
		return product;
	}

	
}
