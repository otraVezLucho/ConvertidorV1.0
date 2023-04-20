package ConversorPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FramePrincipal extends JFrame implements ActionListener {
	
	
	JPanel mensajePrincipalPanel;
		JLabel mensajePrincipalLabel;
	
	JPanel menuPanel;
		JLabel menuLabel;
		JButton convertidorMenu; // Apartir de este boton todas las variables y elementos creados pertenecen al panel del conversor de divisas  
			JPanel convertidorPanel;
				JPanel tituloPanel;
					JLabel convertidorLabel1;
				JPanel mainConversorPanel;
					JComboBox cajaDivisas1; 
						int indexCaja1;
					JTextField campoValor;
						double texto;
					JComboBox cajaDivisas2;  
						int indexCaja2;
					JButton convertirBoton;
						double resultadoConversion;
						String errorString;
						String txtException;
						String tamanoTxt;
						int tamañoNumero;
					JLabel textoDivisor;
					JPanel resultadoPanel;
					JLabel resultado;
					
		JButton botonDistancia; // Apartir de este boton todas las variables y elementos creados pertenecen al panel del conversor de distancias
			JPanel distanciasPanel;
				JPanel tituloPanelDistancias;
					JLabel tituloLabel;
				JPanel panelConversor;
					JTextField campoValor1;
						double texto1;
					JComboBox cajaMedidas1; 
						int index1;
					JLabel textoDivisor1; 
					JComboBox cajaMedidas2; 
						int index2;
					JButton convertirBoton1; 
					JPanel resultadoPanel1;	
						JLabel resultado1;
							double resultadoConversion1;
	
	
	FramePrincipal() {
		
		mensajePrincipalLabel = new JLabel();
		mensajePrincipalLabel.setText("<html> ¡Bienvenido! <p>En esta herramienta podrás realizar conversiones entre divisas o entre distancias, por favor elige una opción para empezar.<html>");
		mensajePrincipalLabel.setFont(new Font("Century Gothic",Font.PLAIN,30));
		mensajePrincipalLabel.setBounds(20, 0, 500, 250);
		
		
		mensajePrincipalPanel = new JPanel();
		mensajePrincipalPanel.setBounds(120, 0, 680, 300);
		mensajePrincipalPanel.setBackground(new Color(0xF5F5F5));
		mensajePrincipalPanel.setLayout(null); // lo coloco en null para que pueda manipular el tamaño del panel interior
		mensajePrincipalPanel.setVisible(true);
		mensajePrincipalPanel.add(mensajePrincipalLabel);
		
		//===================================================================
		//Panel del Convertidor 
	
		convertidorLabel1 = new JLabel();
		convertidorLabel1.setText("Conversor de divisas");
		convertidorLabel1.setFont(new Font("Century Gothic",Font.PLAIN,30));
		convertidorLabel1.setVerticalTextPosition(JLabel.CENTER);
		convertidorLabel1.setHorizontalTextPosition(JLabel.LEFT);
		convertidorLabel1.setBounds(150, 3, 400, 40);
		
	
		//PANELES DETRO DEL PANEL DEL CONVERTIDOR
		//Panel del titulo
		
		tituloPanel = new JPanel();
		tituloPanel.setBackground(new Color(0xC4C4C4));
		tituloPanel.setBounds(0, 0, 680, 50);
		tituloPanel.setLayout(null);
		tituloPanel.add(convertidorLabel1);		
		//Panel para el main del conversor
		
		//Combo Box Divisas 
		
		String[] divisas = {"COP","USD","EUR","RUB","GBP","JPY","KRW"};
		cajaDivisas1 = new JComboBox<>(divisas); 
		cajaDivisas1.addActionListener(this);
		cajaDivisas1.setFont(new Font("Century Gothic",Font.PLAIN,13));
		cajaDivisas1.setBounds(180, 20, 100, 20); 
		
		//Campo de Texto valor
		campoValor = new JTextField();
		campoValor.setBounds(70, 20, 100, 20); 
		campoValor.setPreferredSize(new Dimension(50,20));
		campoValor.setFont(new Font("Century Gothic",Font.PLAIN,11));
		campoValor.setBackground(new Color(0xffffff));
		//campoValor.setText(Ingrese un numero); //No funciono como yo pense, hay que borrar manualmente el texto informativo del campo de texto 
		
		//Boton convertir
		convertirBoton = new JButton("convertir");
		convertirBoton.addActionListener(this);
		convertirBoton.setFont(new Font("Century Gothic",Font.PLAIN,15));
		convertirBoton.setBackground(new Color(0x878787));
		convertirBoton.setBounds(420, 20, 120, 20);
		
		//LABEL PARA TEXTO DIVISOR
		textoDivisor = new JLabel();
		textoDivisor.setText(" - ");
		textoDivisor.setBounds(290, 20, 60, 20);
		
		//CAJA DE DIVISAS 2
		cajaDivisas2 = new JComboBox(divisas);
		cajaDivisas2.addActionListener(this);
		cajaDivisas2.setFont(new Font("Century Gothic",Font.PLAIN,13));
		cajaDivisas2.setBounds(310, 20, 100, 20);
		
		
		
		//Panel para mostrar el resultado aparte
		resultado = new JLabel(txtException);
		resultado.setFont(new Font("Century Gothic",Font.PLAIN,25));
		resultado.setText("" + resultadoConversion);
		
		resultadoPanel = new JPanel();
		resultadoPanel.setBounds(150, 80, 300, 50);
		resultadoPanel.setBackground(new Color(0x878787));
		//resultadoPanel.setBorder(null); // Configurar al final
		resultadoPanel.setLayout(new FlowLayout());
		
		resultadoPanel.setVisible(true);
		resultadoPanel.add(resultado);
		
		//CONVERSOR PANEL MAIN donde se alojan los componentes agregados del convertidor
		
		mainConversorPanel= new JPanel();
		mainConversorPanel.setBackground(new Color(0x727272));
		mainConversorPanel.setBounds(0, 50, 680, 200);
		mainConversorPanel.setLayout(null);
		

		//componentes agregados del panel del convertidor
		mainConversorPanel.add(campoValor);
		mainConversorPanel.add(cajaDivisas1);
		mainConversorPanel.add(textoDivisor);
		mainConversorPanel.add(cajaDivisas2); 
		mainConversorPanel.add(convertirBoton);//TENGO QUE IMPLEMENTAR EL TRY CATCH PARA QUE NO DE ERROR AL EJECUTAR EL BOTON SIN NINGUN VALOR EN LA CAJA DE TEXTO
		mainConversorPanel.add(resultadoPanel);
		
		//*****************************************************************************
		
		convertidorPanel = new JPanel();
		convertidorPanel.setBounds(120, 0, 680, 300);
		convertidorPanel.setBackground(new Color(0x525252));
		convertidorPanel.setLayout(null); // lo coloco en null para que pueda manipular el tamaño del panel interior
		convertidorPanel.setVisible(false);
		
		//Paneles agregados al panel 
		convertidorPanel.add(mainConversorPanel);
		convertidorPanel.add(tituloPanel);
		
		
		//*****************************************************************************
		//*****************************************************************************
		//A PARTIR DE ESTE PUNTO EMPIEZAN LOS PANELES Y DEMAS COMPONENTES DEL CONVERSOR DE DISTANCIAS
		
		
		//Panel para mostrar el resultado aparte
		resultado1 = new JLabel();
		resultado1.setFont(new Font("Century Gothic",Font.PLAIN,25));
		resultado1.setText("" + resultadoConversion1);
		
		resultadoPanel1 = new JPanel();
		resultadoPanel1.setBounds(150, 80, 300, 50);
		resultadoPanel1.setBackground(new Color(0x878787));
		//resultadoPanel.setBorder(null); // Configurar al final
		resultadoPanel1.setLayout(new FlowLayout());
		resultadoPanel1.setVisible(true);
		resultadoPanel1.add(resultado1);
		
		convertirBoton1 = new JButton("convertir");
		convertirBoton1.addActionListener(this);
		convertirBoton1.setFont(new Font("Century Gothic",Font.PLAIN,15));
		convertirBoton1.setBackground(new Color(0x878787));
		convertirBoton1.setBounds(420, 20, 120, 20);
		
		//Lista de medidas de distancia
		String[] medidasDistancias = {"KM","M","CM","MM","P"};
		//Combo Box Medidas2
		cajaMedidas2 = new JComboBox<>(medidasDistancias); 
		cajaMedidas2.addActionListener(this);
		cajaMedidas2.setFont(new Font("Century Gothic",Font.PLAIN,13));
		cajaMedidas2.setBounds(310, 20, 100, 20); 
		 
		
		textoDivisor1 = new JLabel();
		textoDivisor1.setText(" - ");
		textoDivisor1.setBounds(290, 20, 60, 20);
		//Combo Box medidas1
		
		cajaMedidas1 = new JComboBox<>(medidasDistancias); 
		cajaMedidas1.addActionListener(this);
		cajaMedidas1.setFont(new Font("Century Gothic",Font.PLAIN,13));
		cajaMedidas1.setBounds(180, 20, 100, 20); 
		
		campoValor1 = new JTextField();
		campoValor1.setBounds(70, 20, 100, 20); 
		campoValor1.setPreferredSize(new Dimension(50,20));
		campoValor1.setFont(new Font("Century Gothic",Font.PLAIN,11));
		campoValor1.setBackground(new Color(0xffffff));
		
		//Panel principal que contiene los elemetos del conversor de distancias
		panelConversor = new JPanel();
		panelConversor.setBackground(new Color(0x727272));
		panelConversor.setBounds(0, 50, 680, 200);
		panelConversor.setLayout(null);
		
		panelConversor.add(campoValor1);
		panelConversor.add(cajaMedidas1);
		panelConversor.add(textoDivisor1);
		panelConversor.add(cajaMedidas2);
		panelConversor.add(convertirBoton1);
		panelConversor.add(resultadoPanel1);
		
		//Label para colocar el Titulo de la ventana
		tituloLabel = new JLabel();
		tituloLabel.setText("Conversor de distancias");
		tituloLabel.setFont(new Font("Century Gothic",Font.PLAIN,30));
		tituloLabel.setVerticalTextPosition(JLabel.CENTER);
		tituloLabel.setHorizontalTextPosition(JLabel.LEFT);
		tituloLabel.setBounds(150, 3, 400, 40);
		
		//Panel para titulo de la ventana
		tituloPanelDistancias = new JPanel();
		tituloPanelDistancias.setBackground(new Color(0xC4C4C4));
		tituloPanelDistancias.setBounds(0, 0, 680, 50);
		tituloPanelDistancias.setLayout(null);
		tituloPanelDistancias.add(tituloLabel);
		
		//Panel principal del convertidor de distancias 
		distanciasPanel = new JPanel();
		distanciasPanel.setBounds(120, 0, 680, 300);
		distanciasPanel.setBackground(new Color(0x525252));
		distanciasPanel.setLayout(null); // lo coloco en null para que pueda manipular el tamaño del panel interior
		distanciasPanel.setVisible(false);
		//Elementos agregados al panel Principal
		distanciasPanel.add(tituloPanelDistancias);
		distanciasPanel.add(panelConversor);
		
		
		//***********************************************************************************
		//Panel del menu 
		
		
		//BOTON MENU DISTANCIAS  
		botonDistancia = new JButton("Distancias");
		botonDistancia.setFont(new Font("Century Gothic",Font.PLAIN,15));
		botonDistancia.setBackground(new Color(0x727272));
		botonDistancia.setBounds(0,59,120, 30);
		botonDistancia.addActionListener(this);
		
		//BOTON MENU DIVISAS  
		convertidorMenu = new JButton("Divisas");
		convertidorMenu.setFont(new Font("Century Gothic",Font.PLAIN,15));
		convertidorMenu.setBackground(new Color(0x727272));
		convertidorMenu.setBounds(0,30,120, 30);
		convertidorMenu.addActionListener(this);
		
		//Titulo del menu
		menuLabel = new JLabel();
		menuLabel.setText("Conversores");
		menuLabel.setFont(new Font("Century Gothic",Font.PLAIN,15));
		menuLabel.setBounds(15,0,100, 30);
		
		//Panel del menu
		menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 120, 300);
		menuPanel.setBackground(new Color(0x878787));
		menuPanel.setLayout(null);
		
		//Elementos agregados al panel del menu
		menuPanel.add(menuLabel);
		menuPanel.add(convertidorMenu);
		menuPanel.add(botonDistancia);
		
			
		//Frame Configuraciones
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 300);
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		
		//Elementos agregados al frame
		this.add(menuPanel);
		this.add(convertidorPanel);
		this.add(distanciasPanel);
		this.add(mensajePrincipalPanel);
	}
	
	
	public double convertirDistancia(int index1, int index2) {
		
		double medidaActual;
		double medidaCambio;
		double resultado1 = 0;
		
		// {"KM","M","CM","MM","P"};
		if (index1 == 0 && index2 == 1) {
			resultado1 = this.texto1 * 1000;
		}
		else if (index1 == 0 && index2 == 2) {
			resultado1 = this.texto1 * 100000;
		}
		else if (index1 == 0 && index2 == 3) {
			resultado1 = this.texto1 * 1000000;
		}
		else if (index1 == 0 && index2 == 4) {
			resultado1 = this.texto1 * 39370;
		}
		//======================================
		else if (index1 == 1 && index2 == 0) {
			resultado1 = this.texto1 / 1000;
		}
		else if (index1 == 1 && index2 == 2) {
			resultado1 = this.texto1 * 100;
		}
		else if (index1 == 1 && index2 == 3) {
			resultado1 = this.texto1 * 1000;
		}
		else if (index1 == 1 && index2 == 4) {
			resultado1 = this.texto1 * 39.37;
		}
		//======================================
		else if (index1 == 2 && index2 == 0) {
			resultado1 = this.texto1 / 100000;
		}
		else if (index1 == 2 && index2 == 1) {
			resultado1 = this.texto1 / 100;
		}
		else if (index1 == 2 && index2 == 3) {
			resultado1 = this.texto1 * 10;
		}
		else if (index1 == 2 && index2 == 4) {
			resultado1 = this.texto1 / 2.54;
		}
		//====================================
		else if (index1 == 3 && index2 == 0) {
			resultado1 = this.texto1 / 1000000;
		}
		else if (index1 == 3 && index2 == 1) {
			resultado1 = this.texto1 / 1000;
		}
		else if (index1 == 3 && index2 == 2) {
			resultado1 = this.texto1 / 10;
		}
		else if (index1 == 3 && index2 == 4) {
			resultado1 = this.texto1 / 25.4;
		}
		//====================================
		else if (index1 == 4 && index2 == 0) {
			resultado1 = this.texto1 / 39370;
		}
		else if (index1 == 4 && index2 == 1) {
			resultado1 = this.texto1 / 39.37;
		}
		else if (index1 == 4 && index2 == 2) {
			resultado1 = this.texto1 / 2.54;
		}
		else if (index1 == 4 && index2 == 3) {
			resultado1 = this.texto1 * 25.4;
		}
				
		else {
			resultado1 = this.texto1;
		}
		return resultado1;
	}
	
	//METODOS 
	
	//Este metodo se encarga de realizar la conversion y devolver el resultado 
 	public double convertir (int indexDivisa1, int indexDivisa2){
		
		 double divisaCambio; // precio de la divisa a cambiar
		 double divisaActual; // cantidad de la divisa que quiero cambiar
		 double resultado;
		 
		 if (indexDivisa1 == 0 && indexDivisa2 ==1) {
			 divisaCambio = 0.00022; //Dolar precio de cambio
			 divisaActual = this.texto;  //Pesos Colombianos
			 resultado = (divisaActual * divisaCambio)/1; 
		 } 
		 else if (indexDivisa1 == 0 && indexDivisa2 ==2) {
			 divisaCambio = 0.00020; // Euro precio de cambio
			 divisaActual = texto; //Pesos Colombianos
			 resultado = (divisaActual * divisaCambio)/1;
		 } 
		 
		 else if(indexDivisa1 == 0 && indexDivisa2 ==3) {
			 divisaCambio = 0.018; // RUBLO RUSO precio de cambio
			 divisaActual = texto; //Pesos Colombianos
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 0 && indexDivisa2 ==4) {
			 divisaCambio = 0.00018; // lIBRAS ESTERLINAS precio de cambio
			 divisaActual = texto; //Pesos Colombianos
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 0 && indexDivisa2 ==5) {
			 divisaCambio = 0.030; // Yen Japones precio de cambio
			 divisaActual = texto; //Pesos Colombianos
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 0 && indexDivisa2 ==6) {
			 divisaCambio = 0.30; // won koreano precio de cambio
			 divisaActual = texto; //Pesos Colombianos
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 //====================================================
		 else if (indexDivisa1 == 1 && indexDivisa2 ==0) {
			 divisaCambio = 4427.38; //COP precio de cambio
			 divisaActual = texto;  //DOLAR USD
			 resultado = (divisaActual * divisaCambio)/1; 
		 } 
		 else if (indexDivisa1 == 1 && indexDivisa2 ==2) {
			 divisaCambio = 0.91; // Euro precio de cambio
			 divisaActual = texto; //DOLAR USD
			 resultado = (divisaActual * divisaCambio)/1;
		 } 
		 else if (indexDivisa1 == 1 && indexDivisa2 ==3) {
			 divisaCambio = 81.83; // RUBLO precio de cambio
			 divisaActual = texto; //DOLAR USD
			 resultado = (divisaActual * divisaCambio)/1;
		 } 
		 else if (indexDivisa1 == 1 && indexDivisa2 ==4) {
			 divisaCambio = 0.80; // libra  precio de cambio
			 divisaActual = texto; //DOLAR USD 
			 resultado = (divisaActual * divisaCambio)/1;
		 } 
		 else if (indexDivisa1 == 1 && indexDivisa2 ==5) {
			 divisaCambio = 134.07; // Yen Japones precio de cambio
			 divisaActual = texto; //DOLAR USD 
			 resultado = (divisaActual * divisaCambio)/1;
		 } 
		 else if (indexDivisa1 == 1 && indexDivisa2 ==6) {
			 divisaCambio = 1318.86; // WON KOREANO precio de cambio
			 divisaActual = texto; //DOLAR USD 
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		//====================================================
		 else if (indexDivisa1 == 2 && indexDivisa2 ==0) {
			 divisaCambio = 4892.58; // COP precio de cambio
			 divisaActual = texto;  //euro
			 resultado = (divisaActual * divisaCambio)/1; 
		 } 
		 else if (indexDivisa1 == 2 && indexDivisa2 == 1) {
			 divisaCambio = 1.10; // dolar
			 divisaActual = texto; //euro
			 resultado = (divisaActual * divisaCambio)/1;
			 
		 } 
		 else if (indexDivisa1 == 2 && indexDivisa2 == 3) {
			 divisaCambio = 89.73; // RUBLO precio de cambio
			 divisaActual = texto; //euro
			 resultado = (divisaActual * divisaCambio)/1;
		 } 
		 else if (indexDivisa1 == 2 && indexDivisa2 == 4) {
			 divisaCambio = 0.88; // RUBLO precio de cambio
			 divisaActual = texto; //euro
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if (indexDivisa1 == 2 && indexDivisa2 == 5) {
			 divisaCambio = 147.07; // YEN JAPONES precio de cambio
			 divisaActual = texto; //euro
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if (indexDivisa1 == 2 && indexDivisa2 == 6) {
			 divisaCambio = 1446.93; // won koreano precio de cambio
			 divisaActual = texto; //euro
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		//====================================================
		 else if (indexDivisa1 == 3 && indexDivisa2 == 0) {
			 divisaCambio = 54.86; // COP precio de cambio
			 divisaActual = texto; //RUBLO
			 resultado = (divisaActual * divisaCambio)/1; 
		 } 
		 else if (indexDivisa1 == 3 && indexDivisa2 == 1) {
			 divisaCambio = 0.012; // USD precio de cambio
			 divisaActual = texto; //RUBLO
			 resultado = (divisaActual * divisaCambio)/1; 
		 } 
		 else if (indexDivisa1 == 3 && indexDivisa2 == 2) {
			 divisaCambio = 0.011; // EUR precio de cambio
			 divisaActual = texto; //RUBLO
			 resultado = (divisaActual * divisaCambio)/1; 
		 } 
		 else if (indexDivisa1 == 3 && indexDivisa2 == 4) {
			 divisaCambio = 0.0098; // lIBRAS ESTERLINAS precio de cambio
			 divisaActual = texto; //RUBLO
			 resultado = (divisaActual * divisaCambio)/1; 
		 }
		 else if (indexDivisa1 == 3 && indexDivisa2 == 5) {
			 divisaCambio = 1.64; // Yen japones precio de cambio
			 divisaActual = texto; //RUBLO
			 resultado = (divisaActual * divisaCambio)/1; 
		 }
		 else if (indexDivisa1 == 3 && indexDivisa2 == 6) {
			 divisaCambio = 16.12; // won koreano precio de cambio
			 divisaActual = texto; //RUBLO
			 resultado = (divisaActual * divisaCambio)/1; 
		 }
		 //==================================================
		 else if(indexDivisa1 == 4 && indexDivisa2 ==0) {
			 divisaCambio = 5579.58; // Pesos Colombianos precio de cambio
			 divisaActual = texto; //lIBRAS ESTERLINAS
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 4 && indexDivisa2 ==1) {
			 divisaCambio = 1.24; // DOLAR  precio de cambio
			 divisaActual = texto; //lIBRAS ESTERLINAS 
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 4 && indexDivisa2 == 2) {
			 divisaCambio = 1.13; // EURO  precio de cambio
			 divisaActual = texto; //lIBRAS ESTERLINAS 
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 4 && indexDivisa2 == 3) {
			 divisaCambio = 101.73; // EURO  precio de cambio
			 divisaActual = texto; //lIBRAS ESTERLINAS 
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 4 && indexDivisa2 ==5) {
			 divisaCambio = 166.64; // Yen japones  precio de cambio
			 divisaActual = texto; //lIBRAS ESTERLINAS 
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 4 && indexDivisa2 ==6) {
			 divisaCambio = 1639; // WON KOREANO  precio de cambio
			 divisaActual = texto; //lIBRAS ESTERLINAS 
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 //=============================================================
		 else if(indexDivisa1 == 5 && indexDivisa2 ==0) {
			 divisaCambio = 9.84; // Pesos Colombianos precio de cambio
			 divisaActual = texto; //JPY YEN JAPONES
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 5 && indexDivisa2 ==1) {
			 divisaCambio = 0.0075; // USD precio de cambio
			 divisaActual = texto; //JPY YEN JAPONES
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 5 && indexDivisa2 ==2) {
			 divisaCambio = 0.0068; // EURO precio de cambio
			 divisaActual = texto; //JPY YEN JAPONES
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 5 && indexDivisa2 ==3) {
			 divisaCambio = 0.61; // RUBLO precio de cambio
			 divisaActual = texto; //JPY YEN JAPONES
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 5 && indexDivisa2 ==4) {
			 divisaCambio = 0.61; // RUBLO precio de cambio
			 divisaActual = texto; //JPY YEN JAPONES
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 5 && indexDivisa2 ==6) {
			 divisaCambio = 9.83; // RUBLO precio de cambio
			 divisaActual = texto; //JPY YEN JAPONES
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 //==================================================
		 else if(indexDivisa1 == 6 && indexDivisa2 ==0) {
			 divisaCambio = 3.41; // COP precio de cambio
			 divisaActual = texto; //Won koreano 
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 6 && indexDivisa2 ==1) {
			 divisaCambio = 0.00076; // USD precio de cambio
			 divisaActual = texto; //Won koreano 
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 6 && indexDivisa2 ==2) {
			 divisaCambio = 0.00069; // EUR precio de cambio
			 divisaActual = texto; //Won koreano 
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 6 && indexDivisa2 ==3) {
			 divisaCambio = 0.00069; // RUB precio de cambio
			 divisaActual = texto; //Won koreano 
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 6 && indexDivisa2 ==4) {
			 divisaCambio = 0.00061; // libras esterlinas precio de cambio
			 divisaActual = texto; //Won koreano 
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 else if(indexDivisa1 == 6 && indexDivisa2 ==5) {
			 divisaCambio = 0.10; // YEN JAPONES precio de cambio
			 divisaActual = texto; //Won koreano 
			 resultado = (divisaActual * divisaCambio)/1;
		 }
		 
		 else {
			 divisaActual = texto; 
			 resultado = divisaActual;
		 }
		 return resultado;
		}
		
		//String[] divisas = {"COP","USD","EUR","RUB","GBP","JPY","KRW"};
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//ACTIONLISTENER PARA BOTONES DEL MENU 
		//Condicional para que muestre el panel del contenido del conversor
		if(e.getSource()==convertidorMenu) {
			mensajePrincipalPanel.setVisible(false); // panel de mensaje inicial
			convertidorPanel.setVisible(true);
			distanciasPanel.setVisible(false);
		}
		
		
		//ACTIONLISTENER PARA LOS BOTONES DEL CONVERSOR
		// Condicional para obtener el valor ingresado en el campo de texto 
		if (e.getSource()==cajaDivisas1) {
			indexCaja1 = cajaDivisas1.getSelectedIndex();
			System.out.println("index seleccionado opcion 1: " + indexCaja1 + "  " + cajaDivisas1.getSelectedItem());
		}
		
		// Condicional para obtener el valor ingresado en el campo de texto 2
		if (e.getSource()==cajaDivisas2) {
			indexCaja2 = cajaDivisas2.getSelectedIndex();
			System.out.println("index seleccionado opcion 2: " + indexCaja2 + "  " + cajaDivisas2.getSelectedItem());
		}
		
		//EN este condicional se verifican las operaciones al oprimir el boton para convertir 2 divisas
		
		if(e.getSource()==convertirBoton) {
			
			try {		
				texto = Double.parseDouble(campoValor.getText());
				System.out.println(texto);
				resultadoConversion = this.convertir(indexCaja1,indexCaja2);
				System.out.println(this.convertir(indexCaja1,indexCaja2));
				System.out.println(resultadoConversion);
				resultado.setText("" + resultadoConversion);
				
			}catch(NumberFormatException exception) {
				
				//SI EL NUMERO QUE RETORNA ES MUY LARGO TAMBIEN VA A LANZAR UN ERROR PORQUE DOUBLE TIENE UNA CAPACIDAD DE TAMAÑO
				if(campoValor.getText().length()>= 10) {
					resultado.setFont(new Font("Century Gothic",Font.PLAIN,15));
					resultado.setText("Excede el maximo de caracteres");
				}
				else {
					resultado.setFont(new Font("Century Gothic",Font.PLAIN,15));
					System.out.println("Valor ingresado incorrecto. \nPor favor ingrese un valor en numeros");
					resultado.setText("<html>Valor ingresado incorrecto. <p>Por favor ingrese un valor en numeros<html>");
				}
			}	
		}
		//**********************************************************************************
		//A PARTIR DE ACA SE VAN A CREAR LOS EVENTOS PARA EL BOTON Y EN PANEL DEL CONVERSOR DE DISTANCIAS 
		if(e.getSource()==botonDistancia) {
			mensajePrincipalPanel.setVisible(false); // panel de mensaje inicial
			distanciasPanel.setVisible(true);
			convertidorPanel.setVisible(false);
		}
		
		if (e.getSource()==cajaMedidas1) {
			index1 = cajaMedidas1.getSelectedIndex();
			System.out.println("index seleccionado opcion 1: " + index1 + "  " + cajaMedidas1.getSelectedItem());
		}
		
		if (e.getSource()==cajaMedidas2) {
			index2 = cajaMedidas2.getSelectedIndex();
			System.out.println("index seleccionado opcion 2: " + index2 + "  " + cajaMedidas2.getSelectedItem());
		}
		
		if(e.getSource() == convertirBoton1) {
			
			try {
				texto1 = Double.parseDouble(campoValor1.getText());
				System.out.println(texto1);
				resultadoConversion1 = this.convertirDistancia(index1, index2);
				System.out.println(resultadoConversion1);
				resultado1.setText("" + resultadoConversion1);
			}catch(NumberFormatException exception) {
				resultado1.setFont(new Font("Century Gothic",Font.PLAIN,15));
				resultado1.setText("<html>Valor ingresado incorrecto. <p>Por favor ingrese un valor en numeros<html>");
				System.out.println("Valor ingresado incorrecto. Por favor ingrese un valor en numeros");
			}
			
		}
		
	}
}
