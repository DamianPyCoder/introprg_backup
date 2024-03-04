public class Ascensor {

    int pis;                

    public static void main(String[] args) {

        Ascensor ascensor;           // declaremos el ascensor

        ascensor = new Ascensor();   // creamos la instància.
        ascensor.pis=-1;             // asignamos un valor a "pis" de la clase Ascensor

        System.out.println("L'ascensor està a la planta " + ascensor.pis);

    }

}