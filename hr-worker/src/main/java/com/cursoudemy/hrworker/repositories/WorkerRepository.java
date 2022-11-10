package com.cursoudemy.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoudemy.hrworker.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{
    
}
