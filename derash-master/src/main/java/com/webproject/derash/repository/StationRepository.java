package com.webproject.derash.repository;

import com.webproject.derash.entity.Station;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station,Long>{
    public Station findByLocation(String location);
    public Station findByEmail(String email);
    
}
