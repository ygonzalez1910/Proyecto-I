import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ConjuntoTiposInstrumento {
    public ConjuntoTiposInstrumento() {
        this.tiposInstrumentos = new ArrayList<TiposInstrumento>();
    }
    public void agregarTipoInstrumento(String codigo, String nombre,String unidad){
        TiposInstrumento nuevoTipoInstrumento = new TiposInstrumento(codigo,nombre,unidad);
        agregar(nuevoTipoInstrumento);
    }
    public int numTipoInstrumento(){
        return tiposInstrumentos.size();
    }
    public TiposInstrumento recuperar(int p){
        return tiposInstrumentos.get(p);
    }
    public String buscar(String nombre){
        for(int i = 0; i < tiposInstrumentos.size(); i++){
            if(tiposInstrumentos.get(i).getNombre().equals(nombre)){
                return tiposInstrumentos.get(i).toString();
            }
        }
        return "El tipo de instrumento no fue encontrado";
    }
    public void borrar(String codigo, String nombre, String unidad) {
        for (int i = 0; i < tiposInstrumentos.size(); i++) {
            if (tiposInstrumentos.get(i).getNombre().equals(nombre)
                    && tiposInstrumentos.get(i).getCodigo().equals(codigo)
                    && tiposInstrumentos.get(i).getUnidad().equals(unidad)) {
                tiposInstrumentos.remove(i);
                if (modeloTabla != null) {
                    modeloTabla.fireTableDataChanged();
                }
                break;
            }
        }
    }
    public void setModeloTabla(AbstractTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public void agregar(TiposInstrumento nuevoTipoInstrumento){
        tiposInstrumentos.add(nuevoTipoInstrumento);
    }
    public void eliminarFila(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < tiposInstrumentos.size()) {
            tiposInstrumentos.remove(rowIndex); // 'data' es la lista que almacena tus objetos Alumno
            modeloTabla.fireTableRowsDeleted(rowIndex,rowIndex);
        }
    }
    private ArrayList<TiposInstrumento> tiposInstrumentos;
    private AbstractTableModel modeloTabla;

}
