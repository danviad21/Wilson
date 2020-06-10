package com.odavid.projects.app.facturacion.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.odavid.projects.app.facturacion.models.entity.Cliente;
import com.odavid.projects.app.facturacion.models.entity.Region;

public interface IClienteDao extends JpaRepository<Cliente, Long> {

	public Cliente findByIdClienteAndStatusCliente(Long id,int status);
	public Cliente findByEmailCliente(String emailCliente);
	public List<Cliente> findByNombreClienteOrApellidoCliente(String nombre, String apellido);
	public List<Cliente> findAllByStatusCliente(int status);
	public Page<Cliente> findAllByStatusCliente(int status, Pageable pageable);
	
	@Query("from Region")
	public List<Region> findAllRegiones();
}
