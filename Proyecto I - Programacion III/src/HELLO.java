import org.w3c.dom.Document;
import org.w3c.dom.Node;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

//Las variables terminadas en "...TIPINS" corresponden al panel de Tipos de Instrumentos
//Las variables terminadas en "...INS" corresponden al panel de Instrumentos
//Las variables terminadas en "...CALI" corresponden al panel de Calibraciones
public class HELLO extends JFrame{
   private JPanel panelPrincipal;
    private JTabbedPane tablaInstrumentosINS;
    private JButton guardarButtonINS; // de aca en adelante son las variables relacionadas a Intrumentos (...INS)
    private JTextField txtSerieINS;
    private JTextField txtMinimoINS;
    private JTextField txtToleranciaINS;
    private JTextField txtDescripcionINS;
    private JTextField txtMaximoINS;
    private JComboBox comboBoxTipoINS;
    private JButton limpiarButtonINS;
    private JButton borrarButtonINS;
    private JTextField txtBusquedaDescripcionINS;
    private JButton buscarButtonINS;
    private JButton reporteButtonINS;
    private JTable tableInstrumentos;
    private JPanel Calibraciones; // de aca en adelante son las variables relacionadas a Calibraciones (...CALI)
    private JButton guardarButtonCALI;
    private JButton borrarButtonCALI;
    private JButton limpiarButtonCALI;
    private JButton buscarButtonCALI;
    private JTextField txtBusquedaNumeroCALI;
    private JTextField txtNumeroCALI;
    private JTextField txtMedicionesCALI;
    private JTextField txtFechaCALI;
    private JLabel infoCalib;
    private JButton reporteButtonCALI;
    private JTable tableCalibraciones;
    private JButton guardarButtonTIPINS;    // de aca en adelante son las variables relacionadas a Tipos de Intrumentos (...TIPINS)
    private JButton borrarButtonTIPINS;
    private JButton limpiarButtonTIPINS;
    private JTextField txtUnidadTIPINS;
    private JTextField txtCodigoTIPINS;
    private JTextField txtNombreTIPINS;
    private JTable tablaTiposInstruemento;
    private JButton buscarButtonTIPINS;
    private JButton reporteButtonTIPINS;
    private JPanel tablaListadoINS;
    private JPanel tablaListadoTiposINS;
    private JTextField txtNumeroTIPINS;
    private JLabel imagenUNA;   // de aca en adelante son variables de otras cosas
    private JPanel TablaListadoCalibraciones;
    private ConjuntoTiposInstrumento cjntTiposInsrumentos;
    private ConjuntoInstrumentos cjntInstrumentos;
    private ConjuntoCalibraciones cjntCalibraciones;
    private ModeloTablaTipoInstrumentos modeloTablaTipoInstrumentos;
    private ModeloTablaCalibraciones modeloTablaCalibraciones;
    private ModeloTablaInstrumentos modeloTablaInstrumentos;
    private TiposInstrumento tiposInstrumento;
    private Instrumento instrumentos;
    private Calibraciones calibraciones;
    private DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel modelINS = new DefaultTableModel();
    //---------------------FINAL de las declaraciones de vriables
    private void refrescarInstrumentos(){
        modelINS.setRowCount(0);
        for (int i = 0; i < cjntInstrumentos.numInstrumento(); i++) {
            if (cjntInstrumentos.recuperar(i).getTipo() == comboBoxTipoINS.getSelectedItem()) {
                Object[] fila = {
                        cjntInstrumentos.recuperar(i).getSerie(),
                        cjntInstrumentos.recuperar(i).getDescripcion(),
                        cjntInstrumentos.recuperar(i).getMinimo(),
                        cjntInstrumentos.recuperar(i).getMaximo(),
                        cjntInstrumentos.recuperar(i).getTolerancia(),
                        cjntInstrumentos.recuperar(i).getTipo()
                };
                modelINS.addRow(fila);
            }
        }
    }
    public HELLO(){

    //Inicializamos la tabla de TIPOS de INSTRUMENTOS (...TIPINS)
        cjntTiposInsrumentos = new ConjuntoTiposInstrumento();
        modeloTablaTipoInstrumentos = new ModeloTablaTipoInstrumentos(cjntTiposInsrumentos);
        tablaTiposInstruemento.setModel(modeloTablaTipoInstrumentos);
        JTableHeader headerTipoINS = tablaTiposInstruemento.getTableHeader();
        tablaListadoTiposINS.setLayout(new BorderLayout());
        tablaListadoTiposINS.add(headerTipoINS, BorderLayout.NORTH);
        tablaListadoTiposINS.add(new JScrollPane(tablaTiposInstruemento), BorderLayout.CENTER);

    //Inicializamos la tabla de INSTRUMENTOS (...INS)
        cjntInstrumentos = new ConjuntoInstrumentos();
        modeloTablaInstrumentos = new ModeloTablaInstrumentos(cjntInstrumentos);
        tableInstrumentos.setModel(modeloTablaInstrumentos);
        JTableHeader header = tableInstrumentos.getTableHeader();
        tablaListadoINS.setLayout(new BorderLayout());
        tablaListadoINS.add(header, BorderLayout.NORTH);
        tablaListadoINS.add(new JScrollPane(tableInstrumentos), BorderLayout.CENTER);

        //inicializacion tabla calaibraciones
        cjntCalibraciones = new ConjuntoCalibraciones();
        modeloTablaCalibraciones = new ModeloTablaCalibraciones(cjntCalibraciones);
        tableCalibraciones.setModel(modeloTablaCalibraciones);
        JTableHeader headerCalibraciones = tableCalibraciones.getTableHeader();
        TablaListadoCalibraciones.setLayout(new BorderLayout());
        TablaListadoCalibraciones.add(headerCalibraciones,BorderLayout.NORTH);
        TablaListadoCalibraciones.add(new JScrollPane(tableCalibraciones),BorderLayout.CENTER);


    //------------------------------------------------------Botones del Panel TIPOS de INSTRUMENTOS (...TIPINS)
        guardarButtonTIPINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtCodigo = txtCodigoTIPINS.getText();
                String txtNombre = txtNombreTIPINS.getText();
                String txtUnidad = txtUnidadTIPINS.getText();
                comboBoxTipoINS.addItem(txtNombre); // Añade el nombre del tipo a ComboBox
                tiposInstrumento = new TiposInstrumento(txtCodigo,txtNombre,txtUnidad);
                cjntTiposInsrumentos.agregar(tiposInstrumento);
                model.setRowCount(0);
                for(int i = 0; i < cjntTiposInsrumentos.numTipoInstrumento();i++){
                    Object [] fila={
                            cjntTiposInsrumentos.recuperar(i).getCodigo(),
                            cjntTiposInsrumentos.recuperar(i).getNombre(),
                            cjntTiposInsrumentos.recuperar(i).getUnidad()

                    };
                    model.addRow(fila);
                }
                modeloTablaTipoInstrumentos.fireTableDataChanged();
                JOptionPane.showMessageDialog(null, "Tipo de instrumento agregado existosamente");
            }
        });
        limpiarButtonTIPINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCodigoTIPINS.setText("");
                txtUnidadTIPINS.setText("");
                txtNombreTIPINS.setText("");
                modeloTablaTipoInstrumentos.fireTableDataChanged();
            }
        });
        borrarButtonTIPINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String referenciaCodigo = txtCodigoTIPINS.getText();
                String referenciaNombre = txtNombreTIPINS.getText();
                String referenciaUnidad = txtUnidadTIPINS.getText();

                comboBoxTipoINS.removeItem(referenciaNombre); // elimina el item de comboBox
                refrescarInstrumentos();

                tiposInstrumento = new TiposInstrumento(referenciaCodigo,referenciaNombre,referenciaUnidad);
                cjntTiposInsrumentos.borrar(referenciaCodigo,referenciaNombre,referenciaUnidad);

                for(int i = 0; i < cjntTiposInsrumentos.numTipoInstrumento();i++){
                    if(tiposInstrumento.getNombre()== referenciaNombre && tiposInstrumento.getCodigo() == referenciaCodigo
                            && tiposInstrumento.getUnidad() == referenciaUnidad){
                        Object [] fila={
                                cjntTiposInsrumentos.recuperar(i).getCodigo(),
                                cjntTiposInsrumentos.recuperar(i).getNombre(),
                                cjntTiposInsrumentos.recuperar(i).getUnidad()

                        };
                    }

                }
                modeloTablaTipoInstrumentos.fireTableDataChanged();
                JOptionPane.showMessageDialog(null,"Tipo de instrumento eliminado exitosamente.");
            }
        });
        buscarButtonTIPINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String referencNombre = txtNombreTIPINS.getText();
                JOptionPane.showMessageDialog(panelPrincipal,cjntTiposInsrumentos.buscar(referencNombre));
            }
        });
        reporteButtonTIPINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document d;
                try {
                    d = UtilidadesXML.crearDocumento();
                    Node r = d.createElement("DatosClientes");

                    int numero = cjntTiposInsrumentos.numTipoInstrumento();
                    int i = 0;
                    while(i <numero){
                        r.appendChild(cjntTiposInsrumentos.recuperar(i).toXML(d));
                        i++;
                    }
                    d.appendChild(r);

                    UtilidadesXML.guardarArchivoXML(d, "tipos de instrumento.xml");
                    JOptionPane.showMessageDialog(null,"Archivo XML generado exitosamente.");
                } catch (ParserConfigurationException ex) {
                    JOptionPane.showMessageDialog(null,"Error en el archivo XML");
                }
            }
        });

    //------------------------------------------------------Botones del Panel de INSTRUMENTOS (...INS)
        guardarButtonINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtSerie = txtSerieINS.getText();
                String txtDescripcion = txtDescripcionINS.getText();
                int txtMinimo = Integer.parseInt(txtMinimoINS.getText());
                int txtMaximo = Integer.parseInt(txtMaximoINS.getText());
                int txtTolerancia = Integer.parseInt(txtToleranciaINS.getText());
                String txtTipo = (String) comboBoxTipoINS.getSelectedItem();

                Instrumento nuevoInstrumento = new Instrumento(txtSerie, txtDescripcion, txtMinimo, txtMaximo, txtTolerancia, txtTipo);
                cjntInstrumentos.agregar(nuevoInstrumento);

                refrescarInstrumentos();

                modeloTablaInstrumentos.fireTableDataChanged();
                JOptionPane.showMessageDialog(null, "Instrumento agregado existosamente");

                txtSerieINS.setText("");
                txtDescripcionINS.setText("");
                txtMinimoINS.setText("");
                txtMaximoINS.setText("");
                txtToleranciaINS.setText("");

            }

        });
        limpiarButtonINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSerieINS.setText("");
                txtDescripcionINS.setText("");
                txtMinimoINS.setText("");
                txtMaximoINS.setText("");
                txtToleranciaINS.setText("");
                modeloTablaInstrumentos.fireTableDataChanged();

            }
        });
        borrarButtonINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtSerie = txtSerieINS.getText();
                String txtDescripcion = txtDescripcionINS.getText();
                int txtMinimo = Integer.parseInt(txtMinimoINS.getText());
                int txtMaximo = Integer.parseInt(txtMaximoINS.getText());
                int txtTolerancia = Integer.parseInt(txtToleranciaINS.getText());
                String txtTipo = (String) comboBoxTipoINS.getSelectedItem();

                for (int i = 0; i < cjntInstrumentos.numInstrumento(); i++) {
                    if (Objects.equals(cjntInstrumentos.recuperar(i).getSerie(), txtSerie) &&
                            Objects.equals(cjntInstrumentos.recuperar(i).getDescripcion(), txtDescripcion) &&
                            cjntInstrumentos.recuperar(i).getMinimo() == txtMinimo && // Usamos == para comparar ints
                            cjntInstrumentos.recuperar(i).getMaximo() == txtMaximo && // Usamos == para comparar ints
                            cjntInstrumentos.recuperar(i).getTolerancia() == txtTolerancia  &&
                            Objects.equals(cjntInstrumentos.recuperar(i).getTipo(), txtTipo)) {
                        Instrumento a =  cjntInstrumentos.recuperar(i);
                        cjntInstrumentos.remover(a);
                        modeloTablaTipoInstrumentos.fireTableDataChanged();
                        JOptionPane.showMessageDialog(null, "Instrumento eliminado exitosamente.");
                        refrescarInstrumentos(); // actualiza la tabla
                        txtSerieINS.setText("");
                        txtDescripcionINS.setText("");  // una vez boorado el elemento se limpian los textField
                        txtMinimoINS.setText("");
                        txtMaximoINS.setText("");
                        txtToleranciaINS.setText("");
                    }
                }

            }

        });
        reporteButtonINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document d;
                try {
                    d = UtilidadesXML.crearDocumento();
                    Node r = d.createElement("DatosInstrumentos");

                    int numero = cjntInstrumentos.numInstrumento();
                    int i = 0;
                    while(i <numero){
                        r.appendChild(cjntInstrumentos.recuperar(i).toXML(d));
                        i++;
                    }
                    d.appendChild(r);

                    UtilidadesXML.guardarArchivoXML(d, "instrumentos.xml");
                    JOptionPane.showMessageDialog(null,"Archivo XML generado exitosamente.");
                } catch (ParserConfigurationException ex) {
                    JOptionPane.showMessageDialog(null,"Error en el archivo XML");
                }
            }
        });
        buscarButtonINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String referenciaDescripcion = txtDescripcionINS.getText();
                JOptionPane.showMessageDialog(panelPrincipal,cjntInstrumentos.buscar(referenciaDescripcion));
            }
        });
        comboBoxTipoINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refrescarInstrumentos();
            }
        });

    //------------------------------------------------------Botones del Panel de CALIBRACIONES (...CALI)
        guardarButtonCALI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double txtNumero = Double.parseDouble(txtNumeroCALI.getText());
                String txtFecha = txtFechaCALI.getText();
                int txtMediciones = Integer.parseInt(txtMedicionesCALI.getText());
                Calibraciones calibracion = new Calibraciones(txtNumero,txtFecha,txtMediciones);
                cjntCalibraciones.agregar(calibracion);
                model.setRowCount(0);
                for(int i = 0; i < cjntCalibraciones.numCalibraciones();i++){
                    Object [] fila={
                            cjntCalibraciones.recuperar(i).getNumeroCalibracion(),
                            cjntCalibraciones.recuperar(i).getFecha(),
                            cjntCalibraciones.recuperar(i).getMediciones(),

                    };
                    model.addRow(fila);
                }
                modeloTablaCalibraciones.fireTableDataChanged();
                JOptionPane.showMessageDialog(null, "Calibracion agregada existosamente");
            }
        });
        limpiarButtonCALI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNumeroCALI.setText("");
                txtFechaCALI.setText("");
                txtMedicionesCALI.setText("");
                modeloTablaTipoInstrumentos.fireTableDataChanged();
            }
        });
        borrarButtonCALI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double txtNumero = Double.parseDouble(txtNumeroCALI.getText());
                String txtFecha = txtFechaCALI.getText();
                int txtMediciones = Integer.parseInt(txtMedicionesCALI.getText());

                cjntCalibraciones.borrar(txtNumero,txtFecha,txtMediciones);

                for (int i = 0; i < cjntCalibraciones.numCalibraciones(); i++) {
                    if (calibraciones.getNumeroCalibracion() == txtNumero &&
                            calibraciones.getFecha().equals(txtFecha) &&
                            calibraciones.getMediciones() == txtMediciones) {

                        Object[] fila = {
                                cjntCalibraciones.recuperar(i).getNumeroCalibracion(),
                                cjntCalibraciones.recuperar(i).getFecha(),
                                cjntCalibraciones.recuperar(i).getMediciones()
                        };
                    }
                }

                modeloTablaCalibraciones.fireTableDataChanged();
                JOptionPane.showMessageDialog(null, "Calibracion eliminada exitosamente.");
            }
        });
        reporteButtonCALI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document d;
                try {
                    d = UtilidadesXML.crearDocumento();
                    Node r = d.createElement("DatosCalibraciones");

                    int numero = cjntCalibraciones.numCalibraciones();
                    int i = 0;
                    while(i <numero){
                        r.appendChild(cjntCalibraciones.recuperar(i).toXML(d));
                        i++;
                    }
                    d.appendChild(r);

                    UtilidadesXML.guardarArchivoXML(d, "calibraciones.xml");
                    JOptionPane.showMessageDialog(null,"Archivo XML generado exitosamente.");
                } catch (ParserConfigurationException ex) {
                    JOptionPane.showMessageDialog(null,"Error en el archivo XML");
                }
            }
        });
        buscarButtonCALI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // por hacer---
            }
        });
    }
    
//-------------------------------------------------------------------MAIN
    public static void main(String[] args) {
        HELLO hi = new HELLO();
        hi.setContentPane(hi.panelPrincipal);
        hi.setTitle("SILAB: Sistema de laboratorio Industrial");
        hi.setSize(900,400);
        hi.setLocationRelativeTo(null);
        hi.setVisible(true);
        hi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
