package com.alcaudon.dado.vista;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class FrameJugarPartidoFutbol extends JFrame {
	private static final String FRAME_TITULO = "App Partido Futbol";
	private static final Integer FRAME_POS_HORIZONTAL = 400;
	private static final Integer FRAME_POS_VERTICAL = 200;
	private static final Integer FRAME_ANCHO = 400;
	private static final Integer FRAME_ALTO = 400;
	
	public FrameJugarPartidoFutbol() {
		
		setTitle (FRAME_TITULO);
		
		setBounds(FRAME_POS_HORIZONTAL, FRAME_POS_VERTICAL, FRAME_ANCHO, FRAME_ALTO);
		
		System.out.println("*** Cargamos Frame ***");
		
		PanelJugarPartidoFutbol panelJugarPartidoFutbol = new PanelJugarPartidoFutbol();
		
		// Establecemos el Layout del Panel 
		FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER); 
		panelJugarPartidoFutbol.setLayout(disposicion);
		
		// Añadimos el Panel a nuestro Frame
		add(panelJugarPartidoFutbol);
		
		// Establecemos color de fondo del Panel
		panelJugarPartidoFutbol.setBackground(Color.PINK);
		//panelJugarPartidoFutbol.setBackground(SystemColor.window);
		
	}

}
