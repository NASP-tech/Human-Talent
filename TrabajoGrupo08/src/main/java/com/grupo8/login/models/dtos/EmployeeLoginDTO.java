package com.grupo8.login.models.dtos;
//Usando POJOS

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmployeeLoginDTO {
	
	@NotBlank(message="Usuario Incorrecto")
	@Size(min=8, max=8)
	private String usuario;
	
	@NotBlank(message="Contrasena Vacia")
	private String contrasena;
	
	public EmployeeLoginDTO(String usuario, String contrasena) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "EmployeeLoginDTO [usuario=" + usuario + ", contrasena=" + contrasena + "]";
	}
	
	
}

