package com.example.bci.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bci.model.Usuario;
import com.example.bci.repository.UsuarioRepository;

@ExtendWith(SpringExtension.class)
class UsuarioServiceTest {

	@InjectMocks
	UsuarioService service;
	
	@Mock
	UsuarioRepository repository; 

	@Test
	void guardarUsuario() {
		Usuario usuario = new Usuario();
		doReturn(usuario).when(repository).save(any());
		assertEquals(service.guardarUsuario(usuario),usuario);
	}
	
	@Test
	void existeUsuarioByEmail_noExist() {
		List<Usuario> listUsuario  = new ArrayList<>();	
		doReturn(listUsuario).when(repository).getUsuarioByEmail(any());
		assertEquals(service.existeUsuarioByEmail(anyString()),false);
	}
	
	@Test
	void existeUsuarioByEmail_exist() {
		List<Usuario> listUsuario  = new ArrayList<>();	
		listUsuario.add(new Usuario());
		doReturn(listUsuario).when(repository).getUsuarioByEmail(any());
		assertEquals(service.existeUsuarioByEmail(anyString()),true);
	}
	
}
