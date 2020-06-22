package com.alcaudon.dado.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.alcaudon.dado.servicios.ServicioLanzadorDado;
import com.alcaudon.dado.utilidades.UtilidadesLanzadorDado;

public class PanelJugarPartidoBaloncestoTimer extends JPanel {

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
	
	private static final Color COLOR_KAKI = new Color (220,220,160);
	private static final Color COLOR_CELESTE_CLARO = new Color (200,240,240);
	
	private Image imagen;
	public JTextField texto;
	//public String dadoPanel;
	
	JLabel marcadorLocal;
	JLabel marcadorVisitante;
	JLabel cronometro;
	JLabel comentarios;
	
	JPanel marcador;
	
	public PanelJugarPartidoBaloncestoTimer() {
		
		System.out.println("*** Cargamos Panel Principal ***");
		
		// El Layout hay que definirlo en el constructor del Panel 
		//FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER, SEPARACION_HORIZONTAL, SEPARACION_VERTICAL);
		BorderLayout disposicion = new BorderLayout(SEPARACION_HORIZONTAL, SEPARACION_VERTICAL);
		
		// Añadimos el Layout al Panel 
		setLayout(disposicion);
		
		
		PanelFotoCanchaBaloncesto fotoCanchaBaloncesto = new PanelFotoCanchaBaloncesto();
		
		add(fotoCanchaBaloncesto, BorderLayout.CENTER);
		
		
		// Añadimos un Boton abajo
		JPanel botonera = new JPanel();
		
		JButton botonJugar = new JButton("Jugar");
		
		// Listener del boton
		botonJugar.addActionListener(new JugarPartidoBaloncesto());
		
		botonera.add(botonJugar);
		
		add(botonera, BorderLayout.SOUTH);
		
		// Establecemos fuente
		//Font fuenteDialog = new Font("Dialog", Font.BOLD, 20);
		
		// Añadimos un Marcador arriba
		marcador = new JPanel();
		
		comentarios = new JLabel("Vestuario", JLabel.CENTER);
		cronometro = new JLabel("minuto 0", JLabel.CENTER);
		JLabel nombreLocal = new JLabel("EE.UU.", JLabel.CENTER);
		JLabel nombreVisitante = new JLabel("Rusia", JLabel.CENTER);
		marcadorLocal = new JLabel("-", JLabel.CENTER);
		marcadorVisitante = new JLabel("-", JLabel.CENTER);
		
		// Cambia el tamaño de la fuente a 20 
		Font fuenteXS = nombreLocal.getFont().deriveFont( 10f );
		Font fuenteS =  nombreLocal.getFont().deriveFont( 15f );
		Font fuenteM =  nombreLocal.getFont().deriveFont( 20f );
		Font fuenteL =  nombreLocal.getFont().deriveFont( 30f );
		Font fuenteXL = nombreLocal.getFont().deriveFont( 40f );
		
		Font fuenteComicSans = new Font("Comic Sans MS", Font.BOLD, 20);
		Font fuenteVerdana = new Font("Verdana", Font.BOLD, 15);
		
		nombreLocal.setFont(fuenteComicSans);
		nombreVisitante.setFont(fuenteComicSans);
		marcadorLocal.setFont(fuenteM);
		marcadorVisitante.setFont(fuenteM);
		cronometro.setFont(fuenteVerdana);
		comentarios.setFont(fuenteVerdana);
		
		// Definimos dimensiones de los Label 
		Dimension dimNombre = new Dimension(150, 50);
		Dimension dimMarcador = new Dimension(50, 50); // ancho + alto 
		Dimension dimCronometro = new Dimension(100, 50);
		
		nombreLocal.setPreferredSize(dimNombre);
		nombreVisitante.setPreferredSize(dimNombre);
		marcadorLocal.setPreferredSize(dimMarcador);
		marcadorVisitante.setPreferredSize(dimMarcador);
		cronometro.setPreferredSize(dimCronometro);
		comentarios.setPreferredSize(dimCronometro);
		
		// Establecemos el color de fondo de los marcadores
		marcadorLocal.setBackground(Color.PINK);
		marcadorVisitante.setBackground(Color.PINK);
		marcadorLocal.setOpaque(true);
		marcadorVisitante.setOpaque(true);
		nombreLocal.setBackground(COLOR_KAKI);
		nombreVisitante.setBackground(COLOR_KAKI);
		nombreLocal.setOpaque(true);
		nombreVisitante.setOpaque(true);
		//cronometro.setBackground(COLOR_KAKI);
		//cronometro.setOpaque(true);
		//comentarios.setBackground(COLOR_KAKI);
		//comentarios.setOpaque(true);
		
		// Añadimos los componentes al marcador
		marcador.add(comentarios);
		marcador.add(nombreLocal);
		marcador.add(marcadorLocal);
		marcador.add(marcadorVisitante);
		marcador.add(nombreVisitante);
		marcador.add(cronometro);
		
		add(marcador, BorderLayout.NORTH);
		
	}

	// Listener del boton Jugar
	private class JugarPartidoBaloncesto implements ActionListener {
		
		private static final int TIMERTASK_DELAY = 1000;
		private static final int TIMERTASK_PERIOD = 1000;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			Timer timer = new Timer();
			
			TimerTask task = new TTimeC(marcadorLocal, marcadorVisitante, cronometro, comentarios);
			
			System.out.println("Jugar partido");
			
			// Iniciamos la tarea dentro de DELAY milisegundos y luego lanzamos la tarea cada PERIOD milisegundos
			//timer.scheduleAtFixedRate(task, TIMERTASK_DELAY, TIMERTASK_PERIOD);
			timer.schedule(task, TIMERTASK_DELAY, TIMERTASK_PERIOD);
			
			//timer.cancel();
			
		}
		
	}
	
	// Accion del TimerTask
	class TTimeC extends TimerTask {

		private static final int SLEEP_MILISEGUNDOS = 1000;
		
	    private JLabel label1;
	    private JLabel label2;
	    private JLabel label3;
	    private JLabel label4;
	    
	    public TTimeC (JLabel label1, JLabel label2, JLabel label3, JLabel label4){
	        this.label1 = label1;
	        this.label2 = label2;
	        this.label3 = label3;
	        this.label4 = label4;
	    }
	    
	    @Override
	    public void run() {
	    	// TODO Auto-generated method stub

	    	try {
	    		Thread.sleep(SLEEP_MILISEGUNDOS);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}        

	    	JugarPartidoBaloncestoCancha jugar = new JugarPartidoBaloncestoCancha();

	    	jugar.jugarPartidoBaloncestoCancha(label1, label2, label3, label4);

	    	// Finalizamos el TimerTask 
	    	this.cancel();

	    }
		
	}
	
	// JugarPartidoBaloncesto
	private class JugarPartidoBaloncestoCancha {

		private static final int NUM_MINIMO = 1;
		private static final int NUM_MAXIMO = 6;
		private static final int DELAY = 2500; // milisegundos
		private static final int DADO_UNICO = 1;
		private static final int DADO_DOBLE = 2;
		private static final int DADO_MULTIPLE = 3;
		
		private static final int DADO_GOL = 85;
		
		private static final int RONDA_MINUTOS = 4;
		private static final float RONDA_MINUTOS_PRORROGA = 2.5f;
		
		private static final String COMENTARIO_GOL_LOCAL = "Gooool";
		private static final String COMENTARIO_GOL_VISITANTE = "Gol";
		private static final String COMENTARIO_PRIMER_TIEMPO = "1º Tiempo";
		private static final String COMENTARIO_SEGUNDO_TIEMPO = "2º Tiempo";
		private static final String COMENTARIO_PRORROGA = "Prorroga";
		private static final String COMENTARIO_JUEGO = "Juego";
		private static final String COMENTARIO_DESCANSO = "Descanso";
		private static final String COMENTARIO_FINAL = "Final";
		
		UtilidadesLanzadorDado utils;
		
	    private JLabel labelMarcadorLocal;
	    private JLabel labelMarcadorVisitante;
	    private JLabel labelCronometro;
	    private JLabel labelComentarios;
	    
		public void jugarPartidoBaloncestoCancha (JLabel label1, JLabel label2, JLabel label3, JLabel label4) {
			// TODO Auto-generated method stub
			
			System.out.println("Jugar partido");
			
			ServicioLanzadorDado servBasico = new ServicioLanzadorDado();
			String comentarios = "";
			Integer cronometro = 0;
			Integer dadoTotal = 0;
			List<Integer> listaDados = new ArrayList<Integer>();
			Integer dadoLocal = 0;
			Integer dadoVisitante = 0;
			Integer puntosLocal = 7;
			Integer puntosVisitante = 0;
			Integer intMarcadorLocal = 0;
			Integer intMarcadorVisitante = 0;
			Integer c = 0;

			labelMarcadorLocal = label1;
			labelMarcadorVisitante = label2;
			labelCronometro = label3;
			labelComentarios = label4;
			
			// Obtenemos el boton
			//String nombreBoton = (String) getValue(Action.NAME);

			comentarios = COMENTARIO_PRIMER_TIEMPO;
			labelComentarios.setText(comentarios);
			System.out.println("---> Empieza el primer tiempo ");
			
			// Actualizamos los Label del Panel 
			labelMarcadorLocal.setText("0");
			labelMarcadorVisitante.setText("0");
			labelCronometro.setText("minuto " + cronometro);
			labelComentarios.setText(comentarios);
			
			/**
			 * ===========================================================================================================
			 * Primer tiempo
			 * ===========================================================================================================
			 */
			for (int p = 1; p <= 5; p++) {
	
				c++;
				
				comentarios = COMENTARIO_JUEGO;
				
				// Actualizamos cronometro en minutos
				cronometro = c * RONDA_MINUTOS;
				
				// Lanzamos dado de Equipo Local
				listaDados = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY, DADO_DOBLE);
				
				dadoTotal = 0;
				for (Integer dadoItem : listaDados) {
					dadoTotal+= dadoItem;
					//System.out.println ("dadoItem: " + dadoItem);
				}
				
				dadoLocal = dadoTotal;
				
				// Gol local 
				//if (dadoLocal >= DADO_GOL) {
				//	golesLocal += 1;
				//	comentarios = COMENTARIO_GOL_LOCAL;
				//	System.out.println ("*** Gooool ***");
				//}
				
				puntosLocal += dadoLocal;
				
				// Lanzamos dado de Equipo Visitante
				listaDados = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY, DADO_DOBLE);
				
				dadoTotal = 0;
				for (Integer dadoItem : listaDados) {
					dadoTotal+= dadoItem;
					//System.out.println ("dadoItem: " + dadoItem);
				}
				
				dadoVisitante = dadoTotal;
				
				// Gol visitante 
				//if (dadoVisitante >= DADO_GOL) {
				//	golesVisitante += 1;
				//	comentarios = COMENTARIO_GOL_VISITANTE;
				//	System.out.println ("*** Gol ***");
				//}
				
				puntosVisitante += dadoVisitante;
				
				// Calculamos el Handicap
				//if (golesLocal < 0) {
				//	intMarcadorVisitante = golesVisitante - golesLocal;
				//	intMarcadorLocal = 0;
				//} else if (golesVisitante < 0) {
				//	intMarcadorLocal = golesLocal - golesVisitante;
				//	intMarcadorVisitante = 0;
				//} else {
				//	intMarcadorLocal = golesLocal;
				//	intMarcadorVisitante = golesVisitante;
				//}
				
				intMarcadorLocal = puntosLocal;
				intMarcadorVisitante = puntosVisitante;
				
				System.out.println ("*** Cronometro: minuto " + cronometro);
				System.out.println ("Dado Local    : " + dadoLocal);
				System.out.println ("Dado Visitante: " + dadoVisitante);
				System.out.println ("Puntos Local    : " + puntosLocal);
				System.out.println ("Puntos Visitante: " + puntosVisitante);
				System.out.println ("==============================");
				System.out.println ("Marcador Local    : " + intMarcadorLocal);
				System.out.println ("Marcador Visitante: " + intMarcadorVisitante);
				System.out.println ("==============================");
				
				// Actualizamos los Label del Panel 
				labelMarcadorLocal.setText(intMarcadorLocal.toString().trim());
				labelMarcadorVisitante.setText(intMarcadorVisitante.toString().trim());
				labelCronometro.setText("minuto " + cronometro);
				labelComentarios.setText(comentarios);
				
				//marcadorLocal.repaint();
				
				// Refrescamos el panel 
				//marcador.updateUI();
				//marcador.repaint();
				
			}

			comentarios = COMENTARIO_DESCANSO;
			labelComentarios.setText(comentarios);
			System.out.println("... Descanso ... ");
			
			// Intermedio
			listaDados = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY * 4, DADO_DOBLE);
			
			comentarios = COMENTARIO_SEGUNDO_TIEMPO;
			labelComentarios.setText(comentarios);
			System.out.println("---> Empieza el segundo tiempo ");
			
			/**
			 * ===========================================================================================================
			 * Segundo tiempo
			 * ===========================================================================================================
			 */
			for (int p = 1; p <= 5; p++) {

				c++;
				
				comentarios = COMENTARIO_JUEGO;
				
				// Actualizamos cronometro en minutos
				cronometro = c * RONDA_MINUTOS;
				
				// Lanzamos dado de Equipo Local
				listaDados = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY, DADO_DOBLE);
				
				dadoTotal = 0;
				for (Integer dadoItem : listaDados) {
					dadoTotal+= dadoItem;
					//System.out.println ("dadoItem: " + dadoItem);
				}
				
				dadoLocal = dadoTotal;
				
				// Gol local 
				//if (dadoLocal >= DADO_GOL) {
				//	golesLocal += 1;
				//	comentarios = COMENTARIO_GOL_LOCAL;
				//	System.out.println ("*** Gooool ***");
				//}
				
				puntosLocal += dadoLocal;
				
				// Lanzamos dado de Equipo Visitante
				listaDados = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY, DADO_DOBLE);
				
				dadoTotal = 0;
				for (Integer dadoItem : listaDados) {
					dadoTotal+= dadoItem;
					//System.out.println ("dadoItem: " + dadoItem);
				}
				
				dadoVisitante = dadoTotal;
				
				// Gol visitante 
				//if (dadoVisitante >= DADO_GOL) {
				//	golesVisitante += 1;
				//	comentarios = COMENTARIO_GOL_VISITANTE;
				//	System.out.println ("*** Gol ***");
				//}
				
				puntosVisitante += dadoVisitante;
				
				// Calculamos el Handicap
				//if (golesLocal < 0) {
				//	intMarcadorVisitante = golesVisitante - golesLocal;
				//	intMarcadorLocal = 0;
				//} else if (golesVisitante < 0) {
				//	intMarcadorLocal = golesLocal - golesVisitante;
				//	intMarcadorVisitante = 0;
				//} else {
				//	intMarcadorLocal = golesLocal;
				//	intMarcadorVisitante = golesVisitante;
				//}
				
				intMarcadorLocal = puntosLocal;
				intMarcadorVisitante = puntosVisitante;
				
				System.out.println ("*** Cronometro: minuto " + cronometro);
				System.out.println ("Dado Local    : " + dadoLocal);
				System.out.println ("Dado Visitante: " + dadoVisitante);
				System.out.println ("Puntos Local    : " + puntosLocal);
				System.out.println ("Puntos Visitante: " + puntosVisitante);
				System.out.println ("==============================");
				System.out.println ("Marcador Local    : " + intMarcadorLocal);
				System.out.println ("Marcador Visitante: " + intMarcadorVisitante);
				System.out.println ("==============================");
				
				// Actualizamos los Label del Panel 
				labelMarcadorLocal.setText(intMarcadorLocal.toString().trim());
				labelMarcadorVisitante.setText(intMarcadorVisitante.toString().trim());
				labelCronometro.setText("minuto " + cronometro);
				labelComentarios.setText(comentarios);
				
			}
			
			/**
			 * ===========================================================================================================
			 * Prorroga
			 * ===========================================================================================================
			 */
			int cp = 0;
			while (intMarcadorLocal == intMarcadorVisitante) {

				comentarios = COMENTARIO_PRORROGA;
				labelComentarios.setText(comentarios);
				System.out.println("---> Empieza la prorroga ");

				for (int p = 1; p <= 2; p++) {

					cp++;

					comentarios = COMENTARIO_JUEGO;

					// Actualizamos cronometro en minutos
					int cRedondeo = (int) (cp * RONDA_MINUTOS_PRORROGA);
					cronometro = c * RONDA_MINUTOS + cRedondeo;

					// Lanzamos dado de Equipo Local
					listaDados = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY, DADO_DOBLE);

					dadoTotal = 0;
					for (Integer dadoItem : listaDados) {
						dadoTotal+= dadoItem;
						//System.out.println ("dadoItem: " + dadoItem);
					}

					dadoLocal = dadoTotal;

					// Gol local 
					//if (dadoLocal >= DADO_GOL) {
					//	golesLocal += 1;
					//	comentarios = COMENTARIO_GOL_LOCAL;
					//	System.out.println ("*** Gooool ***");
					//}

					puntosLocal += dadoLocal;

					// Lanzamos dado de Equipo Visitante
					listaDados = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY, DADO_DOBLE);

					dadoTotal = 0;
					for (Integer dadoItem : listaDados) {
						dadoTotal+= dadoItem;
						//System.out.println ("dadoItem: " + dadoItem);
					}

					dadoVisitante = dadoTotal;

					// Gol visitante 
					//if (dadoVisitante >= DADO_GOL) {
					//	golesVisitante += 1;
					//	comentarios = COMENTARIO_GOL_VISITANTE;
					//	System.out.println ("*** Gol ***");
					//}

					puntosVisitante += dadoVisitante;

					// Calculamos el Handicap
					//if (golesLocal < 0) {
					//	intMarcadorVisitante = golesVisitante - golesLocal;
					//	intMarcadorLocal = 0;
					//} else if (golesVisitante < 0) {
					//	intMarcadorLocal = golesLocal - golesVisitante;
					//	intMarcadorVisitante = 0;
					//} else {
					//	intMarcadorLocal = golesLocal;
					//	intMarcadorVisitante = golesVisitante;
					//}

					intMarcadorLocal = puntosLocal;
					intMarcadorVisitante = puntosVisitante;

					System.out.println ("*** Cronometro: minuto " + cronometro);
					System.out.println ("Dado Local    : " + dadoLocal);
					System.out.println ("Dado Visitante: " + dadoVisitante);
					System.out.println ("Puntos Local    : " + puntosLocal);
					System.out.println ("Puntos Visitante: " + puntosVisitante);
					System.out.println ("==============================");
					System.out.println ("Marcador Local    : " + intMarcadorLocal);
					System.out.println ("Marcador Visitante: " + intMarcadorVisitante);
					System.out.println ("==============================");

					// Actualizamos los Label del Panel 
					labelMarcadorLocal.setText(intMarcadorLocal.toString().trim());
					labelMarcadorVisitante.setText(intMarcadorVisitante.toString().trim());
					labelCronometro.setText("minuto " + cronometro);
					labelComentarios.setText(comentarios);

				}
				
			} // intMarcadorLocal == intMarcadorVisitante
			
			comentarios = COMENTARIO_FINAL;
			labelComentarios.setText(comentarios);
			System.out.println("---> Final del partido ");
			
		}
		
	}
	
}

