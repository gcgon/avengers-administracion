package com.proyecto.aplicacion.model;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "factura")
public class Factura implements Serializable{
	
	private static final long serialVersionUID = -572756588602899328L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long nroFactura;
	@Column (nullable=false)
	private Date fechaFactura;
	@Column (nullable=false)
	private Date fechaLimitePago;
	@Column (nullable=false)
	private Float valor;
		
	@JoinColumn(name = "apartamento", referencedColumnName = "idApartamento")
	@ManyToOne
	private Apartamento apartamento;
	
	@JsonIgnore
	@OneToMany(mappedBy="factura", cascade=CascadeType.REMOVE) 
	private List<Pago> pagos;	
	
	@JsonIgnore
	@OneToMany(mappedBy="factura", cascade=CascadeType.REMOVE) 
	private List<DetalleFactura> detalleFactura;

	public Factura() {
		super();
		// TODO Auto-generated constructor stub
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

	public Date getFechaLimitePago() {
		return fechaLimitePago;
	}

	public void setFechaLimitePago(Date fechaLimitePago) {
		this.fechaLimitePago = fechaLimitePago;
	}

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

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public List<DetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apartamento, detalleFactura, fechaFactura, fechaLimitePago, nroFactura, pagos, valor);
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
		return Objects.equals(apartamento, other.apartamento) && Objects.equals(detalleFactura, other.detalleFactura)
				&& Objects.equals(fechaFactura, other.fechaFactura)
				&& Objects.equals(fechaLimitePago, other.fechaLimitePago)
				&& Objects.equals(nroFactura, other.nroFactura) && Objects.equals(pagos, other.pagos)
				&& Objects.equals(valor, other.valor);
	}

	@Override
	public String toString() {
		return "Factura [nroFactura=" + nroFactura + ", fechaFactura=" + fechaFactura + ", fechaLimitePago="
				+ fechaLimitePago + ", valor=" + valor + ", apartamento=" + apartamento + ", pagos=" + pagos
				+ ", detalleFactura=" + detalleFactura + "]";
	}	
	
}
