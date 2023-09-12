public class Instrumento {
    public Instrumento(String serie, String descripcion, int minimo, int maximo, int tolerancia, String tipo) {
        this.serie = serie;
        this.descripcion = descripcion;
        this.minimo = minimo;
        this.maximo = maximo;
        this.tolerancia = tolerancia;
        this.tipo = tipo;
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
        return r;
    }

    public static String[] nombreCampos() {
        return NOMBRE_CAMPOS;
    }

    @Override
    public String toString() {
        return "Instrumento{" +
                "serie='" + serie + '\'' +
                ", descipcion='" + descripcion + '\'' +
                ", minimo=" + minimo +
                ", maximo=" + maximo +
                ", tolerancia=" + tolerancia +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    private static final String[] NOMBRE_CAMPOS = {"Serie", "Descripcion", "Minimo", "Maximo", "Tolerancia", "Tipo"};
    private String serie;
    private String descripcion;
    private int minimo;
    private int maximo;
    private int tolerancia;
    private String tipo;
}
