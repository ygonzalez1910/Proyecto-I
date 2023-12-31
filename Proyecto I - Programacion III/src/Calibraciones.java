import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;

public class Calibraciones {
    private List<Mediciones> medicionesList;
    public int getCantMediciones() {
        return cantMediciones;
    }

    public void setCantMediciones(int cantMediciones) {
        this.cantMediciones = cantMediciones;
    }

    public void setMediciones(List<Mediciones> mediciones) {
        this.medicionesList = mediciones;
    }


    public Calibraciones(int numeroCalibracion, String fecha, int cantMediciones) {
        this.numeroCalibracion = numeroCalibracion;
        this.numeroBusqueda = numeroBusqueda;
        this.fecha = fecha;
        this.cantMediciones = cantMediciones;
        this.mediciones = new ConjuntoMediciones();
    }

    @Override
    public String toString() {
        return "Calibraciones{" +
                "\n  Número de Calibración: " + numeroCalibracion +
                "\n  Fecha: '" + fecha + '\'' +
                "\n  Cantidad de mediciones: " + cantMediciones +
                "\n}";
    }

    public int getNumeroCalibracion() {
        return numeroCalibracion;
    }

    public void setNumeroCalibracion(int numeroCalibracion) {
        this.numeroCalibracion = numeroCalibracion;
    }

    public String getNumeroBusqueda() {
        return numeroBusqueda;
    }

    public void setNumeroBusqueda(String numeroBusqueda) {
        this.numeroBusqueda = numeroBusqueda;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ConjuntoMediciones getMediciones() {
        return mediciones;
    }

    public void setMediciones(int mediciones) {
        this.cantMediciones = mediciones;
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
        r.appendChild(UtilidadesXML.crearNodo(doc, "NumeroDecalibraciones", String.valueOf(numeroCalibracion)));
        r.appendChild(UtilidadesXML.crearNodo(doc, "Fecha", fecha));
        r.appendChild(UtilidadesXML.crearNodo(doc, "NumeroDeMediciones", String.valueOf(mediciones)));
        return r;
    }

    public Object[] toArray(){
        Object[] r = new Object[3];
        r[0] = numeroCalibracion;
        r[1] = fecha;
        r[2] = cantMediciones;
        return r;
    }


    private static final String[] NOMBRE_CAMPOS = {"Numero", "Fecha", "Mediciones"};
    private int numeroCalibracion;
    private String numeroBusqueda;
    private String fecha;
    private int cantMediciones;
    private ConjuntoMediciones mediciones;
    public static final String DESCRIPCION_XML = "CALIBRACIONES";
}
