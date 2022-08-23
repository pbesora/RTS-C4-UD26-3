package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Venta;

public interface IVentaService {

	//Metodos del CRUD
		public List<Venta> listarVentas(); //Listar All 
		
		public Venta guardarVenta(Venta venta);	//Guarda un Venta CREATE
		
		public Venta ventaXID(int id); //Leer datos de un Venta READ
		
		public Venta actualizarVenta(Venta venta); //Actualiza datos del Venta UPDATE
		
		public void eliminarVenta(int id);// Elimina el Venta DELETE
	
}


