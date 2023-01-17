package com.shopping.manager.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shopping.manager.entity.Manager;
import com.shopping.manager.model.Product;
import com.shopping.manager.repository.ManagerRepository;
@Service
public class ManagerService implements IManagerService{
	Logger logger=LoggerFactory.getLogger(ManagerService.class);
	@Autowired
	private ManagerRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Manager add(Manager manager) {
		logger.info("Entered Add Manager service Rest Api");
		return repo.save(manager);
	}

	@Override
	public Manager fetchUserByEmailId(String email) {
		logger.info("Entered fetchUserByEmailId service Rest Api ");
		return repo.findByEmail(email);
	}

	@Override
	public Manager fetchUserByUserIdAndPassword(int userId, String password) {
		logger.info("Entered  fetchUserByUserIdAndPassword service Rest Api ");
		return repo.findByUserIdAndPassword(userId, password);
	}

	@Override
	public List<Product> getAllProducts() {
		logger.info("Entered  getAllProducts service Rest Api this will communicate with product get all rest api");
		List<Product> products= restTemplate.getForObject("http://localhost:8083/product/getAll", List.class);
		return products;
	}

	@Override
	public Product addProduct(Product product) {
		logger.info("Entered  addProduct service Rest Api this will communicate with product add prouduct rest api");
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8083/product/add", HttpMethod.POST, entity, Product.class).getBody();
	   }

	@Override
	public Product updateProduct(int id, Product product) {
		logger.info("Entered  getAllProducts service Rest Api this will communicate with product update product rest api");
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8083/product/update/"+id, HttpMethod.PUT, entity, Product.class).getBody();
	}

	@Override
	public Boolean deleteProduct(int id) {
		logger.info("Entered  delete product service Rest Api this will communicate with product delete product rest api");
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Product> entity = new HttpEntity<Product>(headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8083/product/delete/"+id, HttpMethod.DELETE, entity, Boolean.class).getBody();
	}

	@Override
	public Product getProductById(int id) {
		logger.info("Entered  getProductById service Rest Api this will communicate with product  getProductById rest api");
		return restTemplate.getForObject("http://localhost:8083/product/get/"+id, Product.class);
	}
	
	
	
	

	
	
	
		
	}


