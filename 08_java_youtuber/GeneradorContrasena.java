import java.security.SecureRandom;

public class GeneradorContrasena {
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";

    public static String generarContrasena(int longitud) {
        SecureRandom random = new SecureRandom();
        StringBuilder contrasena = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(CARACTERES.length());
            contrasena.append(CARACTERES.charAt(index));
        }

        return contrasena.toString();
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Ingrese la longitud de la contraseña deseada: ");
        int longitudContrasena = scanner.nextInt();

        String contrasenaGenerada = generarContrasena(longitudContrasena);
        System.out.println("Contraseña generada: " + contrasenaGenerada);

        scanner.close();
    }
}
