import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Esta clase representa el historial médico de un paciente.
 */
public class HistorialMedico {

    private int pacienteId;
    private Paciente paciente;
    private List<String> registros;
    private Date fechaActualizacion;

    // Constructor de la clase HistorialMedico
    public HistorialMedico(int pacienteId, Paciente paciente) {
        this.pacienteId = pacienteId;
        this.paciente = paciente;
        this.registros = new ArrayList<>();
        this.fechaActualizacion = new Date();
    }

    // Método para agregar un registro al historial médico
    public void agregarRegistro(String registro) {
        registros.add(registro);
        actualizarFecha();
    }

    // Método para actualizar la fecha de la última actualización del historial
    private void actualizarFecha() {
        this.fechaActualizacion = new Date();
    }

    // Método para obtener el historial médico en formato de texto
    public String obtenerHistorial() {
        if (registros.isEmpty()) {
            return "No hay registros en el historial médico.";
        }
        StringBuilder historial = new StringBuilder();
        for (String registro : registros) {
            historial.append(registro).append("\n");
        }
        return historial.toString() + "Última actualización: " + fechaActualizacion;
    }

    // Métodos getter para los atributos de la clase
    public int getPacienteId() {
        return pacienteId;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }
}
