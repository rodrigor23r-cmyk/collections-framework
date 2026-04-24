package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.management.ValueExp;

import com.sun.org.apache.xpath.internal.operations.Equals;

/**
 * docs.oracle.com/javase/tutorial/extra/generics/index.html
 * 
 * Nota Profe: antes de java8 en la API de la JVM, algunas clases/interfaces eran genéricos, ahora lo son TODOS.
 * Un programador no crea elementos genéricos sino que los consume.
 * Pero los que implementan bibliotecas de métodos, clases, interfaces y records ; SI les interesa crear genericidad.
 * 
 * La genericidad tiene que ver con los tipos de datos que un contenedor puede manejar.
 * Parametrizar los elementos de la API de la plataforma de Java para que pueda trabajar con distintos tipos de datos
 * 
 * 
 */

public class App {
    public static void main(String[] args) {
    	
    	// concretando la definición del comentario anterior
    	// List es una interface con un diamante
    	
    	// ==========SIN GENERICIDAD=============
    	List elementos = new ArrayList();
    	
    	elementos.add("Carolina");
    	elementos.add("Dani");
    	elementos.add(3.14);
    	// hay que hacer un type casting:
    	String variabletexto = (String) elementos.get(0);
    	double variabledecimal = (double) elementos.get(2);
    	
        // ========CON GENERICS ================
    	// durante la compilación se especifica el tipo del elemento y durante la ejecución se minimizan los errores
    	// además nos ahorramos el type casting
    	// en el diamante no se admiten tipos de datos primitivos
    	
    	List<Integer> numeros = new ArrayList<>();
    	
    	numeros.add(100);
    	var x = numeros.get(0);
    	
    	System.out.println(x);
    	
    	List<Persona> personas;
    	
    	/*
    	 * Scope entorno de una variable declarada con pattern matching
    	 * OR || no tiene sentido pero AND && si lo tiene
    	 * */
        Object xx = "dsafd";
        Number yy = 24;
        
        if (xx instanceof String d || yy instanceof Integer n) {
        	// System.out.println(Integer.valueOf(d));
        		
        	}
        
 /*       if (xx instanceof String d || yy instanceof Number n) {
        		if (
        		System.out.println(d);
        }
    */	
    
    /**
     * Framework de colecciones
     * colecciones: son interfaces genéricas <E>. operaciones de agregado (group by que vimos en SQL) 
     * framework: 
     * interfaces - Implementaciones - Algoritmos (polimorfismo)
     * 
     * */
    Integer[] arrayNumerosEnteros = {1,2,3,4,5};
    List<Integer> numerosEnteros = Arrays.asList(arrayNumerosEnteros);
    // numerosEnteros.add(6); // esto daría error
    
    // =================================================================
    
    // Evolución de la declaración de una lista:
    // List<Personaje> personaje = null;
    // inicializar con null no funciona. no puedo agregar elementos porque no reserva memoria
    // hay que usar un constructor de alguna de las clases de List.
    // List<Personaje> personaje = new ArrayList<Personaje>();
    var personajes = new ArrayList<Personaje>();
    

    personajes.add(Personaje.builder()
    		.nombre("Duglas")
    		.primerApellido("Taydron")
    		.segundoApellido("González")
    		.fechaNacimiento(LocalDate.of(1995, Month.JANUARY, 20))
    		.genero(Genero.HOMBRE)
    		.build());
    personajes.add(Personaje.builder()
            .nombre("Carolina")
            .primerApellido("Garzón")
            .segundoApellido("Becerra")
            .fechaNacimiento(LocalDate.of(2000, Month.MAY, 15))
            .genero(Genero.MUJER)
            .build());

    personajes.add(Personaje.builder()
            .nombre("María")
            .primerApellido("Garzón")
            .segundoApellido("González")
            .fechaNacimiento(LocalDate.of(2005, Month.SEPTEMBER, 3))
            .genero(Genero.MUJER)
            .build());

    personajes.add(Personaje.builder()
            .nombre("Jerónimo")
            .primerApellido("Arenal")
            .segundoApellido("Gómez")
            .fechaNacimiento(LocalDate.of(1989, Month.DECEMBER, 12))
            .genero(Genero.HOMBRE)
            .build());

    /*
     * la lista resultante no es de tamaño fijo porque no es un array
     * */
    //System.out.println(personajes);
    
    /*
     * Traversing Collection
     * https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html 
     * 
     * 3 formas de recorrer una colección:
     * 
     * 1 Iterator<E> elimina elementos a la vez que lo recorre.
     * 2 sentencia for mejorada
     * 3 la mejor: Operaciones de agregado, métodos por referencia,
     * 		operaciones de agregado, Programación funcional, lambda
     * 
     */
    
    	System.out.println("=========LISTADO ORIGINAL DE PERSONAS================");
    	System.out.println(personajes);
    	

    	Iterator<Personaje> it = personajes.iterator();
    	
    	while (it.hasNext()) {
    		Personaje personilla = it.next();
    		if (personilla.genero().equals(Genero.HOMBRE) && (personilla.nombre().length() == 6)) {
    			it.remove();
    		}
    	}
    	
    	
    	System.out.println("========RESULTADO DE HACER LA ELIMINACION============");
    	personajes.forEach(System.out::println);
    	

    	/*variante 2 for mejorada
    	 * eliminar personas de género mujer
    	*/
    	for (Personaje personillas : personajes) {
    		if (personillas.genero().equals(Genero.MUJER)) {
    			personajes.remove(personillas);
    		}
    	// la línea 168 no da error ahora pero no funcionará.	
    	}
    	
    	
	}
}
