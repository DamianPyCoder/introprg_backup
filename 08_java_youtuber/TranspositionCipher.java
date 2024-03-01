import java.util.Scanner;

public class TranspositionCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el mensaje a cifrar: ");
        String mensajeOriginal = scanner.nextLine();

        System.out.print("Introduce el tamaño de la matriz: ");
        int tamanoMatriz = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer el entero

        // Cifrado
        String mensajeCifrado = cifrar(mensajeOriginal, tamanoMatriz);
        System.out.println("Mensaje cifrado: " + mensajeCifrado);

        // Descifrado
        String mensajeDescifrado = descifrar(mensajeCifrado, tamanoMatriz);
        System.out.println("Mensaje descifrado: " + mensajeDescifrado);

        scanner.close();
    }

    public static String cifrar(String mensaje, int tamanoMatriz) {
        // Asegurarse de que la longitud del mensaje sea múltiplo del tamaño de la matriz
        while (mensaje.length() % tamanoMatriz != 0) {
            mensaje += " ";
        }

        // Crear matriz para cifrar
        char[][] matriz = new char[tamanoMatriz][mensaje.length() / tamanoMatriz];

        // Llenar la matriz con el mensaje
        int index = 0;
        for (int i = 0; i < tamanoMatriz; i++) {
            for (int j = 0; j < mensaje.length() / tamanoMatriz; j++) {
                matriz[i][j] = mensaje.charAt(index++);
            }
        }

        // Leer la matriz en orden específico para cifrar
        StringBuilder resultado = new StringBuilder();
        for (int j = 0; j < mensaje.length() / tamanoMatriz; j++) {
            for (int i = 0; i < tamanoMatriz; i++) {
                resultado.append(matriz[i][j]);
            }
        }

        return resultado.toString();
    }

    public static String descifrar(String mensajeCifrado, int tamanoMatriz) {
        // Crear matriz para descifrar
        char[][] matriz = new char[tamanoMatriz][mensajeCifrado.length() / tamanoMatriz];

        // Llenar la matriz con el mensaje cifrado
        int index = 0;
        for (int j = 0; j < mensajeCifrado.length() / tamanoMatriz; j++) {
            for (int i = 0; i < tamanoMatriz; i++) {
                matriz[i][j] = mensajeCifrado.charAt(index++);
            }
        }

        // Leer la matriz en orden específico para descifrar
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < tamanoMatriz; i++) {
            for (int j = 0; j < mensajeCifrado.length() / tamanoMatriz; j++) {
                resultado.append(matriz[i][j]);
            }
        }

        return resultado.toString().trim(); // Eliminar espacios adicionales añadidos durante el cifrado
    }
}
