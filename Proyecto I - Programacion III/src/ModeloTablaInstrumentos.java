import javax.swing.table.AbstractTableModel;
public class ModeloTablaInstrumentos extends AbstractTableModel {
    private final ConjuntoTiposInstrumento cjInstrumentos;
    private Object[][] data = new Object[0][5];

    public ModeloTablaInstrumentos(ConjuntoTiposInstrumento cjInstrumentos) {
        this.cjInstrumentos = cjInstrumentos;
    }

    @Override
    public int getRowCount() {
        return cjInstrumentos.numTipoInstrumento();

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
        return cjInstrumentos.recuperar(rowIndex).toArray()[columnIndex];
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
