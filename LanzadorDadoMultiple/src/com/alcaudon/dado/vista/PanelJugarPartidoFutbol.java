package com.alcaudon.dado.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelJugarPartidoFutbol extends JPanel {

	private static final String IMAGEN_RUTA_DADOS_PAREJA = "src/com/alcaudon/dado/imagenes/dados_pareja.jpg";
	private static final String IMAGEN_RUTA_DADOS_MULTIPLES = "src/com/alcaudon/dado/imagenes/dados_multiples.jpg";
	private static final String IMAGEN_RUTA_CAMPO_FUTBOL = "src/com/alcaudon/dado/imagenes/campo_futbol.jpg";
	private static final String IMAGEN_ERROR = "La imagen no se encuentra";

	private static final Integer IMAGEN_POS_HORIZONTAL = 0;
	private static final Integer IMAGEN_POS_VERTICAL = 0;
	private static final Integer IMAGEN_ANCHO = 15;
	private static final Integer IMAGEN_ALTO = 15;
	private static final Integer IMAGEN_DISTANCIA_HOR = 150;
	private static final Integer IMAGEN_DISTANCIA_VER = 75;

	private static final String BOTON_AMARILLO = "Lanzar N";
	private static final String BOTON_AZUL = "Lanzar 2";
	private static final String BOTON_ROJO = "Lanzar 1";

	private static final String URL_ICONO_BOTON_AMARILLO = "src/com/alcaudon/dado/imagenes/boton_amarillo.gif";
	private static final String URL_ICONO_BOTON_AZUL = "src/com/alcaudon/dado/imagenes/boton_azul.gif";
	private static final String URL_ICONO_BOTON_ROJO = "src/com/alcaudon/dado/imagenes/boton_rojo.gif";

	public static final Integer SEPARACION_HORIZONTAL = 10;
	public static final Integer SEPARACION_VERTICAL = 10;
	
	private Image imagen;
	public JTextField texto;
	//public String dadoPanel;
	
	public PanelJugarPartidoFutbol() {
		
		System.out.println("*** Cargamos Panel Principal ***");
		
		// El Layout hay que definirlo en el constructor del Panel 
		//FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER, SEPARACION_HORIZONTAL, SEPARACION_VERTICAL);
		BorderLayout disposicion = new BorderLayout(SEPARACION_HORIZONTAL, SEPARACION_VERTICAL);
		
		// A�adimos el Layout al Panel 
		setLayout(disposicion);
		
		
		PanelFotoCampoFutbol fotoCampoFutbol = new PanelFotoCampoFutbol();
		
		add(fotoCampoFutbol, BorderLayout.CENTER);
		
		
		// A�adimos un Boton abajo
		JPanel botonera = new JPanel();
		
		JButton botonJugar = new JButton("Jugar");
		
		botonera.add(botonJugar);
		
		add(botonera, BorderLayout.SOUTH);
		
		// Establecemos fuente
		//Font fuenteDialog = new Font("Dialog", Font.BOLD, 20);
		
		// A�adimos un Marcador arriba
		JPanel marcador = new JPanel();
		
		JTextField local = new JTextField("1");
		JTextField visitante = new JTextField("0");
		JLabel nombreLocal = new JLabel("Local", JLabel.CENTER);
		JLabel nombreVisitante = new JLabel("Visitante", JLabel.CENTER);
		JLabel marcadorLocal = new JLabel("1", JLabel.CENTER);
		JLabel marcadorVisitante = new JLabel("0", JLabel.CENTER);
		
		// Cambia el tama�o de la fuente a 20 
		Font fuente = nombreLocal.getFont().deriveFont( 20f );
		
		nombreLocal.setFont(fuente);
		nombreVisitante.setFont(fuente);
		local.setFont(fuente);
		visitante.setFont(fuente);
		marcadorLocal.setFont(fuente);
		marcadorVisitante.setFont(fuente);
		
		// Definimos dimensiones de los Label 
		Dimension dimNombre = new Dimension(100, 50);
		Dimension dimMarcador = new Dimension(50, 50); // ancho + alto 
		
		nombreLocal.setPreferredSize(dimNombre);
		nombreVisitante.setPreferredSize(dimNombre);
		local.setPreferredSize(dimMarcador);
		visitante.setPreferredSize(dimMarcador);
		marcadorLocal.setPreferredSize(dimMarcador);
		marcadorVisitante.setPreferredSize(dimMarcador);
		
		// Establecemos el color de fondo de los marcadores
		marcadorLocal.setBackground(Color.PINK);
		marcadorVisitante.setBackground(Color.PINK);
		marcadorLocal.setOpaque(true);
		marcadorVisitante.setOpaque(true);
		
		// A�adimos los componentes al marcador
		marcador.add(nombreLocal);
		marcador.add(marcadorLocal);
		marcador.add(marcadorVisitante);
		marcador.add(nombreVisitante);
		
		add(marcador, BorderLayout.NORTH);
		
	}
	
}
