#### Enunciat

Fins ara disposem de la classe GatRenat amb la següent definició:
´´´
public class GatRenat {

    int vides = 7;         // vides disponibles del gat Renat

}
´´´
En aquesta ocasió afegirem al nostre gat Renat la possibilitat d'indicar en quina posició es troba. En concret, podrà estar dret, assegut o estirat.

Modifica la definició de la seva classe perquè pugui guardar aquesta informació, fent que inicialment el gat estigui estirat.

La informació de l'estat la guardarem en una propietat amb el nom posicio que serà de tipus String.

Considera la següent plantilla:

 /* XXX */

 public class UsaGatRenat {

     public static void main(String[] args) {

         /* XXX */

         System.out.println("Vides inicials: " + renat.vides);

         System.out.println("Posició inicial: " + renat.XXX);

         /* XXX *?

         System.out.println("Posició final: " + renat.XXX);

     }

 }

L'execució hauria de ser:

java UsaGatRenat
Vides inicials: 7
Posició inicial: estirat
Posició final: assegut
