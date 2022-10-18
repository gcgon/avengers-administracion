package com.proyecto.aplicacion.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="apartamento")
public class Apartamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idApartamento;
	@Column(nullable=false)
	private Long bloque_apartamento;
	@Column(length = 2, nullable=false)
	private Long numero_apartamento;
	
	@JsonIgnore
	@OneToMany(mappedBy="apartamento", cascade=CascadeType.REMOVE) 
	private List<Factura> facturas;
	
	@JoinColumn(name = "usuario", referencedColumnName = "nro_documento_usuario")
	@ManyToOne
	private Usuario usuario;
	
	@JoinColumn(name = "conjunto", referencedColumnName = "nitConjunto")
	@ManyToOne
	private Conjunto conjunto;

	
	public Long getIdApartamento() {
		return idApartamento;
	}
	public void setIdApartamento(Long idApartamento) {
		this.idApartamento = idApartamento;
	}
	public Long getBloque_apartamento() {
		return bloque_apartamento;
	}
	public void setBloque_apartamento(Long bloque_apartamentto) {
		this.bloque_apartamento = bloque_apartamentto;
	}
	public Long getNumero_apartamento() {
		return numero_apartamento;
	}
	public void setNumero_apartamento(Long numero_apartamento) {
		this.numero_apartamento = numero_apartamento;
	}	
	
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Conjunto getConjunto() {
		return conjunto;
	}
	public void setConjunto(Conjunto conjunto) {
		this.conjunto = conjunto;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bloque_apartamento, conjunto, facturas, idApartamento, numero_apartamento, usuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apartamento other = (Apartamento) obj;
		return Objects.equals(bloque_apartamento, other.bloque_apartamento) && Objects.equals(conjunto, other.conjunto)
				&& Objects.equals(facturas, other.facturas) && Objects.equals(idApartamento, other.idApartamento)
				&& Objects.equals(numero_apartamento, other.numero_apartamento)
				&& Objects.equals(usuario, other.usuario);
	}
	@Override
	public String toString() {
		return "Apartamento [idApartamento=" + idApartamento + ", bloque_apartamento=" + bloque_apartamento
				+ ", numero_apartamento=" + numero_apartamento + ", facturas=" + facturas + ", usuario=" + usuario
				+ ", conjunto=" + conjunto + "]";
	}
	
		
	
}
