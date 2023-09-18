import javax.swing.table.AbstractTableModel;
public class ModeloTablaTipoInstrumentos extends AbstractTableModel {
    private final ConjuntoTiposInstrumento cjTiposInstrumento;
    private Object[][] data = new Object[0][3];

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
    public void addRow(Object[] rowData) {
        Object[][] newData = new Object[data.length + 1][7];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        newData[data.length] = rowData;
        data = newData;
        fireTableDataChanged();
    }

}
