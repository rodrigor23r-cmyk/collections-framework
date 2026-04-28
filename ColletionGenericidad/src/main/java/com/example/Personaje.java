package com.example;

import java.time.LocalDate;

import lombok.Builder;

@Builder
// al ser un record no hace fata meter otras @ 
public record Personaje(
		String nombre, 
		String primerApellido, 
		String segundoApellido, 
		LocalDate fechaNacimiento,
		Genero genero, 
		double salario
		
		) implements Comparable<Personaje> {
	
	@Override
	public int compareTo(Personaje personaje) {
		
		int cmpPrimerApellido = this.primerApellido
				.compareTo(personaje.primerApellido());
		// para invertir el orden
		//int cmpPrimerApellido = personaje.primerApellido().compareTo(this.primerApellido);
		
		int cmpSegundoApellido = this.segundoApellido
				.compareTo(personaje.segundoApellido());
		int cmpNombre = this.nombre
				.compareTo(personaje.nombre());
		
		return cmpPrimerApellido != 0 ? cmpPrimerApellido : cmpSegundoApellido != 0 ? cmpSegundoApellido : cmpNombre;
	}

}
