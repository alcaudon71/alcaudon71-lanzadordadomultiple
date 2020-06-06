package com.alcaudon.dado.vista;

import java.awt.*;

import javax.swing.*;

class FrameLanzaDado extends JFrame {

	private static final String FRAME_TITULO = "App Lanza Dados";
	private static final Integer FRAME_POS_HORIZONTAL = 400;
	private static final Integer FRAME_POS_VERTICAL = 200;
	private static final Integer FRAME_ANCHO = 400;
	private static final Integer FRAME_ALTO = 400;
	
	public FrameLanzaDado() {
		
		setTitle (FRAME_TITULO);
		
		setBounds(FRAME_POS_HORIZONTAL, FRAME_POS_VERTICAL, FRAME_ANCHO, FRAME_ALTO);
		
		PanelLanzaDado panelLanzaDado = new PanelLanzaDado();
		
		// Establecemos el Layout del Panel 
		//FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER); 
		//panelLanzaDado.setLayout(disposicion);
		
		// Añadimos el Panel a nuestro Frame
		add(panelLanzaDado, BorderLayout.CENTER);
		
		// Establecemos color de fondo del Panel
		panelLanzaDado.setBackground(Color.PINK);
		//panelLanzaDado.setBackground(SystemColor.window);
		
		
	}
	
	
}
