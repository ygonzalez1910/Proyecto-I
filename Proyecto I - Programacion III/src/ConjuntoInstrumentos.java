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
    public void borrar(String serie, String descripcion,int minimo, int maximo, int tolerancia, String tipo){
        for(int i = 0; i < instrumentos.size(); i++){
            if(instrumentos.get(i).getSerie().equals(serie) && instrumentos.get(i).getDescripcion().equals(descripcion) && instrumentos.get(i).getMinimo().equals(minimo) &&instrumentos.get(i).getMaximo().equals(maximo) && instrumentos.get(i).getTolerancia().equals(tolerancia) && instrumentos.get(i).getTipo().equals(tipo)  ){
                instrumentos.remove(i);
            }
        }
    }
    public void agregar(Instrumento nuevoInstrumento){
        instrumentos.add(nuevoInstrumento);
    }
    private ArrayList<Instrumento> instrumentos;

}
