import java.util.ArrayList;

public class ConjuntoMediciones {

    private ArrayList<Mediciones> mediciones;
    public ConjuntoMediciones(){
        this.mediciones = new ArrayList<Mediciones>();

    }
    public void agregarMediciones(int cantidad,float referencia){

        for(int i = 0; i < cantidad; i++) {
            Mediciones nuevaCalibracion = new Mediciones(i,referencia,0);
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
}
