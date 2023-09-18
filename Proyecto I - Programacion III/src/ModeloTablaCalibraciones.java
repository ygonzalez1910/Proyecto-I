import javax.swing.table.AbstractTableModel;

public class ModeloTablaCalibraciones extends AbstractTableModel {
    private final ConjuntoCalibraciones cjCalibraciones;
    private Object[][] data = new Object[0][3];

    public ModeloTablaCalibraciones(ConjuntoCalibraciones cjCalibraciones){
        this.cjCalibraciones = cjCalibraciones;
    }
    @Override
    public int getRowCount(){
        return cjCalibraciones.numCalibraciones();
    }
    @Override
    public int getColumnCount(){
        return Calibraciones.nombreCampos().length;
    }
    @Override
    public String getColumnName(int col){
        return Calibraciones.nombreCampos()[col];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return cjCalibraciones.recuperar(rowIndex).toArray()[columnIndex];
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
