import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private static List<Medico> medicos;
    private static List<Enfermero> enfermeros;
    private static List<Paciente> pacientes;
    private static Hospitalizacion hospitalizacion;

    public static void main(String[] args) {
        // Cargar datos predeterminados
        medicos = DatosPredeterminados.cargarMedicos();
        enfermeros = DatosPredeterminados.crearEnfermeros();
        pacientes = DatosPredeterminados.crearPacientes();
        hospitalizacion = new Hospitalizacion(10); // Suponiendo que hay 10 camas disponibles
        
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
            System.out.println("4. Hospitalización");
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
                case 4:
                    menuHospitalizacion();
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
            System.out.println("4. Listar Pacientes");
            System.out.println("5. Eliminar Paciente");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    Paciente.registrarPaciente(); // Actualizado para usar el método de la clase Paciente
                    break;
                case 2:
                    System.out.print("Ingrese el ID del paciente: ");
                    int pacienteId = scanner.nextInt();
                    Paciente paciente = buscarPacientePorId(pacienteId);
                    if (paciente != null) {
                        enfermero.asignarTriage(paciente);
                    } else {
                        System.out.println("Paciente no encontrado. Registrando nuevo paciente...");
                        Paciente.registrarPaciente(); // Actualizado
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ID del paciente a actualizar: ");
                    int pacienteIdActualizar = scanner.nextInt();
                    Paciente pacienteActualizar = buscarPacientePorId(pacienteIdActualizar);
                    if (pacienteActualizar != null) {
                        actualizarPaciente(pacienteActualizar); // Corregido: Se pasa el paciente encontrado
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                case 4:
                    listarPacientes();
                    break;
                case 5:
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
                        Paciente.registrarPaciente(); // Actualizado para usar el método de la clase Paciente
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
                Medico.registrarMedico();
                break;
            case 2:
                Medico.eliminarMedico();
                break;
            case 3:
                System.out.print("Ingrese el ID del médico a actualizar: ");
                int medicoIdActualizar = scanner.nextInt();
                Medico medicoActualizar = buscarMedicoPorId(medicoIdActualizar);
                if (medicoActualizar != null) {
                    medicoActualizar.actualizarMedico();
                } else {
                    System.out.println("Médico no encontrado.");
                }
                break;
            case 4:
                Enfermero.registrarEnfermero();
                break;
            case 5:
                Enfermero.eliminarEnfermero();
                break;
            case 6:
                System.out.print("Ingrese el ID del enfermero a actualizar: ");
                int enfermeroIdActualizar = scanner.nextInt();
                Enfermero enfermeroActualizar = buscarEnfermeroPorId(enfermeroIdActualizar);
                if (enfermeroActualizar != null) {
                    enfermeroActualizar.actualizarEnfermero();
                } else {
                    System.out.println("Enfermero no encontrado.");
                }
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    /**
     * Muestra el menú para la hospitalización y maneja la selección de opciones.
     */
    static void menuHospitalizacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Menú Hospitalización ---");
        System.out.println("1. Ver pacientes hospitalizados");
        System.out.println("2. Hospitalizar paciente");
        System.out.println("3. Dar de alta a paciente");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                hospitalizacion.verPacientesHospitalizados();
                break;
            case 2:
                hospitalizarPaciente();
                break;
            case 3:
                darDeAltaPaciente();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    /**
     * Hospitaliza a un paciente.
     */
    private static void hospitalizarPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del paciente a hospitalizar: ");
        int id = scanner.nextInt();
        Paciente paciente = buscarPacientePorId(id);
        if (paciente != null) {
            if (hospitalizacion.asignarCama(paciente)) {
                paciente.hospitalizar();
                System.out.println("Paciente hospitalizado exitosamente.");
            }
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    /**
     * Da de alta a un paciente hospitalizado.
     */
    private static void darDeAltaPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del paciente a dar de alta: ");
        int id = scanner.nextInt();
        Paciente paciente = buscarPacientePorId(id);
        if (paciente != null && paciente.isHospitalizado()) {
            hospitalizacion.darDeAlta(paciente);
            paciente.darDeAlta();
            System.out.println("Paciente dado de alta exitosamente.");
        } else {
            System.out.println("Paciente no encontrado o no está hospitalizado.");
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
     * Actualiza la información de un paciente existente.
     * @param paciente El paciente a actualizar.
     */
    private static void actualizarPaciente(Paciente paciente) {
        paciente.actualizarPaciente();
    }

    /**
     * Lista todos los pacientes registrados.
     */
    private static void listarPacientes() {
        System.out.println("\n--- Lista de Pacientes ---");
        for (Paciente paciente : pacientes) {
            paciente.mostrarInfo();
        }
    }
}
