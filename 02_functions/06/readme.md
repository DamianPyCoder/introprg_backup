## Farem ara una nova versió del quadrat parametritzat. En aquesta ocasió, el programa serà capaç de mostrar un caràcter diferent de X a partir del que main() rebi a args[1]

Per simplificar, pressuposarem també que sempre ens donen aquest segon argument i que ens quedarem amb el primer caràcter.

Una execució d'aquest programa podria ser:

java Quadrat 5 Y
 Y Y Y Y Y
 Y Y Y Y Y
 Y Y Y Y Y
 Y Y Y Y Y
 Y Y Y Y Y

En cas que el valor del primer argument sigui menor de 1, el programa no mostrarà res.

La nova signatura dels mòduls ara presenta els dos paràmetres:

public static void dibuixaQuadrat(int costat, char caracter)
public static void dibuixaLinia(int costat, char caracter)


