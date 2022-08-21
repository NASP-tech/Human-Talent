package com.grupo8.login.models.dtos;

public class EmployeeSearchDTO {
	private String usuario;

	public EmployeeSearchDTO(String usuario) {
		super();
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}	

}
