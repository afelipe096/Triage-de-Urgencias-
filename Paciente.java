import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un paciente en el sistema.
 * Hereda de la clase abstracta Persona.
 */
public class Paciente extends Persona {
    // Atributos específicos de un paciente
    private List<String> sintomas; // Lista de síntomas del paciente
    private int nivelTriage; // Nivel de urgencia del paciente
    private Medico medicoAsignado; // Médico asignado al paciente
    private Enfermero enfermeroAsignado; // Enfermero asignado al paciente
    private Integer numeroCama; // Número de cama asignada (null si no tiene cama)
    private HistorialMedico historial; // Historial médico del paciente
    private boolean hospitalizado; // Indica si el paciente está hospitalizado

    // Constructor para inicializar un paciente
    public Paciente(int id, String nombre, String telefono, String direccion, String correo, 
                    Medico medicoAsignado, Enfermero enfermeroAsignado, Integer numeroCama) {
        super(id, nombre, telefono, direccion, correo); // Llama al constructor de la clase base
        this.sintomas = new ArrayList<>();
        this.nivelTriage = 3; // Nivel más bajo por defecto
        this.medicoAsignado = medicoAsignado;
        this.enfermeroAsignado = enfermeroAsignado;
        this.numeroCama = numeroCama;
        this.historial = new HistorialMedico(id, this); // Inicializa el historial médico
        this.hospitalizado = false; // Inicialmente no está hospitalizado
    }

    // Métodos getter y setter para los atributos
    public List<String> getSintomas() {
        return sintomas;
    }

    public void agregarSintoma(String sintoma) {
        sintomas.add(sintoma); // Agrega un síntoma a la lista
    }

    public int getNivelTriage() {
        return nivelTriage;
    }

    public void setNivelTriage(int nivelTriage) {
        this.nivelTriage = nivelTriage; // Actualiza el nivel de urgencia
    }

    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }

    public void asignarMedico(Medico medico) {
        this.medicoAsignado = medico; // Asigna un médico al paciente
    }

    public Enfermero getEnfermeroAsignado() {
        return enfermeroAsignado;
    }

    public void asignarEnfermero(Enfermero enfermero) {
        this.enfermeroAsignado = enfermero; // Asigna un enfermero al paciente
    }

    public Integer getNumeroCama() {
        return numeroCama;
    }

    public void setNumeroCama(Integer numeroCama) {
        this.numeroCama = numeroCama; // Asigna un número de cama
    }

    public void asignarCama(int numeroCama) {
        this.numeroCama = numeroCama; // Asigna una cama específica
    }

    public void eliminarMedico() {
        this.medicoAsignado = null; // Elimina la asignación del médico
    }

    public void eliminarEnfermero() {
        this.enfermeroAsignado = null; // Elimina la asignación del enfermero
    }

    public HistorialMedico getHistorial() {
        return historial; // Devuelve el historial médico
    }

    public boolean isHospitalizado() {
        return hospitalizado; // Devuelve si el paciente está hospitalizado
    }

    public void hospitalizar() {
        this.hospitalizado = true; // Marca al paciente como hospitalizado
    }

    public void darDeAlta() {
        this.hospitalizado = false; // Marca al paciente como dado de alta
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
        System.out.println("\n--- Actualizar Paciente ---");
        System.out.print("Nombre: ");
        String nombre = Persona.SCANNER.nextLine();
        System.out.print("Teléfono: ");
        String telefono = Persona.SCANNER.nextLine();
        System.out.print("Dirección: ");
        String direccion = Persona.SCANNER.nextLine();
        System.out.print("Correo: ");
        String correo = Persona.SCANNER.nextLine();
        setNombre(nombre);
        setTelefono(telefono);
        setDireccion(direccion);
        setCorreo(correo);
        DatosPredeterminados.actualizarPaciente(this); // Actualiza el paciente en la lista de datos predeterminados
        System.out.println("Paciente actualizado exitosamente.");
    }

    // Método para registrar un nuevo paciente
    public static void registrarPaciente() {
        System.out.println("\n--- Registrar Paciente ---");

        // Obtener la lista de pacientes registrados a través de DatosPredeterminados.
        List<Paciente> pacientesRegistrados = DatosPredeterminados.getPacientesRegistrados();
        if (pacientesRegistrados == null) {
            System.out.println("Error: La lista de pacientes no está inicializada.");
            return;
        }

        int id;
        while (true) {
            System.out.print("ID: ");
            // Validar que la entrada sea un entero
            while (!Persona.SCANNER.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                Persona.SCANNER.next(); 
            }
            id = Persona.SCANNER.nextInt();
            Persona.SCANNER.nextLine(); 

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

        // Solicitar los datos del paciente utilizando los métodos de Persona
        String nombre = Persona.solicitarNombre();
        String telefono = Persona.solicitarTelefono();
        String direccion = Persona.solicitarDireccion();
        String correo = Persona.solicitarCorreo();

        // Crear un nuevo paciente y agregarlo a la lista de pacientes registrados
        Paciente paciente = new Paciente(id, nombre, telefono, direccion, correo, null, null, null);
        pacientesRegistrados.add(paciente);
        System.out.println("\n✅ Paciente registrado exitosamente:");
        paciente.mostrarInfo();
    }

    // Método para eliminar la asignación de triage
    public void eliminarAsignacionTriage() {
        this.sintomas.clear(); // Limpia la lista de síntomas
        this.nivelTriage = 3; // Restablece el nivel de triage al valor por defecto
        this.enfermeroAsignado = null; // Desasigna el enfermero
        this.historial.agregarRegistro("Se eliminó la asignación de triage."); // Agrega un registro al historial
    }
}
