public class Ascensor {
    public int pis;

    public static Ascensor[] creaAscensorsEnEscala(int quants) {
        Ascensor[] ascensors = new Ascensor[quants]; // Crear un array de ascensores con la longitud especificada
        for (int i = 0; i < quants; i++) {
            ascensors[i] = new Ascensor(); // Crear una instancia de Ascensor para cada posición del array
            ascensors[i].pis = i; // Asignar el piso correspondiente a la posición del ascensor en el array
        }
        return ascensors;
    }

    public static void main(String[] args) {
        int quants;
        if (args.length == 1) {
            try {
                quants = Integer.parseInt(args[0]); // Intentar convertir el argumento de línea de comandos a un número entero
            } catch (NumberFormatException e) {
                System.out.println("Cap ascensor"); // Mostrar mensaje si el argumento no es un número
                return;
            }
        } else {
            quants = 0; // Si no se pasa un solo argumento, asumir quants = 0
        }

        Ascensor[] ascensors = creaAscensorsEnEscala(quants);

        if (quants == 0) {
            System.out.println("Cap ascensor");
        } else {
            for (int i = 0; i < ascensors.length; i++) {
                System.out.printf("Ascensor %d al pis %d%n", i, ascensors[i].pis);
            }
        }
    }
}
  