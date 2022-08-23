package com.example.demo.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Venta {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "cajero")
    Cajero cajero;
 
    @ManyToOne
    @JoinColumn(name = "producto")
    Producto producto;
	
    @ManyToOne
    @JoinColumn(name = "maquina")
    MaquinaRegistradora maquinaRegistradora;
	
	//Constructors
	
	public Venta() {
	
	}


	/**
	 * @param id
	 * @param cajero
	 * @param producto
	 * @param maquinaRegistradora
	 */
	public Venta(int id, Cajero cajero, Producto producto, MaquinaRegistradora maquinaRegistradora) {
		this.id = id;
		this.cajero = cajero;
		this.producto = producto;
		this.maquinaRegistradora = maquinaRegistradora;
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
	 * @return the cajero
	 */
	public Cajero getCajero() {
		return cajero;
	}

	/**
	 * @param cajero the cajero to set
	 */
	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the maquinaRegistradora
	 */
	public MaquinaRegistradora getMaquinaRegistradora() {
		return maquinaRegistradora;
	}

	/**
	 * @param maquinaRegistradora the maquinaRegistradora to set
	 */
	public void setMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		this.maquinaRegistradora = maquinaRegistradora;
	}


	@Override
	public String toString() {
		return "Venta [id=" + id + ", cajero=" + cajero + ", producto=" + producto + ", maquinaRegistradora="
				+ maquinaRegistradora + "]";
	}
	
}












	

