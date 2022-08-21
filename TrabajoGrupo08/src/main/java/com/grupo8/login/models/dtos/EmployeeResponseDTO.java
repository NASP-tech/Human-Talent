package com.grupo8.login.models.dtos;

public class EmployeeResponseDTO {
	private String usuario;
	private String nombre;
	private String apellido;
	private String contratacion;
	private String rol;
	
	public EmployeeResponseDTO(String usuario, String nombre, String apellido, String contratacion,
			String rol) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contratacion = contratacion;
		this.rol = rol;
		
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
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	// Funciones para poder separar y no anidar los elementos 
	// de los dto junto a la vista
	public boolean isUserRegistered() {
		return !this.usuario.isBlank();
	}
	
	public boolean isNameRegistered() {
		return !this.nombre.isBlank();
	}
	
	public boolean isLastnameRegistered() {
		return !this.apellido.isBlank();
	}
	
	public boolean isHiringDayRegistered() {
		return !this.contratacion.isBlank();
	}

	public boolean isAdmin() {
		return this.rol.equals("admin");
	}
	
	@Override
	public String toString() {
		return "EmployeeResponseDTO [usuario=" + usuario + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", contratacion=" + contratacion + "]";
	}
	
	
}
