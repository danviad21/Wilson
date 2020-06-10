package com.odavid.projects.OAuth2.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odavid.projects.OAuth2.model.entity.Cliente;


import com.odavid.projects.OAuth2.model.services.IClienteService;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private IClienteService clienteService;
	
	
	@GetMapping("/clientes")
	@Transactional(readOnly = true)
	public List<Cliente> index(){
		return this.clienteService.findAll();
	}
}
