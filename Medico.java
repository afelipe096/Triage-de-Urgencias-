public class Medico extends Persona {
    private String especialidad;

    public Medico(int id, String nombre, String telefono, String direccion, String correo, String especialidad) {
        super(id, nombre, telefono, direccion, correo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Correo: " + getCorreo());
        System.out.println("📌 Tipo: Médico");
        System.out.println("Especialidad: " + especialidad);
    }

    public void atenderPaciente(Paciente paciente) {
        System.out.println("\n🩺 " + getNombre() + " está atendiendo a " + paciente.getNombre());
        // Agregar un registro al historial médico del paciente
        paciente.getHistorial().agregarRegistro("Atendido por " + getNombre() + " (" + especialidad + ")");
    }
}
