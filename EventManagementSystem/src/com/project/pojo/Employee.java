package com.project.pojo;

public class Employee {
	private int employeeId, designationId;
	private String employeeName, type, username, password;

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmployeeName() {
		return employeeName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", designationId=" + designationId + ", employeeName="
				+ employeeName + ", type=" + type + ", username=" + username + ", password=" + password + "]";
	}

	public String getType() {
		return type;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Employee(int employeeId, int designationId, String employeeName, String type, String username,
			String password) {
		super();
		this.employeeId = employeeId;
		this.designationId = designationId;
		this.employeeName = employeeName;
		this.type = type;
		this.username = username;
		this.password = password;
	}

}
