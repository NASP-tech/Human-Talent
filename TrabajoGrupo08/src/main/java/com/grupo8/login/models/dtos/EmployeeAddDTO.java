package com.grupo8.login.models.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmployeeAddDTO {
	@NotBlank
	@Size(min = 8, max = 8)
	private String usuario;
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	private String contratacion;
	@NotBlank
	private String activo;
	@NotBlank
	private String rol;
	@NotBlank
	private String contrasena;
	
	public EmployeeAddDTO(String usuario, String nombre, String apellido, String contratacion, String contrasena) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contratacion = contratacion;
		this.activo = "activo";
		this.rol = "usuario";
		this.contrasena = contrasena;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContratacion() {
		return contratacion;
	}

	public void setContratacion(String contratacion) {
		this.contratacion = contratacion;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}	
	
}
