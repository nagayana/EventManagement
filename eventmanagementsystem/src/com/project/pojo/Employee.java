package com.project.pojo;

public class Employee {

	private int employeeId, designationId;
	private String firstName,lastName, type, userName, password;

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public int getDesignationId() {
		return designationId;
	}

	
	public String getType() {
		return type;
	}

	public String getUsername() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Employee(int employeeId,String firstName,String lastName,int designationId,String type,String userName,String password) {
		super();
		
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designationId = designationId;
		this.type = type;
		this.userName = userName;
		this.password = password;
	}
}
