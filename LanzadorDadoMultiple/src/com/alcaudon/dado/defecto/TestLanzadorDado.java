package com.alcaudon.dado.defecto;

import java.util.*;

import com.alcaudon.dado.servicios.*;

public class TestLanzadorDado {

	private static final Integer NUM_MINIMO = 1;
	private static final Integer NUM_MAXIMO = 6;
	private static final Integer DELAY = 50; // milisegundos
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] arrayCarasDado = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		Integer[] arrayCarasDadoCripto = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		//List<Integer> listaCarasDado = new ArrayList<Integer>();
		Integer lanzamientos = 1000;
		Integer dado = 0;
		
		ServicioLanzadorDado servBasico = new ServicioLanzadorDado();
		ServicioLanzadorDadoCripto servCripto = new ServicioLanzadorDadoCripto();
		
		System.out.println("****************************************************************************************************");
		System.out.println("Lanzamiento de Dado *** Aleatorio Estandar");
		
		for (int i=1; i<=lanzamientos; i++) {
		
			dado = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY);
		
			arrayCarasDado[dado]++;
			
			System.out.println("Lanzamiento Dado " + i + ": " + dado);
		
		}
		
		System.out.println(" *** Estadisticas Aleatorio Estandar *** ");
		for (int j=1; j<=NUM_MAXIMO; j++) {
			System.out.println("Cantidad CaraDado " + j + ": " + arrayCarasDado[j]);
		}
		
		System.out.println("****************************************************************************************************");
		System.out.println("Lanzamiento de Dado *** Aleatorio Criptografico");
		
		for (int i=1; i<=lanzamientos; i++) {
		
			dado = servCripto.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY);
			
			arrayCarasDadoCripto[dado]++;
		
			System.out.println("Lanzamiento Dado " + i + ": " + dado);
		
		}
		
		System.out.println(" *** Estadisticas Aleatorio Criptografico *** ");
		for (int j=1; j<=NUM_MAXIMO; j++) {
			System.out.println("Cantidad CaraDado " + j + ": " + arrayCarasDadoCripto[j]);
		}
		
	}

}
