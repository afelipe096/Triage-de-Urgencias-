import java.util.Scanner;

/**
 * Clase abstracta que representa a una persona.
 */
public abstract class Persona {
    private int id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;

    // Constructor de la clase Persona
    public Persona(int id, String nombre, String telefono, String direccion, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    // Métodos getter y setter para los atributos de la clase
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

    // Método abstracto para mostrar la información de la persona
    public abstract void mostrarInfo();

    // Métodos de validación antes de la creación del objeto
    public static int solicitarId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID: ");
        return scanner.nextInt();
    }

    public static String solicitarNombre() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        return scanner.nextLine();
    }

    public static String solicitarTelefono() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el teléfono: ");
        return scanner.nextLine();
    }

    public static String solicitarDireccion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la dirección: ");
        return scanner.nextLine();
    }

    public static String solicitarCorreo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el correo: ");
        return scanner.nextLine();
    }
}