package com.odavid.projects.OAuth2.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8983263180652400547L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRol;
	
	@Column(unique = true, length = 20)
	private String descripcion;

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
