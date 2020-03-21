package com.form.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.form.model.FormOne;
import com.form.model.Login;
import com.form.model.Summary;
import com.form.validate.FormValidate;
import com.form.validate.LoginValidate;

@Controller
public class HomeController {
	
	LoginValidate check = new LoginValidate();
	FormValidate checkForm = new FormValidate();
	Login saveLogin = new Login();
	FormOne form = new FormOne();
	Summary summary = new Summary();
	
	//BROWSER
	//This is the first mapping called: http://localhost:8080/
	@GetMapping("/")
	public String showHomePage(Login login) {
		System.out.println("");
		System.out.println("XXXXXXXXXXXXXXXXX");
		System.out.println("Loading login-page");
		System.out.println("XXXXXXXXXXXXXXXXX");
		System.out.println("");
		return "login";
	}
	
	//LOGIN
	//If login succesfull -> return references.html -> if login fail -> return login.html
	@RequestMapping(value = "/toExplanation", method = RequestMethod.POST)
	public String loadExplanationOrLogin(HttpServletRequest request, @ModelAttribute Login login, BindingResult result, SessionStatus status) {
		System.out.println("username: " + login.getUsername());
		saveLogin.setUsername(login.getUsername());
		System.out.println("username: " + login.getPassword());
		saveLogin.setPassword(login.getPassword());	
		System.out.println("");
		boolean in = check.Validate(login.getUsername(), login.getPassword());
		if(in == true) {
			System.out.println("");
			System.out.println("XXXXXXXXXXXXX");
			System.out.println("Username and pw OK!");
			System.out.println("XXXXXXXXXXXXX");
			System.out.println("Loading explanation- and references-page");
			System.out.println("XXXXXXXXXXXXXXXXX");
			System.out.println("");
			saveLogin.setUsername("");
			saveLogin.setPassword("");
			login.setOk("false");
			return "references";
		} else {
			System.out.println("");
			System.out.println("XXXXXXXXXXXXX");
			System.out.println("Username and pw WRONG!");
			System.out.println("XXXXXXXXXXXXX");
			System.out.println("Loading login-page");
			System.out.println("XXXXXXXXXXXXXXXXX");
			System.out.println("");
			saveLogin.setUsername("");
			saveLogin.setPassword("");
			return "login";
		}
	}
	
	//REFERENCES & EXPLANATION PAGE
	//If user selects 'next' load form page
	@RequestMapping(value = "/toForm", params = "next", method = RequestMethod.POST)
	public String nextLoadFormPage(HttpServletRequest request, @ModelAttribute Login login, BindingResult result, FormOne formOne, SessionStatus status) {
		System.out.println("");
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("Loading mock form page!");
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("");
		return "formOne";
	}
	//If user selects 'logout' load login page
	@RequestMapping(value = "/toForm", params = "logout", method = RequestMethod.POST)
	public String cancelAndGoToLogIn(Login login) {
		System.out.println("");
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("Login out from the website!");
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("");
		return "login";
	}
	
	//FORM PAGE
	//Go to summary page from form
	@RequestMapping(value = "/toSummary", params = "moveToSummary", method = RequestMethod.POST)
	public String submitAndMoveToSUmmary(HttpServletRequest request, @ModelAttribute FormOne form, Login login, BindingResult result, SessionStatus status, FormValidate validate) {
		System.out.println("");
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("Loading summary page!");
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("Loading input validators!");
		System.out.println("XXXXXXXXXXXXX");
		validate.validateNames(form.getFirstname(), form.getLastname());
		validate.validateRoles(form.getRoles());
		validate.checkBooleans(form.isYesGrant());
		validate.validateGrantBefore(form.getGrantBefore());
		validate.validateGrantNow(form.getGrantNow());
		validate.validateRadio(form.getRadio());
		validate.validateCurrentJob(form.getCurrentJob());
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("Validators OK");
		System.out.println("XXXXXXXXXXXXX");
		//Jos halutaan tehdä validaattoreilla jotain...
		System.out.println("");
		return "summary";
	}
	
	//SUMMARY
	//Go to explanation page
	@RequestMapping(value = "/done", params = "moveToExplain", method = RequestMethod.GET)
	public String returnToFormOne(HttpServletRequest request, @ModelAttribute Login login, BindingResult result, FormOne formOne, SessionStatus status) {
		System.out.println("");
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("Loading explain-page");
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("Clearing previous form information");
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("");
		return "references";
	}
	//Return to form from summary
	@RequestMapping(value = "/done", params = "moveToFormOne", method = RequestMethod.GET)
	public String goToExplain(HttpServletRequest request, @ModelAttribute Login login, BindingResult result, FormOne formOne, SessionStatus status) {
		System.out.println("");
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("Loading login-page");
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("Clearing previous form information");
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("");
		return "formOne";
	}
	//Return to login from summary
	@RequestMapping(value = "/done", params = "logout", method = RequestMethod.GET)
	public String goToLogin(HttpServletRequest request, @ModelAttribute Login login, BindingResult result, FormOne formOne, SessionStatus status) {
		System.out.println("");
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("Loading login-page");
		System.out.println("XXXXXXXXXXXXX");
		System.out.println("");
		return "login";
	}
}
