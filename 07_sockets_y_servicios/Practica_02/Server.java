package EJERCICIOFINAL;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread {
	//Server
	private ServerSocket socketServidor;
	private ObjectOutputStream streamSalida;
	private String mensajeSalida;
	boolean servidorEstablecido = false;
	Scanner reader = new Scanner(System.in);

	//Cliente
	private Socket socketCliente;
	private ObjectInputStream streamEntrada;
	private String mensajeEntrada;
	private String ipCliente;
	private boolean finalizarEntrada = false;
	
	
	
	private boolean comunicacionEstablecida = false;

	//**********
	//INICIAR COMUNICACION
	//**********
	public Server() {
		int puerto = 5000;
		//Establer server socket
		while (!servidorEstablecido) {
			try {
				socketServidor = new ServerSocket(puerto);
				System.out.println("Servidor establecido");
				System.out.println("Esperando conexion en puerto: " + puerto);
				servidorEstablecido = true;
			} catch (Exception e){e.printStackTrace();}
		}
		
		//Establecer conexion
		while(!comunicacionEstablecida) {
			try {
				
				socketCliente = socketServidor.accept();
				comunicacionEstablecida = true;
				streamSalida = new ObjectOutputStream(socketCliente.getOutputStream());
				streamEntrada = new ObjectInputStream(socketCliente.getInputStream());
				System.out.println("Estableciendo comunicacion con cliente: " + socketCliente.getInetAddress());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



	//**********
	//LECTURA EN BACKGROUND
	//**********
	public void run() {
		try {
			do {
				//lectura
				mensajeEntrada = (String) streamEntrada.readObject();
				if (mensajeEntrada.equals("fin\n")) {
					//Cerrar conexiones
					finalizarEntrada = true;
					comunicacionEstablecida = false;
					streamSalida.close();
					streamEntrada.close();
					socketCliente.close();
					socketServidor.close();
				}
				System.out.print("\nMENSAJE DE CLIENTE: " + mensajeEntrada);
				System.out.print("\nYO SERVIDOR: ");
			} while (!finalizarEntrada);
		} catch (Exception e) {}

	}

	//**********
	//ENVIO DE MENSAJES
	//**********
	public void enviarMensajes() throws Exception {
		try {
			while(comunicacionEstablecida) {
				System.out.print("YO SERVIDOR: ");
				mensajeSalida = reader.nextLine();
				streamSalida.writeObject(((String) mensajeSalida) + "\n");
				streamSalida.flush();
			}
		} catch (Exception e) {}
	}
	
	public static void main(String[] args) {
		//Inica Servidor
		Server miServer = new Server();
		
		//Lectura en background
		miServer.start();
		
		//Envio de mensajes
		try {
			miServer.enviarMensajes();
		} catch (Exception e) {}
	}
}