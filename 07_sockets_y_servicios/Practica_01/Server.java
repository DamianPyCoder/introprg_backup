import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread {
    private ServerSocket servidor;
    private Scanner scanner;

    public Server() throws IOException {
        int puerto = 5000;
        servidor = new ServerSocket(puerto);
        scanner = new Scanner(System.in);
        System.out.println("Servidor establecido");
        System.out.println("Esperando conexiones en puerto: " + puerto);
    }

    public static void main(String[] args) {
        try {
            Server miServer = new Server();
            miServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Socket cliente = servidor.accept();
            System.out.println("Conexion aceptada de: " + cliente.getInetAddress());
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

            String mensaje;
            do {
                // Permitir al servidor escribir un mensaje después de que el cliente ha enviado uno
                //System.out.print("Escriba un mensaje para el cliente: ");
                String mensajeServidor = scanner.nextLine();
                salida.writeObject(mensajeServidor);
                salida.flush();
                System.out.println("SERVIDOR >>> " + mensajeServidor);

                // Leer y enviar el mensaje del servidor al cliente
                mensaje = (String) entrada.readObject();
                System.out.println("CLIENTE <<< " + mensaje);
            } while (!mensaje.equals("fin"));

            entrada.close();
            salida.close();
            cliente.close();
            servidor.close();
            scanner.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
