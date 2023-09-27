import javax.swing.table.AbstractTableModel;
public class ModeloTablaInstrumentos extends AbstractTableModel {
    private final ConjuntoInstrumentos cjInstrumentos;

    private Object[][] data = new Object[0][5];

    public ModeloTablaInstrumentos(ConjuntoInstrumentos cjInstrumentos) {
        this.cjInstrumentos = cjInstrumentos;
    }

    @Override
    public int getRowCount() {
        return cjInstrumentos.numInstrumento();

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
        Instrumento instrumento = cjInstrumentos.recuperar(rowIndex);
        switch (columnIndex) {
            case 0: return instrumento.getSerie();
            case 1: return instrumento.getDescripcion();
            case 2: return instrumento.getMinimo();
            case 3: return instrumento.getMaximo();
            case 4: return instrumento.getTolerancia();
            case 5: return instrumento.getTipo();
            default: return null;
        }
    }
    private final String[] nombresColumnas = {"Serie", "Descripcion", "Minimo", "Maximo", "Tolerancia", "Tipo"};


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
