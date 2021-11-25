package com.isaac.example.repository.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.isaac.example.models.Vivienda;

public interface ViviendaCrudRepository extends MongoRepository<Vivienda, Integer> {

	@Query("{id: ?0}")
	public Optional<Vivienda> getById(Integer id);
	
	@Query("{habitaciones: {$gte: ?0}}")
	public List<Vivienda> getAllByMinRooms(Integer habitaciones);
	

	@Query("{$and: [{precio; {$lte: ?0}},{habitaciones: {$gte: ?0}}]}")
	public List<Vivienda> getAllByMinRoomsAndPrice(Integer habitaciones, Double precio);

}
