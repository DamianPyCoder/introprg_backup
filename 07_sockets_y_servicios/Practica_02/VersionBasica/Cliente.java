import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cliente extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private PrintWriter salida;
    private BufferedReader entrada;
    private JTextField campoTexto;
    private JTextArea areaTexto;
    
    public Cliente() {
        super("Cliente");
        
        campoTexto = new JTextField();
        campoTexto.setEditable(true);
        campoTexto.addActionListener(this);
        add(campoTexto, BorderLayout.NORTH);
        
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        
        setSize(300, 150);
        setVisible(true);
    }
    
    public void ejecutarCliente() {
        try {
            Socket cliente = new Socket("localhost", 12345); // Conexión al servidor
            
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            salida = new PrintWriter(cliente.getOutputStream(), true);
            
            while (true) {
                String mensajeEntrante = entrada.readLine();
                areaTexto.append("Servidor: " + mensajeEntrante + "\n");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent evento) {
        String mensaje = evento.getActionCommand();
        salida.println(mensaje);
        campoTexto.setText("");
    }
    
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cliente.ejecutarCliente();
    }
}
