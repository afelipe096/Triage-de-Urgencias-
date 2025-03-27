import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase se encarga de la administración del personal, permitiendo registrar y eliminar médicos y enfermeros.
 */
public class AdministracionPersonal {
    private static List<Medico> medicosRegistrados = new ArrayList<>();
    private static List<Enfermero> enfermerosRegistrados = new ArrayList<>();

    // Método para registrar un nuevo médico
    public static void registrarMedico(Medico medico) {
        medicosRegistrados.add(medico);
    }

    // Método para eliminar un médico existente
    public static void eliminarMedico(Medico medico) {
        medicosRegistrados.remove(medico);
    }

    // Método para actualizar un médico existente
    public static void actualizarMedico(Medico medicoActualizado) {
        for (int i = 0; i < medicosRegistrados.size(); i++) {
            if (medicosRegistrados.get(i).getId() == medicoActualizado.getId()) {
                medicosRegistrados.set(i, medicoActualizado);
                break;
            }
        }
    }

    // Método para registrar un nuevo enfermero
    public static void registrarEnfermero(Enfermero enfermero) {
        enfermerosRegistrados.add(enfermero);
    }

    // Método para eliminar un enfermero existente
    public static void eliminarEnfermero(Enfermero enfermero) {
        enfermerosRegistrados.remove(enfermero);
    }

    // Método para actualizar un enfermero existente
    public static void actualizarEnfermero(Enfermero enfermeroActualizado) {
        for (int i = 0; i < enfermerosRegistrados.size(); i++) {
            if (enfermerosRegistrados.get(i).getId() == enfermeroActualizado.getId()) {
                enfermerosRegistrados.set(i, enfermeroActualizado);
                break;
            }
        }
    }

    // Método para obtener la lista de médicos registrados
    public static List<Medico> getMedicosRegistrados() {
        return medicosRegistrados;
    }

    // Método para obtener la lista de enfermeros registrados
    public static List<Enfermero> getEnfermerosRegistrados() {
        // Verificar si la lista está inicializada
        if (enfermerosRegistrados == null) {
            enfermerosRegistrados = new ArrayList<>();
        }
        return enfermerosRegistrados;
    }
}
