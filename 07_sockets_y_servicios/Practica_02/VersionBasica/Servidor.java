import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Puerto de escucha
        
        System.out.println("Esperando conexiones...");
        Socket clienteSocket = serverSocket.accept(); // Espera a que el cliente se conecte
        
        System.out.println("Cliente conectado desde: " + clienteSocket.getInetAddress());
        
        BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
        PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);
        
        String mensajeEntrante, mensajeSaliente;
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            mensajeEntrante = entrada.readLine();
            System.out.println("Cliente: " + mensajeEntrante);
            
            if (mensajeEntrante.equals("fin")) // Para salir del bucle
                break;
            
            System.out.print("Tu: ");
            mensajeSaliente = teclado.readLine();
            salida.println(mensajeSaliente);
        }
        
        serverSocket.close();
        clienteSocket.close();
    }
}
