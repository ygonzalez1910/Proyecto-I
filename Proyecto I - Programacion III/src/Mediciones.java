import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class Mediciones {
    private int medida;
    private double referencia;
    private String lectura;

    public Mediciones() {
        // Constructor vacío
    }

    public Mediciones(int medida, double referencia, String lectura) {
        this.medida = medida;
        this.referencia = referencia;
        this.lectura = lectura;
    }

    public static List<Mediciones> generarMediciones(int cantidadMediciones, double total) {
        List<Mediciones> mediciones = new ArrayList<>();

        double paso = total / cantidadMediciones;
        double referencia = 0.0;

        for (int i = 1; i <= cantidadMediciones; i++) {
            Mediciones medicion = new Mediciones(i, referencia, ""); // La lectura inicial se establece en 0
            mediciones.add(medicion);
            referencia += paso;
        }

        return mediciones;
    }

    public int getMedida() {
        return medida;
    }

    public void setMedida(int medida) {
        this.medida = medida;
    }

    public double getReferencia() {
        return referencia;
    }

    public void setReferencia(double referencia) {
        this.referencia = referencia;
    }

    public String getLectura() {
        return lectura;
    }

    public void setLectura(String lectura) {
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
