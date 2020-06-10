package com.odavid.projects.OAuth2.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;


@Entity
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8637956342225551010L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuario;
	
	@Column(unique = true, length = 20)	
	private String username;
	
	@Column(unique = true, length = 60)
	private String password;
	
	private Boolean enabled;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//SOLO SI SE QUIERE CAMBIAR LOS ATRIBUTOS DE LA CONFIGURACION MANY TO MANY TABLA INTERMEDIA	
	@JoinTable(name = "users_authorities", joinColumns =  @JoinColumn(name = "id_usuario"),
	inverseJoinColumns = @JoinColumn(name="id_rol"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"id_usuario","id_rol"})})
	private List<Rol> roles;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	

}
