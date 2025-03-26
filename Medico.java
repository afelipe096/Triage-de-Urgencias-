import java.util.Scanner;

/**
 * Esta clase representa a un médico y contiene métodos para manejar las operaciones relacionadas con los médicos.
 */
public class Medico extends Persona {
    private String especialidad;

    // Constructor de la clase Medico
    public Medico(int id, String nombre, String telefono, String direccion, String correo, String especialidad) {
        super(id, nombre, telefono, direccion, correo);
        this.especialidad = especialidad;
    }

    // Métodos getter y setter para los atributos de la clase
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Método para mostrar la información del médico
    @Override
    public void mostrarInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Correo: " + getCorreo());
        System.out.println(" Tipo: Médico");
        System.out.println("Especialidad: " + especialidad);
    }

    // Método para atender a un paciente
    public void atenderPaciente(Paciente paciente) {
        System.out.println("\n🩺 " + getNombre() + " está atendiendo a " + paciente.getNombre());
        // Agregar un registro al historial médico del paciente
        paciente.getHistorial().agregarRegistro("Atendido por " + getNombre() + " (" + especialidad + ")");
        
        // Continuar con la consulta del paciente utilizando el sistema de triage
        continuarConsulta(paciente);
    }

    // Método para continuar la consulta de un paciente utilizando el sistema de triage
    public void continuarConsulta(Paciente paciente) {
        Scanner scanner = new Scanner(System.in);
        Triage triage = new Triage();
        triage.mostrarCatalogo();

        System.out.println("\n🩺 " + getNombre() + " asignando triage al paciente...");
        
        while (true) {
            System.out.print("Ingrese el número de la enfermedad (0 para finalizar): ");
            int num = scanner.nextInt();
            if (num == 0) break; // Salir cuando el médico termine de asignar enfermedades
            
            triage.agregarEnfermedad(num);
        }

        // Evaluar y mostrar el diagnóstico final
        triage.evaluarPaciente(paciente);
        paciente.getHistorial().agregarRegistro("Diagnóstico realizado por " + getNombre() + " (" + especialidad + ")");
        
        // Mostrar el historial clínico actualizado
        System.out.println("\n Historial Clínico Actualizado:");
        System.out.println(paciente.getHistorial().obtenerHistorial());
    }
}
