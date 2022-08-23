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

import com.example.demo.dto.MaquinaRegistradora;
import com.example.demo.service.MaquinaRegistradoraServiceImpl;

@RestController
@RequestMapping("/api")
public class MaquinaRegistradoraController {
	
	@Autowired
	MaquinaRegistradoraServiceImpl maquinaRegistradoraServiceImpl;
	
	@GetMapping("/maquinas_registradoras")
	public List<MaquinaRegistradora> listarMaquinasRegistradoras(){
		return maquinaRegistradoraServiceImpl.listarMaquinasRegistradoras();
	}
	
	
	@PostMapping("/maquinas_registradoras")
	public MaquinaRegistradora salvarMaquinaRegistradora(@RequestBody MaquinaRegistradora maquinaRegistradora) {
		
		return maquinaRegistradoraServiceImpl.guardarMaquinaRegistradora(maquinaRegistradora);
	}
	
	
	@GetMapping("/maquinas_registradoras/{id}")
	public MaquinaRegistradora maquinaRegistradoraXID(@PathVariable(name="id") int id) {
		
		MaquinaRegistradora MaquinaRegistradora_xid= new MaquinaRegistradora();
		
		MaquinaRegistradora_xid=maquinaRegistradoraServiceImpl.maquinaRegistradoraXID(id);
		
		System.out.println("MaquinaRegistradora XID: "+MaquinaRegistradora_xid);
		
		return MaquinaRegistradora_xid;
	}
	
	@PutMapping("/maquinas_registradoras/{id}")
	public MaquinaRegistradora actualizarMaquinaRegistradora(@PathVariable(name="id")int id,@RequestBody MaquinaRegistradora maquinaRegistradora) {
		
		MaquinaRegistradora maquinaRegistradora_seleccionado= new MaquinaRegistradora();
		MaquinaRegistradora maquinaRegistradora_actualizado= new MaquinaRegistradora();
		
		maquinaRegistradora_seleccionado= maquinaRegistradoraServiceImpl.maquinaRegistradoraXID(id);
		
		maquinaRegistradora_seleccionado.setPiso(maquinaRegistradora.getPiso());
		
		maquinaRegistradora_actualizado = maquinaRegistradoraServiceImpl.actualizarMaquinaRegistradora(maquinaRegistradora_seleccionado);
		
		System.out.println("El MaquinaRegistradora actualizado es: "+ maquinaRegistradora_actualizado);
		
		return maquinaRegistradora_actualizado;
	}
	
	@DeleteMapping("/maquinas_registradoras/{id}")
	public String eliminarMaquinaRegistradora(@PathVariable(name="id")int id) {
		try {
			maquinaRegistradoraServiceImpl.eliminarMaquinaRegistradora(id);
			return "MaquinaRegistradora eliminada";
		} catch (Exception e) {
			return "La maquinaRegistradora no se puede eliminar";
		}
	}
	
	
}