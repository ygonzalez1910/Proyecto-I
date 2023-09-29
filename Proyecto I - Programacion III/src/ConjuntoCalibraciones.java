import java.util.ArrayList;

public class ConjuntoCalibraciones {

    public ConjuntoCalibraciones(){
        this.calibraciones = new ArrayList<Calibraciones>();

    }

    public void agregarCalibracion(int numeroCalibracion, String fecha, int cantMediciones) {
        Calibraciones nuevaCalibracion = new Calibraciones(numeroCalibracion, fecha, cantMediciones);
        agregar(nuevaCalibracion);
    }

    public int numCalibraciones(){
        return calibraciones.size();
    }
    public Calibraciones recuperar(int p){
        return calibraciones.get(p);
    }
    public String buscar(int numeroBusqueda){
        for(int i = 0; i < calibraciones.size(); i++){
            if(calibraciones.get(i).getNumeroBusqueda() == numeroBusqueda){
                return calibraciones.get(i).toString();
            }
        }
        return "La calibracion no fue encontrada...";
    }
    public void borrar(int noCalibraciones, String fecha, int mediciones){
        for(int i = 0; calibraciones.size() > i; i++) {
            if(calibraciones.get(i).getCantMediciones() == noCalibraciones && calibraciones.get(i).getFecha().equals(fecha) && calibraciones.get(i).getCantMediciones() == mediciones) {
                calibraciones.remove(i);
            }
        }
    }
    public void agregar(Calibraciones nuevaCalibracion){
        calibraciones.add(nuevaCalibracion);
    }
    private ConjuntoCalibraciones obtenerConjuntoCalibraciones() {
        ConjuntoCalibraciones conjuntoCalibraciones = new ConjuntoCalibraciones();
        conjuntoCalibraciones.agregarCalibracion(calibracion.getNumeroCalibracion(), calibracion.getFecha(), calibracion.getCantMediciones());
        return conjuntoCalibraciones;
    }
    private Calibraciones calibracion;
    private ArrayList<Calibraciones> calibraciones;
}
