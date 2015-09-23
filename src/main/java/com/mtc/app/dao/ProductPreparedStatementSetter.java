package com.mtc.app.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.mtc.app.vo.Product;

@Component("preparedStatementSetter")
public class ProductPreparedStatementSetter implements BatchPreparedStatementSetter{
private List<Product> productsList;
	
	public int getBatchSize() {
		
		return productsList.size();
	}

	public void setValues(PreparedStatement preparedStatement, int index) throws SQLException {
		Product product=productsList.get(index);
		preparedStatement.setInt(1, product.getId());
		preparedStatement.setString(2,product.getName());
		preparedStatement.setFloat(3, product.getPrice());
		preparedStatement.setString(4, product.getDescription());
		
	}

	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}

}
