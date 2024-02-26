import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private ServerSocket servidor;
    private Socket cliente;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private BufferedReader consoleReader;
    private boolean fin;

    public Server() throws IOException {
        int puerto = 5000;
        servidor = new ServerSocket(puerto);
        fin = false;
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Servidor establecido");
        System.out.println("Esperando conexion en puerto: " + puerto);
    }

    public void run() {
        try {
            cliente = servidor.accept();
            System.out.println("Conexion aceptada de: " + cliente.getInetAddress());
            salida = new ObjectOutputStream(cliente.getOutputStream());
            entrada = new ObjectInputStream(cliente.getInputStream());

            Thread consoleInputThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (!fin) {
                            String mensajeConsola = consoleReader.readLine();
                            if (mensajeConsola != null && !mensajeConsola.isEmpty()) {
                                salida.writeObject(mensajeConsola + "\n");
                                salida.flush();
                                System.out.println("SERVIDOR <<< " + mensajeConsola);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            consoleInputThread.start();

            do {
                String mensaje = (String) entrada.readObject();
                if (mensaje.equals("fin\n")) {
                    fin = true;
                }
                System.out.println("CLIENTE >>> " + mensaje);
            } while (!fin);

            entrada.close();
            salida.close();
            cliente.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Server miServer = new Server();
            miServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
