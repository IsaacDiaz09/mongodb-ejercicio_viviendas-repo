package com.isaac.example.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="viviendas")
public class Vivienda implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4370397058100323271L;

    @Id
	private Integer id;
	
	private String descripcion;
	
	private String direccion;
	
	private Integer habitaciones;
	
	private Double precio;

}
