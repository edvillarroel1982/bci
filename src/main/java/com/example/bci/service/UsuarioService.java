package com.example.bci.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bci.model.Usuario;
import com.example.bci.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario guardarUsuario(Usuario usuario) {
		usuario.setId(UUID.randomUUID());
		usuario.setFechaCreacion(new Date());
		usuario.setActivo(true);
		usuario.setFechaUltimoAcceso(new Date());
		usuario.setToken(UUID.randomUUID());
		return usuarioRepository.save(usuario);
	}

	public boolean existeUsuarioByEmail(String email) {
		boolean encontrado = false;
		List<Usuario> listUsuario = usuarioRepository.getUsuarioByEmail(email);
		if(!listUsuario.isEmpty()){
			encontrado = true;
		}
		return encontrado;
	}

	
}
