package com.alcaudon.dado.utilidades;

public class UtilidadesLanzadorDado {

	public static void wait(Integer milisegundos){
		
        try
        {
            Thread.sleep(milisegundos);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        
    }
	
}
