/**
 * Clase que representa a un enfermero en el sistema.
 * Hereda de la clase abstracta Persona.
 */
public class Enfermero extends Persona {
    private String especialidad; // Especialidad del enfermero
    private String turno; // Turno de trabajo del enfermero (Mañana, Tarde, Noche)

    // Constructor para inicializar un enfermero
    public Enfermero(int id, String nombre, String telefono, String direccion, String correo, String especialidad, String turno) {
        super(id, nombre, telefono, direccion, correo); // Llama al constructor de la clase base
        this.especialidad = especialidad;
        this.turno = turno;
    }

    // Métodos getter y setter para los atributos
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
        System.out.println("Tipo: Enfermero");
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Turno: " + turno);
    }

    // Método para asignar triage a un paciente
    public void asignarTriage(Paciente paciente) {
        // Asigna al enfermero al paciente
        paciente.asignarEnfermero(this);
        
        Triage triage = new Triage();
        triage.mostrarCatalogo();
    
        System.out.println("\nEnfermero " + getNombre() + " asignando triage al paciente...");
    
        while (true) {
            System.out.print("Ingrese el número de la enfermedad (0 para finalizar): ");
            int num = Persona.SCANNER.nextInt();
            Persona.SCANNER.nextLine(); // Consumir salto de línea
            if (num == 0) break;
            
            // Agregar la enfermedad al triage
            triage.agregarEnfermedad(num);
            // Agregar el síntoma al paciente con el formato esperado, por ejemplo:
            String sintoma = triage.getEnfermedad(num);
            if (sintoma != null) {
                // Formatear el síntoma para incluir el código, por ejemplo:
                paciente.agregarSintoma(sintoma + " (Código: " + num + ")");
            }
        }
        
        // Evaluar el paciente según el triage (actualiza nivel y muestra mensajes)
        triage.evaluarPaciente(paciente);
        
        // Actualiza el nivel de triage del paciente
        paciente.setNivelTriage(triage.getNivelUrgencia());
        
        // Agrega registro al historial
        paciente.getHistorial().agregarRegistro("Triage asignado por " + getNombre() + " (" + especialidad + "), Nivel: " + triage.getNivelUrgencia());
    }
    
    
    

    // Método para actualizar la información del enfermero
    public void actualizarEnfermero() {
        System.out.println("\n--- Actualizar Enfermero ---");
        System.out.print("Nombre: ");
        String nombre = Persona.SCANNER.nextLine();
        System.out.print("Teléfono: ");
        String telefono = Persona.SCANNER.nextLine();
        System.out.print("Dirección: ");
        String direccion = Persona.SCANNER.nextLine();
        System.out.print("Correo: ");
        String correo = Persona.SCANNER.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = Persona.SCANNER.nextLine();
        System.out.print("Turno: ");
        String turno = Persona.SCANNER.nextLine();

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
        System.out.println("\n--- Registrar Enfermero ---");
        int id;
        while (true) {
            System.out.print("ID: ");
            while (!Persona.SCANNER.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                Persona.SCANNER.next(); // Descarta la entrada inválida
            }
            id = Persona.SCANNER.nextInt();
            Persona.SCANNER.nextLine(); // Consumir salto de línea
            if (buscarEnfermeroPorId(id) == null) {
                break;
            } else {
                System.out.println("El ID ya existe. Por favor, ingrese otro ID.");
            }
        }
        // Usamos los métodos de la clase Persona para solicitar datos
        String nombre = Persona.solicitarNombre();
        String telefono = Persona.solicitarTelefono();
        String direccion = Persona.solicitarDireccion();
        String correo = Persona.solicitarCorreo();
        System.out.print("Especialidad: ");
        String especialidad = Persona.SCANNER.nextLine();
        System.out.print("Turno: ");
        String turno = Persona.SCANNER.nextLine();

        Enfermero enfermero = new Enfermero(id, nombre, telefono, direccion, correo, especialidad, turno);
        AdministracionPersonal.registrarEnfermero(enfermero);
        System.out.println("Enfermero registrado exitosamente.");
    }

    // Método para eliminar un enfermero existente
    public static void eliminarEnfermero() {
        System.out.println("\n--- Eliminar Enfermero ---");
        System.out.print("ID del Enfermero: ");
        int id = Persona.SCANNER.nextInt();
        Persona.SCANNER.nextLine();
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
        for (Enfermero enfermero : AdministracionPersonal.getEnfermerosRegistrados()) {
            if (enfermero.getId() == id) {
                return enfermero;
            }
        }
        return null;
    }
}
