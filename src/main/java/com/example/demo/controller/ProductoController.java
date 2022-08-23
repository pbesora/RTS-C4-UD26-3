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

import com.example.demo.dto.Producto;
import com.example.demo.service.ProductoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	ProductoServiceImpl productoServiceImpl;
	
	@GetMapping("/productos")
	public List<Producto> listarCcursos(){
		return productoServiceImpl.listarProductos();
	}
	
	
	@PostMapping("/productos")
	public Producto salvarProducto(@RequestBody Producto producto) {
		
		return productoServiceImpl.guardarProducto(producto);
	}
	
	
	@GetMapping("/productos/{id}")
	public Producto ProductoXID(@PathVariable(name="id") int id) {
		
		Producto Producto_xid= new Producto();
		
		Producto_xid=productoServiceImpl.productoXID(id);
		
		System.out.println("Producto XID: "+Producto_xid);
		
		return Producto_xid;
	}
	
	@PutMapping("/productos/{id}")
	public Producto actualizarProducto(@PathVariable(name="id")int id,@RequestBody Producto producto) {
		
		Producto producto_seleccionado= new Producto();
		Producto producto_actualizado= new Producto();
		
		producto_seleccionado= productoServiceImpl.productoXID(id);
		
		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());
		
		producto_actualizado = productoServiceImpl.actualizarProducto(producto_seleccionado);
		
		System.out.println("El Producto actualizado es: "+ producto_actualizado);
		
		return producto_actualizado;
	}
	
	@DeleteMapping("/productos/{id}")
	public String eliminarProducto(@PathVariable(name="id")int id) {
		try {
			productoServiceImpl.eliminarProducto(id);
			return "Producto eliminado";
		} catch (Exception e) {
			return "El producto no se puede eliminar";
		}
	}
	
	
}
