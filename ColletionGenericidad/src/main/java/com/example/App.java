package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.management.ValueExp;

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
}
