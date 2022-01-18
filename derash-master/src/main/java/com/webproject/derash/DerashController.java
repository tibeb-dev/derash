package com.webproject.derash;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DerashController {
		@Autowired
	    private LoginRepository loginRepo;
		@Autowired
		private RegisterRepository registerRepo;
	     
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
	    public String processRegister(RegisterPage user) {
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(user.getPassword());
	       
	        user.setPassword(encodedPassword);
	         
	        registerRepo.save(user);
	         
	        return "home";
	    }
	    @PostMapping("/logged")
	    public String processRegister(@Valid LoginPage user,Errors errors) {
	       
	        
	         
	        return "report page";
	    }
}