package com.alcaudon.dado.defecto;

import java.util.*;

import com.alcaudon.dado.servicios.ServicioLanzadorDado;
import com.alcaudon.dado.servicios.ServicioLanzadorDadoCripto;

public class TestDadosMultiples {

	private static final Integer NUM_MINIMO = 1;
	private static final Integer NUM_MAXIMO = 6;
	private static final Integer DELAY = 50; // milisegundos
	private static final Integer CANT_DADOS = 20;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> listaDados = new ArrayList<Integer>();
		List<Integer> listaDados2 = new ArrayList<Integer>();
		Integer totalDados = 0;
		Integer totalDados2 = 0;
		
		ServicioLanzadorDado servBasico = new ServicioLanzadorDado();
		ServicioLanzadorDadoCripto servCripto = new ServicioLanzadorDadoCripto();
		
		listaDados = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY, CANT_DADOS);
		
		Integer c = 0;
		for (Integer dadoItem : listaDados) {
			c++;
			System.out.println("Resultado Dado " + c + ": " + dadoItem);
			totalDados = totalDados + dadoItem;
		}
		
		System.out.println("****************************************************************************************************");
		
		listaDados = servCripto.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY, CANT_DADOS);
		
		Integer c2 = 0;
		for (Integer dadoItem : listaDados) {
			c2++;
			System.out.println("Resultado Dado " + c2 + ": " + dadoItem);
			totalDados2 = totalDados2 + dadoItem;
		}
		
		System.out.println("****************************************************************************************************");
		System.out.println("****** Total Dados Impar: " + (totalDados + 7) );
		System.out.println("****** Total Dados Par  : " + totalDados2);
		
	}

}
