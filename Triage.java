import java.util.*;
public class Triage {
    private Map<Integer, String> catalogoEnfermedades;
    private Map<Integer, Integer> nivelesUrgencia;
    private List<Integer> enfermedadesPaciente;
    private int nivelUrgencia;


    public Triage() {
        catalogoEnfermedades = new HashMap<>();
        nivelesUrgencia = new HashMap<>();
        enfermedadesPaciente = new ArrayList<>();
        // Inicialmente se asume el nivel más bajo (3) y se actualizará al agregar enfermedades
        nivelUrgencia = 3;

        agregarEnfermedades();
    }

    public int getNivelUrgencia() {
        return nivelUrgencia;
    }
    
    public String getEnfermedad(int numero) {
        return catalogoEnfermedades.get(numero);
    }
    

    // Método para agregar enfermedades al catálogo
    private void agregarEnfermedades() {
        // Nivel 1 (Emergencia)
        agregarEnfermedad(1, "Infarto", 1);
        agregarEnfermedad(2, "Dificultad respiratoria grave", 1);
        agregarEnfermedad(3, "Hemorragia severa", 1);
        agregarEnfermedad(4, "Quemaduras extensas", 1);
        agregarEnfermedad(5, "Fractura expuesta", 1);
        agregarEnfermedad(6, "Accidente cerebrovascular", 1);
        agregarEnfermedad(7, "Shock anafiláctico", 1);
        agregarEnfermedad(8, "Trauma craneoencefálico severo", 1);
        agregarEnfermedad(9, "Paro cardíaco", 1);
        agregarEnfermedad(10, "Envenenamiento severo", 1);

        // Nivel 2 (Urgente)
        agregarEnfermedad(11, "Apendicitis", 2);
        agregarEnfermedad(12, "Neumonía", 2);
        agregarEnfermedad(13, "Dolor abdominal intenso", 2);
        agregarEnfermedad(14, "Fiebre alta persistente", 2);
        agregarEnfermedad(15, "Heridas profundas", 2);
        agregarEnfermedad(16, "Convulsiones", 2);
        agregarEnfermedad(17, "Cálculos renales", 2);
        agregarEnfermedad(18, "Deshidratación severa", 2);
        agregarEnfermedad(19, "Hemorragia moderada", 2);
        agregarEnfermedad(20, "Dificultad para tragar", 2);

        // Nivel 3 (Prioritario)
        agregarEnfermedad(21, "Resfriado común", 3);
        agregarEnfermedad(22, "Dolor de garganta", 3);
        agregarEnfermedad(23, "Tos persistente", 3);
        agregarEnfermedad(24, "Diarrea leve", 3);
        agregarEnfermedad(25, "Molestia ocular", 3);
        agregarEnfermedad(26, "Dolor de cabeza leve", 3);
        agregarEnfermedad(27, "Alergia leve", 3);
        agregarEnfermedad(28, "Corte superficial", 3);
        agregarEnfermedad(29, "Contractura muscular", 3);
        agregarEnfermedad(30, "Falta de sueño", 3);
    }

    // Método para agregar una enfermedad al catálogo
    private void agregarEnfermedad(int numero, String enfermedad, int nivel) {
        catalogoEnfermedades.put(numero, enfermedad);
        nivelesUrgencia.put(numero, nivel);
    }

    // Método para mostrar el catálogo de enfermedades
    public void mostrarCatalogo() {
        System.out.println("\n📋 Catálogo de Enfermedades:");
        // Se itera sobre las claves ordenadas para garantizar el orden
        List<Integer> claves = new ArrayList<>(catalogoEnfermedades.keySet());
        Collections.sort(claves);
        for (int clave : claves) {
            System.out.println(clave + ". " + catalogoEnfermedades.get(clave));
        }
    }

    // Método para agregar una enfermedad al paciente
    public void agregarEnfermedad(int numero) {
        if (catalogoEnfermedades.containsKey(numero)) {
            enfermedadesPaciente.add(numero);
            int nivel = nivelesUrgencia.get(numero);
            // Se actualiza el nivel de urgencia si la enfermedad es de mayor prioridad
            if (nivel < nivelUrgencia) {
                nivelUrgencia = nivel;
            }
            System.out.println("✅ Enfermedad agregada: " + catalogoEnfermedades.get(numero));
        } else {
            System.out.println("⚠️ Número no válido, intenta de nuevo.");
        }
    }

    // Método para eliminar una enfermedad del paciente
    public void eliminarEnfermedad(int num) {
        if (catalogoEnfermedades.containsKey(num) && enfermedadesPaciente.contains(num)) {
            enfermedadesPaciente.remove(Integer.valueOf(num));
            System.out.println("Enfermedad eliminada: " + catalogoEnfermedades.get(num));
            // Opcional: podrías recalcular el nivel de urgencia si es necesario
        } else {
            System.out.println("Enfermedad no encontrada.");
        }
    }

    // Método para evaluar el estado del paciente basado en las enfermedades asignadas
    public void evaluarPaciente(Paciente paciente) {
        System.out.println("\n🏥 Diagnóstico del Paciente:");
        System.out.println("Nivel de urgencia asignado: " + nivelUrgencia);

        System.out.println("\n🩺 Enfermedades detectadas (ordenadas por urgencia):");
        // Ordenamos las enfermedades del paciente según su nivel de urgencia
        enfermedadesPaciente.sort(Comparator.comparingInt(nivelesUrgencia::get));

        for (int numero : enfermedadesPaciente) {
            System.out.println("- " + catalogoEnfermedades.get(numero) + " (Nivel " + nivelesUrgencia.get(numero) + ")");
        }

        // Evaluar el estado del paciente basado en el nivel de urgencia
        if (nivelUrgencia == 1) {
            System.out.println("El paciente requiere atención inmediata.");
        } else if (nivelUrgencia == 2) {
            System.out.println("El paciente requiere atención urgente.");
        } else {
            System.out.println("El paciente requiere atención prioritaria.");
        }
    }
}
