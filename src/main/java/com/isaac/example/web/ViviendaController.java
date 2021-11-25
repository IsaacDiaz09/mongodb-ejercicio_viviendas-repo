package com.isaac.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.isaac.example.models.Vivienda;
import com.isaac.example.service.ViviendaServiceImpl;

@RestController
@RequestMapping("/api/viviendas")
public class ViviendaController {

	@Autowired
	private ViviendaServiceImpl service;

	@GetMapping("/all")
	public List<Vivienda> traerTodo() {
		return service.traerTodo();
	}

	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public void guardarVivienda(@RequestBody Vivienda vivienda) {
		service.guardarVivienda(vivienda);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarVivienda(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}
}
