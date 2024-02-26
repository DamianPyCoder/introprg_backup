import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente extends Thread {
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private String mensaje = "";
//    private String server = "192.168.16.118";
    private String server = "localhost";
    private Socket cliente;
    private boolean fin = false;
    Scanner reader = new Scanner(System.in);

    public Cliente() throws Exception {
    }

    public void run() {
        try {
            System.out.println("Intentando realizar conexion");
            cliente = new Socket(server, 5000);
            System.out.println("Conectado a: " + cliente.getInetAddress().getHostName());
            salida = new ObjectOutputStream(cliente.getOutputStream());
            entrada = new ObjectInputStream(cliente.getInputStream());

            do {
                System.out.println("Introduce mensaje a enviar: ");
                mensaje = reader.nextLine();
                salida.writeObject(mensaje + "\n");
                salida.flush();
                System.out.println("CLIENTE >>> " + mensaje);
                mensaje = (String) entrada.readObject();
                System.out.println("SERVIDOR <<< " + mensaje);
                if (mensaje.equals("fin\n")) fin = true;
            } while (!fin);
            salida.close();
            entrada.close();
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Cliente cliente = new Cliente();
            cliente.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
