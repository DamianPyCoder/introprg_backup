Desenvolupa una nova versió de Ascensor  
En aquesta ocasió disposarà d'una funció anomenada creaAscensorsEnEscala() que rebrà un nombre d'ascensors i retornarà un array amb el nombre d'ascensors especificat de manera que cada ascensor estarà en el pis indicat per la seva posició a l'array.  
El main() decidirà a partir del valor que rebi en el primer argument de línia de comandes, quants ascensors crea, cridarà a creaAscensorsEnEscala() i mostrarà els pisos de tots els ascensors creats.  
Completa aquesta plantilla:  

/* XXX */  
public class Ascensor {  
    /* XXX */  
    public static Ascensor[] creaAscensorsEnEscala(int quants) {  
        /* XXX */  
    }  
    public static void main(String[] args){  
        /* XXX */  
        Ascensor[] ascensors = creaAscensorsEnEscala(quants);  
        for (int i = 0; i < ascensors.length; i++) {  
            System.out.printf("Ascensor %d al pis %d%n", i, ascensors[i].pis);  
        }  
    }  
}  
  
Un exemple de sortida serà:  
  
java Ascensor 3  
Ascensor 0 al pis 0  
Ascensor 1 al pis 1  
Ascensor 2 al pis 2  
  
En cas que no se li passi un únic úargument enter, es considerarà que se li ha passat el valor 0, i es mostrarà el missatge Cap ascensor com mostra la següent execució.  

java Ascensor 15 són 15  
Cap ascensor  
