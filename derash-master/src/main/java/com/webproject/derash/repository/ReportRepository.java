package com.webproject.derash.repository;

import com.webproject.derash.entity.Report;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report,Long> {
    
}
