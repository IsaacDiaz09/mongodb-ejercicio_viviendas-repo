package com.isaac.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaac.example.models.Vivienda;
import com.isaac.example.repository.ViviendaRepository;

@Service
public class ViviendaServiceImpl implements IViviendaService {

	@Autowired
	private ViviendaRepository repo;

	@Override
	public List<Vivienda> traerTodo() {
		return repo.traerTodo();
	}

	@Override
	public void guardarVivienda(Vivienda vivienda) {
		Optional<Vivienda> viviendaAux = repo.traerVivienda(vivienda.getId());
		if (viviendaAux.isEmpty()) {
			repo.guardarVivienda(vivienda);
		}
	}

	@Override
	public void actualizarVivienda(Vivienda vivienda) {
		Optional<Vivienda> viviendaAux = repo.traerVivienda(vivienda.getId());
		if (viviendaAux.isPresent()) {
			// Validaciones en la recepcion de los nuevos atributos
			repo.guardarVivienda(vivienda);
			
		}
	}

	@Override
	public void eliminar(Integer id) {
		Optional<Vivienda> viviendaAux = repo.traerVivienda(id);
		if (viviendaAux.isPresent()) {
			repo.eliminarVivienda(id);
		}
	}

}
