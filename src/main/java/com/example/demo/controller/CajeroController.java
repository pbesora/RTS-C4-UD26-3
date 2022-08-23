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

import com.example.demo.dto.Cajero;
import com.example.demo.service.CajeroServiceImpl;

@RestController
@RequestMapping("/api")
public class CajeroController {
	
	@Autowired
	CajeroServiceImpl cajeroServiceImpl;
	
	@GetMapping("/cajeros")
	public List<Cajero> listarCajeros(){
		return cajeroServiceImpl.listarCajeros();
	}
	
	
	@PostMapping("/cajeros")
	public Cajero salvarCajero(@RequestBody Cajero cajero) {
		
		return cajeroServiceImpl.guardarCajero(cajero);
	}
	
	
	@GetMapping("/cajeros/{id}")
	public Cajero cajeroXID(@PathVariable(name="id") int id) {
		
		Cajero Cajero_xid= new Cajero();
		
		Cajero_xid=cajeroServiceImpl.cajeroXID(id);
		
		System.out.println("Cajero XID: "+Cajero_xid);
		
		return Cajero_xid;
	}
	
	@PutMapping("/cajeros/{id}")
	public Cajero actualizarCajero(@PathVariable(name="id")int id,@RequestBody Cajero cajero) {
		
		Cajero cajero_seleccionado= new Cajero();
		Cajero cajero_actualizado= new Cajero();
		
		cajero_seleccionado= cajeroServiceImpl.cajeroXID(id);
		
		cajero_seleccionado.setNomApels(cajero.getNomApels());
		
		cajero_actualizado = cajeroServiceImpl.actualizarCajero(cajero_seleccionado);
		
		System.out.println("El Cajero actualizado es: "+ cajero_actualizado);
		
		return cajero_actualizado;
	}
	
	@DeleteMapping("/cajeros/{id}")
	public String eliminarCajero(@PathVariable(name="id")int id) {
		try {
			cajeroServiceImpl.eliminarCajero(id);
			return "Cajero eliminado";
		} catch (Exception e) {
			return "El cajero no se puede eliminar";
		}
	}
	
	
}
