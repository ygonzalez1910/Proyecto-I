import javax.swing.table.AbstractTableModel;

public class ModeloTablaMediciones extends AbstractTableModel {
    private final ConjuntoMediciones cjMediciones;

    private Object[][] data = new Object[0][3];
    private boolean[] editableColumns = {false, false, true}; // Tercera columna (Lectura) es editable

    public ModeloTablaMediciones(ConjuntoMediciones cjMediciones) {
        this.cjMediciones = cjMediciones;
    }

    public int getRowCount() {
        return cjMediciones.numMediciones();
    }

    @Override
    public int getColumnCount() {
        return Mediciones.nombreCampos().length;
    }

    @Override
    public String getColumnName(int col) {
        return Mediciones.nombreCampos()[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return cjMediciones.recuperar(rowIndex).toArray()[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editableColumns[columnIndex];
    }
    public void clearData() {
        int rowCount = getRowCount();
        int columnCount = getColumnCount();

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                data[row][col] = null; // O puedes establecerlos en valores vacíos si prefieres ""
            }
        }

        fireTableDataChanged();
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 2) { // Tercera columna (Lectura) es editable
            try {
                double lectura = Double.parseDouble(aValue.toString());
                Mediciones medicion = cjMediciones.recuperar(rowIndex);
                medicion.setLectura(String.valueOf(lectura));
                System.out.println("Celda actualizada: " + rowIndex + ", " + columnIndex);
                fireTableCellUpdated(rowIndex, columnIndex);
            } catch (NumberFormatException e) {
                System.err.println("Error al actualizar la celda: " + e.getMessage());
            }
        }
    }

    public void addRow(Object[] rowData) {
        Object[][] newData = new Object[data.length + 1][3];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        newData[data.length] = rowData;
        data = newData;
        fireTableDataChanged();
    }

    public void limpiarModelo() {
        int rowCount = cjMediciones.numMediciones();
        data = new Object[rowCount][3];
        fireTableDataChanged();
    }
}

