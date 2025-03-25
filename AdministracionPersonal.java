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

    // Método para registrar un nuevo enfermero
    public static void registrarEnfermero(Enfermero enfermero) {
        enfermerosRegistrados.add(enfermero);
    }

    // Método para eliminar un enfermero existente
    public static void eliminarEnfermero(Enfermero enfermero) {
        enfermerosRegistrados.remove(enfermero);
    }

    // Método para obtener la lista de médicos registrados
    public static List<Medico> getMedicosRegistrados() {
        return medicosRegistrados;
    }

    // Método para obtener la lista de enfermeros registrados
    public static List<Enfermero> getEnfermerosRegistrados() {
        return enfermerosRegistrados;
    }
}
