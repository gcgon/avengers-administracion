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
	private Long norDetalleFactura;
	@Column(length = 70, nullable=false)
	private String conceptoFactura;
	@Column (length = 10, nullable=false)
	private Float valorUnitarioProducto;	
	
	@JoinColumn(name = "factura", referencedColumnName = "nroFactura")
	@ManyToOne
	private Factura factura;

	public DetalleFactura() {
		super();
	}

	@Override
	public String toString() {
		return "DetalleFactura [norDetalleFactura=" + norDetalleFactura + ", conceptoFactura=" + conceptoFactura
				+ ", valorUnitarioProducto=" + valorUnitarioProducto + ", factura=" + factura + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(conceptoFactura, factura, norDetalleFactura, valorUnitarioProducto);
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
		return Objects.equals(conceptoFactura, other.conceptoFactura) && Objects.equals(factura, other.factura)
				&& Objects.equals(norDetalleFactura, other.norDetalleFactura)
				&& Objects.equals(valorUnitarioProducto, other.valorUnitarioProducto);
	}

	public Long getNorDetalleFactura() {
		return norDetalleFactura;
	}

	public void setNorDetalleFactura(Long norDetalleFactura) {
		this.norDetalleFactura = norDetalleFactura;
	}

	public String getConceptoFactura() {
		return conceptoFactura;
	}

	public void setConceptoFactura(String conceptoFactura) {
		this.conceptoFactura = conceptoFactura;
	}

	public Float getValorUnitarioProducto() {
		return valorUnitarioProducto;
	}

	public void setValorUnitarioProducto(Float valorUnitarioProducto) {
		this.valorUnitarioProducto = valorUnitarioProducto;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	
}
