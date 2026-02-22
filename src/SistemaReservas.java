import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

public class SistemaReservas {           //DE AQUI
    private Queue<Integer> asientosDisponibles;
    private Queue<String> salaEspera;
    private Set<Integer> asientosOcupados;

    public SistemaReservas(int N) {
        asientosDisponibles = new LinkedList<>();   //CONSTRUCTOR
        salaEspera = new LinkedList<>();
        asientosOcupados = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            asientosDisponibles.add(i);
        }
    }   //HASTA AQUI

    public String reservarAsiento(String nombre) {      //DE AQUI

        if (!asientosDisponibles.isEmpty()) {
            int asiento = asientosDisponibles.poll();
            asientosOcupados.add(asiento);
            return "Asiento " + asiento + " asignado a " + nombre;
        } else {
            salaEspera.add(nombre);
            return nombre + " agregado a sala de espera.";
        }
    }
                                                              //HASTA AQUI

    public String cancelarAsiento(int numeroAsiento) {    //DE AQUI

        if (!asientosOcupados.contains(numeroAsiento)) {
            return "Error: El asiento " + numeroAsiento + " no está ocupado.";
        }


        asientosOcupados.remove(numeroAsiento);

        if (!salaEspera.isEmpty()) {

            String persona = salaEspera.poll();
            asientosOcupados.add(numeroAsiento);

            return "Asiento " + numeroAsiento +
                    " reasignado a " + persona + " desde sala de espera.";

        } else {

            asientosDisponibles.add(numeroAsiento);

            return "Asiento " + numeroAsiento + " disponible nuevamente.";
        }
    }
                                              // HASTA AQUI

    public String verEstadoSistema() {

        return "\n--- ESTADO DEL SISTEMA ---\n" +
                "Asientos disponibles: " + asientosDisponibles + "\n" +
                "Asientos ocupados: " + asientosOcupados + "\n" +
                "Sala de espera: " + salaEspera + "\n";
    }

}