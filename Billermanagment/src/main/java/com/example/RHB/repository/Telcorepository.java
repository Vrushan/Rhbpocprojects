package com.example.RHB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RHB.model.TelcoBiller;

@Repository
public interface Telcorepository extends JpaRepository<TelcoBiller, Long> {

	

}
