import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase representa a un paciente y contiene métodos para manejar las operaciones relacionadas con los pacientes.
 */
public class Paciente extends Persona {
    private static List<Paciente> pacientes;
    private List<String> sintomas;
    private int nivelTriage;
    private Medico medicoAsignado;
    private Enfermero enfermeroAsignado;
    private Integer numeroCama; // Puede ser null si el paciente no necesita cama
    private HistorialMedico historial; // ✅ Nuevo atributo
    private boolean hospitalizado; // ✅ Nuevo atributo

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
        this.hospitalizado = false; // ✅ Inicialmente no hospitalizado
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

    public void setNumeroCama(Integer numeroCama) {
        this.numeroCama = numeroCama;
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

    // ✅ Métodos para manejar la hospitalización
    public boolean isHospitalizado() {
        return hospitalizado;
    }

    public void hospitalizar() {
        this.hospitalizado = true;
    }

    public void darDeAlta() {
        this.hospitalizado = false;
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
        System.out.println("Hospitalizado: " + (hospitalizado ? "Sí" : "No"));
        System.out.println("📝 Historial Médico:");
        System.out.println(historial.obtenerHistorial());
    }

    // Método para actualizar la información del paciente
    public void actualizarPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Actualizar Paciente ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        setNombre(nombre);
        setTelefono(telefono);
        setDireccion(direccion);
        setCorreo(correo);
        DatosPredeterminados.actualizarPaciente(this);
        System.out.println("Paciente actualizado exitosamente.");
    }

    // Método para registrar un nuevo paciente
    public static void registrarPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Registrar Paciente ---");

        // Obtener la lista de pacientes registrados
        List<Paciente> pacientesRegistrados = DatosPredeterminados.getPacientesRegistrados();
        if (pacientesRegistrados == null) {
            System.out.println("Error: La lista de pacientes no está inicializada.");
            return;
        }

        int id;
        while (true) {
            System.out.print("ID: ");
            id = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            // Verificar si el ID ya existe en la lista de pacientes registrados
            boolean idExiste = false;
            for (Paciente paciente : pacientesRegistrados) {
                if (paciente.getId() == id) {
                    idExiste = true;
                    break;
                }
            }
            if (!idExiste) {
                break;
            } else {
                System.out.println("El ID ya existe. Por favor, ingrese otro ID.");
            }
        }

        // Solicitar los datos del paciente
        String nombre = Persona.solicitarNombre();
        String telefono = Persona.solicitarTelefono();
        String direccion = Persona.solicitarDireccion();
        String correo = Persona.solicitarCorreo();

        // Crear un nuevo paciente y agregarlo a la lista de pacientes registrados
        Paciente paciente = new Paciente(id, nombre, telefono, direccion, correo, null, null, null);
        pacientesRegistrados.add(paciente);

        // Confirmar el registro del paciente
        System.out.println("\n✅ Paciente registrado exitosamente:");
        paciente.mostrarInfo();
    }
}
