import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Cliente extends JFrame {
    private JPanel contentPane;
    private JTextField txtenviar;
    private JTextArea txtrecibir;
    private DataOutputStream salida;

    public static void main(String[] args) throws Exception{
        Cliente frame = new Cliente();
        frame.setVisible(true);
        frame.iniciar();
    }

    public void enviar_datos() throws IOException{
        String mensaje = txtenviar.getText();
        salida.writeUTF(mensaje + "\n");
        salida.flush();
        txtenviar.setText("");
    }

    public Cliente() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JButton btnNewButton = new JButton("Enviar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try { enviar_datos(); } catch (IOException ex) { ex.printStackTrace(); }
            }
        });
        btnNewButton.setBounds(288, 67, 89, 23);
        contentPane.add(btnNewButton);
        txtenviar = new JTextField();
        txtenviar.setBounds(38, 61, 240, 34);
        contentPane.add(txtenviar);
        txtenviar.setColumns(10);
        txtrecibir = new JTextArea();
        JScrollPane sp = new JScrollPane(txtrecibir);
        sp.setBounds(38, 135, 348, 94);
        contentPane.add(sp);
    }

    public void iniciar() throws Exception {
        boolean fin = false;
        txtrecibir.setText("Intentando realizar conexión");
        Socket cliente = new Socket("localhost", 5002);
        txtrecibir.setText("Conectado a: " + cliente.getInetAddress().getHostName() + "\n");
        this.salida = new DataOutputStream(cliente.getOutputStream());
        DataInputStream entrada = new DataInputStream(cliente.getInputStream());
        do {
            String mensaje = entrada.readUTF();
            txtrecibir.append("SERVIDOR <<< " + mensaje + "\n");
            if (mensaje.equals("fin\n"))
                fin = true;
        } while (!fin);
        salida.close();
        entrada.close();
    }
}
