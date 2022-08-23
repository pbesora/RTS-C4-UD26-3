package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Venta;
import com.example.demo.service.VentaServiceImpl;

@RestController
@RequestMapping("/api")
public class VentaController {
	
	@Autowired
	VentaServiceImpl ventaServiceImpl;
	
	@GetMapping("/ventas")
	public List<Venta> listarVenta(){
		return ventaServiceImpl.listarVentas();
	}
	
	
	@PostMapping("/ventas")
	public Venta salvarVenta(@RequestBody Venta venta) {
		
		return ventaServiceImpl.guardarVenta(venta);
	}
	
	
	@GetMapping("/ventas/{id}")
	public Venta VentaXID(@PathVariable(name="id") int id) {
		
		Venta Venta_xid= new Venta();
		
		Venta_xid=ventaServiceImpl.ventaXID(id);
		
		System.out.println("Venta XID: "+Venta_xid);
		
		return Venta_xid;
	}
	
	@PutMapping("/ventas/{id}")
	public Venta actualizarVenta(@PathVariable(name="id")int id,@RequestBody Venta Venta) {
		
		Venta venta_seleccionada= new Venta();
		Venta venta_actualizado= new Venta();
		
		venta_seleccionada= ventaServiceImpl.ventaXID(id);
		
		
		venta_seleccionada.setCajero(Venta.getCajero());
		venta_seleccionada.setProducto(Venta.getProducto());
		venta_seleccionada.setMaquinaRegistradora(Venta.getMaquinaRegistradora());
		
		venta_actualizado = ventaServiceImpl.actualizarVenta(venta_seleccionada);
		
		System.out.println("El Venta actualizado es: "+ venta_actualizado);
		
		return venta_actualizado;
	}
	
	@DeleteMapping("/ventas/{id}")
	public void eliminarVenta(@PathVariable(name="id")int id) {
		ventaServiceImpl.eliminarVenta(id);
	}
	
	
}
