import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente extends Thread {
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private String mensaje = "";
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

            Thread receiverThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (!fin) {
                            String mensaje = (String) entrada.readObject();
                            System.out.println("SERVIDOR <<< " + mensaje);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            receiverThread.start();

            while (!fin) {
                System.out.println("Introduce mensaje a enviar (escribe 'fin' para terminar): ");
                mensaje = reader.nextLine();
                salida.writeObject(mensaje + "\n");
                salida.flush();
                System.out.println("CLIENTE >>> " + mensaje);
                if (mensaje.equals("fin")) {
                    fin = true;
                }
            }

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
