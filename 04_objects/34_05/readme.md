#### Enunciat  

Afegeix el següent procediment al codi de l'ascensor definit a l'exercici anterior:  

_public static void puja(Ascensor ascensor)_  

Aquest procediment incrementarà en un el pis en que es troba l'ascensor que rep.  

Et passo la plantilla amb el main() perquè el prgtest et deixi passar.  

_public class Ascensor {
    // XXX
    public static void puja(Ascensor ascensor) {
        // XXX
    }
    public static void main(String[] args){
        // XXX
        System.out.println("L'ascensor inicialment està a la planta " + ascensor.pis);
        puja(ascensor);
        System.out.println("L'ascensor finalment està a la planta " + ascensor.pis);
    }
}_

En completar el programa anterior, caldrà que l'execució sigui la següent:  

_java Ascensor  
 L'ascensor inicialment està a la planta -1  
 L'ascensor finalment està a la planta 0_  
