package com.example.bci.base;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bci.model.Telefono;
import com.example.bci.model.Usuario;
import com.example.bci.to.TelefonoRequestTO;
import com.example.bci.to.UsuarioRequestTO;

@ExtendWith(SpringExtension.class)
class UtilNegocioTest {
	
	@InjectMocks
	UtilNegocio util;
	
	@Mock
	Environment environment;

	UsuarioRequestTO getUsuarioTO() {
		UsuarioRequestTO u = new UsuarioRequestTO();
		u.setPassword("hunter2");
		u.setEmail("micorreo@gmail.com");
		u.setPhones(new ArrayList<>());
		TelefonoRequestTO telefono = new TelefonoRequestTO();
		telefono.setNumber("1");
		telefono.setContrycode("56");
		telefono.setCitycode("1");
		u.getPhones().add(telefono);
		return u;
	}
	
	Usuario getUsuario() {
		Usuario u = new Usuario();
		u.setTelefonos(new ArrayList<>());
		Telefono telefono = new Telefono();
		telefono.setCodigoCiudad(1);
		telefono.setCodigoPais(56);
		telefono.setNumero(1);
		u.getTelefonos().add(telefono);
		return u;
	}
	
	@Test
	void setterUsuario_dto_to_entity() {
		util.setterUsuario(getUsuarioTO());
	}
	
	@Test
	void setterUsuario_entity_to_dto() {
		util.setterUsuario(getUsuario());
	}
	
	@Test
	void validaciones_ok() {
		when(environment.getProperty("validation.psswrd.regex")).thenReturn("^[a-z0-9]{6,18}$");
		when(environment.getProperty("validation.email.regex")).thenReturn("[^@]+@[^@]+\\\\.[a-zA-Z]{2,}");
		util.validaciones(getUsuarioTO());
	}
	
	@Test
	void validaciones_noOK() {
		UsuarioRequestTO to = getUsuarioTO();
		to.setPassword("1");
		when(environment.getProperty("validation.psswrd.regex")).thenReturn("^[a-z0-9]{6,18}$");
		util.validaciones(to);
	}
	
}
