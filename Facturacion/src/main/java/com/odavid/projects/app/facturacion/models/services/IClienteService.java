package com.odavid.projects.app.facturacion.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.odavid.projects.app.facturacion.models.entity.Cliente;
import com.odavid.projects.app.facturacion.models.entity.Region;

public interface IClienteService {

	public Cliente create(Cliente cliente);
	public Cliente findByIdClienteAndStatusCliente(Long id,int status);
	public Cliente findByEmailCliente(String emailCliente);
	public Page<Cliente> findAllByStatusCliente(int status,Pageable pageable);
	public Cliente update(Long id, Cliente cliente);
	public Cliente delete(Cliente Cliente);
	public List<Cliente> findByNombreClienteOrApellidoCliente(String nombre, String apellido);
	public List<Cliente> findAllByStatusCliente(int status);
	public List<Region> findAllRegiones();
}
