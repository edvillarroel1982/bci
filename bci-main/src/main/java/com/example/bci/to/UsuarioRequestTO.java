package com.example.bci.to;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotNull;

public class UsuarioRequestTO implements Serializable {
	
	private static final long serialVersionUID = -8616590206081899221L;
	
	
	@NotNull(message = "El campo 'name' es obligatorio")
	private String name;
	
	@NotNull(message = "El campo 'email' es obligatorio")
	private String email;
	
	@NotNull(message = "El campo 'password' es obligatorio")
	private String password;
	
	@NotNull(message = "El campo 'phones' es obligatorio")
	private List<TelefonoRequestTO> phones;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TelefonoRequestTO> getPhones() {
		return phones;
	}

	public void setPhones(List<TelefonoRequestTO> phones) {
		this.phones = phones;
	}
	
	
	
}
