package com.project.pojo;

public class Designation {
	private int designationId;
	private String designationName;

	public Designation(int designationId, String designationName) {
		super();
		this.designationId = designationId;
		this.designationName = designationName;
	}

	public Designation() {
		super();
	}
	
	

	@Override
	public String toString() {
		return "Designation [designationId=" + designationId + ", designationName=" + designationName + "]";
	}

	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

}
