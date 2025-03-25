import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa a un paciente y contiene métodos para manejar las operaciones relacionadas con los pacientes.
 */
public class Paciente extends Persona {
    private List<String> sintomas;
    private int nivelTriage;
    private Medico medicoAsignado;
    private Enfermero enfermeroAsignado;
    private Integer numeroCama; // Puede ser null si el paciente no necesita cama
    private HistorialMedico historial; // ✅ Nuevo atributo

    // Constructor de la clase Paciente
    public Paciente(int id, String nombre, String telefono, String direccion, String correo, 
                    Medico medicoAsignado, Enfermero enfermeroAsignado, Integer numeroCama) {
        super(id, nombre, telefono, direccion, correo);
        this.sintomas = new ArrayList<>();
        this.nivelTriage = 3; // Nivel más bajo por defecto
        this.medicoAsignado = medicoAsignado;
        this.enfermeroAsignado = enfermeroAsignado;
        this.numeroCama = numeroCama;
        this.historial = new HistorialMedico(id, this); // ✅ Se inicializa el historial
    }

    // Métodos getter y setter para los atributos de la clase
    public List<String> getSintomas() {
        return sintomas;
    }

    public void agregarSintoma(String sintoma) {
        sintomas.add(sintoma);
    }

    public int getNivelTriage() {
        return nivelTriage;
    }

    public void setNivelTriage(int nivelTriage) {
        this.nivelTriage = nivelTriage;
    }

    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }

    public void asignarMedico(Medico medico) {
        this.medicoAsignado = medico;
    }

    public Enfermero getEnfermeroAsignado() {
        return enfermeroAsignado;
    }

    public void asignarEnfermero(Enfermero enfermero) {
        this.enfermeroAsignado = enfermero;
    }

    public Integer getNumeroCama() {
        return numeroCama;
    }

    public void asignarCama(int numeroCama) {
        this.numeroCama = numeroCama;
    }

    public void eliminarMedico() {
        this.medicoAsignado = null;
    }

    public void eliminarEnfermero() {
        this.enfermeroAsignado = null;
    }

    // ✅ Método para obtener el historial médico del paciente
    public HistorialMedico getHistorial() {
        return historial;
    }

    // Método para mostrar la información del paciente
    @Override
    public void mostrarInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Correo: " + getCorreo());
        System.out.println("📌 Tipo: Paciente");
        System.out.println("Síntomas: " + (sintomas.isEmpty() ? "Ninguno registrado" : String.join(", ", sintomas)));
        System.out.println("Nivel de Triage: " + nivelTriage);
        System.out.println("Médico Asignado: " + (medicoAsignado != null ? medicoAsignado.getNombre() : "No asignado"));
        System.out.println("Enfermero Asignado: " + (enfermeroAsignado != null ? enfermeroAsignado.getNombre() : "No asignado"));
        System.out.println("Número de Cama: " + (numeroCama != null ? numeroCama : "No requiere"));
        System.out.println("📝 Historial Médico:");
        System.out.println(historial.obtenerHistorial());
    }
}
