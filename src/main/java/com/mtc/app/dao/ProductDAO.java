package com.mtc.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mtc.app.vo.Product;

@Repository("productDAO")
public class ProductDAO implements IProductDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ProductRowMapper productRowMapper;
	
	@Autowired
	private ProductPreparedStatementSetter preparedStatementSetter;
	
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		String insertQuery="insert into test.product(product_id,product_name,product_price,product_description)"
				+"values(?,?,?,?)";	
	
	int i=jdbcTemplate.update(insertQuery,product.getId(),product.getName(),product.getPrice(),product.getDescription());
	if(i==1){
		System.out.println("RECORD ADDED SUCCESSFULLY ");
	}
	
	}
	public Product getproductById(int id) {
		String selectQuery="select * from test.product where product_id=?";
		Product product =jdbcTemplate.queryForObject(selectQuery, productRowMapper, id);
		return product;
	}
	public List<Product> getproducts() {
		String selectQuery="select * from test.product";
		List<Product> productsList=jdbcTemplate.query(selectQuery, productRowMapper);
		return productsList;
	}
	public Float getMaxPrice(){
		String maxPriceQuery="select max(product_price) from test.product";
	Float price=jdbcTemplate.queryForObject(maxPriceQuery, Float.class); 
		return price;
	}
	public void addProducts(List<Product> products) {
		String insertQuery="insert into test.product(product_id,product_name,product_price,product_description)"
				+"values(?,?,?,?)";	
		
		preparedStatementSetter.setProductsList(products);
		jdbcTemplate.batchUpdate(insertQuery, preparedStatementSetter);
		
	}
	

}
