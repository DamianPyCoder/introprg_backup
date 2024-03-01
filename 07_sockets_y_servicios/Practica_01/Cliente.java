import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente extends Thread {
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private String mensaje;
    private String server = "localhost"; // Cambiar esta dirección IP por la del servidor
    private Socket cliente;

    public Cliente() throws IOException {
        System.out.println("Intentando realizar conexion");
        cliente = new Socket(server, 5000);
        System.out.println("Conectado a: " + cliente.getInetAddress().getHostName());
        salida = new ObjectOutputStream(cliente.getOutputStream());
        entrada = new ObjectInputStream(cliente.getInputStream());
    }

    public static void main(String[] args) {
        try {
            Cliente miCliente = new Cliente();
            miCliente.start(); // Iniciar el cliente
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                // Leer y mostrar el mensaje del servidor
                mensaje = (String) entrada.readObject();
                System.out.println("SERVIDOR <<< " + mensaje);

                //System.out.println("Introduce mensaje a enviar (o 'fin' para terminar): ");
                mensaje = scanner.nextLine();
                salida.writeObject(mensaje);
                salida.flush();
                System.out.println("CLIENTE >>> " + mensaje);
            } while (!mensaje.equals("fin"));

            scanner.close();
            salida.close();
            entrada.close();
            cliente.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
