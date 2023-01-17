package com.shopping.manager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.manager.entity.Manager;
import com.shopping.manager.exception.InvalidException;
import com.shopping.manager.model.Product;
import com.shopping.manager.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	Logger logger=LoggerFactory.getLogger(ManagerController.class);
	
	@Autowired
	private ManagerService service;
	
	@PostMapping("/add")
	public Manager add(@RequestBody Manager manager) throws Exception
	{
		logger.info("Entered add product rest api");
		String email=manager.getEmail();
		if(email!=null && !"".equals(email))
		{
			Manager managerObj=service.fetchUserByEmailId(email);
			if(managerObj!=null)
			{
				logger.warn("User With This Email Id \"+email+\"Is Already Exist:");
				throw new InvalidException("User With This Email Id "+email+"Is Already Exist:");
			}
		}
		
		return service.add(manager);
	}
	
	@PostMapping("/managerlogin")
	public Manager authenticateMangerLogin(@RequestBody Manager manager) throws Exception
	{
		logger.info("Entered authenticateMangerLogin rest api");
		int userId=manager.getUserId();
		String password=manager.getPassword();
		Manager registerationObj=null;
		if(userId!=0 && password!=null)
		{
			registerationObj=service.fetchUserByUserIdAndPassword(userId, password);
		}
		if(registerationObj==null || !(registerationObj.getUserCategory().equalsIgnoreCase("manager")))
		{
			logger.warn("Bad Credentials");
			throw new InvalidException("Bad Credentials");
		}
		return registerationObj;
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts()
	{
		logger.info("Entered get All Products Rest Api");
		return service.getAllProducts();
	}
	
	@PostMapping("/addProduct")
	public Product add(@RequestBody Product product)
	{
		logger.info("Entered add Product Rest Api");
		return service.addProduct(product);
	}
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable("id") int id,@RequestBody Product product)
	{
		logger.info("Entered update Product Rest Api");
		return service.updateProduct(id, product);
	}
	
	@DeleteMapping("/delete/{id}")
	public Boolean deleteProduct(@PathVariable("id") int id)
	{
		logger.info("Entered delete Product Rest Api");
		return service.deleteProduct(id);
	}
	
	@GetMapping("/get/{id}")
	public Product getProductById(@PathVariable("id") int id)
	{
		logger.info("Entered Delete Product Rest Api");
		return service.getProductById(id);
	}

}
