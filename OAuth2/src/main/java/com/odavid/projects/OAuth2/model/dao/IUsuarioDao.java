package com.odavid.projects.OAuth2.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.odavid.projects.OAuth2.model.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
	
	@Query("SELECT u FROM Usuario u WHERE u.username=?1")
	public Usuario findByUserName2(String username);
	
}
