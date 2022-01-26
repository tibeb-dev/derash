package com.webproject.derash.controller;

import java.util.List;
import java.util.Properties;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import com.webproject.derash.entity.Report;
import com.webproject.derash.entity.Station;
import com.webproject.derash.entity.User;
import com.webproject.derash.repository.ReportRepository;
import com.webproject.derash.repository.StationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
@RequestMapping("/report")
public class ReportController{
    
    @Autowired
    private StationRepository stationRepo;
    @Autowired
    private ReportRepository reportRepo;

    
	@Autowired
	private JavaMailSender javaMailSender;
    
    
    @ModelAttribute("stations")
    public List<Station> getStationLocation(){
        List<Station> stations=stationRepo.findAll();
        return stations;
    }
    
    
    @GetMapping
    public String report(Model model){

        model.addAttribute("report", new Report());
        return "report";
    }

    @PostMapping
    public String processReportForm( @Valid Report report,User user,Errors errors) {
     
    	if(errors.hasErrors()){
         return "report";
       }
    	String location=report.getLocation();
    	System.out.print("worked correctly");
        Station station=stationRepo.findByLocation(location);
        String email=station.getEmail();
       
       	try {
       		
       	 String information = "location  "+  report.getLocation() +"\n"+"Date  " +
       	 report.getDate() + "\n" + 	"Time  "
       		  + report.getTime() + "\n"    +  "Crime Type  "+report.getDescription();
			
       	 System.out.print(information);
       
 
       	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        System.out.print("email asdtyujffh");
        
        
        
        System.out.print(email + "email");
        
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("new report");
        mimeMessageHelper.setText(information);
        
        javaMailSender.send(mimeMessage);
        System.out.print("worked correctly");
			
			
			
		} catch (Exception e) {
			
			return "unsubmitted";
		}
     
      
       reportRepo.save(report);
        
        return "submitted";
    }
}