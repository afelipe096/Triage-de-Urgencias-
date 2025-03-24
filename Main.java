import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Medico> medicos = DatosPredeterminados.cargarMedicos();
        List<Enfermero> enfermeros = DatosPredeterminados.crearEnfermeros();
        List<Paciente> pacientes = DatosPredeterminados.crearPacientes();

        while (true) {
            try {
                System.out.println("\n=== Código del Hospital - Menú Principal ===");
                System.out.println("1. Verificar Médicos");
                System.out.println("2. Verificar Enfermeros");
                System.out.println("3. Comenzar Recorrido");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
        
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
        
                switch (opcion) {
                    case 1:
                        menuMedicos(scanner, medicos, pacientes);
                        break;
                    case 2:
                        menuEnfermeros(scanner, enfermeros, pacientes);
                        break;
                    case 3:
                        menuRecorrido(scanner, pacientes, medicos, enfermeros);
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.nextLine(); // Limpiar entrada inválida
            }
        }
    }
                                    
    // =================== Menú Verificar Médicos ===================
    private static void menuMedicos(Scanner scanner, List<Medico> medicos, List<Paciente> pacientes) {
        while (true) {
            System.out.println("\n=== Menú Verificar Médicos ===");
            System.out.println("1. Agregar Médico");
            System.out.println("2. Eliminar Médico");
            System.out.println("3. Actualizar Médico");
            System.out.println("4. Ver Médicos");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los datos del nuevo médico:");
                    Medico nuevoMedico = new Medico(
                        Persona.solicitarId(),
                        Persona.solicitarNombre(),
                        Persona.solicitarTelefono(),
                        Persona.solicitarDireccion(),
                        Persona.solicitarCorreo(),
                        solicitarEspecialidad(scanner)
                    );
                    medicos.add(nuevoMedico);
                    System.out.println("✅ Médico agregado exitosamente.");
                    break;
                case 2:
                    System.out.print("Ingrese el ID del médico a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    medicos.removeIf(medico -> medico.getId() == idEliminar);
                    System.out.println("✅ Médico eliminado exitosamente.");
                    break;
                case 3:
                    System.out.print("Ingrese el ID del médico a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    for (Medico medico : medicos) {
                        if (medico.getId() == idActualizar) {
                            System.out.println("Ingrese los nuevos datos del médico:");
                            medico.setNombre(Persona.solicitarNombre());
                            medico.setTelefono(Persona.solicitarTelefono());
                            medico.setDireccion(Persona.solicitarDireccion());
                            medico.setCorreo(Persona.solicitarCorreo());
                            medico.setEspecialidad(solicitarEspecialidad(scanner));
                            System.out.println("✅ Médico actualizado exitosamente.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("\n=== Lista de Médicos ===");
                    for (Medico medico : medicos) {
                        medico.mostrarInfo();
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    // =================== Menú Verificar Enfermeros ===================
    private static void menuEnfermeros(Scanner scanner, List<Enfermero> enfermeros, List<Paciente> pacientes) {
        while (true) {
            System.out.println("\n=== Menú Verificar Enfermeros ===");
            System.out.println("1. Agregar Enfermero");
            System.out.println("2. Eliminar Enfermero");
            System.out.println("3. Actualizar Enfermero");
            System.out.println("4. Ver Enfermeros");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los datos del nuevo enfermero:");
                    Enfermero nuevoEnfermero = new Enfermero(
                        Persona.solicitarId(),
                        Persona.solicitarNombre(),
                        Persona.solicitarTelefono(),
                        Persona.solicitarDireccion(),
                        Persona.solicitarCorreo(),
                        solicitarEspecialidad(scanner),
                        "Noche"
                    );
                    enfermeros.add(nuevoEnfermero);
                    System.out.println("✅ Enfermero agregado exitosamente.");
                    break;
                case 2:
                    System.out.print("Ingrese el ID del enfermero a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    enfermeros.removeIf(enfermero -> enfermero.getId() == idEliminar);
                    System.out.println("✅ Enfermero eliminado exitosamente.");
                    break;
                case 3:
                    System.out.print("Ingrese el ID del enfermero a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    for (Enfermero enfermero : enfermeros) {
                        if (enfermero.getId() == idActualizar) {
                            System.out.println("Ingrese los nuevos datos del enfermero:");
                            enfermero.setNombre(Persona.solicitarNombre());
                            enfermero.setTelefono(Persona.solicitarTelefono());
                            enfermero.setDireccion(Persona.solicitarDireccion());
                            enfermero.setCorreo(Persona.solicitarCorreo());
                            enfermero.setEspecialidad(solicitarEspecialidad(scanner));
                            System.out.println("✅ Enfermero actualizado exitosamente.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("\n=== Lista de Enfermeros ===");
                    for (Enfermero enfermero : enfermeros) {
                        enfermero.mostrarInfo();
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    // =================== Menú Comenzar Recorrido ===================
    private static void menuRecorrido(Scanner scanner, List<Paciente> pacientes, List<Medico> medicos, List<Enfermero> enfermeros) {
        while (true) {
            System.out.println("\n=== Menú Comenzar Recorrido ===");
            System.out.println("1. Verificar Pacientes Registrados");
            System.out.println("2. Agregar Pacientes");
            System.out.println("3. Atender Pacientes");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("\n=== Lista de Pacientes ===");
                    for (Paciente paciente : pacientes) {
                        paciente.mostrarInfo();
                    }
                    break;
                case 2:
                    System.out.println("Ingrese los datos del nuevo paciente:");
                    Paciente nuevoPaciente = new Paciente(
                        Persona.solicitarId(),
                        Persona.solicitarNombre(),
                        Persona.solicitarTelefono(),
                        Persona.solicitarDireccion(),
                        Persona.solicitarCorreo(),
                        null, // Médico asignado
                        null, // Enfermero asignado
                        null  // Número de cama
                    );
                    pacientes.add(nuevoPaciente);
                    System.out.println("✅ Paciente agregado exitosamente.");
                    break;
                case 3:
                    System.out.println("Atendiendo pacientes...");
                    for (Paciente paciente : pacientes) {
                        if (paciente.getMedicoAsignado() != null) {
                            paciente.getMedicoAsignado().atenderPaciente(paciente);
                        } else {
                            System.out.println("El paciente " + paciente.getNombre() + " no tiene médico asignado.");
                        }
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static String solicitarEspecialidad(Scanner scanner) {
        System.out.print("Ingrese la especialidad: ");
        return scanner.nextLine();
    }
}