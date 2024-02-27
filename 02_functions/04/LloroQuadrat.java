import java.util.Scanner;

public class LloroQuadrat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String paraula;
        
        System.out.println("El lloro espera paraula:");
        paraula = scanner.nextLine();
        
        while (!paraula.isEmpty()) {
            if (paraula.equalsIgnoreCase("adeu") || paraula.equalsIgnoreCase("adéu")) {
                System.out.println("Adéu");
                return; // Salir del programa
            } else if (paraula.equalsIgnoreCase("dibuixa quadrat")) {
                dibuixaQuadrat();
            } else if (paraula.equalsIgnoreCase("dibuixa rectangle")) {
                dibuixaRectangle();
            } else {
                System.out.println("El lloro repeteix: " + paraula);
            }
            
            System.out.println("El lloro espera paraula:");
            paraula = scanner.nextLine();
        }
        
        scanner.close();
    }
    
    public static void dibuixaQuadrat() {
        int costat = 5;
        for (int i = 0; i < costat; i++) {
            for (int j = 0; j < costat; j++) {
                System.out.print(" X");
            }
            System.out.println();
        }
    }
    
    public static void dibuixaRectangle() {
        int costat = 5;
        int longitud = 10;
        for (int i = 0; i < costat; i++) {
            for (int j = 0; j < longitud; j++) {
                System.out.print(" X");
            }
            System.out.println();
        }
    }
}
