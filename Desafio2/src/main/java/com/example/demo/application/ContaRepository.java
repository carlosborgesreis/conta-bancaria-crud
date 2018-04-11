package com.example.demo.application;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
		
	Conta findByContaId(int id);
	void deleteByContaId(int id);
	
}
