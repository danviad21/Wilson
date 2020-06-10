package com.odavid.projects.OAuth2.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odavid.projects.OAuth2.model.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

	
}
