package com.proyecto.aplicacion.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="conjunto")
public class Conjunto implements Serializable {

	private static final long serialVersionUID = 3108585289022917839L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nitConjunto;
	@Column(length = 70, nullable=false)
	private String nombreConjunto;
	@Column (length = 100, nullable=false)
	private String direccionConjunto;
	@Column (length = 15, nullable=false)
	private String telefonoConjunto;
	
	@JsonIgnore
	@OneToMany(mappedBy="conjunto", cascade=CascadeType.REMOVE) 
	private List<Apartamento> apartamentos;

	public Long getNitConjunto() {
		return nitConjunto;
	}

	public void setNitConjunto(Long nitConjunto) {
		this.nitConjunto = nitConjunto;
	}

	public String getNombreConjunto() {
		return nombreConjunto;
	}

	public void setNombreConjunto(String nombreConjunto) {
		this.nombreConjunto = nombreConjunto;
	}

	public String getDireccionConjunto() {
		return direccionConjunto;
	}

	public void setDireccionConjunto(String direccionConjunto) {
		this.direccionConjunto = direccionConjunto;
	}

	public String getTelefonoConjunto() {
		return telefonoConjunto;
	}

	public void setTelefonoConjunto(String telefonoConjunto) {
		this.telefonoConjunto = telefonoConjunto;
	}

	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apartamentos, direccionConjunto, nitConjunto, nombreConjunto, telefonoConjunto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conjunto other = (Conjunto) obj;
		return Objects.equals(apartamentos, other.apartamentos)
				&& Objects.equals(direccionConjunto, other.direccionConjunto)
				&& Objects.equals(nitConjunto, other.nitConjunto)
				&& Objects.equals(nombreConjunto, other.nombreConjunto)
				&& Objects.equals(telefonoConjunto, other.telefonoConjunto);
	}

	@Override
	public String toString() {
		return "Conjunto [nitConjunto=" + nitConjunto + ", nombreConjunto=" + nombreConjunto + ", direccionConjunto="
				+ direccionConjunto + ", telefonoConjunto=" + telefonoConjunto + ", apartamentos=" + apartamentos + "]";
	}
			
}
