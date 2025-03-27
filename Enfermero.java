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



    // Método para actualizar la información del enfermero
    public void actualizarEnfermero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Actualizar Enfermero ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        System.out.print("Turno: ");
        String turno = scanner.nextLine();
        setNombre(nombre);
        setTelefono(telefono);
        setDireccion(direccion);
        setCorreo(correo);
        setEspecialidad(especialidad);
        setTurno(turno);
        AdministracionPersonal.actualizarEnfermero(this);
        System.out.println("Enfermero actualizado exitosamente.");
    }

    // Método para registrar un nuevo enfermero
    public static void registrarEnfermero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Registrar Enfermero ---");
        int id;
        while (true) {
            System.out.print("ID: ");
            id = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            if (buscarEnfermeroPorId(id) == null) {
                break;
            } else {
                System.out.println("El ID ya existe. Por favor, ingrese otro ID.");
            }
        }
        String nombre = Persona.solicitarNombre();
        String telefono = Persona.solicitarTelefono();
        String direccion = Persona.solicitarDireccion();
        String correo = Persona.solicitarCorreo();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        System.out.print("Turno: ");
        String turno = scanner.nextLine();
        Enfermero enfermero = new Enfermero(id, nombre, telefono, direccion, correo, especialidad, turno);
        AdministracionPersonal.registrarEnfermero(enfermero);
        System.out.println("Enfermero registrado exitosamente.");
    }

    // Método para eliminar un enfermero existente
    public static void eliminarEnfermero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Eliminar Enfermero ---");
        System.out.print("ID del Enfermero: ");
        int id = scanner.nextInt();
        Enfermero enfermero = buscarEnfermeroPorId(id);
        if (enfermero != null) {
            AdministracionPersonal.eliminarEnfermero(enfermero);
            System.out.println("Enfermero eliminado exitosamente.");
        } else {
            System.out.println("Enfermero no encontrado.");
        }
    }

    // Método para buscar un enfermero por su ID
    public static Enfermero buscarEnfermeroPorId(int id) {
        for (Enfermero enfermero : AdministracionPersonal.getEnfermerosRegistrados()) { // Cambiado a AdministracionPersonal
            if (enfermero.getId() == id) {
                return enfermero;
            }
        }
        return null;
    }
}