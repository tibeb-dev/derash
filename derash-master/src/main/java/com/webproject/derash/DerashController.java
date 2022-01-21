package com.webproject.derash;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DerashController {
		@Autowired
	    private LoginRepository loginRepo;
		@Autowired
		private RegisterRepository registerRepo;
		@Autowired
		private UserCrudRepository crudRegisterRepo;
	     
	    @GetMapping("/")
	    public String viewHomePage() {
	        return "home";
	    }
	    
	    @GetMapping("/signUp")
	    public String signUpForm(Model model) {
	        model.addAttribute("signup", new RegisterPage());

	        return "signup page";
	    }
	    
	    @GetMapping("/about")
	    public String aboutPage(Model model) {
	        return "about";
	    }
	    
	    @GetMapping("/signIn")
	    public String signInForm(Model model) {
	        model.addAttribute("signin", new LoginPage());

	        return "login page";
	    }
	    
	  
	    @PostMapping("/registered")
	    public String processRegister(@ModelAttribute RegisterPage signup, Model model) {
	        model.addAttribute("signup", new RegisterPage());
	    	
	    	System.out.print("ajvhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	    	
	    	int length = String.valueOf(signup.getPassword()).length();
	    	
	    	System.out.print(length);
	    	
	    	if(length <= 8) {
	    		return "error";
	    	}
	    	
	    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(signup.getPassword());
	        String stripedEmail = signup.getEmail().strip();
	        System.out.print(stripedEmail);
	        
	        signup.setPassword(encodedPassword);
	        signup.setEmail(stripedEmail);
	        
	        registerRepo.save(signup);
	        return "login page";

//	        RegisterPage emailInDatabase = crudRegisterRepo.findByEmail(user.getEmail());
//	        System.out.print(emailInDatabase != null); 
//	        System.out.print(emailInDatabase);
//
//	        if (emailInDatabase == null) {
//	        	 registerRepo.save(user);
//	 	        
//	 	        return "home";
//	        }
//	        else {
//	            return "signup page";
//	        }
//	 
	    }
	    @PostMapping("/logged")
	    public String processRegister(@ModelAttribute LoginPage signin, BindingResult result, Model model ) {
	        model.addAttribute("signin", new LoginPage());

	    	 if (result.hasErrors()) {
	             return "signup page";
	         }
	    	
	    	
	    	String stripedEmail = signin.getEmail().strip();
	    	signin.setEmail(stripedEmail);
	        
	         
	        return "report page";
	    }
}