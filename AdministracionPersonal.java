import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona la administración de médicos y enfermeros.
 * Proporciona métodos para registrar, actualizar, eliminar y buscar personal.
 */
class AdministracionPersonal {
    // Listas estáticas para almacenar médicos y enfermeros registrados
    private static List<Medico> medicos = new ArrayList<>();
    private static List<Enfermero> enfermeros = new ArrayList<>();

    // Bloque estático para inicializar las listas con datos predeterminados
    static {
        medicos.addAll(DatosPredeterminados.cargarMedicos());
        enfermeros.addAll(DatosPredeterminados.crearEnfermeros());
    }

    // MÉTODOS PARA MÉDICOS

    /**
     * Devuelve la lista de médicos registrados.
     * @return Lista de médicos.
     */
    public static List<Medico> getMedicos() {
        return medicos;
    }

    /**
     * Registra un nuevo médico en la lista.
     * @param medico Médico a registrar.
     */
    public static void registrarMedico(Medico medico) {
        medicos.add(medico);
    }

    public static void actualizarMedico(Medico medicoActualizado) {
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getId() == medicoActualizado.getId()) {
                medicos.set(i, medicoActualizado); // Reemplaza el médico existente
                break;
            }
        }
    }

    /**
     * Elimina un médico de la lista.
     * @param medico Médico a eliminar.
     */
    public static void eliminarMedico(Medico medico) {
        medicos.remove(medico);
    }

    /**
     * Busca un médico por su ID.
     * @param id ID del médico a buscar.
     * @return Médico encontrado o null si no existe.
     */
    public static Medico buscarMedicoPorId(int id) {
        for (Medico m : medicos) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    // MÉTODOS PARA ENFERMEROS

    /**
     * Devuelve la lista de enfermeros registrados.
     * @return Lista de enfermeros.
     */
    public static List<Enfermero> getEnfermeros() {
        return enfermeros;
    }

    /**
     * Agrega este método si tu código llama a getEnfermerosRegistrados().
     * De lo contrario, puedes usar directamente getEnfermeros().
     */
    public static List<Enfermero> getEnfermerosRegistrados() {
        return enfermeros;
    }

    /**
     * Registra un nuevo enfermero en la lista.
     * @param enfermero Enfermero a registrar.
     */
    public static void registrarEnfermero(Enfermero enfermero) {
        enfermeros.add(enfermero);
    }

    /**
     * Actualiza la información de un enfermero existente.
     * @param enfermeroActualizado Enfermero con la información actualizada.
     */
    public static void actualizarEnfermero(Enfermero enfermeroActualizado) {
        for (int i = 0; i < enfermeros.size(); i++) {
            if (enfermeros.get(i).getId() == enfermeroActualizado.getId()) {
                enfermeros.set(i, enfermeroActualizado); // Reemplaza el enfermero existente
                break;
            }
        }
    }

    /**
     * Elimina un enfermero de la lista.
     * @param enfermero Enfermero a eliminar.
     */
    public static void eliminarEnfermero(Enfermero enfermero) {
        enfermeros.remove(enfermero);
    }

    /**
     * Busca un enfermero por su ID.
     * @param id ID del enfermero a buscar.
     * @return Enfermero encontrado o null si no existe.
     */
    public static Enfermero buscarEnfermeroPorId(int id) {
        for (Enfermero e : enfermeros) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
