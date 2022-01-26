package com.webproject.derash.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "User is mandatory")
    private String location;
    @NotBlank(message = "date  is mandatory")
    
    private String date;
    @NotBlank(message = "time is mandatory")
    
    private  String time;
    @NotBlank(message = "description  is mandatory")
   
    private String description;
    
//    private String image;
   
   
    
   
}
