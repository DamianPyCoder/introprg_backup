import java.util.Scanner;

public class Quadrats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar al usuario que ingrese un número
        System.out.println("Quants?");
        int numQuadrats = scanner.nextInt();
        
        // Verificar si el número es válido (mayor que 0)
        if (numQuadrats <= 0) {
            System.out.println("No es pot dibuixar cap quadrat.");
        } else {
            // Dibujar los cuadrados
            for (int i = 0; i < numQuadrats; i++) {
                dibuixaQuadrat();
                // Imprimir una línea en blanco después de cada cuadrado
                System.out.println();
            }
        }
        
        scanner.close();
    }
    
    // Método para dibujar un cuadrado
    public static void dibuixaQuadrat() {
        int costat = 5; // Longitud del lado del cuadrado
        
        for (int i = 0; i < costat; i++) {
            dibuixaLinia(costat);
            System.out.println();
        }
    }
    
    // Método para dibujar una línea del cuadrado
    public static void dibuixaLinia(int longitud) {
        for (int i = 0; i < longitud; i++) {
            System.out.print(" X");
        }
    }
}
