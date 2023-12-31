import org.w3c.dom.Document;
import org.w3c.dom.Node;

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
                "\n  Código: '" + codigo + '\'' +
                "\n  Nombre: '" + nombre + '\'' +
                "\n  Unidad: '" + unidad + '\'' +
                "\n}";
    }

    public String getNodeName() {
        return DESCRIPCION_XML;
    }

    public Node toXML(Document doc) {
        // Aquí se le da el nombre de la etiqueta en minúsculas sin espacios
        Node r = doc.createElement(getNodeName());
        r.appendChild(UtilidadesXML.crearNodo(doc, "codigo", codigo));
        r.appendChild(UtilidadesXML.crearNodo(doc, "nombre", nombre));
        r.appendChild(UtilidadesXML.crearNodo(doc, "unidad", unidad));

        return r;
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

    private static final String[] NOMBRE_CAMPOS = {"Codigo", "Nombre", "Unidad" };
    public static final String DESCRIPCION_XML = "TIPOSDEINSTRUMENTO";
}
