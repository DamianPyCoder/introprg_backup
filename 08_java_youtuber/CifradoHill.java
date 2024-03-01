import java.util.Scanner;

public class CifradoHill {
    public static String cifrarHill(String texto, int[][] clave) {
        int longitudBloque = clave.length;
        StringBuilder textoCifrado = new StringBuilder();

        for (int i = 0; i < texto.length(); i += longitudBloque) {
            String bloque = texto.substring(i, Math.min(i + longitudBloque, texto.length()));
            int[] vector = new int[longitudBloque];

            for (int j = 0; j < bloque.length(); j++) {
                vector[j] = bloque.charAt(j) - 'a';
            }

            for (int k = 0; k < longitudBloque; k++) {
                int suma = 0;
                for (int l = 0; l < longitudBloque; l++) {
                    suma += clave[k][l] * vector[l];
                }
                textoCifrado.append((char) ((suma % 26) + 'a'));
            }
        }

        return textoCifrado.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una palabra: ");
        String palabra = scanner.nextLine();

        int[][] clave = {{1, 2}, {3, 4}}; // Ejemplo de una matriz de clave 2x2
        String palabraCifrada = cifrarHill(palabra, clave);
        System.out.println("Palabra cifrada: " + palabraCifrada);

        scanner.close();
    }
}
