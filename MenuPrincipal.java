import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private static List<Medico> medicos;
    private static List<Enfermero> enfermeros;
    private static List<Paciente> pacientes;

    public static void main(String[] args) {
        // Cargar datos predeterminados
        medicos = DatosPredeterminados.cargarMedicos();
        enfermeros = DatosPredeterminados.crearEnfermeros();
        pacientes = DatosPredeterminados.crearPacientes();
        
        mostrarMenuPrincipal();
    }

    /**
     * Muestra el menú principal y maneja la selección de opciones.
     */
    public static void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Enfermero");
            System.out.println("2. Médico");
            System.out.println("3. Jefe de Personal");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuEnfermero();
                    break;
                case 2:
                    menuMedico();
                    break;
                case 3:
                    menuJefeDePersonal();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    /**
     * Muestra el menú para los enfermeros y maneja la selección de opciones.
     */
    static void menuEnfermero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Menú Enfermero ---");
        System.out.print("Ingrese su ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        Enfermero enfermero = buscarEnfermeroPorId(id);
        if (enfermero != null) {
            System.out.println("Bienvenido, " + enfermero.getNombre());
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Asignar Triage");
            System.out.println("3. Actualizar Paciente");
            System.out.println("4. Eliminar Paciente");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    enfermero.registrarPaciente();
                    break;
                case 2:
                    System.out.print("Ingrese el ID del paciente: ");
                    int pacienteId = scanner.nextInt();
                    Paciente paciente = buscarPacientePorId(pacienteId);
                    if (paciente != null) {
                        enfermero.asignarTriage(paciente);
                    } else {
                        System.out.println("Paciente no encontrado. Registrando nuevo paciente...");
                        enfermero.registrarPaciente();
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ID del paciente a actualizar: ");
                    int pacienteIdActualizar = scanner.nextInt();
                    Paciente pacienteActualizar = buscarPacientePorId(pacienteIdActualizar);
                    if (pacienteActualizar != null) {
                        actualizarPaciente(pacienteActualizar);
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el ID del paciente a eliminar: ");
                    int pacienteIdEliminar = scanner.nextInt();
                    Paciente pacienteEliminar = buscarPacientePorId(pacienteIdEliminar);
                    if (pacienteEliminar != null) {
                        DatosPredeterminados.eliminarPaciente(pacienteEliminar);
                        System.out.println("Paciente eliminado exitosamente.");
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Enfermero no encontrado.");
        }
    }

    /**
     * Muestra el menú para los médicos y maneja la selección de opciones.
     */
    static void menuMedico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Menú Médico ---");
        System.out.print("Ingrese su ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        Medico medico = buscarMedicoPorId(id);
        if (medico != null) {
            System.out.println("Bienvenido, " + medico.getNombre());
            System.out.println("1. Atender Paciente");
            System.out.println("2. Continuar Consulta");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del paciente: ");
                    int pacienteId = scanner.nextInt();
                    Paciente paciente = buscarPacientePorId(pacienteId);
                    if (paciente != null) {
                        medico.atenderPaciente(paciente);
                    } else {
                        System.out.println("Paciente no encontrado. Registrando nuevo paciente...");
                        registrarPaciente();
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el ID del paciente: ");
                    int pacienteIdContinuar = scanner.nextInt();
                    Paciente pacienteContinuar = buscarPacientePorId(pacienteIdContinuar);
                    if (pacienteContinuar != null) {
                        medico.continuarConsulta(pacienteContinuar);
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Médico no encontrado.");
        }
    }

    /**
     * Muestra el menú para el jefe de personal y maneja la selección de opciones.
     */
    static void menuJefeDePersonal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Menú Jefe de Personal ---");
        System.out.println("1. Registrar Médico");
        System.out.println("2. Eliminar Médico");
        System.out.println("3. Actualizar Médico");
        System.out.println("4. Registrar Enfermero");
        System.out.println("5. Eliminar Enfermero");
        System.out.println("6. Actualizar Enfermero");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                registrarMedico();
                break;
            case 2:
                eliminarMedico();
                break;
            case 3:
                actualizarMedico();
                break;
            case 4:
                registrarEnfermero();
                break;
            case 5:
                eliminarEnfermero();
                break;
            case 6:
                actualizarEnfermero();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    /**
     * Registra un nuevo médico.
     */
    private static void registrarMedico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Registrar Médico ---");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
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
        Medico medico = new Medico(id, nombre, telefono, direccion, correo, especialidad);
        AdministracionPersonal.registrarMedico(medico);
        System.out.println("Médico registrado exitosamente.");
    }

    /**
     * Elimina un médico existente.
     */
    private static void eliminarMedico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Eliminar Médico ---");
        System.out.print("ID del Médico: ");
        int id = scanner.nextInt();
        Medico medico = buscarMedicoPorId(id);
        if (medico != null) {
            AdministracionPersonal.eliminarMedico(medico);
            System.out.println("Médico eliminado exitosamente.");
        } else {
            System.out.println("Médico no encontrado.");
        }
    }

    /**
     * Actualiza la información de un médico existente.
     */
    private static void actualizarMedico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Actualizar Médico ---");
        System.out.print("ID del Médico: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        Medico medico = buscarMedicoPorId(id);
        if (medico != null) {
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
            medico.setNombre(nombre);
            medico.setTelefono(telefono);
            medico.setDireccion(direccion);
            medico.setCorreo(correo);
            medico.setEspecialidad(especialidad);
            AdministracionPersonal.actualizarMedico(medico);
            System.out.println("Médico actualizado exitosamente.");
        } else {
            System.out.println("Médico no encontrado.");
        }
    }

    /**
     * Registra un nuevo enfermero.
     */
    private static void registrarEnfermero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Registrar Enfermero ---");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
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
        Enfermero enfermero = new Enfermero(id, nombre, telefono, direccion, correo, especialidad, turno);
        AdministracionPersonal.registrarEnfermero(enfermero);
        System.out.println("Enfermero registrado exitosamente.");
    }

    /**
     * Elimina un enfermero existente.
     */
    private static void eliminarEnfermero() {
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

    /**
     * Actualiza la información de un enfermero existente.
     */
    private static void actualizarEnfermero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Actualizar Enfermero ---");
        System.out.print("ID del Enfermero: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        Enfermero enfermero = buscarEnfermeroPorId(id);
        if (enfermero != null) {
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
            enfermero.setNombre(nombre);
            enfermero.setTelefono(telefono);
            enfermero.setDireccion(direccion);
            enfermero.setCorreo(correo);
            enfermero.setEspecialidad(especialidad);
            enfermero.setTurno(turno);
            AdministracionPersonal.actualizarEnfermero(enfermero);
            System.out.println("Enfermero actualizado exitosamente.");
        } else {
            System.out.println("Enfermero no encontrado.");
        }
    }

    /**
     * Busca un médico por su ID.
     * @param id El ID del médico.
     * @return El médico encontrado o null si no se encuentra.
     */
    private static Medico buscarMedicoPorId(int id) {
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                return medico;
            }
        }
        return null;
    }

    /**
     * Busca un enfermero por su ID.
     * @param id El ID del enfermero.
     * @return El enfermero encontrado o null si no se encuentra.
     */
    private static Enfermero buscarEnfermeroPorId(int id) {
        for (Enfermero enfermero : enfermeros) {
            if (enfermero.getId() == id) {
                return enfermero;
            }
        }
        return null;
    }

    /**
     * Busca un paciente por su ID.
     * @param id El ID del paciente.
     * @return El paciente encontrado o null si no se encuentra.
     */
    private static Paciente buscarPacientePorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    /**
     * Registra un nuevo paciente.
     */
    private static void registrarPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Registrar Paciente ---");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        Paciente paciente = new Paciente(id, nombre, telefono, direccion, correo, null, null, null);
        System.out.println("\n✅ Paciente registrado exitosamente:");
        paciente.mostrarInfo();
    }

    /**
     * Actualiza la información de un paciente existente.
     * @param paciente El paciente a actualizar.
     */
    private static void actualizarPaciente(Paciente paciente) {
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
        paciente.setNombre(nombre);
        paciente.setTelefono(telefono);
        paciente.setDireccion(direccion);
        paciente.setCorreo(correo);
        DatosPredeterminados.actualizarPaciente(paciente);
        System.out.println("Paciente actualizado exitosamente.");
    }
}
