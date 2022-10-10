
package com.proyecto.aplicacion.model;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="factura")
public class Factura implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8576299165550475463L;
	@Id
	private Long nroFactura;
	private Date fechaFactura;
	private Float valor; 
	@ManyToOne
	@JoinColumn(name="apartamento")
	private Apartamento apartamento;
	
	
	
	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Factura() {
		
	}

	public Long getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(Long nroFactura) {
		this.nroFactura = nroFactura;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaFactura, nroFactura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return Objects.equals(fechaFactura, other.fechaFactura) && Objects.equals(nroFactura, other.nroFactura);
	}

	@Override
	public String toString() {
		return "Factura [nroFactura=" + nroFactura + ", fechaFactura=" + fechaFactura + "]";
	}
	
	

}
