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

    public boolean asignarCama(Paciente paciente) {
        for (Map.Entry<Integer, Boolean> cama : camasDisponibles.entrySet()) {
            if (cama.getValue()) { // Si la cama está disponible
                paciente.setNumeroCama(cama.getKey());
                pacientesHospitalizados.add(paciente);
                camasDisponibles.put(cama.getKey(), false); // Ocupa la cama
                System.out.println("Cama " + cama.getKey() + " asignada a " + paciente.getNombre());
                return true;
            }
        }
        System.out.println(" No hay camas disponibles.");
        return false;
    }

    public void darDeAlta(Paciente paciente) {
        Integer cama = paciente.getNumeroCama();
        if (cama != null) {
            camasDisponibles.put(cama, true); // Libera la cama
            pacientesHospitalizados.remove(paciente);
            paciente.setNumeroCama(null);
            System.out.println(" Paciente " + paciente.getNombre() + " dado de alta. Cama " + cama + " ahora está libre.");
        } else {
            System.out.println(" El paciente no tenía una cama asignada.");
        }
    }

    public void mostrarEstadoCamas() {
        System.out.println("\n Estado de camas:");
        for (Map.Entry<Integer, Boolean> cama : camasDisponibles.entrySet()) {
            String estado = cama.getValue() ? "🟢 Libre" : "🔴 Ocupada";
            System.out.println("Cama " + cama.getKey() + ": " + estado);
        }
    }

    // Método para mostrar la lista de pacientes hospitalizados
    public void verPacientesHospitalizados() {
        System.out.println("\n--- Pacientes Hospitalizados ---");
        for (Paciente paciente : pacientesHospitalizados) {
            paciente.mostrarInfo();
        }
    }
}
