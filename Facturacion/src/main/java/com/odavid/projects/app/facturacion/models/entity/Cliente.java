package com.odavid.projects.app.facturacion.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4098514946395500661L;

	@Id
	@GeneratedValue(generator = "ISEQ$$_73648")
	@GenericGenerator(name = "ISEQ$$_73648", strategy = "increment")
	private Long idCliente;
	
	@NotNull(message = "no puede ser nulo o vacio")
	@Size(min = 4, max = 15, message = "debe de contener al menos 4 caracteres")
	private String nombreCliente;
	
	@NotNull(message = "no puede ser nulo o vacio")
	@Size(min = 4, max = 15, message = "debe de contener al menos 4 caracteres")
	private String apellidoCliente;
	
	@NotNull(message = "no puede ser nulo o vacio")
	@Email( message = "debe de ser un correo con formato valido")
	@Column(unique = true)
	private String emailCliente;
	
	@Temporal(TemporalType.DATE)
	@NotNull(message = "no puede ser nulo o vacio")
	private Date fechaNacimientoCliente;
	
//	@NotNull(message = "no puede ser nulo o vacio" )
	private String fotoCliente;
	
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@Temporal(TemporalType.DATE)
	private Date updateAt;
		
	@NotNull
	@Column(unique = true)
	private int statusCliente;
	
	@NotNull(message = "no puede ser nulo o vacio")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_region", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Region region;	
	

	@PrePersist
	public void prePersist() {
		this.statusCliente = 1;
		this.createAt = new Date();
	}
	
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

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	
	public Date getFechaNacimientoCliente() {
		return this.fechaNacimientoCliente;
	}
	
	public void setFechaNacimientoCliente(Date fechaNacCliente) {
		this.fechaNacimientoCliente = fechaNacCliente;
	}

	public String getFotoCliente() {
		return fotoCliente;
	}
	
	public void setFotoCliente(String fotoCliente) {
		this.fotoCliente = fotoCliente;
	}
	
	public int getStatusCliente() {
		return statusCliente;
	}

	public void setStatusCliente(int statusCliente) {
		this.statusCliente = statusCliente;
	}

	
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente="
				+ apellidoCliente + ", emailCliente=" + emailCliente + ", createAt=" + createAt + ", updateAt="
				+ updateAt + ", statusCliente=" + statusCliente + "]";
	}
}
