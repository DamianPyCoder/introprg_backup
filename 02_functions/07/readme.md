## PARTE 1  
## Enunciat  

Desenvolupa un programa que demani un text i una posició.  

Si la posició no existeix dins del text, indicarà que està fora de rang.  

Si la posició és negativa, començarà a comptar a partir de l'últim caràcter del text introduït. Per exemple, -1 correspondrà a l'últim caràcter.  

Si tot ha anat bé, el programa indicarà:  

    el caràcter que correspon a la posició demanada  

    la categoria del caràcter:  

        lletra  

        nombre  

        altre: quan no sigui cap dels anteriors  

Ja hem vist les utilitats de caràcters a un exercici anterior. Aquí en farem servir només unes poques.  

java AnalitzaCaracter  
Text?  
Tinc 3 gats!  
Posició?  
3  
'c' és una lletra  

java AnalitzaCaracter  
Text?  
Tinc 3 gats!  
Posició?  
5  
'3' és un nombre  

java AnalitzaCaracter  
Text?  
Tinc 3 gats!  
Posició?  
-1  
'!' és una altra cosa  

java AnalitzaCaracter  
Text?  
Tinc 3 gats!  
Posició?  
-3  
't' és una lletra  

java AnalitzaCaracter  
Text?  
Hola  
Posició?  
4  
Fora de rang  

java AnalitzaCaracter  
Text?  
Hola  
Posició?  
-5  
Fora de rang  


## PARTE 2
## Enunciat

Desenvolupa una nova versió de l'exercici que analitzava un caràcter.  

La nova versió tindrà el mateix comportament que l'original però el codi serà diferent:  

    el mòdul main() se n'encarregarà d'obtenir les dades d'entrada, comprovarà que siguin vàlides, mostrarà els errors corresponents, i n'extraurà el caràcter que finalment s'haurà d'analitzar.  

    Aquest caràcter a analitzar se li passarà al mòdul analitzaCaracter() que serà qui se n'encarregui de realitzar l'anàlisi.  

La signatura del nou mòdul serà:  
public static void analitzaCaracter(char caracter)  

