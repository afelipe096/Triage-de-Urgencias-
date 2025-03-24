import java.util.ArrayList;
import java.util.List;

public class AdministracionPersonal {
    private static List<Medico> medicosRegistrados = new ArrayList<>();
    private static List<Enfermero> enfermerosRegistrados = new ArrayList<>();

    // Métodos para registrar y eliminar médicos
    public static void registrarMedico(Medico medico) {
        medicosRegistrados.add(medico);
    }

    public static void eliminarMedico(Medico medico) {
        medicosRegistrados.remove(medico);
    }

    // Métodos para registrar y eliminar enfermeros
    public static void registrarEnfermero(Enfermero enfermero) {
        enfermerosRegistrados.add(enfermero);
    }

    public static void eliminarEnfermero(Enfermero enfermero) {
        enfermerosRegistrados.remove(enfermero);
    }

    // Métodos para obtener listas de médicos y enfermeros registrados
    public static List<Medico> getMedicosRegistrados() {
        return medicosRegistrados;
    }

    public static List<Enfermero> getEnfermerosRegistrados() {
        return enfermerosRegistrados;
    }
}
