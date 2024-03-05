public class Ascensor {
    int pis;

    public static void puja(Ascensor ascensor) {
        ascensor.pis ++;
    }

    public static void main(String[] args){
        
        Ascensor ascensor;           // declaremos el ascensor
        ascensor = new Ascensor();   // creamos la instància.
        ascensor.pis=1;             // asignamos un valor a "pis" de la clase Ascensor

        System.out.println("L'ascensor inicialment està a la planta " + ascensor.pis);
        puja(ascensor);
        System.out.println("L'ascensor finalment està a la planta " + ascensor.pis);
    }
}