package com.webproject.derash.security;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class RegistrationController {

   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;

   @GetMapping("/register")
   public String registerForm(Model model) {
     model.addAttribute("user", new User());
     return "registeration";
   }

   @PostMapping("/register")
   public String processRegistration( @Valid User user,BindingResult result, RegistrationForm form) {
    User existing1 = userRepository.findByUsername(user.getUsername());
    User existing2 = userRepository.findByEmail(user.getEmail());

    if (existing1 != null){
      result.rejectValue("username", null, "There is already an account registered with that username");
     }
     if (existing2 != null){
      result.rejectValue("email", null, "There is already an account registered with that eamil");
     }
     if (!(form.getPassword().equals(form.getConfirmpassword()) )){
      result.rejectValue("confirmpassword", null, "confirm password should match the password");
     }

    if(result.hasErrors()){
        return "registeration";
      }
      
      
    userRepository.save(form.toUser(passwordEncoder));
    return "redirect:/login";
  }


}

