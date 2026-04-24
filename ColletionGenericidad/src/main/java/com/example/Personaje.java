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
		Genero genero
		) {

}
