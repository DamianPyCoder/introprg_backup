import java.util.Scanner;

public class AnalitzaCaracter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Obtener el texto de entrada
        System.out.println("Text?");
        String text = scanner.nextLine();
        
        // Verificar si el texto está vacío
        if (text.isEmpty()) {
            System.out.println("Error: Text buit.");
            return;
        }
        
        // Obtener la posición de entrada
        System.out.println("Posició?");
        int posicio = scanner.nextInt();
        
        // Verificar si la posición está dentro del rango
        if (posicio < -text.length() || posicio >= text.length()) {
            System.out.println("Error: Posició fora de rang.");
            return;
        }
        
        // Obtener el carácter correspondiente a la posición
        char caracter;
        if (posicio < 0) {
            // Si la posición es negativa, contar desde el final del texto
            caracter = text.charAt(text.length() + posicio);
        } else {
            caracter = text.charAt(posicio);
        }
        
        // Llamar al módulo analitzaCaracter para analizar el carácter
        analitzaCaracter(caracter);
        
        scanner.close();
    }
    
    public static void analitzaCaracter(char caracter) {
        // Determinar la categoría del carácter
        String categoria;
        if (Character.isLetter(caracter)) {
            categoria = "lletra";
        } else if (Character.isDigit(caracter)) {
            categoria = "nombre";
        } else {
            categoria = "altra cosa";
        }
        
        // Imprimir el carácter y su categoría
        System.out.println("'" + caracter + "' és una " + categoria);
    }
}
