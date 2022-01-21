package com.webproject.derash.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    @Size(min = 5, message = "User name must be at least 5 characters long")
    private String location;
    @NotBlank(message = "date  is mandatory")
    
    private String date;
    @NotBlank(message = "time is mandatory")
    
    private  String time;
    @NotBlank(message = "description  is mandatory")
   
    private String description;
}
