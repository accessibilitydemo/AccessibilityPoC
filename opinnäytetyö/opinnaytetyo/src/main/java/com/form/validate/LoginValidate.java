package com.form.validate;

import com.form.model.Login;

public class LoginValidate {
	
	public static void main(String[] args) {

	}
	
	public boolean Validate(String u, String p) {
		int count = 0;
		//username
		if(u.equals("thesis")) {
			count++;
		} else {
			System.out.println("username doesnt exist");
		}
		//password
		if(p.equals("thesis")) {
			count++;
		} else {
			System.out.println("password doesnt exist");
		}
		//return value accordingly
		if(count == 2) {
			return true;
		}
		return false;
	}
}
