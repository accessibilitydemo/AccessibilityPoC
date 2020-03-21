package com.form.model;

public class Summary {
	
	//NAME INPUTS
	private String firstname;
	private String lastname;
	
	//DDL-list
	private String roles;
	
	//Checkboxit
	private boolean yesGrant;
	private boolean noGrant;
	
	//TEXTBOXES 1 & 2
	private String grantBefore;
	private String grantNow;
	
	//Radiobutton - HH/METRO/OTHER
	private String radio;
	
	//TEXTBOX 3
	private String currentJob;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public boolean isYesGrant() {
		return yesGrant;
	}

	public void setYesGrant(boolean yesGrant) {
		this.yesGrant = yesGrant;
	}

	public boolean isNoGrant() {
		return noGrant;
	}

	public void setNoGrant(boolean noGrant) {
		this.noGrant = noGrant;
	}

	public String getGrantBefore() {
		return grantBefore;
	}

	public void setGrantBefore(String grantBefore) {
		this.grantBefore = grantBefore;
	}

	public String getGrantNow() {
		return grantNow;
	}

	public void setGrantNow(String grantNow) {
		this.grantNow = grantNow;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getCurrentJob() {
		return currentJob;
	}

	public void setCurrentJob(String currentJob) {
		this.currentJob = currentJob;
	}
	
	
}
