import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mtc.app.dao.ProductDAO;
import com.mtc.app.vo.Product;

public class Test {
	public static void main(String[] args){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
		ProductDAO productDAO=applicationContext.getBean("productDAO", ProductDAO.class);
		
		
		//Product product = new Product(106,"Nikon Camera",500,"DLSR");
		//productDAO.addProduct(product);
//		Product product=productDAO.getproductById(105);
//		System.out.println("ProductId:"+ product.getId());
//		System.out.println("ProductName:"+ product.getName());
//		System.out.println("ProductDescription:"+ product.getDescription());
//		System.out.println("ProductPrice:"+ product.getPrice());
//		System.out.println();
		
//		List<Product> productsList=productDAO.getproducts();
//		for (Product product : productsList) {
//			
//		
//		System.out.println("ProductId:"+ product.getId());
//		System.out.println("ProductName:"+ product.getName());
//		System.out.println("ProductDescription:"+ product.getDescription());
//		System.out.println("ProductPrice:"+ product.getPrice());
//		System.out.println();
//	}
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(107,"Sony",40000,"Smart TV"));
		products.add(new Product(108,"Rayban",500,"Glasses"));
		products.add(new Product(109,"Rebook",200,"Shoes"));
		productDAO.addProducts(products);
			

}
}
