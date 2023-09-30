import org.w3c.dom.Document;
import org.w3c.dom.Node;
public class Mediciones {
    private int medida;
    private float referencia;
    private double lectura;
    public Mediciones(int medida, float referencia, double lectura) {
        this.medida = medida;
        this.referencia = referencia; //hacer la referencia automaticamente
        this.lectura = lectura;
    }

    public Mediciones(int medida) {
        this.medida = medida;
    }
    public int generarReferencia(int cantMedicines){
        Calibraciones calibraciones = null;
        double referencia = 0.0;
        referencia = (double) 90 / calibraciones.getCantMediciones();
        return (int) referencia;
    }
    public int getMedida() {
        return medida;
    }

    public void setMedida(int medida) {
        this.medida = medida;
    }

    public float getReferencia() {
        return referencia;
    }

    public void setReferencia(float referencia) {
        this.referencia = referencia;
    }

    public double getLectura() {
        return lectura;
    }

    public void setLectura(double lectura) {
        this.lectura = lectura;
    }

    @Override
    public String toString() {
        return "Mediciones{" +
                "medida=" + medida +
                ", referencia=" + referencia +
                ", lectura=" + lectura +
                '}';
    }
    public String getNodeName() {
        return DESCRIPCION_XML;
    }

    public Node toXML(Document doc) {
        //Aquí se le da el nombre de la etiqueta
        Node r = doc.createElement(getNodeName());
        r.appendChild(UtilidadesXML.crearNodo(doc, "Medicion:", String.valueOf(medida)));
        r.appendChild(UtilidadesXML.crearNodo(doc, "Referencia:", String.valueOf(referencia)));
        r.appendChild(UtilidadesXML.crearNodo(doc, "Lectura:", String.valueOf(lectura)));

        return r;
    }

    public Object[] toArray(){
        Object[] r = new Object[3];
        r[0] = medida;
        r[1] = referencia;
        r[2] = lectura;
        return r;
    }
    private static final String[] NOMBRE_CAMPOS = {"Medida", "Referencia", "Lectura"};
    public static String[] nombreCampos() {
        return NOMBRE_CAMPOS;
    }
    public static final String DESCRIPCION_XML = "Mediciones";
}
