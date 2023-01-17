package com.shopping.manager.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.shopping.manager.entity.Manager;
import com.shopping.manager.model.Product;
import com.shopping.manager.repository.ManagerRepository;
import com.shopping.manager.service.ManagerService;
@ExtendWith(value= {MockitoExtension.class})
class ManagerControllerTest {
	
	@Mock
	ManagerRepository repository;
	
	@InjectMocks
	ManagerService service;

	@Test
	void testAddManager() {
		Manager manager=new Manager(1,"Shaffi","Mohammad","15-10-199","Male","8096793447","imran80967@gmail.com","Shaffi@1999","User");
		
	     when(repository.save(manager)).thenReturn(manager);
	     assertEquals(manager,service.add(manager));
	}

//	@Test
//	void testAuthenticateMangerLogin() {
//		fail("Not yet implemented");
//	}
//	List<Product> productList=new ArrayList<Product>();
//	@Test
//	void testGetAllProducts() {
//		managerList.add(new Manager(1,"Shaffi","Mohammad","15-10-199","Male","8096793447","imrn80967@gmail.com","Shaffi@1999","User"));
//		//managerList.add(new Manager(2,"Shaffi","Mohammad","15-10-199","Male","8096793447","imran80967@gmail.com","Shaffi@1999","User"));
//		
//		when(repository.findAll()).thenReturn(managerList);
//
//		assertEquals(2,service.getAllProducts().size());
//	}

//	@Test
//	void testAddProduct() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateProduct() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteProduct() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetProductById() {
//		fail("Not yet implemented");
//	}

}
