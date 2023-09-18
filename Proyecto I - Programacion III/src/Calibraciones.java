import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Calibraciones {
    public Calibraciones(double numeroCalibracion, String fecha, int mediciones) {
        this.numeroCalibracion = numeroCalibracion;
        this.numeroBusqueda = numeroBusqueda;
        this.fecha = fecha;
        this.mediciones = mediciones;
    }

    @Override
    public String toString() {
        return "Calibraciones{" +
                "numeroCalibracion=" + numeroCalibracion +
                ", numeroBusqueda=" + numeroBusqueda +
                ", fecha='" + fecha + '\'' +
                ", mediciones=" + mediciones +
                '}';
    }

    public double getNumeroCalibracion() {
        return numeroCalibracion;
    }

    public void setNumeroCalibracion(double numeroCalibracion) {
        this.numeroCalibracion = numeroCalibracion;
    }

    public double getNumeroBusqueda() {
        return numeroBusqueda;
    }

    public void setNumeroBusqueda(double numeroBusqueda) {
        this.numeroBusqueda = numeroBusqueda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMediciones() {
        return mediciones;
    }

    public void setMediciones(int mediciones) {
        this.mediciones = mediciones;
    }
    public static String[] nombreCampos() {
        return NOMBRE_CAMPOS;
    }
    public String getNodeName() {
        return DESCRIPCION_XML;
    }

    public Node toXML(Document doc) {
        //Aquí se le da el nombre de la etiqueta
        Node r = doc.createElement(getNodeName());
        r.appendChild(UtilidadesXML.crearNodo(doc, "Numero de calibraciones", Double.parseDouble(numeroCalibracion));
        r.appendChild(UtilidadesXML.crearNodo(doc, "Fecha", fecha));
        r.appendChild(UtilidadesXML.crearNodo(doc, "Numero de mediciones", Integer.parseInt(mediciones));

        return r;
    }
public Object[] toArray(){
    Object[] r = new Object[4];
    r[0] = numeroCalibracion;
    r[1] = fecha;
    r[2] = mediciones;
    r[3] = numeroBusqueda;
    return r;
}
    private static final String[] NOMBRE_CAMPOS = {"Numero", "Fecha", "Mediciones", "Numero"};
    private double numeroCalibracion;
    private double numeroBusqueda;
    private String fecha;
    private int mediciones;
}
