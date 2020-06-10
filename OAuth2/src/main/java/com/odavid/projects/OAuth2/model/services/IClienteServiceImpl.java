package com.odavid.projects.OAuth2.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odavid.projects.OAuth2.model.dao.IClienteDao;
import com.odavid.projects.OAuth2.model.entity.Cliente;


@Service
public class IClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	public List<Cliente> findAll(){
		return this.clienteDao.findAll();
	}
}
