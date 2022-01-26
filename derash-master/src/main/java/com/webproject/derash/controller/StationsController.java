package com.webproject.derash.controller;

import java.util.List;

import javax.validation.Valid;

import com.webproject.derash.entity.Station;
import com.webproject.derash.repository.StationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping
public class StationsController {
    @Autowired
    private  StationRepository stationRepository;

   
    
    @GetMapping("/stations")
    public String showStations(Model model){
        List<Station> stations=stationRepository.findAll();
        
        model.addAttribute("stations",stations);

        model.addAttribute("police_station",new Station());
        return "stations";
    }

    @PostMapping("/stations")
  public String addStation(@ModelAttribute("police_station") @Valid Station station,BindingResult result,Model model){
    Station existing = stationRepository.findByEmail(station.getEmail());
    if (existing != null){
        result.rejectValue("email", null, "There is already an account registered with that eamil");
       }

   
     
      if(result.hasErrors()){
        List<Station> stations=stationRepository.findAll();
        model.addAttribute("stations",stations);
          return "stations";
      }
      stationRepository.save(station);
      return "redirect:/stations";
  }
   



   @PostMapping("/delete")
    public String deleteStation(@RequestParam(required=false,name="id") Long id){
       //Optional<Station> station= stationRepository.findById(id);
       
        stationRepository.deleteById(id);
        return "redirect:/stations";
    }
}
