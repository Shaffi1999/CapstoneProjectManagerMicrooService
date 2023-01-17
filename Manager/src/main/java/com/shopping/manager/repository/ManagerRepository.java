package com.shopping.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopping.manager.entity.Manager;
@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer>{
	public  Manager findByEmail(String email);
	public Manager findByUserIdAndPassword(int userId,String password);
	
}
