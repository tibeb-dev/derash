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
	        model.addAttribute("user", new RegisterPage());
	         
	        return "signup page";
	    }
	    @GetMapping("/signIn")
	    public String signInForm(Model model) {
	        model.addAttribute("user", new LoginPage());
	         
	        return "login page";
	    }
	    
	  
	    @PostMapping("/registered")
	    public String processRegister(@ModelAttribute RegisterPage user, Model model) {
	    	System.out.print("ajvhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	    	int length = String.valueOf(user.getPassword()).length();
	    	 System.out.print(length);
	    	
	    	
	    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(user.getPassword());
	        String stripedEmail = user.getEmail().strip();
	        System.out.print(stripedEmail);
	        
	        user.setPassword(encodedPassword);
	        user.setEmail(stripedEmail);
	        

	        RegisterPage emailInDatabase = crudRegisterRepo.findByEmail(user.getEmail());
	        System.out.print(emailInDatabase != null); 
	        System.out.print(emailInDatabase);

	        if (emailInDatabase == null) {
	        	 registerRepo.save(user);
	 	        
	 	        return "home";
	        }
	        else {
	            return "signup page";
	        }
	 
	    }
	    @PostMapping("/logged")
	    public String processRegister( LoginPage user, BindingResult result ) {
	  
	    	 if (result.hasErrors()) {
	             return "signup page";
	         }
	    	
	    	
	    	String stripedEmail = user.getEmail().strip();
		        user.setEmail(stripedEmail);
	        
	         
	        return "report page";
	    }
}