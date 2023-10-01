import java.util.ArrayList;
import java.util.List;

public class ConjuntoMediciones {

    private ArrayList<Mediciones> mediciones;
    public ConjuntoMediciones(){
        this.mediciones = new ArrayList<Mediciones>();

    }
    public void agregarMediciones(int cantidad,float referencia){

        for(int i = 0; i < cantidad; i++) {
            Mediciones nuevaCalibracion = new Mediciones();
            agregar(nuevaCalibracion);
        }
    }
    public void agregar(Mediciones nuevaMedicion){
        mediciones.add(nuevaMedicion);
    }

    public int numMediciones(){
        return mediciones.size();
    }

    public Mediciones recuperar(int p){
        return mediciones.get(p);
    }

    public List<Mediciones> getMediciones() {
        return mediciones;
    }
    public boolean isEmpty() {
        return mediciones.isEmpty();
    }
    public void agregarMediciones(List<Mediciones> medicionesCalibracion) {
        mediciones.addAll(medicionesCalibracion);
    }
}
