package EJERCICIOFINAL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class VentanaCliente extends JFrame implements Runnable{
	//Grafico
	private JPanel contentPanel;
	private JTextField etSalida;
	private JTextArea etEntrada;
	
	//Cliente
	private ObjectOutputStream streamSalida;
	private String mensajeSalida;
	private Socket socketCliente;
	
	//Server
	private String hostServer = "localhost";
	private ObjectInputStream streamEntrada;
	private String mensajeEntrada;
	
	//Comunicacion
	boolean comunicacionEstablecida;
	boolean finalizarComunicacion;
	
	
	public VentanaCliente() {
		//ESTABLECER GRAFICO
			//accion vetana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//margenes ventana
		setBounds(100, 100, 450, 300);
			//caja interior
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
			//buton enviar
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(288, 67, 89, 23);
		contentPanel.add(btnEnviar);
			//caja Mensaje Salida
		etSalida = new JTextField();
		etSalida.setBounds(38, 61, 240, 34);
		contentPanel.add(etSalida);
		etSalida.setColumns(10);
			//caja Mensaje Entrada
		etEntrada = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(etEntrada);
		scrollPane.setBounds(38, 135, 348, 94);
		contentPanel.add(scrollPane);
		
		//ESTABLECER COMUNICACION
		while(!comunicacionEstablecida) {
			try {
				socketCliente = new Socket(hostServer, 5000);
				String miServer = socketCliente.getInetAddress().getHostName();
				System.out.println("Comunicacion establecida con: " + miServer);
				streamSalida = new ObjectOutputStream(socketCliente.getOutputStream());
				streamEntrada = new ObjectInputStream(socketCliente.getInputStream());
				comunicacionEstablecida = true;
				finalizarComunicacion = false;
			} catch (Exception e) {e.printStackTrace();}
		}
		
		//ESTABLECER ENVIO
		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					enviarMensajes();
				} catch (Exception ex) {}
			}
		});
		
	}

	//**********
	//LECTURA EN BACKGROUND
	//**********
	public void run() {
		try {
			do {
				mensajeEntrada = (String) streamEntrada.readObject();
				etEntrada.append("\nSERVIDOR: " + mensajeEntrada);
				if(mensajeEntrada.equals("fin\n")) {
					finalizarComunicacion = true;
					comunicacionEstablecida = false;
					streamSalida.close();
					streamEntrada.close();
					socketCliente.close();
				}
			} while (!finalizarComunicacion);
		} catch (Exception e) {}
	}
	
	
	
	public void enviarMensajes() throws Exception{
		String mensajeSalida = etSalida.getText();
		streamSalida.writeObject(mensajeSalida + "\n");
		streamSalida.flush();
		etSalida.setText("");
	}

	
	public static void main(String[] args) throws Exception {
		VentanaCliente frame = new VentanaCliente();
		frame.setVisible(true);
		frame.enviarMensajes();
		new Thread(frame).start();
	}
}