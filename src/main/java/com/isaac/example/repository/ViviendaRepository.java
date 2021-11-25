package com.isaac.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.isaac.example.models.Vivienda;
import com.isaac.example.repository.crud.ViviendaCrudRepository;

@Repository
public class ViviendaRepository {

	@Autowired
	private ViviendaCrudRepository repo;
	
	@Transactional
	public Vivienda guardarVivienda(Vivienda vivienda) {
		return repo.save(vivienda);
	}

	@Transactional
	public Optional<Vivienda> traerVivienda(Integer id){
		return repo.getById(id);
	}
	
	@Transactional(readOnly=true)
	public List<Vivienda> traerTodo(){
		return repo.findAll();
	}
	
	@Transactional
	public void eliminarVivienda(Integer id) {
		 repo.deleteById(id);
	}
	
}
