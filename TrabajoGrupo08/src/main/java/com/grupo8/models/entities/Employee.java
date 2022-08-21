package com.grupo8.models.entities;

public class Employee {
	//Using POJO
	//Usando POJOS
		private String usuario;
		private String nombre;
		private String apellido;
		private String contratacion;
		private String activo;
		private String rol;
		private String contrasena;
		private int faltas;
		private int bonos;
		
		public Employee(String usuario, String nombre, String apellido, String contratacion, String activo,
				String rol, String contrasena) {
			super();
			this.usuario = usuario;
			this.nombre = nombre;
			this.apellido = apellido;
			this.contratacion = contratacion;
			this.activo = activo;
			this.rol = rol;
			this.contrasena = contrasena;
		}
		
		

		public Employee(String usuario, String nombre, String apellido, String contratacion, String contrasena) {
			super();
			this.usuario = usuario;
			this.nombre = nombre;
			this.apellido = apellido;
			this.contratacion = contratacion;
			this.contrasena = contrasena;
			// Dejar por defecto que  es activo y usuario
			this.activo = "activo";
			this.rol = "usuario";
		}
		
		public Employee(String usuario, String nombre, String apellido, String contratacion, String activo, String rol,
				String contrasena, int faltas, int bonos) {
			super();
			this.usuario = usuario;
			this.nombre = nombre;
			this.apellido = apellido;
			this.contratacion = contratacion;
			this.activo = activo;
			this.rol = rol;
			this.contrasena = contrasena;
			this.faltas = faltas;
			this.bonos = bonos;
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
		
		public int getFaltas() {
			return faltas;
		}

		public void setFaltas(int faltas) {
			this.faltas = faltas;
		}

		public int getBonos() {
			return bonos;
		}

		public void setBonos(int bonos) {
			this.bonos = bonos;
		}

		@Override
		public String toString() {
			return "Employee [usuario=" + usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", contratacion="
					+ contratacion + ", activo=" + activo + ", rol=" + rol + ", contrasena=" + contrasena + "]";
		}		

}
