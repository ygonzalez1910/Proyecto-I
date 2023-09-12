public class TiposInstrumento {
    public TiposInstrumento(String codigo, String nombre, String unidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidad = unidad;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "TiposInstrumento{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", unidad='" + unidad + '\'' +
                '}';
    }
    public Object[] toArray() {
        Object[] r = new Object[5];
        r[0] = codigo;
        r[1] = nombre;
        r[2] = unidad;
        return r;
    }
    public static String[] nombreCampos() {
        return NOMBRE_CAMPOS;
    }
    public String getNombre() {
        return nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    private String codigo;
    private String nombre;
    private String unidad;

    private static final String[] NOMBRE_CAMPOS = {"Código", "Nombre", "Unidad" };
}
