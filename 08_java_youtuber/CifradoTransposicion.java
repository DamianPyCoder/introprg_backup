import java.util.Scanner;

public class CifradoTransposicion {
    public static String cifrarTransposicion(String texto) {
        StringBuilder textoCifrado = new StringBuilder();

        for (int i = texto.length() - 1; i >= 0; i--) {
            textoCifrado.append(texto.charAt(i));
        }

        return textoCifrado.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una palabra: ");
        String palabra = scanner.nextLine();

        String palabraCifrada = cifrarTransposicion(palabra);
        System.out.println("Palabra cifrada: " + palabraCifrada);

        scanner.close();
    }
}
