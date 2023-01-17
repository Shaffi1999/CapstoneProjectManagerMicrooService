package com.shopping.manager.service;

import java.util.List;

import com.shopping.manager.entity.Manager;
import com.shopping.manager.model.Product;

public interface IManagerService {
	public Manager add(Manager manager);
	public Manager fetchUserByEmailId(String email);
	public Manager fetchUserByUserIdAndPassword(int userId,String password);
	public List<Product> getAllProducts();
	public Product addProduct(Product product);
	public Product updateProduct(int id,Product product);
	public Boolean deleteProduct(int id);
	public Product getProductById(int id);
}
