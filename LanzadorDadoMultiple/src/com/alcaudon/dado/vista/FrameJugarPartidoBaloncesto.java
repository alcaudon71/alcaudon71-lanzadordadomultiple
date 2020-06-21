package com.alcaudon.dado.vista;

import java.awt.SystemColor;

import javax.swing.JFrame;

public class FrameJugarPartidoBaloncesto extends JFrame {
	private static final String FRAME_TITULO = "App Partido Baloncesto";
	private static final Integer FRAME_POS_HORIZONTAL = 400;
	private static final Integer FRAME_POS_VERTICAL = 200;
	private static final Integer FRAME_ANCHO = 700;
	private static final Integer FRAME_ALTO = 700;
	
	public FrameJugarPartidoBaloncesto() {
		
		setTitle (FRAME_TITULO);
		
		setBounds(FRAME_POS_HORIZONTAL, FRAME_POS_VERTICAL, FRAME_ANCHO, FRAME_ALTO);
		
		System.out.println("*** Cargamos Frame ***");
		
		PanelJugarPartidoBaloncestoTimer panelJugarPartidoBaloncesto = new PanelJugarPartidoBaloncestoTimer();
		
		// Establecemos el Layout del Panel 
		//FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER); 
		//panelJugarPartidoBaloncesto.setLayout(disposicion);
		
		// Añadimos el Panel a nuestro Frame
		add(panelJugarPartidoBaloncesto);
		
		// Establecemos color de fondo del Panel
		panelJugarPartidoBaloncesto.setBackground(SystemColor.window);
		
	}

}
