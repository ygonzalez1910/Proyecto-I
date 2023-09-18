import java.util.ArrayList;

public class ConjuntoCalibraciones {

    public ConjuntoCalibraciones(){
        this.calibraciones = new ArrayList<Calibraciones>();

    }

    public void agregarCalibracion(Double numeroMediciones, String fecha, int mediciones){
        Calibraciones nuevaCalibracion = new Calibraciones(numeroMediciones,fecha,mediciones);
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
    public void borrar(Double numeroMediciones, String fecha, int mediciones){
        for(int i = 0; calibraciones.size() > i; i++) {
            if(calibraciones.get(i).getMediciones() == numeroMediciones && calibraciones.get(i).getFecha().equals(fecha) && calibraciones.get(i).getMediciones() == mediciones) {
                calibraciones.remove(i);
            }
        }
    }
    public void agregar(Calibraciones nuevaCalibracion){
        calibraciones.add(nuevaCalibracion);
    }
    private ArrayList<Calibraciones> calibraciones;
}
