import java.util.Scanner;

public class Quadrats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Quants?");
        int numQuadrats = scanner.nextInt();
        
        // Verificar si el número es válido (mayor que 0)
        if (numQuadrats <= 0) {
            System.out.println("No es pot dibuixar cap quadrat.");
        } else {
            // Dibujar los cuadrados
            for (int i = 0; i < numQuadrats; i++) {
                dibujarQuadrat();
                // Imprimir una línea en blanco después de cada cuadrado
                System.out.println();
            }
        }
        
        scanner.close();
    }
    
    // Método para dibujar un cuadrado
    public static void dibujarQuadrat() {
        int costat = 5; // Longitud del lado del cuadrado
        
        for (int i = 0; i < costat; i++) {
            for (int j = 0; j < costat; j++) {
                System.out.print(" X");
            }
            System.out.println();
        }
    }
}

