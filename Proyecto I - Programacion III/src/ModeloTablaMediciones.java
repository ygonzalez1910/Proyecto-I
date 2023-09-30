import javax.swing.table.AbstractTableModel;

public class ModeloTablaMediciones extends AbstractTableModel {

    private final ConjuntoMediciones cjMediciones;

    private Object[][] data = new Object[0][3];

    public ModeloTablaMediciones(ConjuntoMediciones cjMediciones){
        this.cjMediciones = cjMediciones;
    }

    public int getRowCount(){
        return cjMediciones.numMediciones();
    }
    @Override
    public int getColumnCount(){
        return Mediciones.nombreCampos().length;
    }
    @Override
    public String getColumnName(int col){
        return Mediciones.nombreCampos()[col];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return cjMediciones.recuperar(rowIndex).toArray()[columnIndex];
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
    public void limpiarModelo() {
        data = new Object[0][3];
        fireTableDataChanged();
    }


}
