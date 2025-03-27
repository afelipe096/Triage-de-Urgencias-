import java.util.InputMismatchException;

/**
 * Clase principal del sistema de triage.
 * Contiene el método main como punto de entrada del programa.
 */
public class Main {
    // Atributo estático para gestionar la hospitalización con un número fijo de camas
    private static Hospitalizacion hospitalizacion = new Hospitalizacion(10); // Suponiendo 10 camas

    /**
     * Método principal del programa.
     * Muestra el menú principal y permite navegar por las diferentes opciones.
     */
    public static void main(String[] args) {
        int opcion = -1; // Variable para almacenar la opción seleccionada por el usuario
        do {
            try {
                mostrarMenuPrincipal(); // Muestra el menú principal
                opcion = readInt(); // Lee la opción seleccionada
                switch (opcion) {
                    case 1:
                        menuJefeDePersonal(); // Menú para gestionar médicos y enfermeros
                        break;
                    case 2:
                        menuEnfermeros(); // Menú para enfermeros
                        break;
                    case 3:
                        menuMedicos(); // Menú para médicos
                        break;
                    case 4:
                        menuHospitalizacion(); // Menú para hospitalización
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema..."); // Salida del programa
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente."); // Manejo de opciones inválidas
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage()); // Manejo de excepciones generales
            }
        } while (opcion != 0); // Repite hasta que el usuario seleccione salir
    }

    /**
     * Método auxiliar para leer un número entero con validación.
     * @return Número entero ingresado por el usuario.
     */
    private static int readInt() {
        while (true) {
            try {
                int valor = Persona.SCANNER.nextInt(); // Lee un entero
                Persona.SCANNER.nextLine(); // Consumir el salto de línea
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero."); // Manejo de entradas inválidas
                Persona.SCANNER.nextLine(); // Descarta la entrada incorrecta
            }
        }
    }

    /**
     * Muestra el menú principal del sistema.
     */
    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Jefe de Personal");
        System.out.println("2. Enfermeros");
        System.out.println("3. Médicos");
        System.out.println("4. Hospitalización");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Menú para el Jefe de Personal.
     * Permite gestionar médicos y enfermeros.
     */
    private static void menuJefeDePersonal() {
        int opcion = -1;
        do {
            try {
                System.out.println("\n--- Menú Jefe de Personal ---");
                System.out.println("1. Gestionar Médicos");
                System.out.println("2. Gestionar Enfermeros");
                System.out.println("0. Volver al Menú Principal");
                System.out.print("Seleccione una opción: ");
                opcion = readInt();
                switch (opcion) {
                    case 1:
                        gestionarMedicos(); // Submenú para gestionar médicos
                        break;
                    case 2:
                        gestionarEnfermeros(); // Submenú para gestionar enfermeros
                        break;
                    case 0:
                        System.out.println("Regresando al Menú Principal...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error en menú Jefe de Personal: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    /**
     * Submenú para gestionar médicos.
     * Permite mostrar, agregar, actualizar y eliminar médicos.
     */
    private static void gestionarMedicos() {
        int opcion = -1;
        do {
            try {
                System.out.println("\n--- Gestión de Médicos ---");
                System.out.println("1. Mostrar Médicos");
                System.out.println("2. Agregar Médico");
                System.out.println("3. Actualizar Médico");
                System.out.println("4. Eliminar Médico");
                System.out.println("0. Volver");
                System.out.print("Seleccione una opción: ");
                opcion = readInt();
                switch (opcion) {
                    case 1:
                        for (Medico m : AdministracionPersonal.getMedicos()) {
                            m.mostrarInfo(); // Muestra la información de cada médico
                            System.out.println("------------------");
                        }
                        break;
                    case 2:
                        Medico.registrarMedico(); // Registra un nuevo médico
                        break;
                    case 3:
                        System.out.print("Ingrese el ID del médico a actualizar: ");
                        int idActualizar = readInt();
                        Medico medicoAActualizar = AdministracionPersonal.buscarMedicoPorId(idActualizar);
                        if (medicoAActualizar != null) {
                            medicoAActualizar.actualizarMedico(); // Actualiza la información del médico
                        } else {
                            System.out.println("Médico no encontrado.");
                        }
                        break;
                    case 4:
                        Medico.eliminarMedico(); // Elimina un médico
                        break;
                    case 0:
                        System.out.println("Volviendo al menú Jefe de Personal...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error en gestión de médicos: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    /**
     * Submenú para gestionar enfermeros.
     * Permite mostrar, agregar, actualizar y eliminar enfermeros.
     */
    private static void gestionarEnfermeros() {
        int opcion = -1;
        do {
            try {
                System.out.println("\n--- Gestión de Enfermeros ---");
                System.out.println("1. Mostrar Enfermeros");
                System.out.println("2. Agregar Enfermero");
                System.out.println("3. Actualizar Enfermero");
                System.out.println("4. Eliminar Enfermero");
                System.out.println("0. Volver");
                System.out.print("Seleccione una opción: ");
                opcion = readInt();
                switch (opcion) {
                    case 1:
                        for (Enfermero e : AdministracionPersonal.getEnfermeros()) {
                            e.mostrarInfo(); // Muestra la información de cada enfermero
                            System.out.println("------------------");
                        }
                        break;
                    case 2:
                        Enfermero.registrarEnfermero(); // Registra un nuevo enfermero
                        break;
                    case 3:
                        System.out.print("Ingrese el ID del enfermero a actualizar: ");
                        int idActualizar = readInt();
                        Enfermero enfermeroAActualizar = AdministracionPersonal.buscarEnfermeroPorId(idActualizar);
                        if (enfermeroAActualizar != null) {
                            enfermeroAActualizar.actualizarEnfermero(); // Actualiza la información del enfermero
                        } else {
                            System.out.println("Enfermero no encontrado.");
                        }
                        break;
                    case 4:
                        Enfermero.eliminarEnfermero(); // Elimina un enfermero
                        break;
                    case 0:
                        System.out.println("Volviendo al menú Jefe de Personal...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error en gestión de enfermeros: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    /**
     * Menú para los enfermeros.
     * Permite gestionar pacientes y asignar triage.
     */
    private static void menuEnfermeros() {
        try {
            System.out.println("\n--- Menú Enfermeros ---");
            System.out.print("Ingrese el ID del enfermero que desea usar: ");
            int idEnfermero = readInt();
            Enfermero enfermero = AdministracionPersonal.buscarEnfermeroPorId(idEnfermero);
            if (enfermero == null) {
                System.out.println("Enfermero no encontrado.");
                return;
            }
            int opcion = -1;
            do {
                try {
                    System.out.println("\n--- Menú del Enfermero " + enfermero.getNombre() + " ---");
                    System.out.println("1. Ver pacientes disponibles");
                    System.out.println("2. Agregar Paciente");
                    System.out.println("3. Actualizar Paciente");
                    System.out.println("4. Eliminar asignación de triage");
                    System.out.println("5. Asignar Triage");
                    System.out.println("0. Volver");
                    System.out.print("Seleccione una opción: ");
                    opcion = readInt();
                    switch (opcion) {
                        case 1:
                            for (Paciente p : DatosPredeterminados.getPacientesRegistrados()) {
                                p.mostrarInfo();
                                System.out.println("------------------");
                            }
                            break;
                        case 2:
                            Paciente.registrarPaciente();
                            break;
                        case 3:
                            System.out.print("Ingrese el ID del paciente a actualizar: ");
                            int idPacienteActualizar = readInt();
                            Paciente pacienteActualizar = null;
                            for (Paciente p : DatosPredeterminados.getPacientesRegistrados()) {
                                if (p.getId() == idPacienteActualizar) {
                                    pacienteActualizar = p;
                                    break;
                                }
                            }
                            if (pacienteActualizar != null) {
                                pacienteActualizar.actualizarPaciente();
                            } else {
                                System.out.println("Paciente no encontrado.");
                            }
                            break;
                        case 4:
                            System.out.print("Ingrese el ID del paciente para eliminar asignación de triage: ");
                            int idPacienteEliminar = readInt();
                            Paciente pacienteEliminar = null;
                            for (Paciente p : DatosPredeterminados.getPacientesRegistrados()) {
                                if (p.getId() == idPacienteEliminar) {
                                    pacienteEliminar = p;
                                    break;
                                }
                            }
                            if (pacienteEliminar != null) {
                                pacienteEliminar.eliminarAsignacionTriage();
                                System.out.println("Asignación de triage eliminada para el paciente " + pacienteEliminar.getNombre() + ".");
                            } else {
                                System.out.println("Paciente no encontrado.");
                            }
                            break;
                        case 5:
                            System.out.print("Ingrese el ID del paciente para asignar Triage: ");
                            int idPacienteTriage = readInt();
                            Paciente pacienteTriage = null;
                            for (Paciente p : DatosPredeterminados.getPacientesRegistrados()) {
                                if (p.getId() == idPacienteTriage) {
                                    pacienteTriage = p;
                                    break;
                                }
                            }
                            if (pacienteTriage != null) {
                                enfermero.asignarTriage(pacienteTriage);
                                System.out.print("¿Desea asignar cama? (s/n): ");
                                String asignarCama = Persona.SCANNER.nextLine();
                                if (asignarCama.equalsIgnoreCase("s")) {
                                    hospitalizacion.asignarCama(pacienteTriage);
                                }
                            } else {
                                System.out.println("Paciente no encontrado.");
                            }
                            break;
                        case 0:
                            System.out.println("Volviendo al Menú Principal...");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                } catch (Exception e) {
                    System.out.println("Error en el menú de enfermeros: " + e.getMessage());
                }
            } while (opcion != 0);
        } catch (Exception e) {
            System.out.println("Error al ingresar el ID del enfermero: " + e.getMessage());
        }
    }

    /**
     * Menú para los médicos.
     * Permite evaluar pacientes y generar informes.
     */
    private static void menuMedicos() {
        try {
            System.out.println("\n--- Menú Médicos ---");
            System.out.print("Ingrese el ID del médico que desea usar: ");
            int idMedico = readInt();
            Medico medico = AdministracionPersonal.buscarMedicoPorId(idMedico);
            if (medico == null) {
                System.out.println("Médico no encontrado.");
                return;
            }
            int opcion = -1;
            do {
                try {
                    System.out.println("\n--- Menú del Médico " + medico.getNombre() + " ---");
                    System.out.println("1. Evaluar Triage (Consultar y tratar paciente)");
                    System.out.println("0. Volver");
                    System.out.print("Seleccione una opción: ");
                    opcion = readInt();
                    switch (opcion) {
                        case 1:
                            System.out.print("Ingrese el ID del paciente a evaluar: ");
                            int idPacienteEvaluar = readInt();
                            Paciente pacienteEvaluar = null;
                            for (Paciente p : DatosPredeterminados.getPacientesRegistrados()) {
                                if (p.getId() == idPacienteEvaluar) {
                                    pacienteEvaluar = p;
                                    break;
                                }
                            }
                            if (pacienteEvaluar != null) {
                                if (pacienteEvaluar.getSintomas().isEmpty()) {
                                    System.out.println("El paciente no tiene un triage asignado.");
                                } else {
                                    // El médico atiende al paciente usando el triage ya asignado
                                    medico.atenderPaciente(pacienteEvaluar);
                                    // Generar y mostrar el informe de tratamiento
                                    TratamientoMedico tratamiento = new TratamientoMedico();
                                    tratamiento.generarInformeTratamiento(pacienteEvaluar);
                                }
                            } else {
                                System.out.println("Paciente no encontrado.");
                            }
                            break;
                        case 0:
                            System.out.println("Volviendo al Menú Principal...");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                } catch (Exception e) {
                    System.out.println("Error en el menú de médicos: " + e.getMessage());
                }
            } while (opcion != 0);
        } catch (Exception e) {
            System.out.println("Error al ingresar el ID del médico: " + e.getMessage());
        }
    }

    /**
     * Menú para la hospitalización.
     * Permite gestionar camas y dar de alta a pacientes.
     */
    private static void menuHospitalizacion() {
        int opcion = -1;
        do {
            try {
                System.out.println("\n--- Menú Hospitalización ---");
                System.out.println("1. Ver Pacientes Hospitalizados");
                System.out.println("2. Consultar Recibo y Dar de Alta");
                System.out.println("0. Volver");
                System.out.print("Seleccione una opción: ");
                opcion = readInt();
                switch (opcion) {
                    case 1:
                        hospitalizacion.verPacientesHospitalizados();
                        hospitalizacion.mostrarEstadoCamas();
                        break;
                    case 2:
                        System.out.print("Ingrese el ID del paciente a dar de alta: ");
                        int idAlta = readInt();
                        Paciente pacienteAlta = null;
                        for (Paciente p : DatosPredeterminados.getPacientesRegistrados()) {
                            if (p.getId() == idAlta) {
                                pacienteAlta = p;
                                break;
                            }
                        }
                        if (pacienteAlta != null) {
                            // Imprimir todos los datos del paciente
                            System.out.println("\n--- Datos del Paciente ---");
                            pacienteAlta.mostrarInfo();
                            
                            // Generar e imprimir el recibo del tratamiento
                            System.out.println("\n--- Recibo de Tratamiento ---");
                            TratamientoMedico tratamiento = new TratamientoMedico();
                            tratamiento.generarRecibo(pacienteAlta);
                            
                            // Dar de alta: liberar la cama y eliminar todos los datos del paciente
                            hospitalizacion.darDeAlta(pacienteAlta);
                            DatosPredeterminados.eliminarPaciente(pacienteAlta);
                        } else {
                            System.out.println("Paciente no encontrado.");
                        }
                        break;
                    case 0:
                        System.out.println("Volviendo al Menú Principal...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error en el menú de hospitalización: " + e.getMessage());
            }
        } while (opcion != 0);
    }
}
