package com.example.bci.to;

import jakarta.validation.constraints.NotNull;

public class TelefonoRequestTO {

	@NotNull(message = "El campo 'number' es obligatorio")
	private String number;
	
	@NotNull(message = "El campo 'citycode' es obligatorio")
	private String citycode;
	
	@NotNull(message = "El campo 'contrycode' es obligatorio")
	private String contrycode;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getContrycode() {
		return contrycode;
	}
	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}
	
	
}
