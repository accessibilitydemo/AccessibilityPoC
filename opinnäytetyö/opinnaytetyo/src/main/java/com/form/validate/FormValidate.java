package com.form.validate;

import java.util.regex.Pattern;

import com.form.model.FormOne;
import com.form.model.Summary;

public class FormValidate {
	
	Summary save = new Summary();
	
	public boolean validateNames(String first, String last) {
		if(first.length() > 1 && last.length() > 1) {
			save.setFirstname(first);
			save.setLastname(last);
			return true;
		}
		return false;
	}
	
	public boolean validateRoles(String roles) {
		if(!roles.equals("empty")) {
			save.setRoles(roles);
			return true;
		}
		return false;
	}
	
	public boolean checkBooleans(boolean yes) {
		if(yes == true) {
			save.setYesGrant(true);
			save.setNoGrant(false);
			return true;
		}
		return false;
	}
	
	public boolean validateGrantBefore(String grantBefore) {
		if(grantBefore == null) {
			return true;
		}
		if(grantBefore.length() > 1) {
			save.setGrantBefore(grantBefore);
			return true;
		}
		return false;
	}
	
	public boolean validateGrantNow(String grantNow) {
		if(grantNow.length() > 1) {
			save.setGrantNow(grantNow);
			return true;
		}
		return false;
	}
	
	public boolean validateRadio(String radio) {
		if(!radio.isEmpty()) {
			save.setRadio(radio);
			return true;
		}
		return false;
	}
	
	public boolean validateCurrentJob(String currentJob) {
		if(currentJob.isEmpty() || currentJob.length() < 1) {
			save.setCurrentJob("");
			return false;
		}
		save.setCurrentJob(currentJob);
		return true;
	}
	
	public boolean ValidatePhone(String u) {
		if (u.matches("\\d{4}")) {
			return true;
		}
		else if(u.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
			return true;
		}
		else if(u.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) {
			return true;
		}
		else if(u.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	public boolean ValidateEmail(String u) {
		String emailRegex = "^(.+)@(.+)$";
		if (Pattern.matches(emailRegex,u)) {
			return true;
		}
		return false;
	}
}
