import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server extends Thread {
	//Server
	private ServerSocket socketServidor;
	private int puerto = 5000;
	private String mensajeSalida;
	boolean servidorEstablecido = false;

	//Clientes
	public static ArrayList<ObjectOutputStream> streamSalidasClientes = new ArrayList<ObjectOutputStream>();
	private String mensajeEntrada;
	
	
	
	//private boolean comunicacionEstablecida = false;

	//****************************
	//INICIAR COMUNICACION
	//****************************
	public Server() {
		//Establer server socket
		while (!servidorEstablecido) {
			try {
				socketServidor = new ServerSocket(puerto);
				System.out.println("Servidor establecido en puerto: " + puerto);
				servidorEstablecido = true;
			} catch (Exception e){e.printStackTrace();}
		}
	}
	
	public void buscarConexionesYreenviar() {
	//Establecer conexiones
		while(true) { //!conexionEstablecida
			try {
				Socket socketCliente = socketServidor.accept();
				System.out.println("Nevo cliente con IP: " + socketCliente.getInetAddress());
				ObjectOutputStream streamSalida = new ObjectOutputStream(socketCliente.getOutputStream());
				streamSalidasClientes.add(streamSalida);
				ObjectInputStream streamEntrada = new ObjectInputStream(socketCliente.getInputStream());
				Thread enviarMensaje = new EnviarMensajesThread(streamEntrada);
				enviarMensaje.start();
				System.out.println("Mensaje captado. Reenviandolo a " + streamSalidasClientes.size() + " clientes");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		//Inica Servidor
		Server miServer = new Server();
		try {miServer.buscarConexionesYreenviar();} catch(Exception e) {}
	}
	
	//****************************
	//LECTURA Y REENVIO
	//****************************
	public class EnviarMensajesThread extends Thread {
		private ObjectInputStream streamEntrada;
		public EnviarMensajesThread(ObjectInputStream streamEntrada) {
			this.streamEntrada = streamEntrada;
		}
		
		public void run() {
			//lectura y escritura
			System.out.print("reenviando");
			try{
				while(true) {
					String mensajeEntrada = (String) this.streamEntrada.readObject();
					System.out.println(mensajeEntrada);
					for(ObjectOutputStream streamSalida : Server.streamSalidasClientes) {
						streamSalida.writeObject(mensajeEntrada + "\n");
						streamSalida.flush();
					}
				}
			} catch (Exception e){
				e.printStackTrace();
			};
		}
	}
	
	
}
