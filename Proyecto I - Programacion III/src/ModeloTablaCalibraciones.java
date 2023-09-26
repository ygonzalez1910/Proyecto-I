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
        Calibraciones calibraciones = cjCalibraciones.recuperar(rowIndex);
        switch (columnIndex) {
            case 0: return calibraciones.getNumeroCalibracion();
            case 1: return calibraciones.getMediciones();
            case 2: return calibraciones.getFecha();
            default: return null;
        }
    }
    private final String[] nombresColumnas = {"No. Calibracion", "Mediciones", "Fecha", "No. Busqueda"};

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
