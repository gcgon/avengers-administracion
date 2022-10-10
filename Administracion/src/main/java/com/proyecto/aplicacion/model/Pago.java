package com.proyecto.aplicacion.model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

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
public class Pago implements Serializable {
	private static final long serialVersionUID = 1672125358412453855L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_pago", unique=true)
	private Long codigoPago;
	@Column(name = "fecha_pago", length = 255, nullable=false)
	private Timestamp fechaPago;
	@Column(name = "valor_pago", precision = 10, scale = 2, nullable=false)
	private BigDecimal valorPago;
	@ManyToOne
	@JoinColumn(name = "numero_factura", nullable=false)
	private Factura numeroFactura;
	
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
	public Factura getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(Factura numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	
}
