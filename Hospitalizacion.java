import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hospitalizacion {
    private List<Paciente> pacientesHospitalizados = new ArrayList<>();
    private Map<Integer, Boolean> camasDisponibles = new HashMap<>();


    public Hospitalizacion(int totalCamas) {
        for (int i = 1; i <= totalCamas; i++) {
            camasDisponibles.put(i, true); // Todas las camas empiezan libres
        }
    }

    /**
     * Asigna una cama disponible al paciente.
     * @param paciente Paciente que se hospitaliza.
     * @return true si se asignó una cama, false si no hay camas disponibles.
     */
    public boolean asignarCama(Paciente paciente) {
        // Verificar si el paciente ya tiene una cama asignada (opcional)
        if (paciente.getNumeroCama() != null) {
            System.out.println("El paciente " + paciente.getNombre() + " ya tiene una cama asignada.");
            return false;
        }
        
        for (Map.Entry<Integer, Boolean> entrada : camasDisponibles.entrySet()) {
            if (entrada.getValue()) { // Si la cama está disponible
                paciente.setNumeroCama(entrada.getKey());
                pacientesHospitalizados.add(paciente);
                camasDisponibles.put(entrada.getKey(), false); // Ocupa la cama
                System.out.println("Cama " + entrada.getKey() + " asignada a " + paciente.getNombre());
                return true;
            }
        }
        System.out.println("No hay camas disponibles.");
        return false;
    }

    /**
     * Da de alta al paciente liberando la cama asignada.
     * @param paciente Paciente que se da de alta.
     */
    public void darDeAlta(Paciente paciente) {
        Integer cama = paciente.getNumeroCama();
        if (cama != null) {
            camasDisponibles.put(cama, true); // Libera la cama
            pacientesHospitalizados.remove(paciente);
            paciente.setNumeroCama(null);
            System.out.println("Paciente " + paciente.getNombre() + " dado de alta. Cama " + cama + " ahora está libre.");
        } else {
            System.out.println("El paciente no tenía una cama asignada.");
        }
    }

    /**
     * Muestra el estado actual de las camas (libres/ocupadas).
     */
    public void mostrarEstadoCamas() {
        System.out.println("\nEstado de camas:");
        for (Map.Entry<Integer, Boolean> entrada : camasDisponibles.entrySet()) {
            String estado = entrada.getValue() ? "🟢 Libre" : "🔴 Ocupada";
            System.out.println("Cama " + entrada.getKey() + ": " + estado);
        }
    }

    /**
     * Muestra la lista de pacientes que actualmente se encuentran hospitalizados.
     */
    public void verPacientesHospitalizados() {
        System.out.println("\n--- Pacientes Hospitalizados ---");
        if (pacientesHospitalizados.isEmpty()) {
            System.out.println("No hay pacientes hospitalizados en este momento.");
        } else {
            for (Paciente paciente : pacientesHospitalizados) {
                paciente.mostrarInfo();
                System.out.println("---------------------");
            }
        }
    }
}
