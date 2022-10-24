package com.proyecto.aplicacion.model;

import java.io.Serializable;
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
@Table(name="detalleFactura")
public class DetalleFactura implements Serializable{
	
	private static final long serialVersionUID = -2778411932823933009L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long nroDetalleFactura;
			
	@Column (length = 10, nullable=false)
	private Float valorFacturaPendiente;
	
	@JoinColumn(name = "apartamento", referencedColumnName = "idApartamento")
	@ManyToOne
	private Apartamento apartamento;
	
	@JoinColumn(name = "factura", referencedColumnName = "nroFactura")
	@ManyToOne
	private Factura factura;

	public DetalleFactura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getNroDetalleFactura() {
		return nroDetalleFactura;
	}

	public void setNroDetalleFactura(Long nroDetalleFactura) {
		this.nroDetalleFactura = nroDetalleFactura;
	}

	public Float getValorFacturaPendiente() {
		return valorFacturaPendiente;
	}

	public void setValorFacturaPendiente(Float valorFacturaPendiente) {
		this.valorFacturaPendiente = valorFacturaPendiente;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apartamento, factura, nroDetalleFactura, valorFacturaPendiente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleFactura other = (DetalleFactura) obj;
		return Objects.equals(apartamento, other.apartamento) && Objects.equals(factura, other.factura)
				&& Objects.equals(nroDetalleFactura, other.nroDetalleFactura)
				&& Objects.equals(valorFacturaPendiente, other.valorFacturaPendiente);
	}

	@Override
	public String toString() {
		return "DetalleFactura [nroDetalleFactura=" + nroDetalleFactura + ", valorFacturaPendiente="
				+ valorFacturaPendiente + ", apartamento=" + apartamento + ", factura=" + factura + "]";
	}

		
}
