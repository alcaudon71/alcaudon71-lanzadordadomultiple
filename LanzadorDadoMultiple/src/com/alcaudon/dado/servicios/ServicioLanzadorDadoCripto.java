package com.alcaudon.dado.servicios;

import java.security.*;
import java.util.ArrayList;
import java.util.List;

import com.alcaudon.dado.utilidades.UtilidadesLanzadorDado;

public class ServicioLanzadorDadoCripto {

	private static final Integer DELAY = 5000; // milisegundos
	
	UtilidadesLanzadorDado utils;

	/*
	 * Genera un numero aleatorio entre 1 y el numMaximo proporcionado
	 */
	public Integer lanzaDado(Integer numMaximo) {
		
		Integer dado;
		Integer numMinimo = 1;
		Integer delayMilisegundos = DELAY;
		
		dado = lanzaDado(numMinimo, numMaximo, delayMilisegundos);
		
		return dado;
		
	}
	
	/*
	 * Genera un numero aleatorio entre numMinimo y el numMaximo proporcionado
	 */
	public Integer lanzaDado(Integer numMinimo, Integer numMaximo) {
		
		Integer dado;
		Integer delayMilisegundos = DELAY;
		
		dado = lanzaDado(numMinimo, numMaximo, delayMilisegundos);
		
		return dado;
		
	}
	
	/*
	 * Genera un numero aleatorio entre numMinimo y el numMaximo proporcionado
	 * --> Esta clase utiliza Generacion Aleatoria de alta precision
	 */
	public Integer lanzaDado(Integer numMinimo, Integer numMaximo, Integer delayMilisegundos) {
	
		Integer dado;
		
		// Crear un nuevo generador con el algoritmo por defecto
		SecureRandom sr = new SecureRandom();
		
		//System.out.println("Generador Aleatorio Avanzado");
		
		//utils.wait(DELAY);
		utils.wait(delayMilisegundos);
		
		// La lista byte[] es suficiente, la llamada se hace únicamente para causar la generación de una nueva semilla 
		sr.nextBytes(new byte[1]);
		
		//System.out.println("Generacion de nueva semilla ... ");
		
		Integer limite = numMaximo - numMinimo + 1;
		
		// Así para tener un valor entero aleatorio de 0 al limite-1, se usa
		Integer intAleatorio = sr.nextInt(limite);
		
		//System.out.println("Numero aleatorio: " + intAleatorio);
		
		dado = intAleatorio + numMinimo;
		
		return dado;
		
	}
	
	/*
	 * Lanzamiento multiple de varios dados
	 */
	public List<Integer> lanzaDado(Integer numMinimo, Integer numMaximo, Integer delayMilisegundos, Integer cantidadDados) {
		
		List<Integer> listaDados = new ArrayList<Integer>();
		
		for (int i = 1; i <= cantidadDados; i++) {
			
			Integer lanzamiento = lanzaDado(numMinimo, numMaximo, delayMilisegundos);
			
			listaDados.add(lanzamiento);
			
		}

		return listaDados;
		
	}
	
}
