import java.util.Scanner;

public class MenuPrincipal {
    
    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }

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
                default:
                    System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Enfermero no encontrado.");
        }
    }

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
                default:
                    System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Médico no encontrado.");
        }
    }

    static void menuJefeDePersonal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Menú Jefe de Personal ---");
        System.out.println("1. Registrar Médico");
        System.out.println("2. Eliminar Médico");
        System.out.println("3. Registrar Enfermero");
        System.out.println("4. Eliminar Enfermero");
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
                registrarEnfermero();
                break;
            case 4:
                eliminarEnfermero();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

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

    private static Medico buscarMedicoPorId(int id) {
        for (Medico medico : AdministracionPersonal.getMedicosRegistrados()) {
            if (medico.getId() == id) {
                return medico;
            }
        }
        return null;
    }

    private static Enfermero buscarEnfermeroPorId(int id) {
        for (Enfermero enfermero : AdministracionPersonal.getEnfermerosRegistrados()) {
            if (enfermero.getId() == id) {
                return enfermero;
            }
        }
        return null;
    }

    private static Paciente buscarPacientePorId(int id) {
        for (Paciente paciente : DatosPredeterminados.crearPacientes()) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

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
}
