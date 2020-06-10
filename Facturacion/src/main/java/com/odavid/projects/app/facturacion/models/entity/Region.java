package com.odavid.projects.app.facturacion.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Region implements Serializable{

	private static final long serialVersionUID = 590887828979108502L;
	
	@Id
	@Column(name = "id_region")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRegion;
	
	@NotNull(message = "no puede ser nulo o vacio")
	private String nombreRegion;
	
	@Temporal(TemporalType.DATE)
	private Date createAtRegion;
	
	@Temporal(TemporalType.DATE)
	private Date updateAtRegion;
	
	@NotNull(message = "no puede ser nulo o vacio")
	private int statusRegion;
	
	@PrePersist
	public void prePersist() {
		this.createAtRegion = new Date();
	}
	
	
	public Region() {
		
	}

	public Long getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Long idRegion) {
		this.idRegion = idRegion;
	}

	public String getNombreRegion() {
		return nombreRegion;
	}

	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}
	
	public int getStatusRegion() {
		return statusRegion;
	}


	public void setStatusRegion(int statusRegion) {
		this.statusRegion = statusRegion;
	}

	public Date getCreateAtRegion() {
		return createAtRegion;
	}

	public void setCreateAtRegion(Date createAtRegion) {
		this.createAtRegion = createAtRegion;
	}

	public Date getUpdateAtRegion() {
		return updateAtRegion;
	}

	public void setUpdateAtRegion(Date updateAtRegion) {
		this.updateAtRegion = updateAtRegion;
	}

}
