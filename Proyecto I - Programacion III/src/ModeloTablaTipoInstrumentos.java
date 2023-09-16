import javax.swing.table.AbstractTableModel;
public class ModeloTablaTipoInstrumentos extends AbstractTableModel {
    private final ConjuntoTiposInstrumento cjTiposInstrumento;

    public ModeloTablaTipoInstrumentos(ConjuntoTiposInstrumento cjTiposInstrumento) {
        this.cjTiposInstrumento = cjTiposInstrumento;
    }

    @Override
    public int getRowCount() {
        return cjTiposInstrumento.numTipoInstrumento();

    }

    @Override
    public int getColumnCount() {
        return TiposInstrumento.nombreCampos().length;
    }

    @Override
    public String getColumnName(int col) {
        return TiposInstrumento.nombreCampos()[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return cjTiposInstrumento.recuperar(rowIndex).toArray()[columnIndex];
    }


}
