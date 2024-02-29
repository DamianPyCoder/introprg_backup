import java.util.Scanner;

public class CifradoCesar {
    public static String cifrarCesar(String texto, int desplazamiento) {
        StringBuilder textoCifrado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            if (Character.isLetter(caracter)) {
                char base = Character.isLowerCase(caracter) ? 'a' : 'A';
                char cifrado = (char) (((caracter - base + desplazamiento) % 26) + base);
                textoCifrado.append(cifrado);
            } else {
                textoCifrado.append(caracter);
            }
        }

        return textoCifrado.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una palabra: ");
        String palabra = scanner.nextLine();

        System.out.print("Introduce el número de desplazamiento: ");
        int desplazamiento = scanner.nextInt();

        String palabraCifrada = cifrarCesar(palabra, desplazamiento);
        System.out.println("Palabra cifrada: " + palabraCifrada);

        scanner.close();
    }
}
