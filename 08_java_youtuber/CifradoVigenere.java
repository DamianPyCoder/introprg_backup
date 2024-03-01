import java.util.Scanner;

public class CifradoVigenere {
    public static String cifrarVigenere(String texto, String clave) {
        StringBuilder textoCifrado = new StringBuilder();
        int longitudClave = clave.length();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            int desplazamiento = clave.charAt(i % longitudClave) - 'a';

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

        System.out.print("Introduce la clave: ");
        String clave = scanner.nextLine();

        String palabraCifrada = cifrarVigenere(palabra, clave);
        System.out.println("Palabra cifrada: " + palabraCifrada);

        scanner.close();
    }
}
