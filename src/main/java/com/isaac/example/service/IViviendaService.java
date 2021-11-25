package com.isaac.example.service;

import java.util.List;

import com.isaac.example.models.Vivienda;

public interface IViviendaService {

	List<Vivienda> traerTodo();
	
	void guardarVivienda(Vivienda vivienda);
	
	void actualizarVivienda(Vivienda vivienda);
	
	void eliminar(Integer id);
}
