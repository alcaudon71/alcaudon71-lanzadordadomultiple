package com.alcaudon.dado.vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

import com.alcaudon.dado.servicios.ServicioLanzadorDado;

public class PanelLanzaDado extends JPanel {

	private static final String IMAGEN_RUTA_DADOS_PAREJA = "src/com/alcaudon/dado/imagenes/dados_pareja.jpg";
	private static final String IMAGEN_RUTA_DADOS_MULTIPLES = "src/com/alcaudon/dado/imagenes/dados_multiples.jpg";
	private static final String IMAGEN_ERROR = "La imagen no se encuentra";

	private static final Integer IMAGEN_POS_HORIZONTAL = 0;
	private static final Integer IMAGEN_POS_VERTICAL = 0;
	private static final Integer IMAGEN_ANCHO = 15;
	private static final Integer IMAGEN_ALTO = 15;
	private static final Integer IMAGEN_DISTANCIA_HOR = 150;
	private static final Integer IMAGEN_DISTANCIA_VER = 75;

	private static final String BOTON_AMARILLO = "Amarillo";
	private static final String BOTON_AZUL = "Azul";
	private static final String BOTON_ROJO = "Lanzar";

	private static final String URL_ICONO_BOTON_AMARILLO = "src/com/alcaudon/dado/imagenes/boton_amarillo.gif";
	private static final String URL_ICONO_BOTON_AZUL = "src/com/alcaudon/dado/imagenes/boton_azul.gif";
	private static final String URL_ICONO_BOTON_ROJO = "src/com/alcaudon/dado/imagenes/boton_rojo.gif";

	public static final Integer SEPARACION_HORIZONTAL = 10;
	public static final Integer SEPARACION_VERTICAL = 10;
	
	private Image imagen;
	private JTextField texto;

	public PanelLanzaDado() {

		// El Layout hay que definirlo en el constructor del Panel 
		//FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER, SEPARACION_HORIZONTAL, SEPARACION_VERTICAL);
		BorderLayout disposicion = new BorderLayout(SEPARACION_HORIZONTAL, SEPARACION_VERTICAL);
		
		// Añadimos el Layout al Panel 
		setLayout(disposicion);
		
		File miImagen = new File(IMAGEN_RUTA_DADOS_PAREJA);
		//File miImagen = new File(IMAGEN_RUTA_DADOS_MULTIPLES);

		try {

			imagen = ImageIO.read(miImagen);

		} catch (IOException e) {

			System.out.println(IMAGEN_ERROR);

		}

		// Creamos las instancias de la clase oyente
		AccionBoton accionAmarillo = new AccionBoton(BOTON_AMARILLO, new ImageIcon(URL_ICONO_BOTON_AMARILLO), Color.YELLOW);
		AccionBoton accionAzul = new AccionBoton(BOTON_AZUL, new ImageIcon(URL_ICONO_BOTON_AZUL), Color.BLUE);
		AccionBoton accionRojo = new AccionBoton(BOTON_ROJO, new ImageIcon(URL_ICONO_BOTON_ROJO), Color.RED);

		JButton botonAmarillo = new JButton(accionAmarillo);
		JButton botonAzul = new JButton(accionAzul);
		JButton botonRojo = new JButton(accionRojo);

		//add(botonAmarillo, BorderLayout.NORTH);
		//add(botonAzul, BorderLayout.NORTH);
		add(botonRojo, BorderLayout.NORTH);

		// Creamos un JTextField
		texto = new JTextField("Dado", 20);

		add(texto, BorderLayout.SOUTH);

	}

	@Override
	public void paintComponent (Graphics g) {

		// Ejecutamos el software por defecto de la clase "paintComponent"
		super.paintComponent(g);

		// Adicionalmente, añadimos nuestra logica:

		// Capturamos las dimensiones de la imagen
		Integer anchuraImagen = imagen.getWidth(this);
		Integer alturaImagen = imagen.getHeight(this);

		// Dibujamos la imagen 
		ImageObserver progresion = null; // progresion del renderizado de la imagen 

		Dimension dim = this.getSize();
		Integer dimAlto = dim.height;
		Integer dimAncho = dim.width;
		
		//g.drawImage(imagen, IMAGEN_POS_HORIZONTAL, IMAGEN_POS_VERTICAL, progresion);
		//g.drawImage(imagen, IMAGEN_POS_HORIZONTAL, IMAGEN_POS_VERTICAL, 400, 400, progresion);
		g.drawImage(imagen, IMAGEN_POS_HORIZONTAL, IMAGEN_POS_VERTICAL, dimAncho, dimAlto, progresion);

		//		// Establecemos un mosaico repetitivo 
		//		for (int i=0 ; i<MarcoImagen.FRAME_ANCHO; i++) {
		//			
		//			for (int j=0; j<MarcoImagen.FRAME_ALTO; j++) {
		//		
		//				if ( i + j > 0) { // Nos saltamos la primera iteracion, para no machacar nuestra imagen inicial 
		//					// Copiar una imagen y replicar a una distancia determinada
		//					//g.copyArea(IMAGEN_POS_HORIZONTAL, IMAGEN_POS_VERTICAL, IMAGEN_ANCHO, IMAGEN_ALTO, i * IMAGEN_ANCHO, j * IMAGEN_ALTO);
		//					g.copyArea(IMAGEN_POS_HORIZONTAL, IMAGEN_POS_VERTICAL, anchuraImagen, alturaImagen, i * anchuraImagen, j * alturaImagen);
		//				}
		//		
		//			}
		//		}

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
			
			texto.setText("Dado: " + dado);

			add(texto);
			
		}
	}	



}
