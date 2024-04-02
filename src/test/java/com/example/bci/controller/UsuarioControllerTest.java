package com.example.bci.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bci.base.MensajeValidacion;
import com.example.bci.base.UtilNegocio;
import com.example.bci.service.UsuarioService;
import com.example.bci.to.UsuarioRequestTO;

@ExtendWith(SpringExtension.class)
class UsuarioControllerTest {
	
	@InjectMocks
	UsuarioController controller;
	
	@Mock
	UsuarioService usuarioService;	
	
	@Mock
	UtilNegocio util;

	@Test
	void registrarUsuario_OK() {
		UsuarioRequestTO usuario = new UsuarioRequestTO();
		MensajeValidacion validacion = new MensajeValidacion();
		validacion.setOk(true);
		when(util.validaciones(usuario)).thenReturn(validacion);
		when(usuarioService.existeUsuarioByEmail(any())).thenReturn(false);	
		ResponseEntity<?> response = controller.registrarUsuario(usuario);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		
	}

	@Test
	void registrarUsuario_emailExist() {
		UsuarioRequestTO usuario = new UsuarioRequestTO();
		MensajeValidacion validacion = new MensajeValidacion();
		validacion.setOk(true);
		when(util.validaciones(usuario)).thenReturn(validacion);
		when(usuarioService.existeUsuarioByEmail(any())).thenReturn(true);
		ResponseEntity<?> response = controller.registrarUsuario(usuario);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
	}
	
	@Test
	void registrarUsuario_badPattern() {
		UsuarioRequestTO usuario = new UsuarioRequestTO();
		MensajeValidacion validacion = new MensajeValidacion();
		validacion.setOk(false);
		when(util.validaciones(usuario)).thenReturn(validacion);
		ResponseEntity<?> response = controller.registrarUsuario(usuario);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
}
