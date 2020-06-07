package com.alcaudon.dado.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.alcaudon.dado.servicios.ServicioLanzadorDado;

public class PanelNorte extends JPanel {

	private static final String BOTON_AMARILLO = "Amarillo";
	private static final String BOTON_AZUL = "Azul";
	private static final String BOTON_ROJO = "Lanzar";

	private static final String URL_ICONO_BOTON_AMARILLO = "src/com/alcaudon/dado/imagenes/boton_amarillo.gif";
	private static final String URL_ICONO_BOTON_AZUL = "src/com/alcaudon/dado/imagenes/boton_azul.gif";
	private static final String URL_ICONO_BOTON_ROJO = "src/com/alcaudon/dado/imagenes/boton_rojo.gif";

	public static final Integer SEPARACION_HORIZONTAL = 10;
	public static final Integer SEPARACION_VERTICAL = 10;
	
	public Integer lanzamientoDado;
	
	  public Integer getDado()
	   {
	      return this.lanzamientoDado;
	   }
	  
	public PanelNorte() {

		// El Layout hay que definirlo en el constructor del Panel 
		FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER, SEPARACION_HORIZONTAL, SEPARACION_VERTICAL);
		
		// Añadimos el Layout al Panel 
		setLayout(disposicion);
		
		// Creamos las instancias de la clase oyente
		AccionBoton accionAmarillo = new AccionBoton(BOTON_AMARILLO, new ImageIcon(URL_ICONO_BOTON_AMARILLO), Color.YELLOW);
		AccionBoton accionAzul = new AccionBoton(BOTON_AZUL, new ImageIcon(URL_ICONO_BOTON_AZUL), Color.BLUE);
		AccionBoton accionRojo = new AccionBoton(BOTON_ROJO, new ImageIcon(URL_ICONO_BOTON_ROJO), Color.RED);

		JButton botonAmarillo = new JButton(accionAmarillo);
		JButton botonAzul = new JButton(accionAzul);
		JButton botonRojo = new JButton(accionRojo);

		//add(botonAmarillo, BorderLayout.NORTH);
		add(botonRojo, BorderLayout.NORTH);
		add(botonAzul, BorderLayout.EAST);

	}
	
	// Clase oyente para los Eventos disparadores de los Botones 
	// --> Este Listener solo actua para el Panel en el que esta definido
	// ****************************************************************************************************
	private class AccionBoton extends AbstractAction {

		private static final String DESC_ACCION_COLOR = "Poner la lamina de color ";
		private static final String CLAVE_COLOR_FONDO = "COLOR_DE_FONDO";

		private static final int NUM_MINIMO = 1;
		private static final int NUM_MAXIMO = 6;
		private static final int DELAY = 50; // milisegundos

		public AccionBoton(String nombre, Icon icono, Color colorBoton) {

			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, DESC_ACCION_COLOR + nombre);
			putValue(CLAVE_COLOR_FONDO, colorBoton);
			
			lanzamientoDado = 0;

		}

		// Accion a realizar cuando los botones sean pulsados
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			ServicioLanzadorDado servBasico = new ServicioLanzadorDado();
			Integer dado = 0;

			// Obtenemos el boton
			String nombreBoton = (String) getValue(Action.NAME);

			if (nombreBoton.equals(BOTON_ROJO)) {

				dado = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY);

			}
			
			System.out.println ("Dado: " + dado);

			// Creamos un JTextField
			//JTextField texto = new JTextField(20);
			
			
			
			//texto.setText("Dado: " + dado);

			//add(texto);
			
			lanzamientoDado = dado;
			
		}
	}	
}
