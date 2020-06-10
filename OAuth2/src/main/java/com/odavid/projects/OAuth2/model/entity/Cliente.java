package com.odavid.projects.OAuth2.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7407700306765714961L;


	@Id
	private Long idCliente;
	
	
	private String nombreCliente;


	public Long getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	
}
