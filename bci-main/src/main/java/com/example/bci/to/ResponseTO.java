package com.example.bci.to;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseTO {
	
	private String mensaje;
	
	private UsuarioResponseTO usuario;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public UsuarioResponseTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioResponseTO usuario) {
		this.usuario = usuario;
	}
	
	

}
