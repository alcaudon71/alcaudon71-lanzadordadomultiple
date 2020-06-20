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

public class PanelJugarPartidoFutbolTimer extends JPanel {

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
	
	JLabel marcadorLocal;
	JLabel marcadorVisitante;
	
	JPanel marcador;
	
	public PanelJugarPartidoFutbolTimer() {
		
		System.out.println("*** Cargamos Panel Principal ***");
		
		// El Layout hay que definirlo en el constructor del Panel 
		//FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER, SEPARACION_HORIZONTAL, SEPARACION_VERTICAL);
		BorderLayout disposicion = new BorderLayout(SEPARACION_HORIZONTAL, SEPARACION_VERTICAL);
		
		// Añadimos el Layout al Panel 
		setLayout(disposicion);
		
		
		PanelFotoCampoFutbol fotoCampoFutbol = new PanelFotoCampoFutbol();
		
		add(fotoCampoFutbol, BorderLayout.CENTER);
		
		
		// Añadimos un Boton abajo
		JPanel botonera = new JPanel();
		
		JButton botonJugar = new JButton("Jugar");
		
		// Listener del boton
		botonJugar.addActionListener(new JugarPartidoFutbol());
		
		botonera.add(botonJugar);
		
		add(botonera, BorderLayout.SOUTH);
		
		// Establecemos fuente
		//Font fuenteDialog = new Font("Dialog", Font.BOLD, 20);
		
		// Añadimos un Marcador arriba
		marcador = new JPanel();
		
		//JTextField local = new JTextField("1");
		//JTextField visitante = new JTextField("0");
		JLabel nombreLocal = new JLabel("Local", JLabel.CENTER);
		JLabel nombreVisitante = new JLabel("Visitante", JLabel.CENTER);
		marcadorLocal = new JLabel("-", JLabel.CENTER);
		marcadorVisitante = new JLabel("-", JLabel.CENTER);
		
		// Cambia el tamaño de la fuente a 20 
		Font fuente = nombreLocal.getFont().deriveFont( 20f );
		
		nombreLocal.setFont(fuente);
		nombreVisitante.setFont(fuente);
		//local.setFont(fuente);
		//visitante.setFont(fuente);
		marcadorLocal.setFont(fuente);
		marcadorVisitante.setFont(fuente);
		
		// Definimos dimensiones de los Label 
		Dimension dimNombre = new Dimension(100, 50);
		Dimension dimMarcador = new Dimension(50, 50); // ancho + alto 
		
		nombreLocal.setPreferredSize(dimNombre);
		nombreVisitante.setPreferredSize(dimNombre);
		//local.setPreferredSize(dimMarcador);
		//visitante.setPreferredSize(dimMarcador);
		marcadorLocal.setPreferredSize(dimMarcador);
		marcadorVisitante.setPreferredSize(dimMarcador);
		
		// Establecemos el color de fondo de los marcadores
		marcadorLocal.setBackground(Color.PINK);
		marcadorVisitante.setBackground(Color.PINK);
		marcadorLocal.setOpaque(true);
		marcadorVisitante.setOpaque(true);
		
		// Añadimos los componentes al marcador
		marcador.add(nombreLocal);
		marcador.add(marcadorLocal);
		marcador.add(marcadorVisitante);
		marcador.add(nombreVisitante);
		
		add(marcador, BorderLayout.NORTH);
		
	}

	// Listener del boton Jugar
	private class JugarPartidoFutbol implements ActionListener {
		
		private static final int TIMERTASK_DELAY = 0;
		private static final int TIMERTASK_PERIOD = 10000;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			Timer timer = new Timer();
			
			TimerTask task = new TTimeC(marcadorLocal, marcadorVisitante); // = new TimerTask(marcadorLocal);
			
			System.out.println("Jugar partido");
			
			// Iniciamos la tarea dentro de DELAY milisegundos y luego lanzamos la tarea cada PERIOD milisegundos
			//timer.scheduleAtFixedRate(task, TIMERTASK_DELAY, TIMERTASK_PERIOD);
			timer.schedule(task, TIMERTASK_DELAY, TIMERTASK_PERIOD);
			
		}
		
	}
	
	// Accion del TimerTask
	class TTimeC extends TimerTask {

		private static final int SLEEP_MILISEGUNDOS = 1000;
		
	    private JLabel label1;
	    private JLabel label2;
	    int milisegundos = 0;
	    int minutos = 0;
	    int segundos = 0;
	    String sOfTime;
	    
	    public TTimeC (JLabel label1, JLabel label2){
	        this.label1 = label1;
	        this.label2 = label2;
	    }
	    
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			int cont = 0;
			
	        while (cont < 10){
	        	cont++;
	        	
	            milisegundos++;
	            if (milisegundos == 1000) {
	                milisegundos = 0;
	                segundos++;
	            }
	            if (segundos == 60) {
	                segundos = 0;
	                minutos++;
	            }
	            
	            //sOfTime = minutos + ":" + segundos + ":" + milisegundos;
	            sOfTime = milisegundos + "";
	            
	            System.out.println("sOfTime: " + sOfTime);
	            
	            label1.setText(sOfTime);    
	            
	            try {
	                Thread.sleep(SLEEP_MILISEGUNDOS);
	            } catch (Exception e) {
	            	e.printStackTrace();
	            }
	            
	        }
	        
	        JugarPartidoFutbolCampo jugar = new JugarPartidoFutbolCampo();
	        
	        jugar.jugarPartidoFutbolCampo(label1, label2);
	        
		}
		
	}
	
	// JugarPartidoFutbol
	private class JugarPartidoFutbolCampo {

		private static final int NUM_MINIMO = 1;
		private static final int NUM_MAXIMO = 100;
		private static final int DELAY = 5000; // milisegundos
		private static final int DADO_UNICO = 1;
		private static final int DADO_DOBLE = 2;
		private static final int DADO_MULTIPLE = 3;
		
		private static final int DADO_GOL = 85;
		
		private static final int RONDA_MINUTOS = 9;
		
		UtilidadesLanzadorDado utils;
		
	    private JLabel labelMarcadorLocal;
	    private JLabel labelMarcadorVisitante;
	    
		public void jugarPartidoFutbolCampo (JLabel label1, JLabel label2) {
			// TODO Auto-generated method stub
			
			System.out.println("Jugar partido");
			
			ServicioLanzadorDado servBasico = new ServicioLanzadorDado();
			Integer cronometro = 0;
			Integer dadoTotal = 0;
			List<Integer> listaDados = new ArrayList<Integer>();
			Integer dadoLocal = 0;
			Integer dadoVisitante = 0;
			Integer golesLocal = 0;
			Integer golesVisitante = -1;
			Integer intMarcadorLocal = 0;
			Integer intMarcadorVisitante = 0;

			labelMarcadorLocal = label1;
			labelMarcadorVisitante = label2;
			
			// Obtenemos el boton
			//String nombreBoton = (String) getValue(Action.NAME);

			System.out.println("---> Empieza el primer tiempo ");
			
			/**
			 * ===========================================================================================================
			 * Primer tiempo
			 * ===========================================================================================================
			 */
			for (int c = 1; c <= 5; c++) {
	
				// Actualizamos cronometro en minutos
				cronometro = c * RONDA_MINUTOS;
				
				// Lanzamos dado de Equipo Local
				listaDados = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY, DADO_UNICO);
				
				dadoTotal = 0;
				for (Integer dadoItem : listaDados) {
					dadoTotal+= dadoItem;
					// System.out.println ("dadoItem: " + dadoItem);
				}
				
				dadoLocal = dadoTotal;
				
				// Gol local 
				if (dadoLocal >= DADO_GOL) {
					golesLocal += 1;
					System.out.println ("*** Gooool ***");
				}
				
				// Lanzamos dado de Equipo Visitante
				listaDados = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY, DADO_UNICO);
				
				dadoTotal = 0;
				for (Integer dadoItem : listaDados) {
					dadoTotal+= dadoItem;
					//System.out.println ("dadoItem: " + dadoItem);
				}
				
				dadoVisitante = dadoTotal;
				
				// Gol visitante 
				if (dadoVisitante >= DADO_GOL) {
					golesVisitante += 1;
					System.out.println ("*** Gol ***");
				}
				
				// Calculamos el Handicap
				if (golesLocal < 0) {
					intMarcadorVisitante = golesVisitante - golesLocal;
					intMarcadorLocal = 0;
				} else if (golesVisitante < 0) {
					intMarcadorLocal = golesLocal - golesVisitante;
					intMarcadorVisitante = 0;
				} else {
					intMarcadorLocal = golesLocal;
					intMarcadorVisitante = golesVisitante;
				}
				
				System.out.println ("*** Cronometro: minuto " + cronometro);
				System.out.println ("Dado Local    : " + dadoLocal);
				System.out.println ("Dado Visitante: " + dadoVisitante);
				System.out.println ("Goles Local    : " + golesLocal);
				System.out.println ("Goles Visitante: " + golesVisitante);
				System.out.println ("==============================");
				System.out.println ("Marcador Local    : " + intMarcadorLocal);
				System.out.println ("Marcador Visitante: " + intMarcadorVisitante);
				System.out.println ("==============================");
				
				// Actualizamos los Label del Panel 
				labelMarcadorLocal.setText(intMarcadorLocal.toString().trim());
				labelMarcadorVisitante.setText(intMarcadorVisitante.toString().trim());
				
				//marcadorLocal.repaint();
				
				// Refrescamos el panel 
				//marcador.updateUI();
				//marcador.repaint();
				
			}

			System.out.println("... Descanso ... ");
			
			// Intermedio
			listaDados = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY * 10, DADO_UNICO);
			
			System.out.println("---> Empieza el segundo tiempo ");
			
			/**
			 * ===========================================================================================================
			 * Segundo tiempo
			 * ===========================================================================================================
			 */
			for (int c = 6; c <= 10; c++) {

				// Actualizamos cronometro en minutos
				cronometro = c * RONDA_MINUTOS;
				
				// Lanzamos dado de Equipo Local
				listaDados = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY, DADO_UNICO);
				
				dadoTotal = 0;
				for (Integer dadoItem : listaDados) {
					dadoTotal+= dadoItem;
					//System.out.println ("dadoItem: " + dadoItem);
				}
				
				dadoLocal = dadoTotal;
				
				// Gol local 
				if (dadoLocal >= DADO_GOL) {
					golesLocal += 1;
					System.out.println ("*** Gooool ***");
				}
				
				// Lanzamos dado de Equipo Visitante
				listaDados = servBasico.lanzaDado(NUM_MINIMO, NUM_MAXIMO, DELAY, DADO_UNICO);
				
				dadoTotal = 0;
				for (Integer dadoItem : listaDados) {
					dadoTotal+= dadoItem;
					//System.out.println ("dadoItem: " + dadoItem);
				}
				
				dadoVisitante = dadoTotal;
				
				// Gol visitante 
				if (dadoVisitante >= DADO_GOL) {
					golesVisitante += 1;
					System.out.println ("*** Gol ***");
				}
				
				// Calculamos el Handicap
				if (golesLocal < 0) {
					intMarcadorVisitante = golesVisitante - golesLocal;
					intMarcadorLocal = 0;
				} else if (golesVisitante < 0) {
					intMarcadorLocal = golesLocal - golesVisitante;
					intMarcadorVisitante = 0;
				} else {
					intMarcadorLocal = golesLocal;
					intMarcadorVisitante = golesVisitante;
				}
				
				System.out.println ("*** Cronometro: minuto " + cronometro);
				System.out.println ("Dado Local    : " + dadoLocal);
				System.out.println ("Dado Visitante: " + dadoVisitante);
				System.out.println ("Goles Local    : " + golesLocal);
				System.out.println ("Goles Visitante: " + golesVisitante);
				System.out.println ("==============================");
				System.out.println ("Marcador Local    : " + intMarcadorLocal);
				System.out.println ("Marcador Visitante: " + intMarcadorVisitante);
				System.out.println ("==============================");
				
				// Actualizamos los Label del Panel 
				labelMarcadorLocal.setText(intMarcadorLocal.toString().trim());
				labelMarcadorVisitante.setText(intMarcadorVisitante.toString().trim());
				
			}
			
			System.out.println("---> Final del partido ");
			
		}
		
	}
	
}

