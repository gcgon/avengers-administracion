package com.example.apartamento.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="apartamento")

public class apartamento {
	@Column
	@Id
	private Long id_apartamento;
	@Column(length = 25, nullable=false)
	private Long nit_conjunto;
	@Column(length = 25, nullable=false)
	private Long nro_documento_usario;
	@Column(nullable=false, unique=true)
	private Long bloque_apartamentto;
	@Column(length = 2, nullable=false)
	private Long numero_apartamento;
	public Long getId_apartamento() {
		return id_apartamento;
	}
	public void setId_apartamento(Long id_apartamento) {
		this.id_apartamento = id_apartamento;
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
	@Override
	public int hashCode() {
		return Objects.hash(bloque_apartamentto, id_apartamento, nit_conjunto, nro_documento_usario,
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
		apartamento other = (apartamento) obj;
		return Objects.equals(bloque_apartamentto, other.bloque_apartamentto)
				&& Objects.equals(id_apartamento, other.id_apartamento)
				&& Objects.equals(nit_conjunto, other.nit_conjunto)
				&& Objects.equals(nro_documento_usario, other.nro_documento_usario)
				&& Objects.equals(numero_apartamento, other.numero_apartamento);
	}
	@Override
	public String toString() {
		return "apartamento [id_apartamento=" + id_apartamento + ", nit_conjunto=" + nit_conjunto
				+ ", nro_documento_usario=" + nro_documento_usario + ", bloque_apartamentto=" + bloque_apartamentto
				+ ", numero_apartamento=" + numero_apartamento + "]";
	}
	
	
	

}
