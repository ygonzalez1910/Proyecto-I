import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Instrumento {
    public Instrumento(String serie, String descripcion, int minimo, int maximo, int tolerancia, String tipo) {
        this.serie = serie;
        this.descripcion = descripcion;
        this.minimo = minimo;
        this.maximo = maximo;
        this.tolerancia = tolerancia;
        this.tipo = tipo;
        this.caliInstrumento = new ConjuntoCalibraciones();
    }

    public ConjuntoCalibraciones getCaliInstrumento() {
        return caliInstrumento;
    }

    public void setCaliInstrumento(ConjuntoCalibraciones caliInstrumento) {
        this.caliInstrumento = caliInstrumento;
    }

    public String getSerie() {
        return serie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getMinimo() {
        return minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public int getTolerancia() {
        return tolerancia;
    }

    public String getTipo() {
        return tipo;
    }
    public Object[] toArray() {
        Object[] r = new Object[7];
        r[0] = serie;
        r[1] = descripcion;
        r[2] = minimo;
        r[3] = maximo;
        r[4] = tolerancia;
        r[5] = tipo;
        r[6] = caliInstrumento;
        return r;
    }
    public Node toXML(Document doc) {
        //Aquí se le da el nombre de la etiqueta
        Node r = doc.createElement(getNodeName());
        r.appendChild(UtilidadesXML.crearNodo(doc, "serie", serie));
        r.appendChild(UtilidadesXML.crearNodo(doc, "descripcion", descripcion));
        r.appendChild(UtilidadesXML.crearNodo(doc, "minimo", String.valueOf(minimo)));
        r.appendChild(UtilidadesXML.crearNodo(doc, "maximo", String.valueOf(maximo)));
        r.appendChild(UtilidadesXML.crearNodo(doc, "tolerancia", String.valueOf(tolerancia)));
        r.appendChild(UtilidadesXML.crearNodo(doc, "tipo", tipo));

        return r;
    }

    private String getNodeName() {

        return DESCRIPCION_XML;
    }

    public static String[] nombreInstrumentos() {
        return NOMBRE_INSTRUMENTOS;
    }

    @Override
    public String toString() {
        return "Instrumento" +
                "\n  Serie: '" + serie + '\'' +
                "\n  Descripción: '" + descripcion + '\'' +
                "\n  Mínimo: " + minimo +
                "\n  Máximo: " + maximo +
                "\n  Tolerancia: " + tolerancia +
                "\n  Tipo: '" + tipo + '\'';
    }


    private static final String[] NOMBRE_INSTRUMENTOS = {"Serie", "Descripcion", "Minimo", "Maximo", "Tolerancia", "Tipo"};
    private String serie;
    public static final String DESCRIPCION_XML = "INSTRUMENTO";
    private String descripcion;
    private int minimo;
    private int maximo;
    private int tolerancia;
    private String tipo;
    private ConjuntoCalibraciones caliInstrumento;
}
