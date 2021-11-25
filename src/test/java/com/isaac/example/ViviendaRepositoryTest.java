package com.isaac.example;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.isaac.example.models.Vivienda;
import com.isaac.example.repository.ViviendaRepository;
import com.isaac.example.repository.crud.ViviendaCrudRepository;

/**
 * @author Isaac
 *
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ViviendaRepositoryTest {

	@Autowired
	private ViviendaRepository repo;

	@Autowired
	private ViviendaCrudRepository crudRepo;

	@Test
	@Order(1)
	void testDeleteAll() {
		System.out.println("Test 1: Borrar todo");
		
		crudRepo.deleteAll();
		List<Vivienda> viviendas = repo.traerTodo();
		Assertions.assertEquals(viviendas.size(), 0);
	}

	@Test
	@Order(2)
	void testSave() {
		System.out.println("Test 2: Guardar objetos");

		Vivienda v1 = new Vivienda(1,"Casa 1", "Calle 1", 4, 200000d);
		repo.guardarVivienda(v1);
		Vivienda v2 = new Vivienda(2,"Casa 2", "Calle 2", 2, 100000d);
		repo.guardarVivienda(v2);
		Vivienda v3 = new Vivienda(3,"Casa 3", "Calle 3", 5, 700200d);
		repo.guardarVivienda(v3);
		Vivienda v4 = new Vivienda(4,"Casa 4", "Calle 4", 7, 400000d);
		repo.guardarVivienda(v4);
		Vivienda v5 = new Vivienda(5,"Casa 5", "Calle 5", 4, 230000d);
		repo.guardarVivienda(v5);

		List<Vivienda> viviendas = repo.traerTodo();
		Assertions.assertEquals(viviendas.size(), 5);

	}


	@Test
	@Order(3)
	void testGetVivienda() {
		System.out.println("Test 3: Recuperar objetos");

		Optional<Vivienda> vivienda = repo.traerVivienda(1);
		
		Assertions.assertTrue(vivienda.isPresent());
		Assertions.assertEquals(vivienda.get().getHabitaciones(), 4);

	}
}
