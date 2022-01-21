package com.webproject.derash;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 

 
 
 
@Controller
public class loginController {
@Autowired
    private loginService loginService;
 
                                  
    @GetMapping("/login page")
          
    public ModelAndView login() {
     ModelAndView mav = new ModelAndView("login page");
        mav.addObject("user", new LoginPage());
        return mav;
    }
 
    @PostMapping("/login page")
    public String login(@ModelAttribute("user") LoginPage user ) {
    
     LoginPage oauthUser = loginService.login(user.getEmail(), user.getPassword());
    
 
     System.out.print(oauthUser);
     if(Objects.nonNull(oauthUser))
     {
  
     return "redirect:/report";
    
    
     } else {
     return "error"; // for this error page it shoud desiplay such type of user has not any accout just lik this
    
    
     }
 
}
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
    
  
        return "redirect:/login page";
    }
 
}
