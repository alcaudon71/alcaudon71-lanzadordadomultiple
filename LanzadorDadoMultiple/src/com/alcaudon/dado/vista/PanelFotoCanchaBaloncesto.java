package com.alcaudon.dado.vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelFotoCanchaBaloncesto extends JPanel {


	private static final String IMAGEN_RUTA_DADOS_PAREJA = "src/com/alcaudon/dado/imagenes/dados_pareja.jpg";
	private static final String IMAGEN_RUTA_DADOS_MULTIPLES = "src/com/alcaudon/dado/imagenes/dados_multiples.jpg";
	private static final String IMAGEN_RUTA_CAMPO_FUTBOL = "src/com/alcaudon/dado/imagenes/campo_futbol.jpg";
	private static final String IMAGEN_RUTA_PISTA_BALONCESTO = "src/com/alcaudon/dado/imagenes/pista_baloncesto.jpg";
	private static final String IMAGEN_RUTA_CANCHA_BALONCESTO = "src/com/alcaudon/dado/imagenes/cancha_baloncesto.jpg";
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
	
	public PanelFotoCanchaBaloncesto() {
		
		File miImagen = new File(IMAGEN_RUTA_PISTA_BALONCESTO);
		//File miImagen = new File(IMAGEN_RUTA_DADOS_MULTIPLES);

		try {

			imagen = ImageIO.read(miImagen);

		} catch (IOException e) {

			System.out.println(IMAGEN_ERROR);

		}
		
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

		// Capturamos dimension del panel
		Dimension dim = this.getSize();
		Integer dimAlto = dim.height;
		Integer dimAncho = dim.width;
		
		//g.drawImage(imagen, IMAGEN_POS_HORIZONTAL, IMAGEN_POS_VERTICAL, progresion);
		//g.drawImage(imagen, IMAGEN_POS_HORIZONTAL, IMAGEN_POS_VERTICAL, 600, 400, progresion);
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
	
}
