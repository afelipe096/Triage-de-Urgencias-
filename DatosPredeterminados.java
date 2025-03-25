import java.util.ArrayList;
import java.util.List;

public class DatosPredeterminados {

    // Método para cargar una lista de médicos predeterminados
    public static List<Medico> cargarMedicos() {
        List<Medico> medicos = new ArrayList<>();
        medicos.add(new Medico(1, "Dr. Juan Pérez", "123456789", "Calle Falsa 123", "juan.perez@hospital.com", "Cardiología"));
        medicos.add(new Medico(2, "Dra. Ana Gómez", "987654321", "Avenida Siempre Viva 456", "ana.gomez@hospital.com", "Neurología"));
        medicos.add(new Medico(3, "Dr. Luis Martínez", "555666777", "Calle 5", "luis.martinez@hospital.com", "Pediatría"));
        medicos.add(new Medico(4, "Dra. Sofía Torres", "888999000", "Calle 6", "sofia.torres@hospital.com", "Dermatología"));
        medicos.add(new Medico(5, "Dr. Miguel Ángel", "111222333", "Calle 7", "miguel.angel@hospital.com", "Gastroenterología"));
        medicos.add(new Medico(6, "Dra. Elena Ruiz", "444555666", "Calle 8", "elena.ruiz@hospital.com", "Endocrinología"));
        // Agregar más médicos según sea necesario
        return medicos;
    }

    // Método para cargar una lista de enfermeros predeterminados
    public static List<Enfermero> crearEnfermeros() {
        List<Enfermero> enfermeros = new ArrayList<>();
        enfermeros.add(new Enfermero(1, "Enf. Carlos López", "123123123", "Calle 1", "carlos.lopez@hospital.com", "Urgencias", "Mañana"));
        enfermeros.add(new Enfermero(2, "Enf. María Rodríguez", "321321321", "Calle 2", "maria.rodriguez@hospital.com", "Pediatría", "Noche"));
        enfermeros.add(new Enfermero(3, "Enf. José Hernández", "444555666", "Calle 7", "jose.hernandez@hospital.com", "Traumatología", "Tarde"));
        enfermeros.add(new Enfermero(4, "Enf. Laura García", "777888999", "Calle 8", "laura.garcia@hospital.com", "Oncología", "Mañana"));
        enfermeros.add(new Enfermero(5, "Enf. Luis Fernández", "999000111", "Calle 9", "luis.fernandez@hospital.com", "Cardiología", "Noche"));
        enfermeros.add(new Enfermero(6, "Enf. Ana Torres", "222333444", "Calle 10", "ana.torres@hospital.com", "Neurología", "Tarde"));
        // Agregar más enfermeros según sea necesario
        return enfermeros;
    }

    // Método para cargar una lista de pacientes predeterminados
    public static List<Paciente> crearPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente(1, "Pedro Sánchez", "111222333", "Calle 3", "pedro.sanchez@correo.com", null, null, null));
        pacientes.add(new Paciente(2, "Laura Martínez", "444555666", "Calle 4", "laura.martinez@correo.com", null, null, null));
        pacientes.add(new Paciente(3, "Carlos Gómez", "777888999", "Calle 9", "carlos.gomez@correo.com", null, null, null));
        pacientes.add(new Paciente(4, "Ana López", "000111222", "Calle 10", "ana.lopez@correo.com", null, null, null));
        pacientes.add(new Paciente(5, "Marta Díaz", "555666777", "Calle 11", "marta.diaz@correo.com", null, null, null));
        pacientes.add(new Paciente(6, "Jorge Ramírez", "888999000", "Calle 12", "jorge.ramirez@correo.com", null, null, null));
        // Agregar más pacientes según sea necesario
        return pacientes;
    }
}
