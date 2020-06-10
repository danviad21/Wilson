package com.odavid.projects.OAuth2.model.services;

import java.util.List;

import com.odavid.projects.OAuth2.model.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
}
