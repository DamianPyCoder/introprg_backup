public class Quadrats {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Quadrat <costat> <caracter>");
            return;
        }
        
        int costat = Integer.parseInt(args[0]);
        char caracter = args[1].charAt(0);
        
        if (costat < 1) {
            System.out.println("No es pot dibuixar cap quadrat.");
            return;
        }
        
        dibuixaQuadrat(costat, caracter);
    }
    
    public static void dibuixaQuadrat(int costat, char caracter) {
        for (int i = 0; i < costat; i++) {
            dibuixaLinia(costat, caracter);
            System.out.println();
        }
    }
    
    public static void dibuixaLinia(int costat, char caracter) {
        for (int i = 0; i < costat; i++) {
            System.out.print(" " + caracter);
        }
    }
}
