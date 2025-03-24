import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Persona {
    private int id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;

    public Persona(int id, String nombre, String telefono, String direccion, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public abstract void mostrarInfo();

    // Métodos de validación antes de la creación del objeto
    public static int solicitarId() {
        Scanner scanner = new Scanner(System.in);
        int id;
        while (true) {
            System.out.print("Ingrese un ID: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                if (id > 0) return id;
                else System.out.println("Error: El ID debe ser mayor que 0.");
            } else {
                System.out.println("Error: Debe ingresar un número.");
                scanner.next(); // Limpiar entrada inválida
            }
        }
    }

    public static String solicitarNombre() {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        while (true) {
            System.out.print("Ingrese el nombre: ");
            nombre = scanner.nextLine().trim();
            if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) return nombre;
            else System.out.println("Error: El nombre solo debe contener letras y espacios.");
        }
    }

    public static String solicitarTelefono() {
        Scanner scanner = new Scanner(System.in);
        String telefono;
        while (true) {
            System.out.print("Ingrese el teléfono (10 dígitos): ");
            telefono = scanner.nextLine().trim();
            if (telefono.matches("\\d{10}")) return telefono;
            else System.out.println("Error: El teléfono debe tener exactamente 10 dígitos numéricos.");
        }
    }

    public static String solicitarDireccion() {
        Scanner scanner = new Scanner(System.in);
        String direccion;
        while (true) {
            System.out.print("Ingrese la dirección: ");
            direccion = scanner.nextLine().trim();
            if (!direccion.isEmpty()) return direccion;
            else System.out.println("Error: La dirección no puede estar vacía.");
        }
    }

    public static String solicitarCorreo() {
        Scanner scanner = new Scanner(System.in);
        String correo;
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        while (true) {
            System.out.print("Ingrese el correo electrónico: ");
            correo = scanner.nextLine().trim();
            if (Pattern.matches(emailRegex, correo)) return correo;
            else System.out.println("Error: El correo electrónico no es válido.");
        }
    }
}