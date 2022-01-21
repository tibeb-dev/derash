package com.webproject.derash.controller;

import javax.validation.Valid;

import com.webproject.derash.entity.Report;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/report")
public class ReportController{
    @GetMapping
    public String report(Model model){
        model.addAttribute("report", new Report());
        return "report";
    }

    @PostMapping
    public String processRegistration( @Valid Report report,Errors errors) {
       if(errors.hasErrors()){
         return "report";
       }
        
        return "login";
    }
}