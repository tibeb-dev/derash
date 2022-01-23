package com.webproject.derash.controller;

import javax.validation.Valid;

import com.webproject.derash.entity.Report;
import com.webproject.derash.repository.ReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping

public class ReportController{
    @Autowired
    private ReportRepository repo;
    @GetMapping("/report")
    public String reportForm(Model model) {
      model.addAttribute("report", new Report());
      return "report";
    }

    @PostMapping("/report")
    public String processReport( @Valid Report report,BindingResult result) {
       if(result.hasErrors()){
         return "report";
       }
       repo.save(report);
        
        return "redirect:/login";
    }
}