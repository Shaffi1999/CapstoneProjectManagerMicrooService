package com.shopping.manager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Manager {
	@Id
	private int userId;
	@NotNull(message="First Name Can Not Be Null")
	private String firstName;
	@NotNull(message="Last Name Can Not Be Null")
	private String lastName;
	@NotNull(message="DOB Can Not Be Null")
	private String dob;
	@NotNull(message="Gender Can Not Be Null")
	private String gender;
	@NotNull(message="Contact Number Can Not Be Null")
	private String contactNumber;
	@NotNull(message="Email Can Not Be Null")
	private String email;
	@NotNull(message="Password Can Not Be Null")
	private String password;
	@NotNull(message="User Category Can Not Be Null")
	private String userCategory;
}
