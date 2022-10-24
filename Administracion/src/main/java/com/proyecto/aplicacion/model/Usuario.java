package com.proyecto.aplicacion.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = -6693602575509371765L;
	
	@Id
	@Column(unique=true, nullable=false)
	private Long nro_documento_usuario;
	
	@Column(nullable=false, length = 50)
	private String nombreUsuario;
	
	@Column(length = 50)
	private String apellido;
	
	@Column(nullable=false, length = 30)
	private String tipoDocumento;
	
	@Column(length = 50)
	private Long telefono;
	
	@Column(nullable=false, length = 30)
	private String rol;
	
	@Column(nullable=false, length = 45)
	private String clave;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario", cascade=CascadeType.REMOVE) 
	private List<Apartamento> apartamentos;

	public Long getNro_documento_usuario() {
		return nro_documento_usuario;
	}

	public void setNro_documento_usuario(Long nro_documento_usuario) {
		this.nro_documento_usuario = nro_documento_usuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apartamentos, apellido, clave, nombreUsuario, nro_documento_usuario, rol, telefono,
				tipoDocumento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apartamentos, other.apartamentos) && Objects.equals(apellido, other.apellido)
				&& Objects.equals(clave, other.clave) && Objects.equals(nombreUsuario, other.nombreUsuario)
				&& Objects.equals(nro_documento_usuario, other.nro_documento_usuario) && Objects.equals(rol, other.rol)
				&& Objects.equals(telefono, other.telefono) && Objects.equals(tipoDocumento, other.tipoDocumento);
	}

	@Override
	public String toString() {
		return "Usuario [nro_documento_usuario=" + nro_documento_usuario + ", nombreUsuario=" + nombreUsuario
				+ ", apellido=" + apellido + ", tipoDocumento=" + tipoDocumento + ", telefono=" + telefono + ", rol="
				+ rol + ", clave=" + clave + ", apartamentos=" + apartamentos + "]";
	}
	
}
