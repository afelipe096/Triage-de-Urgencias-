import java.util.ArrayList;
import java.util.List;

public class DatosPredeterminados {
    public static List<Medico> cargarMedicos() {
        List<Medico> medicos = new ArrayList<>();
        medicos.add(new Medico(101, "Dr. Juan Pérez", "3214567890", "Calle A # 123", "juan.perez@hospital.com", "Cardiología"));
        medicos.add(new Medico(102, "Dr. Ana Gómez", "3123456789", "Carrera B # 456", "ana.gomez@hospital.com", "Pediatría"));
        medicos.add(new Medico(103, "Dr. Carlos Ramírez", "3109876543", "Avenida C # 789", "carlos.ramirez@hospital.com", "Traumatología"));
        medicos.add(new Medico(104, "Dr. Laura Martínez", "3156781234", "Calle D # 101", "laura.martinez@hospital.com", "Dermatología"));
        medicos.add(new Medico(105, "Dr. Luis Fernández", "3168974321", "Carrera H # 222", "luis.fernandez@hospital.com", "Neurología"));
        return medicos;
    }

    public static List<Enfermero> cargarEnfermeros() {
        List<Enfermero> enfermeros = new ArrayList<>();
        enfermeros.add(new Enfermero(201, "Enf. Andrés López", "3004561234", "Calle N # 888", "andres.lopez@hospital.com", "Cuidados intensivos", "Noche"));
        enfermeros.add(new Enfermero(202, "Enf. Camila Vega", "3117896542", "Carrera O # 999", "camila.vega@hospital.com", "Cuidados intensivos", "Día"));
        enfermeros.add(new Enfermero(203, "Enf. Diego Castro", "3209871234", "Avenida P # 101", "diego.castro@hospital.com", "Pediatría", "Noche"));
        enfermeros.add(new Enfermero(204, "Enf. Valeria Muñoz", "3126547890", "Calle Q # 202", "valeria.munoz@hospital.com", "Pediatría", "Día"));
        enfermeros.add(new Enfermero(205, "Enf. Fernando Ruiz", "3176543210", "Carrera R # 303", "fernando.ruiz@hospital.com", "Neurología", "Noche"));
        enfermeros.add(new Enfermero(206, "Enf. Natalia Jiménez", "3145678901", "Avenida S # 404", "natalia.jimenez@hospital.com", "Neurología", "Día"));
        enfermeros.add(new Enfermero(207, "Enf. Ricardo Salazar", "3198765432", "Calle T # 505", "ricardo.salazar@hospital.com", "Traumatología", "Noche"));
        enfermeros.add(new Enfermero(208, "Enf. Carolina Ortiz", "3103456789", "Carrera U # 606", "carolina.ortiz@hospital.com", "Traumatología", "Día"));
        enfermeros.add(new Enfermero(209, "Enf. Javier Gómez", "3182345678", "Avenida V # 707", "javier.gomez@hospital.com", "Dermatología", "Noche"));
        enfermeros.add(new Enfermero(210, "Enf. Andrea Castillo", "3124567890", "Calle W # 808", "andrea.castillo@hospital.com", "Dermatología", "Día"));
        return enfermeros;
    }

    public static List<Paciente> cargarPacientes(List<Medico> medicos, List<Enfermero> enfermeros) {
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente(301, "María López", "3004561234", "Calle X # 909", "maria.lopez@gmail.com", medicos.get(4), enfermeros.get(4), null));
        pacientes.add(new Paciente(302, "Pedro Rodríguez", "3117896542", "Carrera Y # 1010", "pedro.rodriguez@gmail.com", medicos.get(0), enfermeros.get(0), 1));
        pacientes.add(new Paciente(303, "Ana Ramírez", "3209871234", "Avenida Z # 1111", "ana.ramirez@gmail.com", medicos.get(1), enfermeros.get(1), 2));
        pacientes.add(new Paciente(304, "José Ramírez", "3182345678", "Calle AA # 1212", "jose.ramirez@gmail.com", medicos.get(2), enfermeros.get(6), null));
        return pacientes;
    }

    public static List<Enfermero> crearEnfermeros() {
        return cargarEnfermeros();
    }

    public static List<Paciente> crearPacientes() {
        List<Medico> medicos = cargarMedicos();
        List<Enfermero> enfermeros = cargarEnfermeros();
        return cargarPacientes(medicos, enfermeros);
    }

    public static List<Medico> crearMedicos() {
        return cargarMedicos();
    }
}
