import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Calibraciones {
    public int getCantMediciones() {
        return cantMediciones;
    }

    public void setCantMediciones(int cantMediciones) {
        this.cantMediciones = cantMediciones;
    }

    public void setMediciones(ConjuntoMediciones mediciones) {
        this.mediciones = mediciones;
    }

    public Calibraciones(int numeroCalibracion, String fecha, int mediciones) {
        this.numeroCalibracion = numeroCalibracion;
        this.numeroBusqueda = numeroBusqueda;
        this.fecha = fecha;
        this.cantMediciones = mediciones;
        this.mediciones = new ConjuntoMediciones();
    }

    @Override
    public String toString() {
        return "Calibraciones{" +
                "\n  Número de Calibración: " + numeroCalibracion +
                "\n  Número de Búsqueda: " + numeroBusqueda +
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
        r.appendChild(UtilidadesXML.crearNodo(doc, "Numero de calibraciones", String.valueOf(numeroCalibracion)));
        r.appendChild(UtilidadesXML.crearNodo(doc, "Fecha", fecha));
        r.appendChild(UtilidadesXML.crearNodo(doc, "Numero de mediciones", String.valueOf(mediciones)));
        r.appendChild(UtilidadesXML.crearNodo(doc, "Numero de mediciones", " "+mediciones));
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

    public void crearMediciones(int n,int maximo, int minimo){
        for(int i = 0; i<n;i++){
            float referencia = (maximo + minimo)/n-i;
            mediciones.agregarMediciones(i,referencia);
        }
    }

    private static final String[] NOMBRE_CAMPOS = {"Numero", "Fecha", "Mediciones"};
    private int numeroCalibracion;
    private double numeroBusqueda;
    private String fecha;
    private int cantMediciones;
    private ConjuntoMediciones mediciones;
    public static final String DESCRIPCION_XML = "CALIBRACIONES";
}
