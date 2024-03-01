import java.util.Scanner;

public class CifradoPlayfair {
    public static String cifrarPlayfair(String texto, String clave) {
        // Implementación del cifrado de Playfair aquí
        return texto;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una palabra: ");
        String palabra = scanner.nextLine();

        System.out.print("Introduce la clave: ");
        String clave = scanner.nextLine();

        String palabraCifrada = cifrarPlayfair(palabra, clave);
        System.out.println("Palabra cifrada: " + palabraCifrada);

        scanner.close();
    }
}
