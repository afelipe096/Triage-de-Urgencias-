import java.util.Scanner;

public class Enfermero extends Persona {
    private String especialidad;
    private String turno;

    // Constructor de la clase Enfermero
    public Enfermero(int id, String nombre, String telefono, String direccion, String correo, String especialidad, String turno) {
        super(id, nombre, telefono, direccion, correo);
        this.especialidad = especialidad;
        this.turno = turno;
    }

    // Métodos getter y setter para los atributos de la clase
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    // Método para mostrar la información del enfermero
    @Override
    public void mostrarInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Correo: " + getCorreo());
        System.out.println(" Tipo: Enfermero");
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Turno: " + turno);
    }

    // Método para registrar un nuevo paciente
    public void registrarPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n🩺 Enfermero " + getNombre() + " registrando un paciente...");
        int id;
        while (true) {
            System.out.print("ID: ");
            id = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            if (buscarPacientePorId(id) == null) {
                break;
            } else {
                System.out.println("El ID ya existe. Por favor, ingrese otro ID.");
            }
        }
        String nombre = Persona.solicitarNombre();
        String telefono = Persona.solicitarTelefono();
        String direccion = Persona.solicitarDireccion();
        String correo = Persona.solicitarCorreo();

        Paciente paciente = new Paciente(id, nombre, telefono, direccion, correo, null, null, null);
        System.out.println("\n✅ Paciente registrado exitosamente:");
        paciente.mostrarInfo();

        // Agregar un registro al historial médico del paciente
        paciente.getHistorial().agregarRegistro("Registrado por " + getNombre() + " (" + especialidad + ")");

        // Asignar triage al paciente después de registrarlo
        asignarTriage(paciente);
    }

    // Método para asignar triage a un paciente
    public void asignarTriage(Paciente paciente) {
        Scanner scanner = new Scanner(System.in);
        Triage triage = new Triage();
        triage.mostrarCatalogo();

        System.out.println("\n Enfermero " + getNombre() + " asignando triage al paciente...");
        
        while (true) {
            System.out.print("Ingrese el número de la enfermedad (0 para finalizar): ");
            int num = scanner.nextInt();
            if (num == 0) break; // Salir cuando el enfermero termine de asignar enfermedades
            
            triage.agregarEnfermedad(num);
        }

        // Evaluar y mostrar el diagnóstico final
        triage.evaluarPaciente(paciente);
        paciente.getHistorial().agregarRegistro("Triage asignado por " + getNombre() + " (" + especialidad + ")");
    }

    // Método para buscar un paciente por su ID
    private Paciente buscarPacientePorId(int id) {
        for (Paciente paciente : DatosPredeterminados.getPacientesRegistrados()) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public void getRegistrarPaciente() {
    }
}