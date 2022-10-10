package com.proyecto.aplicacion.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Long idApartamento;
	@Column(length = 25, nullable=false)
	private Long nit_conjunto;
	@Column(length = 25, nullable=false)
	private Long nro_documento_usario;
	@Column(nullable=false, unique=true)
	private Long bloque_apartamentto;
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
	public Long getNit_conjunto() {
		return nit_conjunto;
	}
	public void setNit_conjunto(Long nit_conjunto) {
		this.nit_conjunto = nit_conjunto;
	}
	public Long getNro_documento_usario() {
		return nro_documento_usario;
	}
	public void setNro_documento_usario(Long nro_documento_usario) {
		this.nro_documento_usario = nro_documento_usario;
	}
	public Long getBloque_apartamentto() {
		return bloque_apartamentto;
	}
	public void setBloque_apartamentto(Long bloque_apartamentto) {
		this.bloque_apartamentto = bloque_apartamentto;
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
		return Objects.hash(bloque_apartamentto, facturas, idApartamento, nit_conjunto, nro_documento_usario,
				numero_apartamento);
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
		return Objects.equals(bloque_apartamentto, other.bloque_apartamentto) && Objects.equals(facturas, other.facturas)
				&& Objects.equals(idApartamento, other.idApartamento)
				&& Objects.equals(nit_conjunto, other.nit_conjunto)
				&& Objects.equals(nro_documento_usario, other.nro_documento_usario)
				&& Objects.equals(numero_apartamento, other.numero_apartamento);
	}
	@Override
	public String toString() {
		return "Apartamento [idApartamento=" + idApartamento + ", nit_conjunto=" + nit_conjunto
				+ ", nro_documento_usario=" + nro_documento_usario + ", bloque_apartamentto=" + bloque_apartamentto
				+ ", numero_apartamento=" + numero_apartamento + ", factura=" + facturas + "]";
	}
		
	
}
