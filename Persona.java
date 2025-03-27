import java.util.Scanner;
public abstract class Persona {
    private int id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;
    protected static final Scanner SCANNER = new Scanner(System.in);


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

    // Método abstracto para mostrar la información de la persona
    public abstract void mostrarInfo();

    // Métodos de validación y solicitud de datos antes de la creación del objeto
    public static int solicitarId() {
        System.out.print("Ingrese el ID: ");
        while (!SCANNER.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            SCANNER.next(); // Descartar entrada inválida.
        }
        int id = SCANNER.nextInt();
        SCANNER.nextLine(); // Consumir el salto de línea pendiente.
        return id;
    }

    public static String solicitarNombre() {
        System.out.print("Ingrese el nombre: ");
        return SCANNER.nextLine();
    }

    public static String solicitarTelefono() {
        System.out.print("Ingrese el teléfono: ");
        return SCANNER.nextLine();
    }

    public static String solicitarDireccion() {
        System.out.print("Ingrese la dirección: ");
        return SCANNER.nextLine();
    }

    public static String solicitarCorreo() {
        System.out.print("Ingrese el correo: ");
        return SCANNER.nextLine();
    }
}
