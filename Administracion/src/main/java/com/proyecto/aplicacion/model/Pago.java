package com.proyecto.aplicacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="pago")
public class Pago implements Serializable{
	
	private static final long serialVersionUID = 3212451542381217613L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long codigoPago;
	@Column(length = 255, nullable=false)
	private Timestamp fechaPago;
	@Column(precision = 10, scale = 2, nullable=false)
	private BigDecimal valorPago;
	
	@ManyToOne
	@JoinColumn(name = "factura", referencedColumnName = "nroFactura", nullable=false)
	private Factura factura;
		
	public Long getCodigoPago() {
		return codigoPago;
	}
	public void setCodigoPago(Long codigoPago) {
		this.codigoPago = codigoPago;
	}
	public Timestamp getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Timestamp fechaPago) {
		this.fechaPago = fechaPago;
	}
	public BigDecimal getValorPago() {
		return valorPago;
	}
	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigoPago, factura, fechaPago, valorPago);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pago other = (Pago) obj;
		return Objects.equals(codigoPago, other.codigoPago) && Objects.equals(factura, other.factura)
				&& Objects.equals(fechaPago, other.fechaPago) && Objects.equals(valorPago, other.valorPago);
	}
	@Override
	public String toString() {
		return "Pago [codigoPago=" + codigoPago + ", fechaPago=" + fechaPago + ", valorPago=" + valorPago + ", factura="
				+ factura + "]";
	}	
	
}
