package com.alcaudon.dado.servicios;

import java.util.*;

import com.alcaudon.dado.utilidades.UtilidadesLanzadorDado;

public class ServicioLanzadorDado {

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
	 */
	public Integer lanzaDado(Integer numMinimo, Integer numMaximo, Integer delayMilisegundos) {
		
		Integer dado;
		Random aleatorio = new Random();	
		
		//System.out.println("Generador Aleatorio Estandar");
		
		//utils.wait(DELAY);
		utils.wait(delayMilisegundos);
		
		Long semillaTimestamp = System.currentTimeMillis();
		
		//System.out.println("Timestamp: " + semillaTimestamp);
		
		aleatorio.setSeed(semillaTimestamp);
	
		Integer limite = numMaximo - numMinimo + 1;
		
		// Producir nuevo int aleatorio entre 0 y limite-1
		Integer intAleatorio = aleatorio.nextInt(limite);
		
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
