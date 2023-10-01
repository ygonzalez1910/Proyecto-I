import java.util.ArrayList;

public class ConjuntoInstrumentos {
    public ConjuntoInstrumentos() {
        this.instrumentos = new ArrayList<Instrumento>();
    }
    public void agregarInstrumento(String serie, String descripcion,int minimo, int maximo, int tolerancia, String tipo){
        Instrumento nuevoInstrumento = new Instrumento(serie,descripcion,minimo,maximo,tolerancia,tipo);
        agregar(nuevoInstrumento);
    }
    public int numInstrumento(){
        return instrumentos.size();
    }
    public Instrumento recuperar(int a){
        return instrumentos.get(a);
    }
    public String buscar(String descripcion){
        for(int i = 0; i < instrumentos.size(); i++){
            if(instrumentos.get(i).getDescripcion().equals(descripcion)){
                return instrumentos.get(i).toString();
            }
        }
        return "El instrumento no fue encontrado";
    }
    public void borrar(String serie, String descripcion, int minimo, int maximo, int tolerancia, String tipo) {
        for (int i = 0; i < instrumentos.size(); i++) {
            Instrumento instrumento = instrumentos.get(i);
            if (instrumento.getSerie().equals(serie) &&
                    instrumento.getDescripcion().equals(descripcion) &&
                    instrumento.getMinimo() == minimo &&
                    instrumento.getMaximo() == maximo &&
                    instrumento.getTolerancia() == tolerancia &&
                    instrumento.getTipo().equals(tipo)) {
                instrumentos.remove(i);
                i--; // Ajusta el índice después de eliminar un elemento
            }
        }
    }

    public void agregar(Instrumento nuevoInstrumento){
        instrumentos.add(nuevoInstrumento);
    }
    private ArrayList<Instrumento> instrumentos;

}
