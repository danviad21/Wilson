package com.odavid.projects.app.facturacion.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odavid.projects.app.facturacion.models.dao.IClienteDao;
import com.odavid.projects.app.facturacion.models.entity.Cliente;
import com.odavid.projects.app.facturacion.models.entity.Region;

@Service
public class IClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAllByStatusCliente(int status) {
		return (List<Cliente>)this.clienteDao.findAllByStatusCliente(status);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAllByStatusCliente(int status, Pageable pageable) {
		return this.clienteDao.findAllByStatusCliente(status, pageable);
	}
	
	@Override
	@Transactional
	public Cliente create(Cliente cliente) {
		return this.clienteDao.save(cliente);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Cliente findByIdClienteAndStatusCliente(Long id, int status) {
		return this.clienteDao.findByIdClienteAndStatusCliente(id,status);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findByEmailCliente(String emailCliente) {
		return this.clienteDao.findByEmailCliente(emailCliente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByNombreClienteOrApellidoCliente(String nombre, String apellido) {
		return this.clienteDao.findByNombreClienteOrApellidoCliente(nombre, apellido);
	}

	@Override
	@Transactional
	public Cliente update(Long id, Cliente clienteNuevo) {
		return this.clienteDao.save(clienteNuevo);
	}

	@Override
	@Transactional
	public Cliente delete(Cliente cliente) {
		return this.clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllRegiones() {
		return this.clienteDao.findAllRegiones();
	}
}
