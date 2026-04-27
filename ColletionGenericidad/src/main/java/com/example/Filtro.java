package com.example;

import java.util.function.Predicate;

public class Filtro implements Predicate<Personaje> {

	@Override
	public boolean test(Personaje personaje) {
		// es el método abstracto.
		
		return personaje.genero().equals(Genero.MUJER);
	}

}
