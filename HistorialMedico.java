import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistorialMedico {

    private int pacienteId;
    private Paciente paciente;
    private List<String> registros;
    private Date fechaActualizacion;

    public HistorialMedico(int pacienteId, Paciente paciente) {
        this.pacienteId = pacienteId;
        this.paciente = paciente;
        this.registros = new ArrayList<>();
        this.fechaActualizacion = new Date();
    }

    public void agregarRegistro(String registro) {
        registros.add(registro);
        actualizarFecha();
    }

    private void actualizarFecha() {
        this.fechaActualizacion = new Date();
    }

    public String obtenerHistorial() {
        if (registros.isEmpty()) {
            return "No hay registros en el historial médico.";
        }
        return String.join("\n", registros) + "\nÚltima actualización: " + fechaActualizacion;
    }

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
