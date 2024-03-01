import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class CifradoSustitucionHomofona {
    public static String cifrarSustitucionHomofona(String texto) {
        Map<Character, String> homofonos = new HashMap<>();
        homofonos.put('a', "42");
        homofonos.put('b', "91");
        homofonos.put('c', "37");
        homofonos.put('d', "13");
        // Añade más homófonos según sea necesario

        StringBuilder textoCifrado = new StringBuilder();

        for (char caracter : texto.toCharArray()) {
            if (homofonos.containsKey(Character.toLowerCase(caracter))) {
                textoCifrado.append(homofonos.get(Character.toLowerCase(caracter)));
                textoCifrado.append(" ");
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

        String palabraCifrada = cifrarSustitucionHomofona(palabra);
        System.out.println("Palabra cifrada: " + palabraCifrada);

        scanner.close();
    }
}
