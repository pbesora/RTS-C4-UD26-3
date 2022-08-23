package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="maquinas_registradoras")
public class MaquinaRegistradora {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="piso")
	private int piso;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Venta> venta;

	
	
	//Constructors
	
	public MaquinaRegistradora() {
	}



	/**
	 * @param id
	 * @param piso
	 */
	public MaquinaRegistradora(int id, int piso) {
		this.id = id;
		this.piso = piso;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the piso
	 */
	public int getPiso() {
		return piso;
	}



	/**
	 * @param piso the piso to set
	 */
	public void setPiso(int piso) {
		this.piso = piso;
	}



	/**
	 * @return the venta
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVenta() {
		return venta;
	}



	/**
	 * @param venta the venta to set
	 */
	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}



	@Override
	public String toString() {
		return "MaquinaRegistradora [id=" + id + ", piso=" + piso + "]";
	}
	
	
}