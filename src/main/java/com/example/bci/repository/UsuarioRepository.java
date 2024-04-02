package com.example.bci.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bci.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long>{

	
    @Query("select u from Usuario u where u.email = :email")
    public List<Usuario> getUsuarioByEmail(@Param("email")String email);
	

}
